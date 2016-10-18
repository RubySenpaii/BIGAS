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
public class Program {
    final static String TABLE_PROGRAM = "Program";
    final static String COLUMN_PROGRAMCODE = "ProgramCode";
    final static String COLUMN_PROGRAMNAME = "ProgramName";
    final static String COLUMN_DESCRIPTION = "Description";
    
    private String programCode;
    private String programName;
    private String description;
    
    public Program() {
        
    }

    /**
     * @return the programCode
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     * @param programCode the programID to set
     */
    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    /**
     * @return the programName
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName the programName to set
     */
    public void setProgramName(String programName) {
        this.programName = programName;
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
}
