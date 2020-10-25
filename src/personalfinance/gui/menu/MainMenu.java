package personalfinance.gui.menu;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete{

    private final MainFrame frame;
    private JMenuItem menuAdd;
    private JMenuItem menuEdit;
    private JMenuItem menuDelete;

    public MainMenu(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }

    private void init() {
        JMenu file = addMainMenuItem(Localization.get("MENU_FILE"), Style.ICON_MENU_FILE);
        JMenu edit = addMainMenuItem(Localization.get("MENU_EDIT"), Style.ICON_MENU_EDIT);
        JMenu view = addMainMenuItem(Localization.get("MENU_VIEW"), Style.ICON_MENU_VIEW);
        JMenu help = addMainMenuItem(Localization.get("MENU_HELP"), Style.ICON_MENU_HELP);

        addMenuItem(file, Localization.get("MENU_FILE_NEW"), Style.ICON_MENU_FILE_NEW, HandlerCode.MENU_FILE_NEW, KeyEvent.VK_N);
        addMenuItem(file, Localization.get("MENU_FILE_OPEN"), Style.ICON_MENU_FILE_OPEN, HandlerCode.MENU_FILE_OPEN, KeyEvent.VK_O);
        addMenuItem(file, Localization.get("MENU_FILE_SAVE"), Style.ICON_MENU_FILE_SAVE, HandlerCode.MENU_FILE_SAVE, KeyEvent.VK_S);
        addMenuItem(file, Localization.get("MENU_FILE_UPDATE_CURRENCIES"), Style.ICON_MENU_FILE_UPDATE_CURRENCIES, HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
        addMenuItem(file, Localization.get("MENU_FILE_EXIT"), Style.ICON_MENU_FILE_EXIT, HandlerCode.MENU_FILE_EXIT);
        menuAdd = addMenuItem(edit, Localization.get("MENU_EDIT_ADD"), Style.ICON_MENU_EDIT_ADD, HandlerCode.MENU_EDIT_ADD);
        menuEdit = addMenuItem(edit, Localization.get("MENU_EDIT_EDIT"), Style.ICON_MENU_EDIT_EDIT, HandlerCode.MENU_EDIT_EDIT);
        menuDelete = addMenuItem(edit, Localization.get("MENU_EDIT_DELETE"), Style.ICON_MENU_EDIT_DELETE, HandlerCode.MENU_EDIT_DELETE);
        setAllowEditState(false);
        addMenuItem(view, Localization.get("MENU_VIEW_OVERVIEW"), Style.ICON_MENU_VIEW_OVERVIEW, HandlerCode.MENU_VIEW_OVERVIEW);
        addMenuItem(view, Localization.get("MENU_VIEW_ACCOUNTS"), Style.ICON_MENU_VIEW_ACCOUNTS, HandlerCode.MENU_VIEW_ACCOUNTS);
        addMenuItem(view, Localization.get("MENU_VIEW_ARTICLES"), Style.ICON_MENU_VIEW_ARTICLES, HandlerCode.MENU_VIEW_ARTICLES);
        addMenuItem(view, Localization.get("MENU_VIEW_TRANSACTIONS"), Style.ICON_MENU_VIEW_TRANSACTIONS, HandlerCode.MENU_VIEW_TRANSACTIONS);
        addMenuItem(view, Localization.get("MENU_VIEW_TRANSFERS"), Style.ICON_MENU_VIEW_TRANSFERS, HandlerCode.MENU_VIEW_TRANSFERS);
        addMenuItem(view, Localization.get("MENU_VIEW_CURRENCIES"), Style.ICON_MENU_VIEW_CURRENCIES, HandlerCode.MENU_VIEW_CURRENCIES);
        addMenuItem(view, Localization.get("MENU_VIEW_STATISTIC"), Style.ICON_MENU_VIEW_STATISTIC, HandlerCode.MENU_VIEW_STATISTIC);
        addMenuItem(help, Localization.get("MENU_HELP_ABOUT"), Style.ICON_MENU_HELP_ABOUT, HandlerCode.MENU_HELP_ABOUT);
    }

    private JMenu addMainMenuItem(String title, ImageIcon icon) {
        JMenu item = new JMenu(Localization.get(title));
        item.setIcon(icon);
        add(item);
        return item;
    }

    private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action) {
        return addMenuItem(menu, title, icon, action, null);
    }

    private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, Integer key) {
        JMenuItem item = new JMenuItem(title);
        item.setIcon(icon);
        item.setActionCommand(action);
        menu.add(item);
        if (key != null) {
            item.setAccelerator(
                KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())
            );
        }
        return item;
    }

    @Override
    public void setAllowEditState(boolean isEnabled) {
        menuEdit.setEnabled(isEnabled);
        menuDelete.setEnabled(isEnabled);
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}
