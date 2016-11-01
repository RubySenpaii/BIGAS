package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Plot {

    public static final String TABLE_NAME = "Plot";
    public static final String COLUMN_PLOT_ID = "PlotID";
    public static final String COLUMN_FARM_ID = "FarmID";
    public static final String COLUMN_PLOT_SIZE = "PlotSize";
    public static final String COLUMN_PLOT_PLANTED = "PlotPlanted";
    public static final String COLUMN_PLOT_ACTIVE = "PlotActive";

    private int plotID;
    private int farmID;
    private double plotSize;
    private int plotPlanted;
    private int plotActive;

    public Plot() {
    }

    public int getPlotID() {
        return plotID;
    }

    public void setPlotID(int plotID) {
        this.plotID = plotID;
    }

    public int getFarmID() {
        return farmID;
    }

    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    public double getPlotSize() {
        return plotSize;
    }

    public void setPlotSize(double plotSize) {
        this.plotSize = plotSize;
    }

    public Plot(int plotID, int farmID, double plotSize, int plotPlanted, int plotActive) {
        this.plotID = plotID;
        this.farmID = farmID;
        this.plotSize = plotSize;
        this.plotPlanted = plotPlanted;
        this.plotActive = plotActive;
    }

    /**
     * @return the plotPlanted
     */
    public int getPlotPlanted() {
        return plotPlanted;
    }

    /**
     * @param plotPlanted the plotPlanted to set
     */
    public void setPlotPlanted(int plotPlanted) {
        this.plotPlanted = plotPlanted;
    }

    /**
     * @return the plotActive
     */
    public int getPlotActive() {
        return plotActive;
    }

    /**
     * @param plotActive the plotActive to set
     */
    public void setPlotActive(int plotActive) {
        this.plotActive = plotActive;
    }
}
