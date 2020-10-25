package personalfinance.settings;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class Style {
    public static final Color COLOR_MASTER_BACKGROUND = new Color(200, 200, 250);
    public static final Color COLOR_BUTTON_BG_NORMAL = new Color(200, 200, 200);
    public static final Color COLOR_BUTTON_BG_HOVER = new Color(240, 240, 240);
    public static final Color COLOR_MAIN_TOOLBAR_BGR = new Color(200, 250, 200);
    public static final Color COLOR_LEFT_PANEL_BGR = new Color(250, 250, 200);
    public static final Color COLOR_RIGHT_PANEL_BGR = new Color(200, 250, 200);
    public static final Color COLOR_LEFT_PANEL_ROW_BGR_ODD = new Color(250, 250, 250);
    public static final Color COLOR_LEFT_PANEL_ROW_BGR_EVEN = new Color(220, 220, 220);

    public static final Font FONT_BUTTON_TOOLBAR = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_DIALOG_LABEL = new Font("Roboto-Light", Font.BOLD, 12);
    public static final Font FONT_MAIN_BUTTON = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_DIALOG_BUTTON = new Font("Roboto-Light", Font.BOLD, 12);
    public static final Font FONT_RIGHT_PANEL_HEADER = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_LABEL_HEADER = new Font("Roboto-Light", Font.BOLD, 12);
    public static final Font FONT_LABEL_ROW_DESC = new Font("Roboto-Light", Font.PLAIN, 12);
    public static final Font FONT_LABEL_ROW_AMOUNT = new Font("Roboto-Light", Font.BOLD, 12);

    public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_MAIN_TOOLBAR = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_FUNCTIONS_TOOLBAR = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_LEFT_PANEL = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_RIGHT_PANEL = new EmptyBorder(10, 10, 10, 10);

    public static final Dimension DIMENSION_MINIMAL_WINDOW_SIZE = new Dimension(800, 500);
    public static final Dimension DIMENSION_DIALOG_TEXTFIELD_SIZE = new Dimension(200, 25);
    public static final Dimension DIMENSION_DIALOG_BUTTONS_PADDING = new Dimension(10, 0);
    public static final Dimension DIMENSION_DIALOG_BUTTONS_SIZE = new Dimension(140, 50);
    public static final Dimension DIMENSION_LEFT_PANEL_LABEL_PADDING = new Dimension(20, 0);

    public static final int PADDING_DIALOG_TEXT = 10;
    public static final int PADDING_RIGHT_PANEL_ITEMS = 10;

    public static final ImageIcon ICON_MAIN = new ImageIcon("images/money32.png");
    public static final ImageIcon ICON_ABOUT = new ImageIcon("images/money32.png");

    public static final ImageIcon ICON_MENU_FILE = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_EDIT = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_HELP = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_FILE_NEW = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_FILE_OPEN = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_FILE_SAVE = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_FILE_EXIT = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_FILE_UPDATE_CURRENCIES = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_EDIT_ADD = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_EDIT_EDIT = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_EDIT_DELETE = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_OVERVIEW = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_ACCOUNTS = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_ARTICLES = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSACTIONS = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSFERS = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_CURRENCIES = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_VIEW_STATISTIC = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_MENU_HELP_ABOUT = new ImageIcon("images/no_icon32.png");

    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/view32.png");
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("images/money32.png");
    public static final ImageIcon ICON_TOOLBAR_ARTICLES = new ImageIcon("images/check32.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONS = new ImageIcon("images/check32.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSFERS = new ImageIcon("images/check32.png");
    public static final ImageIcon ICON_TOOLBAR_CURRENCIES = new ImageIcon("images/exchange32.png");
    public static final ImageIcon ICON_TOOLBAR_STATISTIC = new ImageIcon("images/report32.png");
    public static final ImageIcon ICON_TOOLBAR_ADD = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_TOOLBAR_EDIT = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_TOOLBAR_DELETE = new ImageIcon("images/no_icon32.png");

    public static final ImageIcon ICON_LEFT_PANEL_BALANCE_ACCOUNTS = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_LEFT_PANEL_BALANCE_CURRENCIES = new ImageIcon("images/no_icon32.png");
    public static final ImageIcon ICON_LEFT_PANEL_BALANCE_TOTAL = new ImageIcon("images/no_icon32.png");

    public static final ImageIcon ICON_CALENDAR = new ImageIcon("images/date.png");
    public static final ImageIcon ICON_OK = new ImageIcon("images/ok.png");
    public static final ImageIcon ICON_CANCEL = new ImageIcon("images/cancel.png");

    public static final ImageIcon ICON_DIALOG_ACCOUNT = new ImageIcon("images/exchange32.png");
    public static final ImageIcon ICON_DIALOG_AMOUNT = new ImageIcon("images/money32.png");
    public static final ImageIcon ICON_DIALOG_CURRENCY = new ImageIcon("images/exchange32.png");
    public static final ImageIcon ICON_DIALOG_DATE = new ImageIcon("images/date.png");
    public static final ImageIcon ICON_DIALOG_DESCRIPTION = new ImageIcon("images/notice.png.png");
    public static final ImageIcon ICON_DIALOG_PURPOSE = new ImageIcon("images/check32.png");
    public static final ImageIcon ICON_DIALOG_TITLE = new ImageIcon("images/notice.png.png");
}
