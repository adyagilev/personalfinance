package personalfinance.gui.dialog;

import org.jdatepicker.impl.JDatePickerImpl;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainDatePicker;
import personalfinance.gui.MainFrame;
import personalfinance.model.*;
import personalfinance.settings.Format;
import personalfinance.settings.Style;
import personalfinance.storage.DataStorage;

import javax.swing.*;
import java.util.Date;

public class TransactionEditDialog extends AddEditDialog {
    public TransactionEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void setComponents() {
        components.put("LABEL_DATE", (new MainDatePicker()).getDatePicker());
        components.put("LABEL_ACCOUNT", new CommonComboBox(DataStorage.getInstance().getAccounts().toArray()));
        components.put("LABEL_PURPOSE", new CommonComboBox(DataStorage.getInstance().getPurposes().toArray()));
        components.put("LABEL_AMOUNT", new JTextField());
        components.put("LABEL_DESCRIPTION", new JTextField());
    }

    @Override
    protected void setIcons() {
        icons.put("LABEL_DATE", Style.ICON_DIALOG_DATE);
        icons.put("LABEL_ACCOUNT", Style.ICON_DIALOG_ACCOUNT);
        icons.put("LABEL_PURPOSE", Style.ICON_DIALOG_PURPOSE);
        icons.put("LABEL_AMOUNT", Style.ICON_DIALOG_AMOUNT);
        icons.put("LABEL_DESCRIPTION", Style.ICON_DIALOG_DESCRIPTION);
    }

    @Override
    protected void setValues() {
        if (common == null) {
            values.put("LABEL_DATE", new Date());
            values.put("LABEL_AMOUNT", Format.amount(0));
        } else {
            Transaction transaction = (Transaction) common;
            values.put("LABEL_DATE", transaction.getDate());
            values.put("LABEL_ACCOUNT", transaction.getAccount());
            values.put("LABEL_PURPOSE", transaction.getPurpose());
            values.put("LABEL_AMOUNT", Format.amount(transaction.getAmount()));
            values.put("LABEL_DESCRIPTION", transaction.getDesc());
        }
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            Date date = (Date) ((JDatePickerImpl) components.get("LABEL_DATE")).getModel().getValue();
            Account account = (Account) ((CommonComboBox) components.get("LABEL_ACCOUNT")).getSelectedItem();
            Purpose purpose = (Purpose) ((CommonComboBox) components.get("LABEL_PURPOSE")).getSelectedItem();
            Double amount = Format.parceAmount(((JTextField) components.get("LABEL_AMOUNT")).getText());
            String desc = ((JTextField) components.get("LABEL_DESCRIPTION")).getText();
            return new Transaction(account, purpose, date, amount, desc);
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}