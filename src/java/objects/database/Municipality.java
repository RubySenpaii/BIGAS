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
public class Municipality {
    final static String TABLE_MUNICIPALITY = "Municipality";
    final static String COLUMN_MUNICIPALITYID = "MunicipalityID";
    final static String COLUMN_MUNICIPALITYNAME = "MunicipalityName";
    final static String COLUMN_DISTRICT = "District";
    final static String COLUMN_AREA = "Area";
    
    private int municipalityID;
    private String municipalityName;
    private int district;
    private double area;
    
    public Municipality() {
        
    }

    /**
     * @return the municipalityID
     */
    public int getMunicipalityID() {
        return municipalityID;
    }

    /**
     * @param municipalityID the municipalityID to set
     */
    public void setMunicipalityID(int municipalityID) {
        this.municipalityID = municipalityID;
    }

    /**
     * @return the municipalityName
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * @param municipalityName the municipalityName to set
     */
    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    /**
     * @return the district
     */
    public int getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(int district) {
        this.district = district;
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
}
