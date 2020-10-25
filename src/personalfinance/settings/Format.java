package personalfinance.settings;

import personalfinance.model.Currency;
import personalfinance.model.Filter;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Format {
    public static String amount(double amount) {
        return String.format(Settings.FORMAT_AMOUNT, amount);
    }

    public static String amount(double amount, Currency currency) {
        return amount(amount) + " " + currency.getCode();
    }

    public static String rate(double rate) {
        return String.format(Settings.FORMAT_RATE, rate);
    }

    public static String rate(double rate, Currency currency) {
        return rate(rate) + " " + currency.getCode();
    }

    public static String dateDay(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_DATE);
    }

    public static String dateMonth(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_MONTH);
    }

    public static String dateYear(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_YEAR);
    }

    private static String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, new CustomDateFormatSymbols());
        return sdf.format(date);
    }

    public static double parceAmount(String amount) {
        amount = amount.replaceAll(",", ".");
        return Double.parseDouble(amount);
    }

    public static String getFilterTitle(Filter filter) {
        Date date = filter.getTo();
        switch (filter.getStep()) {
            case Filter.STEP_DAY:
                return dateDay(date);
            case Filter.STEP_MONTH:
                return dateMonth(date);
            case Filter.STEP_YEAR:
                return dateYear(date);
        }
        return null;
    }

    private static class CustomDateFormatSymbols extends DateFormatSymbols {
        @Override
        public String[] getMonths() {
            return Localization.getMonths();
        }
    }
}
