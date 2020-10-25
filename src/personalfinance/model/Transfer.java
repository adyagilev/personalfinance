package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.storage.DataStorage;

import java.util.Date;

public class Transfer extends Common {
    private Account accountFrom;
    private Account accountTo;
    private double amountFrom;
    private double amountTo;
    private Date date;
    private String desc;

    public Transfer() {}

    public Transfer(Account accountFrom, Account accountTo, double amountFrom, double amountTo) throws ModelException {
        this(accountFrom, accountTo, amountFrom, amountTo, new Date(), "");
    }

    public Transfer(Account accountFrom, Account accountTo, double amountFrom, double amountTo, String desc) throws ModelException {
        this(accountFrom, accountTo, amountFrom, amountTo, new Date(), desc);
    }

    public Transfer(Account accountFrom, Account accountTo, double amountFrom, double amountTo, Date date) throws ModelException {
        this(accountFrom, accountTo, amountFrom, amountTo, date, "");
    }

    public Transfer(Account accountFrom, Account accountTo, double amountFrom, double amountTo, Date date, String desc) throws ModelException {
        if(accountFrom == null) throw new ModelException(ModelException.EMPTY_ACCOUNT);
        if(accountTo == null) throw new ModelException(ModelException.EMPTY_ACCOUNT);
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amountFrom = amountFrom;
        this.amountTo = amountTo;
        this.date = date;
        this.desc = desc;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public double getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(double amountFrom) {
        this.amountFrom = amountFrom;
    }

    public double getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(double amountTo) {
        this.amountTo = amountTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "\nTransfer{" +
                "\n  accountFrom=" + accountFrom +
                "\n  accountTo=" + accountTo +
                "\n  amountFrom=" + amountFrom +
                "\n  amountTo=" + amountTo +
                "\n  date=" + date +
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
