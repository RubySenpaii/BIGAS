package tbd;

/**
 * Created by Josiah on 27/10/2016.
 */

public class PlantingStage {

    public static final String TABLE_NAME = "PlantingStage";
    public static final String COLUMN_PLANTING_REPORT_ID = "PlantingReportID";
    public static final String COLUMN_CROP_STAGE = "CropStage";
    public static final String COLUMN_DATE_REPORTED = "DateReported";
    public static final String COLUMN_IMAGE = "Image";

    private String plantingReportID;
    private String cropStage;
    private String dateReported;
    private String image;

    public PlantingStage() {
    }

    public PlantingStage(String plantingReportID, String cropStage, String dateReported) {
        this.plantingReportID = plantingReportID;
        this.cropStage = cropStage;
        this.dateReported = dateReported;
    }

    public String getPlantingReportID() {
        return plantingReportID;
    }

    public void setPlantingReportID(String plantingReportID) {
        this.plantingReportID = plantingReportID;
    }

    public String getCropStage() {
        return cropStage;
    }

    public void setCropStage(String cropStage) {
        this.cropStage = cropStage;
    }

    public String getDateReported() {
        return dateReported;
    }

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
}
