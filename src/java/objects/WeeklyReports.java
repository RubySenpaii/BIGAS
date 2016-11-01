/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author RubySenpaii
 */
public class WeeklyReports {
    
    public static String TABLE_NAME = "WeeklyReports";
    public static String COLUMN_CROP_STAGE = "CropStage";
    public static String COLUMN_DATE_REPORTED = "DateReported";
    public static String COLUMN_IMAGE = "Image";
    public static String COLUMN_PLANTING_REPORT_ID = "PlantingReportID";
    public static String COLUMN_WATER_LEVEL = "WaterLevel";
    public static String COLUMN_HEIGHT = "Height";
    
    private String cropStage;
    private String dateReported;
    private String image;
    private int plantingReportID;
    private double waterLevel;
    private double height;
    
    public WeeklyReports(){
        
    }
    
    public WeeklyReports(String cropStage, String dateReported, String image, int plantingReportID, double waterLevel, double height) {
        this.cropStage = cropStage;
        this.dateReported = dateReported;
        this.image = image;
        this.waterLevel = waterLevel;
        this.height = height;
        this.plantingReportID = plantingReportID;
    }

    /**
     * @return the cropStage
     */
    public String getCropStage() {
        return cropStage;
    }

    /**
     * @param cropStage the cropStage to set
     */
    public void setCropStage(String cropStage) {
        this.cropStage = cropStage;
    }

    /**
     * @return the dateReported
     */
    public String getDateReported() {
        return dateReported;
    }

    /**
     * @param dateReported the dateReported to set
     */
    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
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

    /**
     * @return the waterLevel
     */
    public double getWaterLevel() {
        return waterLevel;
    }

    /**
     * @param waterLevel the waterLevel to set
     */
    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
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
     * @return the plantingReportID
     */
    public int getPlantingReportID() {
        return plantingReportID;
    }

    /**
     * @param plantingReportID the plantingReportID to set
     */
    public void setPlantingReportID(int plantingReportID) {
        this.plantingReportID = plantingReportID;
    }
    
    
}
