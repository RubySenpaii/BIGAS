package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class SeedVariety {

    public static final String TABLE_NAME = "SeedVariety";
    public static final String COLUMN_SEED_VARIETY_ID = "SeedVarietyID";
    public static final String COLUMN_VARIETY_NAME = "VarietyName";
    public static final String COLUMN_SEED_TYPE_ID = "SeedTypeID";
    public static final String COLUMN_ACQUIRED = "Acquired";
    public static final String COLUMN_WATER_SOURCE = "WaterSource";
    public static final String COLUMN_AVG_YIELD = "AverageYield";
    public static final String COLUMN_MAXIMUM_YIELD = "MaximumYield";
    public static final String COLUMN_MATURITY = "Maturity";
    public static final String COLUMN_HEIGHT = "Height";
    public static final String COLUMN_GRAIN_SIZE = "GrainSize";
    public static final String COLUMN_MILLING_RECOVERY = "MillingRecovery";
    public static final String COLUMN_CONDITION = "Condition";

    private String seedVarietyID;
    private String varietyName;
    private int seedTypeID;
    private String acquired;
    private String waterSource;
    private double averageYield;
    private double maximumYield;
    private int maturity;
    private double height;
    private String grainSize;
    private double millingRecovery;
    private String condition;

    public SeedVariety() {
    }

    public SeedVariety(String seedVarietyID, String varietyName, int seedTypeID, String acquired, String waterSource, double averageYield, double maximumYield, int maturity, double height, String grainSize, double millingRecovery, String condition) {
        this.seedVarietyID = seedVarietyID;
        this.varietyName = varietyName;
        this.seedTypeID = seedTypeID;
        this.acquired = acquired;
        this.waterSource = waterSource;
        this.averageYield = averageYield;
        this.maximumYield = maximumYield;
        this.maturity = maturity;
        this.height = height;
        this.grainSize = grainSize;
        this.millingRecovery = millingRecovery;
        this.condition = condition;
    }

    /**
     * @return the seedVarietyID
     */
    public String getSeedVarietyID() {
        return seedVarietyID;
    }

    /**
     * @param seedVarietyID the seedVarietyID to set
     */
    public void setSeedVarietyID(String seedVarietyID) {
        this.seedVarietyID = seedVarietyID;
    }

    /**
     * @return the varietyName
     */
    public String getVarietyName() {
        return varietyName;
    }

    /**
     * @param varietyName the varietyName to set
     */
    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    /**
     * @return the seedTypeID
     */
    public int getSeedTypeID() {
        return seedTypeID;
    }

    /**
     * @param seedTypeID the seedTypeID to set
     */
    public void setSeedTypeID(int seedTypeID) {
        this.seedTypeID = seedTypeID;
    }

    /**
     * @return the acquired
     */
    public String getAcquired() {
        return acquired;
    }

    /**
     * @param acquired the acquired to set
     */
    public void setAcquired(String acquired) {
        this.acquired = acquired;
    }

    /**
     * @return the waterSource
     */
    public String getWaterSource() {
        return waterSource;
    }

    /**
     * @param waterSource the waterSource to set
     */
    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    /**
     * @return the averageYield
     */
    public double getAverageYield() {
        return averageYield;
    }

    /**
     * @param averageYield the averageYield to set
     */
    public void setAverageYield(double averageYield) {
        this.averageYield = averageYield;
    }

    /**
     * @return the maximumYield
     */
    public double getMaximumYield() {
        return maximumYield;
    }

    /**
     * @param maximumYield the maximumYield to set
     */
    public void setMaximumYield(double maximumYield) {
        this.maximumYield = maximumYield;
    }

    /**
     * @return the maturity
     */
    public int getMaturity() {
        return maturity;
    }

    /**
     * @param maturity the maturity to set
     */
    public void setMaturity(int maturity) {
        this.maturity = maturity;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the grainSize
     */
    public String getGrainSize() {
        return grainSize;
    }

    /**
     * @param grainSize the grainSize to set
     */
    public void setGrainSize(String grainSize) {
        this.grainSize = grainSize;
    }

    /**
     * @return the millingRecovery
     */
    public double getMillingRecovery() {
        return millingRecovery;
    }

    /**
     * @param millingRecovery the millingRecovery to set
     */
    public void setMillingRecovery(double millingRecovery) {
        this.millingRecovery = millingRecovery;
    }

    /**
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }
}
