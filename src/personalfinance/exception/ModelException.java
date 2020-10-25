package personalfinance.exception;

import personalfinance.settings.Localization;

public class ModelException extends Exception {
    public static final int NOT_EXISTS = 1;
    public static final int ALREADY_EXISTS = 2;
    public static final int EMPTY_TITLE = 101;
    public static final int EMPTY_CURRENCY = 102;
    public static final int EMPTY_PURPOSE = 103;
    public static final int EMPTY_ACCOUNT = 104;
    public static final int EMPTY_CODE = 105;
    public static final int EMPTY_DATE = 106;
    public static final int AMOUNT_FORMAT = 107;
    public static final int PRIMARY_CURRENCY_IS_NOT_SET = 108;

    private final int code;

    public ModelException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        switch (code) {
            case NOT_EXISTS:
                return Localization.get("ERROR_NOT_EXISTS");
            case ALREADY_EXISTS:
                return Localization.get("ERROR_ALREADY_EXISTS");
            case EMPTY_TITLE:
                return Localization.get("ERROR_EMPTY_TITLE");
            case EMPTY_CURRENCY:
                return Localization.get("ERROR_EMPTY_CURRENCY");
            case EMPTY_PURPOSE:
                return Localization.get("ERROR_EMPTY_PURPOSE");
            case EMPTY_ACCOUNT:
                return Localization.get("ERROR_EMPTY_ACCOUNT");
            case EMPTY_CODE:
                return Localization.get("ERROR_EMPTY_CODE");
            case EMPTY_DATE:
                return Localization.get("ERROR_EMPTY_DATE");
            case AMOUNT_FORMAT:
                return Localization.get("ERROR_AMOUNT_FORMAT");
            case PRIMARY_CURRENCY_IS_NOT_SET:
                return Localization.get("ERROR_PRIMARY_CURRENCY_IS_NOT_SET");
            default:
                return Localization.get("ERROR_MESSAGE_IS_ABSENT");
        }
    }
}
