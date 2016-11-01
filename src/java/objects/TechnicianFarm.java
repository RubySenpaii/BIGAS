package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class TechnicianFarm {

    public static final String TABLE_NAME = "TechnicianFarm";
    public static final String COLUMN_ASSIGNED_FARM_ID = "AssignedFarmID";
    public static final String COLUMN_FARM_ID = "FarmID";
    public static final String COLUMN_EMPLOYEE_ID = "EmployeeID";
    public static final String COLUMN_START_DATE = "StartDate";
    public static final String COLUMN_END_DATE = "EndDate";

    private int assignedFarmID;
    private int farmID;
    private int employeeID;
    private String startDate;
    private String endDate;

    public TechnicianFarm() {
    }

    public TechnicianFarm(int assignedFarmID, int farmID, int employeeID, String startDate, String endDate) {
        this.assignedFarmID = assignedFarmID;
        this.farmID = farmID;
        this.employeeID = employeeID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getFarmID() {
        return farmID;
    }

    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the assignedFarmID
     */
    public int getAssignedFarmID() {
        return assignedFarmID;
    }

    /**
     * @param assignedFarmID the assignedFarmID to set
     */
    public void setAssignedFarmID(int assignedFarmID) {
        this.assignedFarmID = assignedFarmID;
    }
}
