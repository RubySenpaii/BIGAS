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
import objects.ProblemDatabase;

/**
 *
 * @author RubySenpaii
 */
public class ProblemDatabaseDAO {
    
    public boolean recordProblem(ProblemDatabase problem) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProblemDatabase.TABLE_NAME + " "
                    + "(" + ProblemDatabase.COLUMN_DESCRIPTION + ", " + ProblemDatabase.COLUMN_IMAGE + ", " + ProblemDatabase.COLUMN_PROBLEM_ID + ", " 
                    + ProblemDatabase.COLUMN_PROBLEM_NAME + ", " + ProblemDatabase.COLUMN_TYPE + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, problem.getDescription());
            ps.setString(2, problem.getImage());
            ps.setInt(3, problem.getProblemID());
            ps.setString(4, problem.getProblemName());
            ps.setString(5, problem.getType());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProblemDatabaseDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }
    
    public boolean updatePlantingProblem(ProblemDatabase problem) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE " + ProblemDatabase.TABLE_NAME + 
                    " SET " + ProblemDatabase.COLUMN_DESCRIPTION + " = ?, " + ProblemDatabase.COLUMN_IMAGE + " = ?, " + ProblemDatabase.COLUMN_PROBLEM_ID + " = ?, "
                    + ProblemDatabase.COLUMN_PROBLEM_NAME + " = ?, " + ProblemDatabase.COLUMN_TYPE + " = ? "
                    + "WHERE " + ProblemDatabase.COLUMN_PROBLEM_ID + " = ?");
            ps.setString(1, problem.getDescription());
            ps.setString(2, problem.getImage());
            ps.setInt(3, problem.getProblemID());
            ps.setString(4, problem.getProblemName());
            ps.setString(5, problem.getType());
            ps.setInt(6, problem.getProblemID());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } return true;
    }

    public ArrayList<ProblemDatabase> getListOfProblems() {
        ArrayList<ProblemDatabase> problems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProblemDatabase.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            problems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProblemDatabaseDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return problems;
    }
    
    public ProblemDatabase getProblemWithProblemID(int problemID) {
        ArrayList<ProblemDatabase> problems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProblemDatabase.TABLE_NAME + " WHERE " + ProblemDatabase.COLUMN_PROBLEM_ID + " = ?");
            ps.setInt(1, problemID);

            ResultSet rs = ps.executeQuery();
            problems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProblemDatabaseDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return problems.get(0);
    }

    private ArrayList<ProblemDatabase> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProblemDatabase> problems = new ArrayList<>();
        while (rs.next()) {
            ProblemDatabase problem = new ProblemDatabase();
            problem.setDescription(rs.getString(ProblemDatabase.COLUMN_DESCRIPTION));
            problem.setImage(rs.getString(ProblemDatabase.COLUMN_IMAGE));
            problem.setProblemID(rs.getInt(ProblemDatabase.COLUMN_PROBLEM_ID));
            problem.setProblemName(rs.getString(ProblemDatabase.COLUMN_PROBLEM_NAME));
            problem.setType(rs.getString(ProblemDatabase.COLUMN_TYPE));
            problems.add(problem);
        }
        return problems;
    }
}
