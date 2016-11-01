package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramDeployed {

    public static final String TABLE_NAME = "ProgramDeployed";
    public static final String COLUMN_PROGRAM_DEPLOYED_ID = "ProgramDeployedID";
    public static final String COLUMN_PROGRAM_ID = "ProgramID";
    public static final String COLUMN_SEED_VARIETY_ID = "SeedVarietyID";
    public static final String COLUMN_SEED_PROVIDED = "SeedProvided";
    public static final String COLUMN_FERTILIZER_ID = "FertilizerID";
    public static final String COLUMN_FERTILIZIER_PROVIDED = "FertilizerProvided";
    public static final String COLUMN_DATE_STARTED = "DateStarted";
    public static final String COLUMN_DATE_ENDED = "DateEnded";

    private int programDeployedID;
    private int programID;
    private int seedVarietyID;
    private double seedProvided;
    private int fertilizerID;
    private double fertilizerProvided;
    private String dateStarted;
    private String dateEnded;

    public ProgramDeployed() {
    }

    public ProgramDeployed(int programDeployedID, int programID, int seedVarietyID, double seedProvided, int fertilizerID, double fertilizerProvided, String dateStarted, String dateEnded) {
        this.programDeployedID = programDeployedID;
        this.programID = programID;
        this.seedVarietyID = seedVarietyID;
        this.seedProvided = seedProvided;
        this.fertilizerID = fertilizerID;
        this.fertilizerProvided = fertilizerProvided;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
    }

    public int getProgramDeployedID() {
        return programDeployedID;
    }

    public void setProgramDeployedID(int programDeployedID) {
        this.programDeployedID = programDeployedID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public int getSeedVarietyID() {
        return seedVarietyID;
    }

    public void setSeedVarietyID(int seedVarietyID) {
        this.seedVarietyID = seedVarietyID;
    }

    public double getSeedProvided() {
        return seedProvided;
    }

    public void setSeedProvided(double seedProvided) {
        this.seedProvided = seedProvided;
    }

    public int getFertilizerID() {
        return fertilizerID;
    }

    public void setFertilizerID(int fertilizerID) {
        this.fertilizerID = fertilizerID;
    }

    public double getFertilizerProvided() {
        return fertilizerProvided;
    }

    public void setFertilizerProvided(double fertilizerProvided) {
        this.fertilizerProvided = fertilizerProvided;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(String dateEnded) {
        this.dateEnded = dateEnded;
    }
}
