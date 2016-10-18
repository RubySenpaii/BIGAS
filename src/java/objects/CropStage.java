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
public class CropStage {
    final static String TABLE_CROPSTAGE = "CropStage";
    final static String COLUMN_CROPSTAGEID = "CropStageID";
    final static String COLUMN_STAGE = "Stage";
    
    private int cropStageID;
    private String stage;
    
    public CropStage() {
        
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
     * @return the stage
     */
    public String getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(String stage) {
        this.stage = stage;
    }
}
