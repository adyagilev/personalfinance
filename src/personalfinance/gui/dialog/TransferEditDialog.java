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

public class TransferEditDialog extends AddEditDialog {
    public TransferEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void setComponents() {
        components.put("LABEL_DATE", (new MainDatePicker()).getDatePicker());
        components.put("LABEL_ACCOUNT_FROM", new CommonComboBox(DataStorage.getInstance().getAccounts().toArray()));
        components.put("LABEL_AMOUNT_FROM", new JTextField());
        components.put("LABEL_ACCOUNT_TO", new CommonComboBox(DataStorage.getInstance().getAccounts().toArray()));
        components.put("LABEL_AMOUNT_TO", new JTextField());
        components.put("LABEL_DESCRIPTION", new JTextField());
    }

    @Override
    protected void setIcons() {
        icons.put("LABEL_DATE", Style.ICON_DIALOG_DATE);
        icons.put("LABEL_ACCOUNT_FROM", Style.ICON_DIALOG_ACCOUNT);
        icons.put("LABEL_AMOUNT_FROM", Style.ICON_DIALOG_AMOUNT);
        icons.put("LABEL_ACCOUNT_TO", Style.ICON_DIALOG_ACCOUNT);
        icons.put("LABEL_AMOUNT_TO", Style.ICON_DIALOG_AMOUNT);
        icons.put("LABEL_DESCRIPTION", Style.ICON_DIALOG_DESCRIPTION);
    }

    @Override
    protected void setValues() {
        if (common == null) {
            values.put("LABEL_DATE", new Date());
            values.put("LABEL_AMOUNT_FROM", Format.amount(0));
            values.put("LABEL_AMOUNT_TO", Format.amount(0));
        } else {
            Transfer transfer = (Transfer) common;
            values.put("LABEL_DATE", transfer.getDate());
            values.put("LABEL_ACCOUNT_FROM", transfer.getAccountFrom());
            values.put("LABEL_AMOUNT_FROM", Format.amount(transfer.getAmountFrom()));
            values.put("LABEL_ACCOUNT_TO", transfer.getAccountTo());
            values.put("LABEL_AMOUNT_TO", Format.amount(transfer.getAmountTo()));
            values.put("LABEL_DESCRIPTION", transfer.getDesc());
        }
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            Date date = (Date) ((JDatePickerImpl) components.get("LABEL_DATE")).getModel().getValue();
            Account accountFrom = (Account) ((CommonComboBox) components.get("LABEL_ACCOUNT_FROM")).getSelectedItem();
            Double amountFrom = Format.parceAmount(((JTextField) components.get("LABEL_AMOUNT_FROM")).getText());
            Account accountTo = (Account) ((CommonComboBox) components.get("LABEL_ACCOUNT_TO")).getSelectedItem();
            Double amountTo = Format.parceAmount(((JTextField) components.get("LABEL_AMOUNT_TO")).getText());
            String desc = ((JTextField) components.get("LABEL_DESCRIPTION")).getText();
            return new Transfer(accountFrom, accountTo, amountFrom, amountTo, date, desc);
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}