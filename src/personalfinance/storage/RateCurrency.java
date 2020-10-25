package personalfinance.storage;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import personalfinance.model.Currency;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RateCurrency {
    private static final String EXCHANGE_RATE_URL = "http://cbr.ru/scripts/XML_daily.asp?date_req=%s";
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static HashMap<String, Double> getRates(Currency primaryCurrency) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String url = String.format(EXCHANGE_RATE_URL, dateFormat.format(new Date()));
        System.out.println("URL: " + url);

        // Get xml with actual rates from Central Bank of Russian Federation
        HashMap<String, NodeList> result = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(
                new URL(url).openStream()
        );

        NodeList nodes = doc.getElementsByTagName("Valute");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            NodeList children = node.getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                Node child = children.item(j);
                if (child.getNodeName().equals("CharCode")) {
                    result.put(child.getTextContent(), children);
                }
            }
        }

        // Get rates for Russian Ruble
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("RUB", 1.0);
        for (Map.Entry<String, NodeList> entry : result.entrySet()) {
            NodeList temp = entry.getValue();
            double value = 0.0;
            int nominal = 0;
            for (int i = 0; i < temp.getLength(); i++) {
                if(temp.item(i).getNodeName().equals("Value"))
                    value = Double.parseDouble(temp.item(i).getTextContent().replace(',', '.'));
                if(temp.item(i).getNodeName().equals("Nominal"))
                    nominal = Integer.parseInt(temp.item(i).getTextContent());
            }
            double amount = value / nominal;
            rates.put(
                entry.getKey(),
                ((double)Math.round(amount * 10000) / 10000)
            );
        }

        // Recalculate according to actual Primary Currency
        double div = rates.get(primaryCurrency.getCode());
        for (Map.Entry<String, Double> entry : rates.entrySet()) {
            entry.setValue(entry.getValue() / div);
        }

        return rates;
    }
}
