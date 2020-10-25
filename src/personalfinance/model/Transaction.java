package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.storage.DataStorage;

import java.util.Date;

public class Transaction extends Common {
    private Account account;
    private Purpose purpose;
    private Date date;
    private double amount;
    private String desc;

    public Transaction() {}

    public Transaction(Account account, Purpose purpose, double amount) throws ModelException {
        this(account, purpose, new Date(), amount, "");
    }

    public Transaction(Account account, Purpose purpose, Date date, double amount) throws ModelException {
        this(account, purpose, date, amount, "");
    }

    public Transaction(Account account, Purpose purpose, double amount, String desc) throws ModelException {
        this(account, purpose, new Date(), amount, desc);
    }

    public Transaction(Account account, Purpose purpose, Date date, double amount, String desc) throws ModelException {
        if(account == null) throw new ModelException(ModelException.EMPTY_ACCOUNT);
        if(purpose == null) throw new ModelException(ModelException.EMPTY_PURPOSE);
        if(date == null) throw new ModelException(ModelException.EMPTY_DATE);
        this.account = account;
        this.purpose = purpose;
        this.date = date;
        this.amount = amount;
        this.desc = desc;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "\nTransaction{" +
                "\n  account=" + account +
                "\n  purpose=" + purpose +
                "\n  date=" + date +
                "\n  amount=" + amount +
                "\n  desc='" + desc + '\'' +
                "\n}";
    }

    @Override
    public void postCreate(DataStorage data) {
        recalculate(data);
    }

    @Override
    public void postUpdate(DataStorage data) {
        recalculate(data);
    }

    @Override
    public void postDelete(DataStorage data) {
        recalculate(data);
    }

    private void recalculate(DataStorage data) {
        for (Account a : data.getAccounts()) {
            a.recalculate(data.getTransactions(), data.getTransfers());
        }
    }
}
