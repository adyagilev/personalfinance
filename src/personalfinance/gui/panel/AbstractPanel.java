package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;

import javax.swing.*;

abstract public class AbstractPanel extends JPanel implements Refresh {
    protected final MainFrame frame;

    protected AbstractPanel(MainFrame frame) {
        this.frame = frame;
    }

    public void refresh() {
        removeAll();
        init();
    }

    abstract protected void init();
}
