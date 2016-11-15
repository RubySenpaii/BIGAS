/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Alert;
import objects.ProgramEmployees;

/**
 *
 * @author RubySenpaii
 */
public class ProgramEmployeesDAO {
    
    public boolean addProgramEmployee(ProgramEmployees programEmployee) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramEmployees.TABLE_NAME + " "
                    + "(" + ProgramEmployees.COLUMN_EMPLOYEE_ID + ", " + ProgramEmployees.COLUMN_POSITION + ", " + ProgramEmployees.COLUMN_PROGRAM_DEPLOYED_ID + ") "
                    + "VALUES(?, ?, ?)");
            ps.setInt(1, programEmployee.getEmployeeID());
            ps.setString(2, programEmployee.getPosition());
            ps.setInt(3, programEmployee.getProgramDeployedID());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramEmployeesDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramEmployees> getListOfProgramEmployees() {
        ArrayList<ProgramEmployees> programEmployees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramEmployees.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programEmployees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramEmployeesDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programEmployees;
    }
    
    public ArrayList<ProgramEmployees> getListOfProgramEmployeesForProgram(int programDeployed) {
        ArrayList<ProgramEmployees> programEmployees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramEmployees.TABLE_NAME + " WHERE " + ProgramEmployees.COLUMN_PROGRAM_DEPLOYED_ID + " = ?");
            ps.setInt(1, programDeployed);

            ResultSet rs = ps.executeQuery();
            programEmployees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramEmployeesDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programEmployees;
    }

    private ArrayList<ProgramEmployees> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramEmployees> programEmployees = new ArrayList<>();
        while (rs.next()) {
            ProgramEmployees programEmployee = new ProgramEmployees();
            programEmployee.setEmployeeID(rs.getInt(ProgramEmployees.COLUMN_EMPLOYEE_ID));
            programEmployee.setPosition(rs.getString(ProgramEmployees.COLUMN_POSITION));
            programEmployee.setProgramDeployedID(rs.getInt(ProgramEmployees.COLUMN_PROGRAM_DEPLOYED_ID));
            programEmployees.add(programEmployee);
        }
        return programEmployees;
    }
}
