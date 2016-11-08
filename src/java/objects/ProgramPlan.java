package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramPlan {

    public static final String TABLE_NAME = "ProgramPlan";
    public static final String COLUMN_PROGRAM_ID = "ProgramID";
    public static final String COLUMN_PROGRAM_NAME = "ProgramName";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_HEADED_BY = "HeadedBy";
    public static final String COLUMN_PURPOSE = "Purpose";

    private int programID;
    private String programName;
    private String description;
    private String type;
    private String headedBy;
    private String purpose;

    public ProgramPlan() {
    }

    public ProgramPlan(int programID, String programName, String description, String type, String headedBy, String purpose) {
        this.programID = programID;
        this.programName = programName;
        this.description = description;
        this.type = type;
        this.headedBy = headedBy;
        this.purpose = purpose;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeadedBy() {
        return headedBy;
    }

    public void setHeadedBy(String headedBy) {
        this.headedBy = headedBy;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
