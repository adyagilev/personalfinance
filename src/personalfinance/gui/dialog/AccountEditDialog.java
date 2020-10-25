package personalfinance.gui.dialog;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Account;
import personalfinance.model.Common;
import personalfinance.model.Currency;
import personalfinance.settings.Format;
import personalfinance.settings.Style;
import personalfinance.storage.DataStorage;

import javax.swing.*;

public class AccountEditDialog extends AddEditDialog {
    public AccountEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void setComponents() {
        components.put("LABEL_TITLE", new JTextField());
        components.put("LABEL_CURRENCY", new CommonComboBox(DataStorage.getInstance().getEnabledCurrencies().toArray()));
        components.put("LABEL_START_AMOUNT", new JTextField());
    }

    @Override
    protected void setIcons() {
        icons.put("LABEL_TITLE", Style.ICON_DIALOG_TITLE);
        icons.put("LABEL_CURRENCY", Style.ICON_DIALOG_CURRENCY);
        icons.put("LABEL_START_AMOUNT", Style.ICON_DIALOG_AMOUNT);
    }

    @Override
    protected void setValues() {
        if (common == null) {
            values.put("LABEL_START_AMOUNT", Format.amount(0));
        } else {
            Account account = (Account) common;
            values.put("LABEL_TITLE", account.getTitle());
            values.put("LABEL_CURRENCY", account.getCurrency());
            values.put("LABEL_START_AMOUNT", Format.amount(account.getStartAmount()));
        }
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();
            String startAmount = ((JTextField) components.get("LABEL_START_AMOUNT")).getText();
            Currency currency = (Currency) ((CommonComboBox) components.get("LABEL_CURRENCY")).getSelectedItem();
            return new Account(title, currency, Format.parceAmount(startAmount));
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
