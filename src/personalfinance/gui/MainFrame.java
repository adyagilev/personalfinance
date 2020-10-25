package personalfinance.gui;

import personalfinance.gui.dialog.*;
import personalfinance.gui.menu.MainMenu;
import personalfinance.gui.panel.LeftPanel;
import personalfinance.gui.toolbar.MainToolbar;
import personalfinance.settings.Localization;
import personalfinance.settings.Style;
import personalfinance.storage.DataStorage;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;
    private final MainMenu menu;
    private final MainToolbar toolbar;
    private final LeftPanel leftPanel;

    public MainFrame() throws Exception {
        super(Localization.get("PROGRAM_NAME"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Style.ICON_MAIN.getImage());

        //ErrorDialog.show(this, "Упс... Что-то пошло не так...");
        //ConfirmDialog.show(this, "Перевести все деньги в фонд спасения утконосов?", "Вы уверены?");
        //AboutDialog.show(this);
        //(new AccountEditDialog(this)).showDialog();
        //(new PurposeEditDialog(this)).showDialog();
        //(new TransactionEditDialog(this)).showDialog();
        //(new TransferEditDialog(this)).showDialog();
        //(new CurrencyEditDialog(this)).showDialog();
/*
        CurrencyEditDialog temp = new CurrencyEditDialog(this);
        temp.setCommon(DataStorage.getInstance().getBaseCurrency());
        temp.showDialog();
*/
        menu = new MainMenu(this);
        setJMenuBar(menu);

        setLayout(new GridBagLayout());
        setBackground(Style.COLOR_MASTER_BACKGROUND);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        toolbar = new MainToolbar();
        add(toolbar, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        leftPanel = new LeftPanel(this);
        add(leftPanel, constraints);

        constraints.gridx = 1;
        // TODO: Add Right Panel


        //add(new MainButton("test", null, "TEST"));
        //add(new FunctionsToolbar(), constraints);
        //add(new MainDatePicker().getDatePicker(), constraints);
        //add(new MainFileChooser(this), constraints);
        //(new MainFileChooser(this)).open();
        //(new MainFileChooser(this)).save();
    }

    public MainMenu getMenu() {
        return menu;
    }

    public MainToolbar getToolbar() {
        return toolbar;
    }

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        menu.refresh();
        leftPanel.refresh();
        pack();
    }
}
