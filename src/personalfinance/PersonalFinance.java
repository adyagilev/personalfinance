package personalfinance;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.model.*;
import personalfinance.settings.Localization;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;
import personalfinance.storage.DataStorage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class PersonalFinance {
    public static void main(String[] args) throws Exception {
        //Settings.save();
        init();
        //testModel();
        DataStorage data = DataStorage.getInstance();
        //System.out.println(data);

        MainFrame frame = new MainFrame();
        frame.setMinimumSize(Style.DIMENSION_MINIMAL_WINDOW_SIZE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void testModel() throws ModelException {
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("RUB", "Рубль", 1.0, true, true));
        currencies.add(new Currency("USD", "Доллар", 65.0, true, false));
        currencies.add(new Currency("EUR", "Евро", 72.0, true, false));
        currencies.add(new Currency("CNY", "Юань", 9.3, false, false));

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Наличка рубли", currencies.get(0), 5000.0, 5000.0));
        accounts.add(new Account("Наличка баксы", currencies.get(1), 5.0, 5.0));
        accounts.add(new Account("Наличка евро", currencies.get(2), 0.0, 0.0));
        accounts.add(new Account("Рублёвая карта", currencies.get(0), 15000.0, 15000.0));
        accounts.add(new Account("Долларовая карта", currencies.get(1), 100.0, 100.0));
        accounts.add(new Account("Евро карта", currencies.get(2), 0.0, 0.0));

        ArrayList<Purpose> purposes = new ArrayList<>();
        purposes.add(new Purpose("Зарплата"));
        purposes.add(new Purpose("Квартплата"));
        purposes.add(new Purpose("Продукты"));
        purposes.add(new Purpose("Развлечения"));

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(accounts.get(3), purposes.get(0), new Date((new Date()).getTime() - (1000L * 60 * 60 * 24 * 5)), 50000.0));
        transactions.add(new Transaction(accounts.get(3), purposes.get(1), new Date((new Date()).getTime() - (1000L * 60 * 60 * 24 * 4)), -5000.0));
        transactions.add(new Transaction(accounts.get(3), purposes.get(2), -3000.0));
        transactions.add(new Transaction(accounts.get(0), purposes.get(2), -2000.0));
        transactions.add(new Transaction(accounts.get(0), purposes.get(3), -7000.0));

        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(accounts.get(3), accounts.get(0), 20000.0, 20000.0, new Date((new Date()).getTime() - (1000L * 60 * 60 * 24 * 3)), "Снятие налички"));
        transfers.add(new Transfer(accounts.get(3), accounts.get(0), 5000.0, 5000.0, "Снятие налички"));

        for(Account a : accounts) {
            a.recalculate(transactions, transfers);
        }

        DataStorage data = DataStorage.getInstance();
        data.setAccounts(accounts);
        data.setCurrencies(currencies);
        data.setPurposes(purposes);
        data.setTransactions(transactions);
        data.setTransfers(transfers);

        data.save();
        //System.out.println(data);
    }

    private static void init() {
        Localization.init();
        loadFonts();
    }

    private static void loadFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (File fontFile : Settings.FONTS_FILES) {
            try {
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
