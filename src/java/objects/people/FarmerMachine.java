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
public class FarmerMachine {
    final static String TABLE_FARMERMACHINE = "FarmerMachine";
    final static String COLUMN_MACHINEID = "MachineID";
    final static String COLUMN_FARMERID = "FarmerID";
    
    private int machineID;
    private int farmerID;
    
    public FarmerMachine() {
        
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
}
