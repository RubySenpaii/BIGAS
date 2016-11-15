package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Farm {

    public static final String TABLE_NAME = "Farm";
    public static final String COLUMN_FARM_ID = "FarmID";
    public static final String COLUMN_BARANGAY_ID = "BarangayID";
    public static final String COLUMN_FARM_NAME = "FarmName";
    public static final String COLUMN_FARM_ADDRESS = "FarmAddress";
    public static final String COLUMN_FARM_AREA = "FarmArea";
    public static final String COLUMN_ECOSYSTEM = "Ecosystem";
    public static final String COLUMN_LATITUDE = "Latitude";
    public static final String COLUMN_LONGITUDE = "Longitude";
    public static final String COLUMN_FARM_UPDATED = "FarmUpdated";

    private int farmID;
    private int barangayID;
    private String farmName;
    private String farmAddress;
    private double farmArea;
    private String ecosystem;
    private double latitude;
    private double longitude;
    private int farmUpdated; 

    public Farm() {
    }

    public Farm(int farmID, int barangayID, String farmName, double farmArea, String ecosystem, double latitude, double longitude, int farmUpdated) {
        this.farmID = farmID;
        this.barangayID = barangayID;
        this.farmName = farmName;
        this.farmArea = farmArea;
        this.ecosystem = ecosystem;
        this.latitude = latitude;
        this.longitude = longitude;
        this.farmUpdated = farmUpdated;
    }

    public int getFarmID() {
        return farmID;
    }

    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    public int getBarangayID() {
        return barangayID;
    }

    public void setBarangayID(int barangayID) {
        this.barangayID = barangayID;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getFarmArea() {
        return farmArea;
    }

    public void setFarmArea(double farmArea) {
        this.farmArea = farmArea;
    }

    public String getEcosystem() {
        return ecosystem;
    }

    public void setEcosystem(String ecosystem) {
        this.ecosystem = ecosystem;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the farmUpdated
     */
    public int getFarmUpdated() {
        return farmUpdated;
    }

    /**
     * @param farmUpdated the farmUpdated to set
     */
    public void setFarmUpdated(int farmUpdated) {
        this.farmUpdated = farmUpdated;
    }

    /**
     * @return the farmAddress
     */
    public String getFarmAddress() {
        return farmAddress;
    }

    /**
     * @param farmAddress the farmAddress to set
     */
    public void setFarmAddress(String farmAddress) {
        this.farmAddress = farmAddress;
    }
}
