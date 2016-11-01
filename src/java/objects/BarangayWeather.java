package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class BarangayWeather {

    public static final String TABLE_NAME = "BarangayWeather";
    public static final String COLUMN_BARANGAY_ID = "BarangayID";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_TEMPERATURE = "Temperature";
    public static final String COLUMN_WIND_SPEED = "WindSpeed";
    public static final String COLUMN_PRECIPITATION = "Precipitation";

    private int barangayID;
    private String date;
    private double temperature;
    private String windSpeed;
    private String precipitation;

    public BarangayWeather() {
    }

    public BarangayWeather(int barangayID, String date, double temperature, String windSpeed, String precipitation) {
        this.barangayID = barangayID;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.precipitation = precipitation;
    }

    public int getBarangayID() {
        return barangayID;
    }

    public void setBarangayID(int barangayID) {
        this.barangayID = barangayID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
