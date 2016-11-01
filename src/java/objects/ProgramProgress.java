package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramProgress {

    public static final String TABLE_NAME = "ProgramProgress";
    public static final String COLUMN_PROGRAM_DEPLOYED_ID = "ProgramDeployedID";
    public static final String COLUMN_PROCEDURE_NO = "ProcedureNo";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_REMARKS = "Remarks";
    public static final String COLUMN_REPORTED_BY = "ReportedBy";

    private int programDeployedID;
    private int procedureNo;
    private String date;
    private String Remarks;
    private int reportedBy;

    public ProgramProgress() {
    }

    public ProgramProgress(int programDeployedID, int procedureNo, String date, String remarks, int reportedBy) {
        this.programDeployedID = programDeployedID;
        this.procedureNo = procedureNo;
        this.date = date;
        Remarks = remarks;
        this.reportedBy = reportedBy;
    }

    public int getProgramDeployedID() {
        return programDeployedID;
    }

    public void setProgramDeployedID(int programDeployedID) {
        this.programDeployedID = programDeployedID;
    }

    public int getProcedureNo() {
        return procedureNo;
    }

    public void setProcedureNo(int procedureNo) {
        this.procedureNo = procedureNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public int getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(int reportedBy) {
        this.reportedBy = reportedBy;
    }
}

