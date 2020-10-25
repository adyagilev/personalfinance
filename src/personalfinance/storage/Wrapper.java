package personalfinance.storage;

import personalfinance.model.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class Wrapper {
    private List<Account> accounts;
    private List<Currency> currencies;
    private List<Purpose> purposes;
    private List<PurposeType> purposeTypes;
    private List<Transaction> transactions;
    private List<Transfer> transfers;

    @XmlElement(name = "accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @XmlElement(name = "currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @XmlElement(name = "purposes")
    public List<Purpose> getPurposes() {
        return purposes;
    }

    public void setPurposes(List<Purpose> purposes) {
        this.purposes = purposes;
    }

    @XmlElement(name = "purposeTypes")
    public List<PurposeType> getPurposeTypes() {
        return purposeTypes;
    }

    public void setPurposeTypes(List<PurposeType> purposeTypes) {
        this.purposeTypes = purposeTypes;
    }

    @XmlElement(name = "transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @XmlElement(name = "transfers")
    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
}
