package personalfinance.gui.dialog;

import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalfinance.exception.ModelException;
import personalfinance.gui.ButtonBuilder;
import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.model.Common;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class AddEditDialog extends JDialog {
    protected LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap<>();
    protected LinkedHashMap<String, Object> values = new LinkedHashMap<>();
    protected Common common;

    public AddEditDialog(MainFrame frame) {
        super(frame, Localization.get("ADD_TITLE"), true);
        setResizable(false);
    }

    protected void init() {
        setComponents();
        setIcons();
        setValues();
    }

    abstract protected void setComponents();
    abstract protected void setIcons();
    abstract protected void setValues();
    abstract protected Common getCommonFromForm() throws ModelException;

    public Common getCommon() {
        return common;
    }

    public void setCommon(Common common) {
        this.common = common;
    }

    public final void showDialog() {
        setDialog();
        setVisible(true);
    }

    public final void closeDialog() {
        setVisible(false);
        common = null;
        components.clear();
        icons.clear();
        values.clear();
        dispose();
    }

    public boolean isAdd() {
        return common == null;
    }

    private void setDialog() {
        init();
        setTitle(isAdd() ? Localization.get("ADD_TITLE") : Localization.get("EDIT_TITLE"));
        setIconImage(isAdd() ? Style.ICON_TOOLBAR_ADD.getImage() : Style.ICON_TOOLBAR_EDIT.getImage());
        getContentPane().removeAll();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);
        for (Map.Entry<String, JComponent> entry : components.entrySet()) {
            String key = entry.getKey();
            JLabel label = new JLabel(Localization.get(key));
            label.setFont(Style.FONT_DIALOG_LABEL);
            if (icons.containsKey(key) && icons.get(key) != null) label.setIcon(icons.get(key));

            JComponent component = entry.getValue();
            if (component instanceof JTextField) {
                component.setPreferredSize(Style.DIMENSION_DIALOG_TEXTFIELD_SIZE);
                if (values.containsKey(key)) {
                    ((JTextField) component).setText(values.get(key).toString());
                }
            } else if (component instanceof JComboBox) {
                if (values.containsKey(key)) {
                    ((JComboBox) component).setSelectedItem(values.get(key));
                }
            } else if (component instanceof JDatePickerImpl) {
                UtilDateModel model = (UtilDateModel) ((JDatePickerImpl) component).getModel();
                if (values.containsKey(key)) model.setValue((Date) values.get(key));
                else model.setValue(new Date());
            }
            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(label);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG_TEXT));
            add(component);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG_TEXT));
        }

        MainButton btnCancel = new ButtonBuilder()
                .setTitle(Localization.get("BTN_LABEL_CANCEL"))
                .setIcon(Style.ICON_CANCEL)
                .setFont(Style.FONT_DIALOG_BUTTON)
                .setSize(Style.DIMENSION_DIALOG_BUTTONS_SIZE)
                .setAction(HandlerCode.CANCEL)
                .build();

        MainButton btnSubmit;
        if (isAdd()) {
            btnSubmit = new ButtonBuilder()
                    .setTitle(Localization.get("BTN_LABEL_ADD"))
                    .setIcon(Style.ICON_OK)
                    .setFont(Style.FONT_DIALOG_BUTTON)
                    .setSize(Style.DIMENSION_DIALOG_BUTTONS_SIZE)
                    .setAction(HandlerCode.ADD)
                    .build();
        } else {
            btnSubmit = new ButtonBuilder()
                    .setTitle(Localization.get("BTN_LABEL_SAVE"))
                    .setIcon(Style.ICON_OK)
                    .setFont(Style.FONT_DIALOG_BUTTON)
                    .setSize(Style.DIMENSION_DIALOG_BUTTONS_SIZE)
                    .setAction(HandlerCode.EDIT)
                    .build();
        }

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        buttons.add(btnSubmit, BorderLayout.EAST);
        buttons.add(Box.createRigidArea(Style.DIMENSION_DIALOG_BUTTONS_PADDING), BorderLayout.CENTER);
        buttons.add(btnCancel, BorderLayout.WEST);
        add(buttons);
        pack();
        setLocationRelativeTo(null);
    }

    protected class CommonComboBox extends JComboBox {
        public CommonComboBox(Object[] objs) {
            super(objs);
            setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    Common c = (Common) value;
                    if (c != null) renderer.setText(c.getComboBoxElementTitle());
                    return renderer;
                }
            });
        }
    }
}
