package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramEmployees {

    public static final String TABLE_NAME = "ProgramEmployees";
    public static final String COLUMN_PROGRAM_DEPLOYED_ID = "ProgramDeployedID";
    public static final String COLUMN_EMPLOYEE_ID = "EmployeeID";
    public static final String COLUMN_POSITION = "Position";

    private int programDeployedID;
    private int employeeID;
    private String position;

    public ProgramEmployees() {
    }

    public ProgramEmployees(int programDeployedID, int employeeID, String position) {
        this.programDeployedID = programDeployedID;
        this.employeeID = employeeID;
        this.position = position;
    }

    public int getProgramDeployedID() {
        return programDeployedID;
    }

    public void setProgramDeployedID(int programDeployedID) {
        this.programDeployedID = programDeployedID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
