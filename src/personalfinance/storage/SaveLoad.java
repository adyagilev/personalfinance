package personalfinance.storage;

import personalfinance.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SaveLoad {
    public static void load(DataStorage data) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Wrapper wrapper = (Wrapper)unmarshaller.unmarshal(Settings.getSaveFile());
            data.setAccounts(wrapper.getAccounts());
            data.setCurrencies(wrapper.getCurrencies());
            data.setPurposes(wrapper.getPurposes());
            data.setPurposeTypes(wrapper.getPurposeTypes());
            data.setTransactions(wrapper.getTransactions());
            data.setTransfers(wrapper.getTransfers());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void save(DataStorage data) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Wrapper wrapper = new Wrapper();
            wrapper.setAccounts(data.getAccounts());
            wrapper.setCurrencies(data.getCurrencies());
            wrapper.setPurposes(data.getPurposes());
            wrapper.setPurposeTypes(data.getPurposeTypes());
            wrapper.setTransactions(data.getTransactions());
            wrapper.setTransfers(data.getTransfers());

            marshaller.marshal(wrapper, Settings.getSaveFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
