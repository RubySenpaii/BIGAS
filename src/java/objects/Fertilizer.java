package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Fertilizer {

    public static final String TABLE_NAME = "Fertilizer";
    public static final String COLUMN_FERTILIZER_ID = "FertilizerID";
    public static final String COLUMN_FERTILIZER_NAME = "FertilizerName";

    private int fertilizerID;
    private String fertilizerName;

    public Fertilizer() {
    }

    public Fertilizer(int fertilizerID, String fertilizerName) {
        this.fertilizerID = fertilizerID;
        this.fertilizerName = fertilizerName;
    }

    public int getFertilizerID() {
        return fertilizerID;
    }

    public void setFertilizerID(int fertilizerID) {
        this.fertilizerID = fertilizerID;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }
}
