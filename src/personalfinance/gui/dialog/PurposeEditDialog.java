package personalfinance.gui.dialog;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Common;
import personalfinance.model.Purpose;
import personalfinance.model.PurposeType;
import personalfinance.settings.Style;
import personalfinance.storage.DataStorage;

import javax.swing.*;

public class PurposeEditDialog extends AddEditDialog {
    public PurposeEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void setComponents() {
        components.put("LABEL_PURPOSE_TYPE", new CommonComboBox(DataStorage.getInstance().getAllPurposeTypes().toArray()));
        components.put("LABEL_TITLE", new JTextField());
    }

    @Override
    protected void setIcons() {
        icons.put("LABEL_PURPOSE_TYPE", Style.ICON_DIALOG_TITLE);
        icons.put("LABEL_TITLE", Style.ICON_DIALOG_TITLE);
    }

    @Override
    protected void setValues() {
        if (common != null) {
            Purpose purpose = (Purpose) common;
            values.put("LABEL_PURPOSE_TYPE", purpose.getType());
            values.put("LABEL_TITLE", purpose.getTitle());
        }
    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        return new Purpose(
                ((JTextField) components.get("LABEL_TITLE")).getText(),
                ((PurposeType) ((CommonComboBox) components.get("LABEL_PURPOSE_TYPE")).getSelectedItem())
        );
    }
}
