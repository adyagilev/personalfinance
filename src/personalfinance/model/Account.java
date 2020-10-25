package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.storage.DataStorage;

import java.util.List;
import java.util.Objects;

public class Account extends Common {
    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account() {}

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        this(title, currency, startAmount, startAmount);
    }

    public Account(String title, Currency currency, double startAmount, double amount) throws ModelException {
        if(title.length() == 0) throw new ModelException(ModelException.EMPTY_TITLE);
        if(currency == null) throw new ModelException(ModelException.EMPTY_CURRENCY);
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void recalculate(List<Transaction> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                this.amount += transaction.getAmount();
            }
        }
        for (Transfer transfer : transfers) {
            if (transfer.getAccountTo().equals(this)) {
                this.amount += transfer.getAmountTo();
            }
            if (transfer.getAccountFrom().equals(this)) {
                this.amount -= transfer.getAmountFrom();
            }
        }
    }

    @Override
    public String getComboBoxElementTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\nAccount {" +
                "\n  title='" + title + '\'' +
                "\n  currency=" + currency +
                "\n  startAmount=" + startAmount +
                "\n  amount=" + amount +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(title, account.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public void postCreate(DataStorage data) {
        recalculate(data.getTransactions(), data.getTransfers());
    }

    @Override
    public void postUpdate(DataStorage data) {
        for (Transaction t : data.getTransactions()) {
            if(t.getAccount().equals(data.getOldCommon())) t.setAccount(this);
        }
        for (Transfer t : data.getTransfers()) {
            if(t.getAccountFrom().equals(data.getOldCommon())) t.setAccountFrom(this);
            if(t.getAccountTo().equals(data.getOldCommon())) t.setAccountTo(this);
        }
        recalculate(data.getTransactions(), data.getTransfers());
    }
}
