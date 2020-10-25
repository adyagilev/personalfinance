package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.storage.DataStorage;

import java.util.Objects;

public class Purpose extends Common {
    private String title;
    private PurposeType type;

    public Purpose() {}

    public Purpose(String title) throws ModelException {
        this(title, null);
    }

    public Purpose(String title, PurposeType type) throws ModelException {
        if(title.length() == 0) throw new ModelException(ModelException.EMPTY_TITLE);
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PurposeType getType() {
        return type;
    }

    public void setType(PurposeType type) {
        this.type = type;
    }

    @Override
    public String getComboBoxElementTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\nPurpose{\n  title='" + title + "',\n  type='" + type + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purpose purpose = (Purpose) o;
        return Objects.equals(title, purpose.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public void postUpdate(DataStorage data) {
        for (Transaction t : data.getTransactions()) {
            if(t.getPurpose().equals(data.getOldCommon())) t.setPurpose(this);
        }
    }
}
