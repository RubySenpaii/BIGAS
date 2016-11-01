package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Machine {

    public static final String TABLE_NAME = "Machina";
    public static final String COLUMN_MACHINE_ID = "MachineID";
    public static final String COLUMN_EQUIPMENT = "Equipment";
    public static final String COLUMN_PROVIDED_BY = "ProvidedBy";
    public static final String COLUMN_RECIPIENT = "Recipient";
    public static final String COLUMN_COST = "Cost";
    public static final String COLUMN_UPDATED_BY = "UpdatedBy";

    private int machineID;
    private String equipment;
    private String providedBy;
    private int recipient;
    private double cost;
    private int updatedBy;

    public Machine() {
    }

    public Machine(int machineID, String equipment, String providedBy, int recipient, double cost, int updatedBy) {
        this.machineID = machineID;
        this.equipment = equipment;
        this.providedBy = providedBy;
        this.recipient = recipient;
        this.cost = cost;
        this.updatedBy = updatedBy;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getProvidedBy() {
        return providedBy;
    }

    public void setProvidedBy(String providedBy) {
        this.providedBy = providedBy;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}
