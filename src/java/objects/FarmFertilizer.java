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
public class FarmFertilizer {
    final static String TABLE_FARMFERTILIZER = "FarmFertilizer";
    final static String COLUMN_FARMID = "FarmID";
    final static String COLUMN_FERTILIZERID = "FertilizerID";
    final static String COLUMN_DATEAPPLIED = "DateApplied";
    
    private int farmID;
    private int fertilizerID;
    private String dateApplied;
    
    public FarmFertilizer() {
        
    }

    /**
     * @return the farmID
     */
    public int getFarmID() {
        return farmID;
    }

    /**
     * @param farmID the farmID to set
     */
    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    /**
     * @return the fertilizerID
     */
    public int getFertilizerID() {
        return fertilizerID;
    }

    /**
     * @param fertilizerID the fertilizerID to set
     */
    public void setFertilizerID(int fertilizerID) {
        this.fertilizerID = fertilizerID;
    }

    /**
     * @return the dateApplied
     */
    public String getDateApplied() {
        return dateApplied;
    }

    /**
     * @param dateApplied the dateApplied to set
     */
    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }
}
