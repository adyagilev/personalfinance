package personalfinance.gui;

import personalfinance.settings.Localization;
import personalfinance.settings.Settings;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFileChooser extends JFileChooser {
    private final MainFrame frame;

    public MainFileChooser(MainFrame frame) {
        this.frame = frame;
        setFileFilter(new FileNameExtensionFilter("DavFinanceFiles", Settings.SAVE_FILE_EXT));
        setAcceptAllFileFilterUsed(false);
        setCurrentDirectory(Settings.SAVES_DIR);

        UIManager.put("FileChooser.saveDialogTitleText", Localization.get("FC_SAVE"));
        UIManager.put("FileChooser.lookInLabelText", Localization.get("FC_LOOK"));
        UIManager.put("FileChooser.saveInLabelText", Localization.get("FC_LOOK"));
        UIManager.put("FileChooser.openDialogTitleText", Localization.get("FC_OPEN"));
        UIManager.put("FileChooser.homeFolderToolTipText", Localization.get("FC_HOME"));
        UIManager.put("FileChooser.openButtonText", Localization.get("FC_OPEN"));
        UIManager.put("FileChooser.openButtonToolTipText", Localization.get("FC_OPEN"));
        UIManager.put("FileChooser.saveButtonText", Localization.get("FC_SAVE"));
        UIManager.put("FileChooser.saveButtonToolTipText", Localization.get("FC_SAVE"));
        UIManager.put("FileChooser.cancelButtonText", Localization.get("FC_CANCEL"));
        UIManager.put("FileChooser.cancelButtonToolTipText", Localization.get("FC_CANCEL"));
        UIManager.put("FileChooser.fileNameLabelText", Localization.get("FC_NAME_FILE"));
        UIManager.put("FileChooser.filesOfTypeLabelText", Localization.get("FC_TYPE_FILE"));
        UIManager.put("FileChooser.upFolderToolTipText", Localization.get("FC_UP"));
        UIManager.put("FileChooser.newFolderToolTipText", Localization.get("FC_NEW_DIRECTORY"));
        UIManager.put("FileChooser.listViewButtonToolTipText", Localization.get("FC_LIST"));
        UIManager.put("FileChooser.detailsViewButtonToolTipText", Localization.get("FC_TABLE"));
        UIManager.put("FileChooser.fileNameHeaderText", Localization.get("FC_NAME"));
        UIManager.put("FileChooser.fileSizeHeaderText", Localization.get("FC_SIZE"));
        UIManager.put("FileChooser.fileTypeHeaderText", Localization.get("FC_TYPE"));
        UIManager.put("FileChooser.fileDateHeaderText", Localization.get("FC_DATE"));
        UIManager.put("FileChooser.fileAttrHeaderText", Localization.get("FC_ATTR"));
        UIManager.put("FileChooser.acceptAllFileFilterText", Localization.get("FC_ALL_FILTER"));
        updateUI();
    }

    public int open() {
        return super.showOpenDialog(frame);
    }

    public int save() {
        return super.showSaveDialog(frame);
    }
}
