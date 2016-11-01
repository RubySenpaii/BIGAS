package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class TargetProduction {

    public static final String TABLE_NAME = "TargetProduction";
    public static final String COLUMN_YEAR = "Year";
    public static final String COLUMN_TARGET = "Target";
    public static final String COLUMN_SET_BY = "SetBy";

    private int year;
    private double target;
    private int setBy;

    public TargetProduction() {
    }

    public TargetProduction(int year, double target, int setBy) {
        this.year = year;
        this.target = target;
        this.setBy = setBy;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public int getSetBy() {
        return setBy;
    }

    public void setSetBy(int setBy) {
        this.setBy = setBy;
    }
}
