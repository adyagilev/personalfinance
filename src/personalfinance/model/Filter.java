package personalfinance.model;

import java.util.Date;

public class Filter {
    private Date from;
    private Date to;
    private int step;

    public static final int STEP_DAY = 1;
    public static final int STEP_MONTH = 2;
    public static final int STEP_YEAR = 3;

    public Filter() {}
    public Filter(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public boolean isMatch(Date date) {
        return (date.compareTo(from)) > 0 && (date.compareTo(to) < 0);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
