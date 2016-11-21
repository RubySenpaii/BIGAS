package tbd;

/**
 * Created by Josiah on 27/10/2016.
 */

public class SeedType {

    public static final String TABLE_NAME = "SeedType";
    public static final String COLUMN_SEED_TYPE_ID = "SeedtypeID";
    public static final String COLUMN_TYPE_NAME = "TypeName";

    private int seedTypeID;
    private String typeName;

    public SeedType() {
    }

    public SeedType(int seedTypeID, String typeName) {
        this.seedTypeID = seedTypeID;
        this.typeName = typeName;
    }

    public int getSeedTypeID() {
        return seedTypeID;
    }

    public void setSeedTypeID(int seedTypeID) {
        this.seedTypeID = seedTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
