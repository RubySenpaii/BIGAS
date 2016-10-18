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
public class ProgramDetail {
    final static String TABLE_PROGRAMDETAIL = "ProgramDetail";
    final static String COLUMN_PROGRAMID = "ProgramCode";
    final static String COLUMN_PROGRAMNO = "ProgramNo";
    final static String COLUMN_LOCATION = "Location";
    final static String COLUMN_MUNICIPAL = "Municipal";
    final static String COLUMN_PROGRESS = "Progress";
    final static String COLUMN_STARTDATE = "StartDate";
    final static String COLUMN_ENDDATE = "EndDate";
    final static String COLUMN_UPDATEDBY = "UpdatedBy";
    final static String COLUMN_UPDATETIME = "UpdateTime";
    final static String COLUMN_SEEDPROVIDED = "SeedProvided";
    final static String COLUMN_SEEDBAGS = "SeedBags";
    final static String COLUMN_FERTILIZERPROVDED = "FertilizerProvided";
    final static String COLUMN_FERTILIZERBAGS = "FertilizerBags";
    final static String COLUMN_CAUSE = "Cause";
    final static String COLUMN_REMARKS = "Remarks";
    
    private String programCode;
    private int programNo;
    private String locaton;
    private int municipal;
    private String progress;
    private String startDate;
    private String endDate;
    private int updatedBy;
    private String updatedTime;
    private int seedProvided;
    private int seedBags;
    private int fertilizerProvided;
    private int fertilizerBags;
    private String cause;
    private String remarks;
    
    public ProgramDetail() {
        
    }

    /**
     * @return the programCode
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     * @param programCode the programCode to set
     */
    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    /**
     * @return the programNo
     */
    public int getProgramNo() {
        return programNo;
    }

    /**
     * @param programNo the programNo to set
     */
    public void setProgramNo(int programNo) {
        this.programNo = programNo;
    }

    /**
     * @return the locaton
     */
    public String getLocaton() {
        return locaton;
    }

    /**
     * @param locaton the locaton to set
     */
    public void setLocaton(String locaton) {
        this.locaton = locaton;
    }

    /**
     * @return the municipal
     */
    public int getMunicipal() {
        return municipal;
    }

    /**
     * @param municipal the municipal to set
     */
    public void setMunicipal(int municipal) {
        this.municipal = municipal;
    }

    /**
     * @return the progress
     */
    public String getProgress() {
        return progress;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the updatedBy
     */
    public int getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the updatedTime
     */
    public String getUpdatedTime() {
        return updatedTime;
    }

    /**
     * @param updatedTime the updatedTime to set
     */
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * @return the seedProvided
     */
    public int getSeedProvided() {
        return seedProvided;
    }

    /**
     * @param seedProvided the seedProvided to set
     */
    public void setSeedProvided(int seedProvided) {
        this.seedProvided = seedProvided;
    }

    /**
     * @return the seedBags
     */
    public int getSeedBags() {
        return seedBags;
    }

    /**
     * @param seedBags the seedBags to set
     */
    public void setSeedBags(int seedBags) {
        this.seedBags = seedBags;
    }

    /**
     * @return the fertilizerProvided
     */
    public int getFertilizerProvided() {
        return fertilizerProvided;
    }

    /**
     * @param fertilizerProvided the fertilizerProvided to set
     */
    public void setFertilizerProvided(int fertilizerProvided) {
        this.fertilizerProvided = fertilizerProvided;
    }

    /**
     * @return the fertilizerBags
     */
    public int getFertilizerBags() {
        return fertilizerBags;
    }

    /**
     * @param fertilizerBags the fertilizerBags to set
     */
    public void setFertilizerBags(int fertilizerBags) {
        this.fertilizerBags = fertilizerBags;
    }

    /**
     * @return the cause
     */
    public String getCause() {
        return cause;
    }

    /**
     * @param cause the cause to set
     */
    public void setCause(String cause) {
        this.cause = cause;
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
}
