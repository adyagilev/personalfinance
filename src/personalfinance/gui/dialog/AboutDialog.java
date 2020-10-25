package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class AboutDialog extends JDialog {
    public AboutDialog() {
        super();
        init();
        setIconImage(Style.ICON_ABOUT.getImage());
        setTitle(Localization.get("ABOUT_TITLE"));
        setResizable(false);
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Localization.get("ABOUT_TEXT"));
        pane.setEditable(false);
        pane.setOpaque(false);
        pane.addHyperlinkListener(he -> {
           if (HyperlinkEvent.EventType.ACTIVATED.equals(he.getEventType())) {
               try {
                   Desktop.getDesktop().browse(he.getURL().toURI());
               } catch (URISyntaxException | IOException e) {
                   e.printStackTrace();
               }
           }
        });
        add(pane);
        pack();
        setLocationRelativeTo(null);
    }

    public static void show(MainFrame frame) {
        AboutDialog dialog = new AboutDialog();
        dialog.setVisible(true);
    }
}
