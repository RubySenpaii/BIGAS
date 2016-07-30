/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.database;

/**
 *
 * @author RubySenpaii
 */
public class Machine {
    final static String TABLE_MACHINE = "Machine";
    final static String COLUMN_MACHINEID = "MachineID";
    final static String COLUMN_EQUIPMENT = "Equipment";
    final static String COLUMN_PROVIDEDBY = "ProvidedBy";
    final static String COLUMN_RECIPIENT = "Recipient";
    final static String COLUMN_COST = "Cost";
    final static String COLUMN_UPDATEDBY = "UpdatedBy";
    
    private int machineID;
    private String equipment;
    private String providedBy;
    private String recipient;
    private double cost;
    private int updatedBy;
    
    public Machine() {
        
    }

    /**
     * @return the machineID
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     * @param machineID the machineID to set
     */
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    /**
     * @return the equipment
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * @return the providedBy
     */
    public String getProvidedBy() {
        return providedBy;
    }

    /**
     * @param providedBy the providedBy to set
     */
    public void setProvidedBy(String providedBy) {
        this.providedBy = providedBy;
    }

    /**
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * @param recipient the recipient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the updatedBy
     */
    public int getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}
