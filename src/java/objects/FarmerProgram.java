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
public class FarmerProgram {
    final static String TABLE_FARMERPROGRAM = "FarmerProgram";
    final static String COLUMN_FARMERID = "FarmerID";
    final static String COLUMN_PROGRAMCODE = "ProgramCode";
    final static String COLUMN_PROGRAMNO = "ProgramNo";
    final static String COLUMN_SEEDRECEVED = "SeedReceived";
    final static String COLUMN_FERTILIZERRECEIVED = "FertilizerReceived";
    
    private int farmerID;
    private String programCode;
    private int programNo;
    private int seedReceived;
    private int fertilizerReceived;
    
    public FarmerProgram() {
        
    }

    /**
     * @return the farmerID
     */
    public int getFarmerID() {
        return farmerID;
    }

    /**
     * @param farmerID the farmerID to set
     */
    public void setFarmerID(int farmerID) {
        this.farmerID = farmerID;
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
     * @return the seedReceived
     */
    public int getSeedReceived() {
        return seedReceived;
    }

    /**
     * @param seedReceived the seedReceived to set
     */
    public void setSeedReceived(int seedReceived) {
        this.seedReceived = seedReceived;
    }

    /**
     * @return the fertilizerReceived
     */
    public int getFertilizerReceived() {
        return fertilizerReceived;
    }

    /**
     * @param fertilizerReceived the fertilizerReceived to set
     */
    public void setFertilizerReceived(int fertilizerReceived) {
        this.fertilizerReceived = fertilizerReceived;
    }
}
