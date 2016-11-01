package tbd;

/**
 * Created by Josiah on 27/10/2016.
 */

public class SeedCategory {

    public static final String TABLE_NAME = "SeedCategory";
    public static final String COLUMN_CATEGORY_ID = "CategoryID";
    public static final String COLUMN_SEED_TYPE_ID = "SeedTypeID";
    public static final String COLUMN_SEED_CATEGORY = "S    eedCategory";

    private String categoryID;
    private int seedTypeID;
    private String seedCategory;

    public SeedCategory() {
    }

    public SeedCategory(String categoryID, int seedTypeID, String seedCategory) {
        this.categoryID = categoryID;
        this.seedTypeID = seedTypeID;
        this.seedCategory = seedCategory;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getSeedTypeID() {
        return seedTypeID;
    }

    public void setSeedTypeID(int seedTypeID) {
        this.seedTypeID = seedTypeID;
    }

    public String getSeedCategory() {
        return seedCategory;
    }

    public void setSeedCategory(String seedCategory) {
        this.seedCategory = seedCategory;
    }
}
