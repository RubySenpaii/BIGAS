/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author RubySenpaii
 */
public class SeedPlanted {
    final static String TABLE_SEEDPLANTED = "SeedPlanted";
    final static String COLUMN_FARMID = "FarmID";
    final static String COLUMN_PLANTEDID = "PlantedID";
    final static String COLUMN_SEEDVARIETYID = "SeedVarietyID";
    final static String COLUMN_SEASONID = "SeasonID";
    final static String COLUMN_AREA = "Area";
    final static String COLUMN_YEAR = "Year";
    
    private int farmID;
    private int plantedID;
    private int seedVarietyID;
    private int seasonID;
    private double area;
    private String year;
    
    public SeedPlanted() {
        
    }

    /**
     * @return the farmID
     */
    public int getFarmID() {
        return farmID;
    }

    /**
     * @param farmID the farmID to set
     */
    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    /**
     * @return the plantedID
     */
    public int getPlantedID() {
        return plantedID;
    }

    /**
     * @param plantedID the plantedID to set
     */
    public void setPlantedID(int plantedID) {
        this.plantedID = plantedID;
    }

    /**
     * @return the seedVarietyID
     */
    public int getSeedVarietyID() {
        return seedVarietyID;
    }

    /**
     * @param seedVarietyID the seedVarietyID to set
     */
    public void setSeedVarietyID(int seedVarietyID) {
        this.seedVarietyID = seedVarietyID;
    }

    /**
     * @return the seasonID
     */
    public int getSeasonID() {
        return seasonID;
    }

    /**
     * @param seasonID the seasonID to set
     */
    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
}
