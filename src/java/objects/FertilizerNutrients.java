package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class FertilizerNutrients {

    public static final String TABLE_NAME = "FertilizerNutrients";
    public static final String COLUMN_FERTILIZER_ID = "FertilizerID";
    public static final String COLUMN_MINERAL = "Mineral";
    public static final String COLUMN_PERCENTAGE = "Percentage";

    private int fertilizerID;
    private String mineral;
    private double percentage;

    public FertilizerNutrients() {
    }

    public FertilizerNutrients(int fertilizerID, String mineral, double percentage) {
        this.fertilizerID = fertilizerID;
        this.mineral = mineral;
        this.percentage = percentage;
    }

    public int getFertilizerID() {
        return fertilizerID;
    }

    public void setFertilizerID(int fertilizerID) {
        this.fertilizerID = fertilizerID;
    }

    public String getMineral() {
        return mineral;
    }

    public void setMineral(String mineral) {
        this.mineral = mineral;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
