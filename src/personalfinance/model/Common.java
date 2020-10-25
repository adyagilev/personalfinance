package personalfinance.model;

import personalfinance.storage.DataStorage;

abstract public class Common {
    public String getComboBoxElementTitle() {
        return null;
    }

    public void postCreate(DataStorage data) {}
    public void postUpdate(DataStorage data) {}
    public void postDelete(DataStorage data) {}
}
