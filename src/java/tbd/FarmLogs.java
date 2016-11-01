/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd;

/**
 *
 * @author RubySenpaii
 */
public class FarmLogs {
    public static final String TABLE_NAME = "FarmLogs";
    public static final String COLUMN_ASSIGNED_FARM_ID = "AssignedFarmID";
    public static final String COLUMN_DATE_VISITED = "DateVisited";
    
    private int assignedFarmedID;
    private String dateVisited;
    
    public FarmLogs(){
        
    }

    /**
     * @return the assignedFarmedID
     */
    public int getAssignedFarmedID() {
        return assignedFarmedID;
    }

    /**
     * @param assignedFarmedID the assignedFarmedID to set
     */
    public void setAssignedFarmedID(int assignedFarmedID) {
        this.assignedFarmedID = assignedFarmedID;
    }

    /**
     * @return the dateVisited
     */
    public String getDateVisited() {
        return dateVisited;
    }

    /**
     * @param dateVisited the dateVisited to set
     */
    public void setDateVisited(String dateVisited) {
        this.dateVisited = dateVisited;
    }
}
