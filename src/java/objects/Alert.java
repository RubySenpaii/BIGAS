package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Alert {

    public static final String TABLE_NAME = "Alert";
    public static final String COLUMN_ALERT_ID = "AlertID";
    public static final String COLUMN_MESSAGE = "Message";
    public static final String COLUMN_REPORTED_BY = "ReportedBy";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_VALIDITY = "Validity";

    private int alertID;
    private String message;
    private int reportedBy;
    private String date;
    private String validity;

    public Alert() {
    }

    public Alert(int alertID, String message, int reportedBy, String date, String validity) {
        this.alertID = alertID;
        this.message = message;
        this.reportedBy = reportedBy;
        this.date = date;
        this.validity = validity;
    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(int reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
