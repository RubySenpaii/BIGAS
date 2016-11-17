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
import objects.PlantingProblem;

/**
 *
 * @author RubySenpaii
 */
public class PlantingProblemDAO {
    
    public boolean reportPlantingProblem(PlantingProblem plantingProblem) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + PlantingProblem.TABLE_NAME + " "
                    + "(" + PlantingProblem.COLUMN_AREA_AFFECTED + ", " + PlantingProblem.COLUMN_DATE_REPORTED + ", " + PlantingProblem.COLUMN_EMPLOYEE_ID + ", " 
                    + PlantingProblem.COLUMN_IMAGE + ", " + PlantingProblem.COLUMN_PLANTING_REPORT_ID + ", " + PlantingProblem.COLUMN_PROBLEM_ID + ", " 
                    + PlantingProblem.COLUMN_PROBLEM_REPORT_ID + ", " + PlantingProblem.COLUMN_DATE_AFFECTED + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setDouble(1, plantingProblem.getAreaAffected());
            ps.setString(2, plantingProblem.getDateReported());
            ps.setInt(3, plantingProblem.getEmployeeID());
            ps.setString(4, plantingProblem.getImage());
            ps.setInt(5, plantingProblem.getPlantingReportID());
            ps.setInt(6, plantingProblem.getProblemID());
            ps.setInt(7, plantingProblem.getProblemReportID());
            ps.setString(8, plantingProblem.getDateAffected());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }
    
    public boolean updatePlantingProblem(PlantingProblem problem) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE " + PlantingProblem.TABLE_NAME + 
                    " SET " + PlantingProblem.COLUMN_AREA_AFFECTED + " = ?, " + PlantingProblem.COLUMN_DATE_AFFECTED + " = ?, " + PlantingProblem.COLUMN_DATE_REPORTED + " = ?, "
                    + PlantingProblem.COLUMN_EMPLOYEE_ID + " = ?, " + PlantingProblem.COLUMN_IMAGE + " = ?, " + PlantingProblem.COLUMN_PLANTING_REPORT_ID + " = ?, "
                    + PlantingProblem.COLUMN_PROBLEM_ID + " = ?, " + PlantingProblem.COLUMN_PROBLEM_REPORT_ID + " = ? "
                    + "WHERE " + PlantingProblem.COLUMN_PROBLEM_REPORT_ID + " = ?");
            ps.setDouble(1, problem.getAreaAffected());
            ps.setString(2, problem.getDateAffected());
            ps.setString(3, problem.getDateReported());
            ps.setInt(4, problem.getEmployeeID());
            ps.setString(5, problem.getImage());
            ps.setInt(6, problem.getPlantingReportID());
            ps.setInt(7, problem.getProblemID());
            ps.setInt(8, problem.getProblemReportID());
            ps.setInt(9, problem.getProblemReportID());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } return true;
    }

    public ArrayList<PlantingProblem> getListOfPlantingProblems() {
        ArrayList<PlantingProblem> plantingProblems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingProblem.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            plantingProblems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plantingProblems;
    }
    
    public ArrayList<PlantingProblem> getListOfPlantingProblemsFromPlantingReport(int plantingReport) {
        ArrayList<PlantingProblem> plantingProblems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingProblem.TABLE_NAME + " WHERE " + PlantingProblem.COLUMN_PLANTING_REPORT_ID + " = ?");
            ps.setInt(1, plantingReport);

            ResultSet rs = ps.executeQuery();
            plantingProblems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plantingProblems;
    }
    
    public ArrayList<PlantingProblem> getListOfPlantingProblemsReportedBy(int employeeID) {
        ArrayList<PlantingProblem> plantingProblems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingProblem.TABLE_NAME + " WHERE " + PlantingProblem.COLUMN_EMPLOYEE_ID + " = ?");
            ps.setInt(1, employeeID);

            ResultSet rs = ps.executeQuery();
            plantingProblems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plantingProblems;
    }
    
    public boolean hasPlantingProblemCreated(PlantingProblem plantingProblem) {
        ArrayList<PlantingProblem> plantingProblems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingProblem.TABLE_NAME + 
                    " WHERE " + PlantingProblem.COLUMN_EMPLOYEE_ID + " = ? AND " + PlantingProblem.COLUMN_IMAGE + 
                    " = ? AND " + PlantingProblem.COLUMN_PROBLEM_ID + " = ? AND " + PlantingProblem.COLUMN_PLANTING_REPORT_ID + " = ?");
            ps.setInt(1, plantingProblem.getEmployeeID());
            ps.setString(2, plantingProblem.getImage());
            ps.setInt(3, plantingProblem.getProblemID());
            ps.setInt(4, plantingProblem.getPlantingReportID());

            ResultSet rs = ps.executeQuery();
            plantingProblems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        if (plantingProblems.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<PlantingProblem> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<PlantingProblem> plantingProblems = new ArrayList<>();
        while (rs.next()) {
            PlantingProblem plantingProblem = new PlantingProblem();
            plantingProblem.setAreaAffected(rs.getDouble(PlantingProblem.COLUMN_AREA_AFFECTED));
            plantingProblem.setDateReported(rs.getString(PlantingProblem.COLUMN_DATE_REPORTED));
            plantingProblem.setEmployeeID(rs.getInt(PlantingProblem.COLUMN_EMPLOYEE_ID));
            plantingProblem.setImage(rs.getString(PlantingProblem.COLUMN_IMAGE));
            plantingProblem.setPlantingReportID(rs.getInt(PlantingProblem.COLUMN_PLANTING_REPORT_ID));
            plantingProblem.setProblemID(rs.getInt(PlantingProblem.COLUMN_PROBLEM_ID));
            plantingProblem.setProblemReportID(rs.getInt(PlantingProblem.COLUMN_PROBLEM_REPORT_ID));
            plantingProblem.setDateAffected(rs.getString(PlantingProblem.COLUMN_DATE_AFFECTED));
            plantingProblems.add(plantingProblem);
        }
        return plantingProblems;
    }
}
