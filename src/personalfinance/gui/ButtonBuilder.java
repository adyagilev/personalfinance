package personalfinance.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonBuilder {
    private MainButton button;

    public ButtonBuilder() {
        button = new MainButton();
    }

    public ButtonBuilder setTitle(String title) {
        button.setText(title);
        return this;
    }

    public ButtonBuilder setIcon(ImageIcon icon) {
        button.setIcon(icon);
        return this;
    }

    public ButtonBuilder setFont(Font font) {
        button.setFont(font);
        return this;
    }

    public ButtonBuilder setSize(Dimension size) {
        button.setPreferredSize(size);
        return this;
    }

    public ButtonBuilder setListener(ActionListener listener) {
        button.addActionListener(listener);
        return this;
    }

    public ButtonBuilder setAction(String action) {
        button.setActionCommand(action);
        return this;
    }

    public MainButton build() {
        return button;
    }
}
