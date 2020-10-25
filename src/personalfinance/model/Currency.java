package personalfinance.model;

import personalfinance.storage.DataStorage;

import java.util.Objects;

public class Currency extends Common {
    private String code;
    private String title;
    private double rate;
    private boolean isEnabled;
    private boolean isPrimary;

    public Currency() {
        this.init("", "", 1.0, false, false);
    }

    public Currency(String code, String title, double rate) {
        this.init(code, title, rate, false, false);
    }

    public Currency(String code, String title, double rate, boolean isEnabled, boolean isPrimary) {
        this.init(code, title, rate, isEnabled, isPrimary);
    }

    private void init(String code, String title, double rate, boolean isEnabled, boolean isPrimary) {
        this.code = code;
        this.title = title;
        this.rate = rate;
        this.isEnabled = isEnabled;
        this.isPrimary = isPrimary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public double getRateToCurrency(Currency currency) {
        return rate / currency.getRate();
    }

    @Override
    public String getComboBoxElementTitle() {
        return title + " (" + code + ")";
    }

    @Override
    public String toString() {
        return "\nCurrency{" +
                "\n  code='" + code + '\'' +
                "\n  title='" + title + '\'' +
                "\n  rate=" + rate +
                "\n  isEnabled=" + isEnabled +
                "\n  isPrimary=" + isPrimary +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public void postCreate(DataStorage data) {
        clearBase(data);
    }

    @Override
    public void postUpdate(DataStorage data) {
        clearBase(data);
        for (Account a : data.getAccounts()) {
            if(a.getCurrency().equals(data.getOldCommon())) a.setCurrency(this);
        }
    }

    private void clearBase(DataStorage data) {
        if (isPrimary) {
            rate = 1;
            Currency old = (Currency)data.getOldCommon();
            for (Currency c : data.getCurrencies()) {
                if (!this.equals(c)) {
                    c.setPrimary(false);
                    if (old != null) c.setRate(c.getRate() / old.getRate());
                }
            }
        }
    }
}