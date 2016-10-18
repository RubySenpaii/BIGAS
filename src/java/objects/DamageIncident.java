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
public class DamageIncident {
    final static String TABLE_DAMAGEINCIDENT = "DamageIncident";
    final static String COLUMN_INCIDENTID = "IncidentID";
    final static String COLUMN_PLANTEDID = "PlantedID";
    final static String COLUMN_DAMAGEID = "DamageID";
    final static String COLUMN_AREAAFFECTED = "AreaAffected";
    final static String COLUMN_IMAGE = "Image";
    final static String COLUMN_REMARKS = "Remarks";
    final static String COLUMN_DATE = "Date";
    final static String COLUMN_HANDLEDBY = "HandledBy";
    
    private int incidentID;
    private int plantedID;
    private int damageID;
    private double areaAffected;
    private String image;
    private String remarks;
    private String date;
    private int handledBy;
    
    public DamageIncident() {
        
    }

    /**
     * @return the incidentID
     */
    public int getIncidentID() {
        return incidentID;
    }

    /**
     * @param incidentID the incidentID to set
     */
    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
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
     * @return the damageID
     */
    public int getDamageID() {
        return damageID;
    }

    /**
     * @param damageID the damageID to set
     */
    public void setDamageID(int damageID) {
        this.damageID = damageID;
    }

    /**
     * @return the areaAffected
     */
    public double getAreaAffected() {
        return areaAffected;
    }

    /**
     * @param areaAffected the areaAffected to set
     */
    public void setAreaAffected(double areaAffected) {
        this.areaAffected = areaAffected;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
     * @return the handledBy
     */
    public int getHandledBy() {
        return handledBy;
    }

    /**
     * @param handledBy the handledBy to set
     */
    public void setHandledBy(int handledBy) {
        this.handledBy = handledBy;
    }
}
