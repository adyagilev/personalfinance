package personalfinance.model;

import personalfinance.storage.DataStorage;

public class Statistic {
    public static double getCurrencyBalance(Currency currency) {
        DataStorage data = DataStorage.getInstance();
        double balance = 0.0;
        for (Account account : data.getAccounts()) {
            if (currency.equals(account.getCurrency()))
                balance += account.getAmount();
        }
        return balance;
    }

    public static double getTotalBalance(Currency currency) {
        DataStorage data = DataStorage.getInstance();
        double balance = 0.0;
        for (Account account : data.getAccounts()) {
            balance += account.getAmount() * account.getCurrency().getRateToCurrency(currency);
        }
        return balance;
    }
}
