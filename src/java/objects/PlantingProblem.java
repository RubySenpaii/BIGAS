package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class PlantingProblem {

    public static final String TABLE_NAME = "PlantingProblem";
    public static final String COLUMN_PROBLEM_REPORT_ID = "ProblemReportID";
    public static final String COLUMN_PLANTING_REPORT_ID ="PlantingReportID";
    public static final String COLUMN_EMPLOYEE_ID = "EmployeeID";
    public static final String COLUMN_PROBLEM_ID = "ProblemID";
    public static final String COLUMN_DATE_REPORTED = "DateReported";
    public static final String COLUMN_AREA_AFFECTED = "AreaAffected";
    public static final String COLUMN_IMAGE = "Image";

    private int problemReportID;
    private int plantingReportID;
    private int employeeID;
    private int problemID;
    private String dateReported;
    private double areaAffected;
    private String image;

    public PlantingProblem() {
    }

    public PlantingProblem(int problemReportID, int plantingReportID, int employeeID, int problemID, String dateReported, double areaAffected) {
        this.problemReportID = problemReportID;
        this.plantingReportID = plantingReportID;
        this.employeeID = employeeID;
        this.problemID = problemID;
        this.dateReported = dateReported;
        this.areaAffected = areaAffected;
    }

    public int getProblemID() {
        return problemID;
    }

    public void setProblemID(int problemID) {
        this.problemID = problemID;
    }

    public int getPlantingReportID() {
        return plantingReportID;
    }

    public void setPlantingReportID(int plantingReportID) {
        this.plantingReportID = plantingReportID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getProblemReportID() {
        return problemReportID;
    }

    public void setProblemReportID(int problemReportID) {
        this.problemReportID = problemReportID;
    }

    public String getDateReported() {
        return dateReported;
    }

    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
    }

    public double getAreaAffected() {
        return areaAffected;
    }

    public void setAreaAffected(double areaAffected) {
        this.areaAffected = areaAffected;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
