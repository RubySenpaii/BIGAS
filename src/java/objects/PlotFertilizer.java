package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class PlotFertilizer {

    public static final String TABLE_NAME = "PlotFertilizer";
    public static final String COLUMN_PLOT_ID = "PlotID";
    public static final String COLUMN_FERTILIZER_ID = "FertilizerID";
    public static final String COLUMN_FERTILIZER_APPLIED = "FertilizerApplied";
    public static final String COLUMN_DATE_APPLIED = "DateApplied";
    public static final String COLUMN_REMARKS = "Remarks";

    private int plotID;
    private int fertilizerID;
    private double fertilizerApplied;
    private String dateApplied;
    private String remarks;

    public PlotFertilizer() {
    }

    public PlotFertilizer(int plotID, int fertilizerID, double fertilizerApplied, String dateApplied, String remarks) {
        this.plotID = plotID;
        this.fertilizerID = fertilizerID;
        this.fertilizerApplied = fertilizerApplied;
        this.dateApplied = dateApplied;
        this.remarks = remarks;
    }

    public int getPlotID() {
        return plotID;
    }

    public void setPlotID(int plotID) {
        this.plotID = plotID;
    }

    public int getFertilizerID() {
        return fertilizerID;
    }

    public void setFertilizerID(int fertilizerID) {
        this.fertilizerID = fertilizerID;
    }

    public double getFertilizerApplied() {
        return fertilizerApplied;
    }

    public void setFertilizerApplied(double fertilizerApplied) {
        this.fertilizerApplied = fertilizerApplied;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
