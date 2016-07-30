/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.farm;

/**
 *
 * @author RubySenpaii
 */
public class SeedStage {
    final static String TABLE_SEEDSTAGE = "SeedStage";
    final static String COLUMN_PLANTEDD = "PlantedID";
    final static String COLUMN_CROPSTAGEID = "CropStageID";
    final static String COLUMN_UPDATEDBY = "UpdatedBy";
    final static String COLUMN_DATEUPDATED = "DateUpdated";
    final static String COLUMN_HARVESTED = "Harvested";
    final static String COLUMN_REMARKS = "Remarks";
    
    private int plantedID;
    private int cropStageID;
    private int updatedBy;
    private String dateUpdated;
    private double harvested;
    private String remarks;
    
    public SeedStage() {
        
    }

    /**
     * @return the plantedID
     */
    public int getPlantedID() {
        return plantedID;
    }

    /**
     * @param plantedID the plantedID to set
     */
    public void setPlantedID(int plantedID) {
        this.plantedID = plantedID;
    }

    /**
     * @return the cropStageID
     */
    public int getCropStageID() {
        return cropStageID;
    }

    /**
     * @param cropStageID the cropStageID to set
     */
    public void setCropStageID(int cropStageID) {
        this.cropStageID = cropStageID;
    }

    /**
     * @return the updatedBy
     */
    public int getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the dateUpdated
     */
    public String getDateUpdated() {
        return dateUpdated;
    }

    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the harvested
     */
    public double getHarvested() {
        return harvested;
    }

    /**
     * @param harvested the harvested to set
     */
    public void setHarvested(double harvested) {
        this.harvested = harvested;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
