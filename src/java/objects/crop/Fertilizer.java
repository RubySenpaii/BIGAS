/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.crop;

/**
 *
 * @author RubySenpaii
 */
public class Fertilizer {
    final static String TABLE_FERTILIZER = "Fertilizer";
    final static String COLUMN_FERTILIZERID = "FertilizerID";
    final static String COLUMN_FERTILIZERNAME = "FertilizerName";
    
    private int fertilizerID;
    private String fertilizerName;
    
    public Fertilizer() {
        
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
     * @return the fertilizerName
     */
    public String getFertilizerName() {
        return fertilizerName;
    }

    /**
     * @param fertilizerName the fertilizerName to set
     */
    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }
}
