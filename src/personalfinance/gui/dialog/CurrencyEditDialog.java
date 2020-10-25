package personalfinance.gui.dialog;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Common;
import personalfinance.model.Currency;
import personalfinance.settings.Format;
import personalfinance.settings.Localization;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;

import javax.swing.*;

public class CurrencyEditDialog extends AddEditDialog {
    public CurrencyEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void setComponents() {
        components.put("LABEL_TITLE", new JTextField());
        components.put("LABEL_CODE", new JComboBox(Settings.CURRENCIES));
        components.put("LABEL_RATE", new JTextField());
        components.put("LABEL_ACTIVE", new JComboBox(new String[]{Localization.get("Yes"), Localization.get("No")}));
        components.put("LABEL_PRIMARY", new JComboBox(new String[]{Localization.get("Yes"), Localization.get("No")}));
    }

    @Override
    protected void setIcons() {
        icons.put("LABEL_TITLE", Style.ICON_DIALOG_TITLE);
        icons.put("LABEL_CODE", Style.ICON_DIALOG_TITLE);
        icons.put("LABEL_RATE", Style.ICON_DIALOG_CURRENCY);
        icons.put("LABEL_ACTIVE", Style.ICON_DIALOG_AMOUNT);
        icons.put("LABEL_PRIMARY", Style.ICON_DIALOG_AMOUNT);
    }

    @Override
    protected void setValues() {
        if (common == null) {
            values.put("LABEL_RATE", Format.amount(1));
        } else {
            Currency currency = (Currency) common;
            values.put("LABEL_TITLE", currency.getTitle());
            values.put("LABEL_CODE", currency.getCode());
            values.put("LABEL_RATE", Format.amount(currency.getRate()));
            values.put("LABEL_ACTIVE", currency.isEnabled() ? Localization.get("Yes") : Localization.get("No"));
            values.put("LABEL_PRIMARY", currency.isPrimary() ? Localization.get("Yes") : Localization.get("No"));
            if(currency.isPrimary()) {
                // It is not allowed to uncheck primary currency or disable it.
                // User have to select another currency as primary.
                values.put("LABEL_ACTIVE", Localization.get("Yes"));
                values.put("LABEL_PRIMARY", Localization.get("Yes"));
                components.get("LABEL_ACTIVE").setEnabled(false);
                components.get("LABEL_PRIMARY").setEnabled(false);
            }
        }
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();
            String code = ((JComboBox) components.get("LABEL_CODE")).getSelectedItem().toString();
            Double rate = Format.parceAmount(((JTextField) components.get("LABEL_RATE")).getText());
            Boolean isEnabled = ((JComboBox) components.get("LABEL_ACTIVE"))
                    .getSelectedItem().toString().equals(Localization.get("Yes"));
            Boolean isPrimary = ((JComboBox) components.get("LABEL_PRIMARY"))
                    .getSelectedItem().toString().equals(Localization.get("Yes"));
            return new Currency(code, title, rate, isEnabled, isPrimary);
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
