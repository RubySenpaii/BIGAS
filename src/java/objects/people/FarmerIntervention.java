/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.people;

/**
 *
 * @author RubySenpaii
 */
public class FarmerIntervention {
    final static String TABLE_FARMERINTERVENTON = "FarmerIntervention";
    final static String COLUMN_FARMERID = "FarmerID";
    final static String COLUMN_INTERVENTIONID = "InterventionID";
    final static String COLUMN_MUNICIPALITYID = "MunicipalityID";
    final static String COLUMN_STARTDATE = "StartDate";
    
    private int farmerID;
    private int interventionID;
    private int municipalityID;
    private String startDate;
    
    public FarmerIntervention() {
        
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
     * @return the interventionID
     */
    public int getInterventionID() {
        return interventionID;
    }

    /**
     * @param interventionID the interventionID to set
     */
    public void setInterventionID(int interventionID) {
        this.interventionID = interventionID;
    }

    /**
     * @return the municipalityID
     */
    public int getMunicipalityID() {
        return municipalityID;
    }

    /**
     * @param municipalityID the municipalityID to set
     */
    public void setMunicipalityID(int municipalityID) {
        this.municipalityID = municipalityID;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
