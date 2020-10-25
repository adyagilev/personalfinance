package personalfinance.storage;

import personalfinance.exception.ModelException;
import personalfinance.model.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class DataStorage {
    private static DataStorage instance;
    private List<Account> accounts = new ArrayList();
    private List<Currency> currencies = new ArrayList();
    private List<Purpose> purposes = new ArrayList();
    private List<PurposeType> purposeTypes = new ArrayList();
    private List<Transaction> transactions = new ArrayList();
    private List<Transfer> transfers = new ArrayList();
    private Common oldCommon;
    private boolean isSaved = true;
    private final Filter filter;

    private DataStorage() {
        this.filter = new Filter();
        load();
    }

    public static DataStorage getInstance() {
        if (instance == null) instance = new DataStorage();
        return instance;
    }

    public static void setInstance(DataStorage instance) {
        DataStorage.instance = instance;
    }

    public Filter getFilter() {
        return filter;
    }

    public void load() {
        SaveLoad.load(this);
        sort();
    }

    public void save() {
        SaveLoad.save(this);
        isSaved = true;
    }

    public boolean isSaved() {
        return isSaved;
    }

    private void sort() {
        this.accounts.sort(
            (Account var1, Account var2) -> var1.getTitle().compareToIgnoreCase(var2.getTitle())
        );
        this.purposes.sort(
                (Purpose var1, Purpose var2) -> var1.getTitle().compareToIgnoreCase(var2.getTitle())
        );
        this.transactions.sort(
                (Transaction var1, Transaction var2) -> var2.getDate().compareTo(var1.getDate())
        );
        this.transfers.sort(
                (Transfer var1, Transfer var2) -> var2.getDate().compareTo(var1.getDate())
        );
        this.currencies.sort((Currency c1, Currency c2) -> {
            if (c1.isPrimary()) return -1;
            if (c2.isPrimary()) return 1;
            if (c1.isEnabled() ^ c2.isEnabled()) {
                return c1.isEnabled() ? -1 : 1;
            }
            return c1.getTitle().compareToIgnoreCase(c2.getTitle());
        });
    }

    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency c : getCurrencies()) {
            c.setRate(rates.get(c.getCode()));
        }
        for (Account a : getAccounts()) {
            Currency c = a.getCurrency();
            c.setRate(rates.get(c.getCode()));
            a.setCurrency(c);
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> acounts) {
        this.accounts = acounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Purpose> getPurposes() {
        return purposes;
    }

    public void setPurposes(List<Purpose> purposes) {
        this.purposes = purposes;
    }

    public List<PurposeType> getPurposeTypes() {
        return purposeTypes;
    }

    public void setPurposeTypes(List<PurposeType> purposeTypes) {
        this.purposeTypes = purposeTypes;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Currency getBaseCurrency() throws ModelException {
        for (Currency c : getCurrencies()) {
            if (c.isPrimary()) return c;
        }
        throw new ModelException(ModelException.EMPTY_CURRENCY);
    }

    public ArrayList<Currency> getEnabledCurrencies() {
        ArrayList<Currency> list = new ArrayList<>();
        for (Currency c : getCurrencies()) {
            if (c.isEnabled()) list.add(c);
        }
        return list;
    }

    public ArrayList<PurposeType> getAllPurposeTypes() {
        return new ArrayList<PurposeType>() {{
            add(new PurposeType(PurposeType.INCOME_ACTIVE));
            add(new PurposeType(PurposeType.INCOME_PASSIVE));
            add(new PurposeType(PurposeType.OUTCOME_INVEST));
            add(new PurposeType(PurposeType.OUTCOME_SAVE));
            add(new PurposeType(PurposeType.OUTCOME_HELP));
            add(new PurposeType(PurposeType.OUTCOME_STUDY));
            add(new PurposeType(PurposeType.OUTCOME_FUN));
            add(new PurposeType(PurposeType.OUTCOME_SPEND));
        }};
    }

    public List<Transaction> getLastTransactions(int count) {
        return new ArrayList<>(
                transactions.subList(0, Math.min(count, transactions.size()))
        );
    }

    public List<Transfer> getLastTransfers(int count) {
        return new ArrayList<>(
                transfers.subList(0, Math.min(count, transfers.size()))
        );
    }

    public Common getOldCommon() {
        return oldCommon;
    }

    public void add(Common c) throws ModelException {
        List ref = getReference(c);
        if (ref.contains(c)) throw new ModelException(ModelException.ALREADY_EXISTS);
        ref.add(c);
        c.postCreate(this);
        sort();
        isSaved = false;
    }

    public void edit(Common oldC, Common newC) throws ModelException {
        List ref = getReference(oldC);
        if (!ref.contains(oldC)) throw new ModelException(ModelException.NOT_EXISTS);
        if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) throw new ModelException(ModelException.ALREADY_EXISTS);
        ref.set(ref.indexOf(oldC), newC);
        oldCommon = oldC;
        newC.postUpdate(this);
        sort();
        isSaved = false;
    }

    public void remove(Common c) throws ModelException {
        List ref = getReference(c);
        if (!ref.contains(c)) throw new ModelException(ModelException.NOT_EXISTS);
        ref.remove(c);
        c.postDelete(this);
        sort();
        isSaved = false;
    }

    private List getReference(Common c) {
        if(c instanceof Account) return accounts;
        if(c instanceof Currency) return currencies;
        if(c instanceof Purpose) return purposes;
        if(c instanceof PurposeType) return purposeTypes;
        if(c instanceof Transaction) return transactions;
        if(c instanceof Transfer) return transfers;
        return null;
    }

    @Override
    public String toString() {
        return "DataStorage{" +
                "accounts=" + accounts +
                ", currencies=" + currencies +
                ", purposes=" + purposes +
                ", purposeTypes=" + purposeTypes +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                ", oldCommon=" + oldCommon +
                ", isSaved=" + isSaved +
                '}';
    }
}
