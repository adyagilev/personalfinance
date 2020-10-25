package personalfinance.gui;

import personalfinance.settings.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainButton extends JButton {
    public MainButton() {
        this("", null, null, "");
    }

    public MainButton(String title, ImageIcon icon, ActionListener listener, String action) {
        super(title);
        if(icon != null) setIcon(icon);
        addActionListener(listener);
        setActionCommand(action);
        addMouseListener(new HoverButton());

        setFont(Style.FONT_MAIN_BUTTON);
        setFocusPainted(false);
        setBackground(Style.COLOR_BUTTON_BG_NORMAL);
    }

    private class HoverButton implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            ((MainButton) e.getSource()).setBackground(Style.COLOR_BUTTON_BG_HOVER);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ((MainButton) e.getSource()).setBackground(Style.COLOR_BUTTON_BG_NORMAL);
        }
    }
}
