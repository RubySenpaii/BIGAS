package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class FarmerAssociation {

    public static final String TABLE_NAME = "FarmerAssociation";
    public static final String COLUMN_ASSOCIATION_ID = "AssociationID";
    public static final String COLUMN_ASSOCIATION_NAME = "AssociationName";

    private int associationID;
    private String associationName;

    public FarmerAssociation() {
    }

    public FarmerAssociation(int associationID, String associationName) {
        this.associationID = associationID;
        this.associationName = associationName;
    }

    public int getAssociationID() {
        return associationID;
    }

    public void setAssociationID(int associationID) {
        this.associationID = associationID;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }
}
