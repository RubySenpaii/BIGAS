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
public class FertilizerNutrients {
    final static String TABLE_FERTILIZERNUTRIENTS = "FertilizerNutrients";
    final static String COLUMN_FERTILIZERID = "FertilizerID";
    final static String COLUMN_MINERAL = "Mineral";
    final static String COLUMN_PERCENTAGE = "Percentage";
    
    private int fertilizerID;
    private String mineral;
    private double percentage;
    
    public FertilizerNutrients() {
        
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
     * @return the mineral
     */
    public String getMineral() {
        return mineral;
    }

    /**
     * @param mineral the mineral to set
     */
    public void setMineral(String mineral) {
        this.mineral = mineral;
    }

    /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
