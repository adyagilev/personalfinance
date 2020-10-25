package personalfinance.gui.toolbar;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainButton;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;

public final class FunctionsToolbar extends AbstractToolbar implements EnableEditDelete {
    private static final boolean TOP_ICON = false;
    private MainButton btnAdd;
    private MainButton btnEdit;
    private MainButton btnDelete;

    public FunctionsToolbar() {
        super();
        setBorder(Style.BORDER_FUNCTIONS_TOOLBAR);
        init();
    }

    @Override
    protected void init() {
        btnAdd = addButton(Localization.get("TOOLBAR_ADD"), Style.ICON_TOOLBAR_ADD, HandlerCode.TOOLBAR_ADD, TOP_ICON);
        btnEdit = addButton(Localization.get("TOOLBAR_EDIT"), Style.ICON_TOOLBAR_EDIT, HandlerCode.TOOLBAR_EDIT, TOP_ICON);
        btnDelete = addButton(Localization.get("TOOLBAR_DELETE"), Style.ICON_TOOLBAR_DELETE, HandlerCode.TOOLBAR_DELETE, TOP_ICON);
    }

    @Override
    public void setAllowEditState(boolean isEnabled) {
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(isEnabled);
        btnDelete.setEnabled(isEnabled);
    }
}
