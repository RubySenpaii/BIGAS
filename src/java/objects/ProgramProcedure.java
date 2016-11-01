package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramProcedure {

    public static final String TABLE_NAME = "ProgramProcedure";
    public static final String COLUMN_PROGRAM_ID = "ProgramID";
    public static final String COLUMN_PROCEDURE_NO = "ProcedureNo";
    public static final String COLUMN_PHASE = "Phase";
    public static final String COLUMN_ACTIVITY = "Activity";

    private int programID;
    private int procedureNo;
    private String phase;
    private String activity;

    public ProgramProcedure() {
    }

    public ProgramProcedure(int programID, int procedureNo, String phase, String activity) {
        this.programID = programID;
        this.procedureNo = procedureNo;
        this.phase = phase;
        this.activity = activity;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public int getProcedureNo() {
        return procedureNo;
    }

    public void setProcedureNo(int procedureNo) {
        this.procedureNo = procedureNo;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
