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
public class SeedResistance {
    
    public static String TABLE_NAME = "SeedResistance";
    public static String COLUMN_SEED_VARIETY_ID = "SeedVarietyID";
    public static String COLUMN_PROBLEM_ID = "ProblemID";
    public static String COLUMN_TOLERANCE_LEVEL = "ToleranceLevel";
    
    private String seedVarietyID;
    private int problemID;
    private String toleranceLevel;
    
    public SeedResistance() {
        
    }
    
    public SeedResistance(String seedVarietyID, int problemID, String toleranceLevel) {
        this.seedVarietyID = seedVarietyID;
        this.problemID = problemID;
        this.toleranceLevel = toleranceLevel;
    }

    /**
     * @return the seedVarietyID
     */
    public String getSeedVarietyID() {
        return seedVarietyID;
    }

    /**
     * @param seedVarietyID the seedVarietyID to set
     */
    public void setSeedVarietyID(String seedVarietyID) {
        this.seedVarietyID = seedVarietyID;
    }

    /**
     * @return the problemID
     */
    public int getProblemID() {
        return problemID;
    }

    /**
     * @param problemID the problemID to set
     */
    public void setProblemID(int problemID) {
        this.problemID = problemID;
    }

    /**
     * @return the toleranceLevel
     */
    public String getToleranceLevel() {
        return toleranceLevel;
    }

    /**
     * @param toleranceLevel the toleranceLevel to set
     */
    public void setToleranceLevel(String toleranceLevel) {
        this.toleranceLevel = toleranceLevel;
    }
}
