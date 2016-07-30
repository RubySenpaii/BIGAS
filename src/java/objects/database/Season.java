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
public class Season {
    final static String TABLE_SEASON = "Season";
    final static String COLUMN_SEASONID = "SeasonID";
    final static String COLUMN_SEASONNAME = "SeasonName";
    final static String COLUMN_DATESTART = "DateStart";
    final static String COLUMN_DATEEND = "DateEnd";
    
    private int seasonID;
    private String seasonName;
    private String dateStart;
    private String dateEnd;
    
    public Season() {
        
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
     * @return the seasonName
     */
    public String getSeasonName() {
        return seasonName;
    }

    /**
     * @param seasonName the seasonName to set
     */
    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    /**
     * @return the dateStart
     */
    public String getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return the dateEnd
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
