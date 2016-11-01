package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramProblem {

    public static final String TABLE_NAME = "ProgramProblem";
    public static final String COLUMN_PROBLEM_REPORT_ID = "ProblemReportID";
    public static final String COLUMN_PROGRAM_DEPLOYED_ID = "ProgramDeployedID";

    private int problemReportID;
    private int programDeployedID;

    public ProgramProblem() {
    }

    public ProgramProblem(int problemReportID, int programDeployedID) {
        this.problemReportID = problemReportID;
        this.programDeployedID = programDeployedID;
    }

    public int getProblemReportID() {
        return problemReportID;
    }

    public void setProblemReportID(int problemReportID) {
        this.problemReportID = problemReportID;
    }

    public int getProgramDeployedID() {
        return programDeployedID;
    }

    public void setProgramDeployedID(int programDeployedID) {
        this.programDeployedID = programDeployedID;
    }
}
