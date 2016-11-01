package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class FAMembers {

    public static final String TABLE_NAME = "FAMembers";
    public static final String COLUMN_ASSOCIATION_ID ="AssociationID";
    public static final String COLUMN_FARMER_ID = "FarmerID";

    private int associationID;
    private int farmerID;

    public FAMembers() {
    }

    public FAMembers(int associationID, int farmerID) {
        this.associationID = associationID;
        this.farmerID = farmerID;
    }

    public int getAssociationID() {
        return associationID;
    }

    public void setAssociationID(int associationID) {
        this.associationID = associationID;
    }

    public int getFarmerID() {
        return farmerID;
    }

    public void setFarmerID(int farmerID) {
        this.farmerID = farmerID;
    }
}
