/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.people;

/**
 *
 * @author RubySenpaii
 */
public class EmployeeProgram {
    final static String TABLE_EMPLOYEEPROGRAM = "EmployeeProgram";
    final static String COLUMN_PROGRAMID = "ProgramID";
    final static String COLUMN_PROGRAMNO = "ProgramNo";
    final static String COLUMN_EMPLOYEEID = "EmployeeID";
    final static String COLUMN_POSITION = "Position";
    
    private String programID;
    private int programNo;
    private int employeeID;
    private String position;
    
    public EmployeeProgram() {
        
    }

    /**
     * @return the programID
     */
    public String getProgramID() {
        return programID;
    }

    /**
     * @param programID the programID to set
     */
    public void setProgramID(String programID) {
        this.programID = programID;
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
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
