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
public class InterventionDetail {
    final static String TABLE_INTERVENTIONDETAIL = "InterventionDetail";
    final static String COLUMN_INTERVENTION = "InterventionID";
    final static String COLUMN_MUNICIPALITY = "Municipality";
    final static String COLUMN_HANDLEDBY = "HandledBy";
    final static String COLUMN_STARTDATE = "StartDate";
    final static String COLUMN_ENDDATE = "EndDate";
    final static String COLUMN_REMARKS = "Remarks";
    
    private int interventionID;
    private int municipality;
    private int handledBy;
    private String startDate;
    private String endDate;
    private String remarks;
    
    public InterventionDetail() {
        
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
     * @return the municipality
     */
    public int getMunicipality() {
        return municipality;
    }

    /**
     * @param municipality the municipality to set
     */
    public void setMunicipality(int municipality) {
        this.municipality = municipality;
    }

    /**
     * @return the handledBy
     */
    public int getHeadedBy() {
        return handledBy;
    }

    /**
     * @param handledBy the handledBy to set
     */
    public void setHandledBy(int handledBy) {
        this.handledBy = handledBy;
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

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
