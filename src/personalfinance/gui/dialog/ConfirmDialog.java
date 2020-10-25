package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Localization;

import javax.swing.*;

public class ConfirmDialog {
    public static int show(MainFrame frame, String message, String title) {
        String[] options = {Localization.get("Yes"), Localization.get("No")};
        return JOptionPane.showOptionDialog(
                frame,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
    }
}
