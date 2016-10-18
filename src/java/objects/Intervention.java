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
public class Intervention {
    final String TABLE_NAME = "Intervention";
    final String COLUMN_INTERVENTIONID = "InterventionID";
    final String COLUMN_INTERVENTIONNAME = "InterventionName";
    final String COLUMN_PURPOSE = "Purpose";
    
    private int interventionID;
    private String interventionName;
    private String purpose;
    
    public Intervention() {
        
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
     * @return the interventionName
     */
    public String getInterventionName() {
        return interventionName;
    }

    /**
     * @param interventionName the interventionName to set
     */
    public void setInterventionName(String interventionName) {
        this.interventionName = interventionName;
    }

    /**
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
