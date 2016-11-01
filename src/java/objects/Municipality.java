package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Municipality {

    public static final String TABLE_NAME = "Municipality";
    public static final String COLUMN_MUNICIPALITY_ID = "MunicipalityID";
    public static final String COLUMN_MUNICIPALITY_NAME = "MunicipalityName";
    public static final String COLUMN_DISTRICT = "District";
    public static final String COLUMN_AREA = "Area";
    public static final String COLUMN_LONGITUDE = "Longitude";
    public static final String COLUMN_LATITUDE = "Latitude";

    private int municipalityID;
    private String municipalityName;
    private int disctrict;
    private double area;
    private double longitude;
    private double latitude;

    public Municipality() {
    }

    public Municipality(int municipalityID, String municipalityName, int disctrict, double area) {
        this.municipalityID = municipalityID;
        this.municipalityName = municipalityName;
        this.disctrict = disctrict;
        this.area = area;
    }

    public int getMunicipalityID() {
        return municipalityID;
    }

    public void setMunicipalityID(int municipalityID) {
        this.municipalityID = municipalityID;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public int getDisctrict() {
        return disctrict;
    }

    public void setDisctrict(int disctrict) {
        this.disctrict = disctrict;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
