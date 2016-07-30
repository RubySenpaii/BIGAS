/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.database;

/**
 *
 * @author RubySenpaii
 */
public class DailyBarangayWeather {
    final static String TABLE_DAILYBARANGAYWEATHER = "DailyBarangayWeather";
    final static String COLUMN_BARANGAYID = "BarangayID";
    final static String COLUMN_DATE = "Date";
    final static String COLUMN_TEMPERATURE = "Temperature";
    final static String COLUMN_WINDSPEED = "WindSpeed";
    final static String COLUMN_PRECIPITATION = "Precipitation";
    
    private int barangayID;
    private String date;
    private double temperature;
    private double windSpeed;
    private double precipitation;
    
    public DailyBarangayWeather() {
        
    }

    /**
     * @return the barangayID
     */
    public int getBarangayID() {
        return barangayID;
    }

    /**
     * @param barangayID the barangayID to set
     */
    public void setBarangayID(int barangayID) {
        this.barangayID = barangayID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the windSpeed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return the precipitation
     */
    public double getPrecipitation() {
        return precipitation;
    }

    /**
     * @param precipitation the precipitation to set
     */
    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }
}
