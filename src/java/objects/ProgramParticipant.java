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
public class ProgramParticipant {

    public static final String TABLE_NAME = "ProgramParticipant";
    public static final String COLUMN_FARMER_ID = "FarmerID";
    public static final String COLUMN_PROGRAM_DEPLOYED_ID = "ProgramDeployedID";
    public static final String COLUMN_FERTILIZER_ACQUIRED = "FertilizerAcquired";
    public static final String COLUMN_SEEDS_ACQUIRED = "SeedsAcquired";

    private int farmerID;
    private int programDeployedID;
    private double fertilizerAcquired;
    private double seedsAcquired;

    public ProgramParticipant() {
    }

    public ProgramParticipant(int farmerID, int programDeployedID, double fertilizerAcquired, double seedAcquired) {
        this.farmerID = farmerID;
        this.programDeployedID = programDeployedID;
        this.fertilizerAcquired = fertilizerAcquired;
        this.seedsAcquired = seedAcquired;
    }

    /**
     * @return the farmerID
     */
    public int getFarmerID() {
        return farmerID;
    }

    /**
     * @param farmerID the farmerID to set
     */
    public void setFarmerID(int farmerID) {
        this.farmerID = farmerID;
    }

    /**
     * @return the programDeployedID
     */
    public int getProgramDeployedID() {
        return programDeployedID;
    }

    /**
     * @param programDeployedID the programDeployedID to set
     */
    public void setProgramDeployedID(int programDeployedID) {
        this.programDeployedID = programDeployedID;
    }

    /**
     * @return the fertilizerAcquired
     */
    public double getFertilizerAcquired() {
        return fertilizerAcquired;
    }

    /**
     * @param fertilizerAcquired the fertilizerAcquired to set
     */
    public void setFertilizerAcquired(double fertilizerAcquired) {
        this.fertilizerAcquired = fertilizerAcquired;
    }

    /**
     * @return the seedsAcquired
     */
    public double getSeedsAcquired() {
        return seedsAcquired;
    }

    /**
     * @param seedsAcquired the seedsAcquired to set
     */
    public void setSeedsAcquired(double seedsAcquired) {
        this.seedsAcquired = seedsAcquired;
    }
    
    
}
