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
public class Farm {
    final static String TABLE_FARM = "Farm";
    final static String COLUMN_FARMID = "FarmID";
    final static String COLUMN_BARANGAYID = "BarangayID";
    final static String COLUMN_FARMNAME = "FarmName";
    final static String COLUMN_FARMAREA = "FarmArea";
    final static String COLUMN_ECOSYSTEM = "Ecosystem";
    
    private int farmID;
    private int barangayID;
    private String farmName;
    private double farmArea;
    private String ecosystem;
    
    public Farm() {
        
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
     * @return the barangayID
     */
    public int getBarangayID() {
        return barangayID;
    }

    /**
     * @param barangayID the barangayID to set
     */
    public void setBarangayID(int barangayID) {
        this.barangayID = barangayID;
    }

    /**
     * @return the farmName
     */
    public String getFarmName() {
        return farmName;
    }

    /**
     * @param farmName the farmName to set
     */
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    /**
     * @return the farmArea
     */
    public double getFarmArea() {
        return farmArea;
    }

    /**
     * @param farmArea the farmArea to set
     */
    public void setFarmArea(double farmArea) {
        this.farmArea = farmArea;
    }

    /**
     * @return the ecosystem
     */
    public String getEcosystem() {
        return ecosystem;
    }

    /**
     * @param ecosystem the ecosystem to set
     */
    public void setEcosystem(String ecosystem) {
        this.ecosystem = ecosystem;
    }
}
