package objects;

/**
 * Created by Josiah on 27/10/2016.
 */
public class PlantingReport {

    public static final String TABLE_NAME = "PlantingReport";
    public static final String COLUMN_PLANTING_REPORT_ID = "PlantingReportID";
    public static final String COLUMN_PLOT_ID = "PlotID";
    public static final String COLUMN_SEASON = "Season";
    public static final String COLUMN_YEAR = "Year";
    public static final String COLUMN_PLANTING_METHOD = "PlantingMethod";
    public static final String COLUMN_DATE_PLANTED = "DatePlanted";
    public static final String COLUMN_SEED_VARIETY_ID = "SeedVarietyID";
    public static final String COLUMN_SEED_PLANTED = "SeedPlanted";
    public static final String COLUMN_AMOUNT_HARVESTED = "AmountHarvested";

    private int plantingReportID;
    private int plotID;
    private String season;
    private String year;
    private String plantingMethod;
    private String datePlanted;
    private String seedVarietyID;
    private double seedPlanted;
    private double amountHarvested;

    public PlantingReport() {
    }

    public PlantingReport(int plantingReportID, int plotID, String season, String year, String datePlanted, String seedVarietyID, double seedPlanted, double amountHarvested, String plantingMethod) {
        this.plantingReportID = plantingReportID;
        this.plotID = plotID;
        this.season = season;
        this.year = year;
        this.datePlanted = datePlanted;
        this.seedVarietyID = seedVarietyID;
        this.seedPlanted = seedPlanted;
        this.amountHarvested = amountHarvested;
        this.plantingMethod = plantingMethod;
    }

    public int getPlantingReportID() {
        return plantingReportID;
    }

    public void setPlantingReportID(int plantingReportID) {
        this.plantingReportID = plantingReportID;
    }

    public int getPlotID() {
        return plotID;
    }

    public void setPlotID(int plotID) {
        this.plotID = plotID;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(String datePlanted) {
        this.datePlanted = datePlanted;
    }

    public String getSeedVarietyID() {
        return seedVarietyID;
    }

    public void setSeedVarietyID(String seedVarietyID) {
        this.seedVarietyID = seedVarietyID;
    }

    public double getSeedPlanted() {
        return seedPlanted;
    }

    public void setSeedPlanted(double seedPlanted) {
        this.seedPlanted = seedPlanted;
    }

    public double getAmountHarvested() {
        return amountHarvested;
    }

    public void setAmountHarvested(double amountHarvested) {
        this.amountHarvested = amountHarvested;
    }

    /**
     * @return the plantingMethod
     */
    public String getPlantingMethod() {
        return plantingMethod;
    }

    /**
     * @param plantingMethod the plantingMethod to set
     */
    public void setPlantingMethod(String plantingMethod) {
        this.plantingMethod = plantingMethod;
    }
}
