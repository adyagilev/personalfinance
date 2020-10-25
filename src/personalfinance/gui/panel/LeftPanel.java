package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.model.Account;
import personalfinance.model.Currency;
import personalfinance.model.Statistic;
import personalfinance.settings.Format;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;
import personalfinance.storage.DataStorage;

import javax.swing.*;
import java.awt.*;

public final class LeftPanel extends AbstractPanel {
    public LeftPanel(MainFrame frame) {
        super(frame);
        setBorder(Style.BORDER_LEFT_PANEL);
        setBackground(Style.COLOR_LEFT_PANEL_BGR);
        init();
    }

    @Override
    protected void init() {
        DataStorage data = DataStorage.getInstance();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(getLabel(Localization.get("BALANCE_BY_ACCOUNTS"), Style.ICON_LEFT_PANEL_BALANCE_ACCOUNTS));
        addAccountBalance(data);
        add(getLabel(Localization.get("BALANCE_BY_CURRENCIES"), Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES));
        addCurrencyBalance(data);
        add(getLabel(Localization.get("BALANCE_TOTAL"), Style.ICON_LEFT_PANEL_BALANCE_TOTAL));
        addTotal(data);
    }

    private JLabel getLabel(String labelText, ImageIcon icon) {
        JLabel label = new JLabel(labelText);
        label.setFont(Style.FONT_LABEL_HEADER);
        label.setIcon(icon);
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return label;
    }

    private void addAccountBalance(DataStorage data) {
        int i = 0;
        for(Account account : data.getAccounts()) {
            Color color = i++%2 == 0 ? Style.COLOR_LEFT_PANEL_ROW_BGR_EVEN : Style.COLOR_LEFT_PANEL_ROW_BGR_ODD;
            add(new PanelBalance(account.getTitle(), account.getAmount(), account.getCurrency(), color));
        }
    }

    private void addCurrencyBalance(DataStorage data) {
        int i = 0;
        for(Currency currency : data.getCurrencies()) {
            if (currency.isEnabled()) {
                Color color = i++%2 == 0 ? Style.COLOR_LEFT_PANEL_ROW_BGR_EVEN: Style.COLOR_LEFT_PANEL_ROW_BGR_ODD;
                add(new PanelBalance(currency.getTitle(), Statistic.getCurrencyBalance(currency), currency, color));
            }
        }
    }

    private void addTotal(DataStorage data) {
        int i = 0;
        for(Currency currency : data.getCurrencies()) {
            if (currency.isEnabled()) {
                Color color = i++%2 == 0 ? Style.COLOR_LEFT_PANEL_ROW_BGR_EVEN : Style.COLOR_LEFT_PANEL_ROW_BGR_ODD;
                add(new PanelBalance(currency.getTitle(), Statistic.getTotalBalance(currency), currency, color));
            }
        }
    }

    private class PanelBalance extends JPanel {
        public PanelBalance(String labelText, double amount, Currency currency, Color color) {
            super();
            setLayout(new BorderLayout());
            setBackground(color);

            JLabel labelDesc = new JLabel(labelText);
            labelDesc.setFont(Style.FONT_LABEL_ROW_DESC);

            JLabel labelAmount = new JLabel(Format.amount(amount, currency));
            labelAmount.setFont(Style.FONT_LABEL_ROW_AMOUNT);

            add(labelDesc, BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENSION_LEFT_PANEL_LABEL_PADDING));
            add(labelAmount, BorderLayout.EAST);
        }
    }
}
