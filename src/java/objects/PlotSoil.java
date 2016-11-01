package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class PlotSoil {

    public static final String TABLE_NAME = "PlotSoil";
    public static final String COLUMN_PLOT_ID = "PlotID";
    public static final String COLUMN_SOIL_NUTRIENT = "SoilNutrient";
    public static final String COLUMN_AMOUNT = "Amount";

    private int plotID;
    private String soilNutrient;
    private double amount;

    public PlotSoil() {
    }

    public PlotSoil(int plotID, String soilNutrient, double amount) {
        this.plotID = plotID;
        this.soilNutrient = soilNutrient;
        this.amount = amount;
    }

    public int getPlotID() {
        return plotID;
    }

    public void setPlotID(int plotID) {
        this.plotID = plotID;
    }

    public String getSoilNutrient() {
        return soilNutrient;
    }

    public void setSoilNutrient(String soilNutrient) {
        this.soilNutrient = soilNutrient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
