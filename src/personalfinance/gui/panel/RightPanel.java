package personalfinance.gui.panel;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;
import personalfinance.gui.table.TableData;
import personalfinance.settings.Style;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RightPanel extends AbstractPanel {
    protected String title;
    protected ImageIcon icon;
    protected JPanel[] panels;
    protected TableData td;

    public RightPanel(MainFrame frame, String title, ImageIcon icon) {
        super(frame);
        this.title = title;
        this.icon = icon;
        setBorder(Style.BORDER_RIGHT_PANEL);
        setBackground(Style.COLOR_RIGHT_PANEL_BGR);
        init();
    }

    @Override
    public void refresh() {
        super.refresh();
        for (JPanel panel : panels) {
            if (panel instanceof Refresh) ((Refresh) panel).refresh();
        }
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setEnableEdit();

        JLabel header = new JLabel(title);
        header.setFont(Style.FONT_RIGHT_PANEL_HEADER);
        header.setIcon(icon);
        header.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(header);

        if (panels == null || panels.length == 0) {
            add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL_ITEMS));
        } else {
            for (JPanel panel : panels) {
                add(panel);
                add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL_ITEMS));
            }
        }

        if (td != null) {
            JScrollPane scrollPane = new JScrollPane(td);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            add(scrollPane);

            ListSelectionModel model = td.getSelectionModel();
            model.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    setEnableEdit();
                }
            });
        }
    }

    private void setEnableEdit() {
        boolean state = td != null && td.getSelectedRow() != -1;
        frame.getMenu().setAllowEditState(state);

        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete) {
                ((EnableEditDelete) panel).setAllowEditState(state);
            }
        }
    }
}
