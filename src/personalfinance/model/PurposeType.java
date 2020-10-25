package personalfinance.model;

import personalfinance.settings.Localization;

public class PurposeType extends Common {
    public static final String INCOME_ACTIVE = "INCOME_ACTIVE";
    public static final String INCOME_PASSIVE = "INCOME_PASSIVE";
    public static final String OUTCOME_INVEST = "OUTCOME_INVEST";
    public static final String OUTCOME_SAVE = "OUTCOME_SAVE";
    public static final String OUTCOME_HELP = "OUTCOME_HELP";
    public static final String OUTCOME_STUDY = "OUTCOME_STUDY";
    public static final String OUTCOME_FUN = "OUTCOME_FUN";
    public static final String OUTCOME_SPEND = "OUTCOME_SPEND";

    private String title;

    public PurposeType() {}

    public PurposeType(String type) {
        title = Localization.get(type);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getComboBoxElementTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\nPurposeType{\n  title='" + title + "'\n}";
    }
}
