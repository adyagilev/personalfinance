package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Localization;

import javax.swing.*;

public class ErrorDialog {
    public static void show(MainFrame frame, String message) {
        JOptionPane.showMessageDialog(
                frame,
                message,
                Localization.get("ERROR"),
                JOptionPane.ERROR_MESSAGE
        );
    }
}
