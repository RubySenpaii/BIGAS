package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramObjectives {

    public static final String TABLE_NAME = "ProgramObjectives";
    public static final String COLUMN_PROGRAM_ID = "ProgramID";
    public static final String COLUMN_INDICATOR = "Indicator";
    public static final String COLUMN_TARGET_VALUE = "TargetValue";

    private int programID;
    private String indicator;
    private double targetValue;

    public ProgramObjectives() {
    }

    public ProgramObjectives(int programID, String indicator, double targetValue) {
        this.programID = programID;
        this.indicator = indicator;
        this.targetValue = targetValue;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }
}
