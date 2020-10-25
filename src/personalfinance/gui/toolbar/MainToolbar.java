package personalfinance.gui.toolbar;

import personalfinance.settings.HandlerCode;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;

public final class MainToolbar extends AbstractToolbar {
    private static final boolean TOP_ICON = true;

    public MainToolbar() {
        super();
        setBorder(Style.BORDER_MAIN_TOOLBAR);
        setBackground(Style.COLOR_MAIN_TOOLBAR_BGR);
        init();
    }

    @Override
    protected void init() {
        addButton(Localization.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, TOP_ICON);
        addButton(Localization.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, TOP_ICON);
        addButton(Localization.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, TOP_ICON);
        addButton(Localization.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONS, HandlerCode.TOOLBAR_TRANSACTIONS, TOP_ICON);
        addButton(Localization.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, TOP_ICON);
        addButton(Localization.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, TOP_ICON);
        addButton(Localization.get("TOOLBAR_STATISTIC"), Style.ICON_TOOLBAR_STATISTIC, HandlerCode.TOOLBAR_STATISTIC, TOP_ICON);
    }
}
