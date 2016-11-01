package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Barangay {
    public static final String TABLE_NAME = "Barangay";
    public static final String COLUMN_BARANGAY_ID = "BarangayID";
    public static final String COLUMN_MUNICIPALITY_ID = "MunicipalityID";
    public static final String COLUMN_BARANGAY_NAME = "BarangayName";
    public static final String COLUMN_AREA = "Area";

    private int barangayID;
    private int municipalityID;
    private String barangayName;
    private double area;

    public Barangay() {
    }

    public Barangay(int barangayID, int municipalityID, String barangayName, double area) {
        this.barangayID = barangayID;
        this.municipalityID = municipalityID;
        this.barangayName = barangayName;
        this.area = area;
    }

    public int getBarangayID() {
        return barangayID;
    }

    public void setBarangayID(int barangayID) {
        this.barangayID = barangayID;
    }

    public int getMunicipalityID() {
        return municipalityID;
    }

    public void setMunicipalityID(int municipalityID) {
        this.municipalityID = municipalityID;
    }

    public String getBarangayName() {
        return barangayName;
    }

    public void setBarangayName(String barangayName) {
        this.barangayName = barangayName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
