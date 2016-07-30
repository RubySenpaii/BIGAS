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
public class SeedVariety {
    final static String TABLE_SEEDVARIETY = "SeedVariety";
    final static String COLUMN_SEEDVARIETYID = "SeedVarietyID";
    final static String COLUMN_SEEDTYPEID = "SeedTypeID";
    final static String COLUMN_VARIETYNAME = "VarietyName";
    final static String COLUMN_MATURITYDAYMIN = "MaturityDayMin";
    final static String COLUMN_MATURITYDAYMAX = "MaturityDayMax";
    
    private int seedVarietyID;
    private int seedTypeID;
    private String varietyName;
    private int maturityDayMin;
    private int maturityDayMax;
    
    public SeedVariety() {
        
    }

    /**
     * @return the seedVarietyID
     */
    public int getSeedVarietyID() {
        return seedVarietyID;
    }

    /**
     * @param seedVarietyID the seedVarietyID to set
     */
    public void setSeedVarietyID(int seedVarietyID) {
        this.seedVarietyID = seedVarietyID;
    }

    /**
     * @return the seedTypeID
     */
    public int getSeedTypeID() {
        return seedTypeID;
    }

    /**
     * @param seedTypeID the seedTypeID to set
     */
    public void setSeedTypeID(int seedTypeID) {
        this.seedTypeID = seedTypeID;
    }

    /**
     * @return the varietyName
     */
    public String getVarietyName() {
        return varietyName;
    }

    /**
     * @param varietyName the varietyName to set
     */
    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    /**
     * @return the maturityDayMin
     */
    public int getMaturityDayMin() {
        return maturityDayMin;
    }

    /**
     * @param maturityDayMin the maturityDayMin to set
     */
    public void setMaturityDayMin(int maturityDayMin) {
        this.maturityDayMin = maturityDayMin;
    }

    /**
     * @return the maturityDayMax
     */
    public int getMaturityDayMax() {
        return maturityDayMax;
    }

    /**
     * @param maturityDayMax the maturityDayMax to set
     */
    public void setMaturityDayMax(int maturityDayMax) {
        this.maturityDayMax = maturityDayMax;
    }
    
    
}
