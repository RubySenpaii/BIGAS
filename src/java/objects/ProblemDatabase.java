package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProblemDatabase {

    public static final String TABLE_NAME = "ProblemDatabase";
    public static final String COLUMN_PROBLEM_ID = "ProblemID";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_PROBLEM_NAME = "ProblemName";
    public static final String COLUMN_IMAGE = "Image";

    private int problemID;
    private String type;
    private String description;
    private String problemName;
    private String image;

    public ProblemDatabase() {
        
    }
    
    public ProblemDatabase(int problemID, String type, String description, String problemName, String image) {
        this.problemID = problemID;
        this.type = type;
        this.description = description;
        this.problemName = problemName;
        this.image = image;
    }

    /**
     * @return the problemID
     */
    public int getProblemID() {
        return problemID;
    }

    /**
     * @param problemID the problemID to set
     */
    public void setProblemID(int problemID) {
        this.problemID = problemID;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the problemName
     */
    public String getProblemName() {
        return problemName;
    }

    /**
     * @param problemName the problemName to set
     */
    public void setProblemName(String problemName) {
        this.problemName = problemName;
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
}
