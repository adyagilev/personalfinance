package personalfinance.gui;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;

import javax.swing.*;
import java.util.Date;
import java.util.Properties;

public class MainDatePicker {
    private final JDatePickerImpl datePicker;

    public MainDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", Localization.get("TODAY"));
        JDatePanelImpl panel = new JDatePanelImpl(model, properties);
        datePicker = new JDatePickerImpl(panel, new DateComponentFormatter());
        model.setValue(new Date());

        JButton button = (JButton) datePicker.getComponent(1);
        button.setIcon(Style.ICON_CALENDAR);
        button.setText("");
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public void setValue(Date date) {
        ((UtilDateModel) datePicker.getModel()).setValue(date);
    }
}
