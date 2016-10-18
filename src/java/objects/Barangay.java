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
public class Barangay {
    final static String TABLE_BARANGAY = "Barangay";
    final static String COLUMN_BARANGAYID = "BarangayID";
    final static String COLUMN_MUNICIPALITYNAME = "MunicipalityName";
    final static String COLUMN_AREA = "Area";
    
    private int barangayID;
    private int municipalityID;
    private String barangayName;
    private double area;
    
    public Barangay() {
        
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
     * @return the barangayName
     */
    public String getBarangayName() {
        return barangayName;
    }

    /**
     * @param barangayName the barangayName to set
     */
    public void setBarangayName(String barangayName) {
        this.barangayName = barangayName;
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
