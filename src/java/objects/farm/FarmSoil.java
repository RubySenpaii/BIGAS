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
public class FarmSoil {
    final static String TABLE_FARMSOIL = "FarmSoil";
    final static String COLUMN_FARMID = "FarmID";
    final static String COLUMN_SOILNUTRIENT = "SoilNutrient";
    final static String COLUMN_AMOUNT = "Amount";
    
    private int farmID;
    private String soilNutrient;
    private double amount;
    
    public FarmSoil() {
        
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
     * @return the soilNutrient
     */
    public String getSoilNutrient() {
        return soilNutrient;
    }

    /**
     * @param soilNutrient the soilNutrient to set
     */
    public void setSoilNutrient(String soilNutrient) {
        this.soilNutrient = soilNutrient;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
