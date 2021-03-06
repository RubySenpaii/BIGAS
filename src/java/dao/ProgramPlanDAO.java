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
import objects.ProgramPlan;

/**
 *
 * @author RubySenpaii
 */
public class ProgramPlanDAO {
    
    public boolean createProgramPlan(ProgramPlan programPlan) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramPlan.TABLE_NAME + " "
                    + "(" + ProgramPlan.COLUMN_DESCRIPTION + ", " + ProgramPlan.COLUMN_PROGRAM_ID + ", " 
                    + ProgramPlan.COLUMN_PROGRAM_NAME + ", " + ProgramPlan.COLUMN_TYPE + ", " + ProgramPlan.COLUMN_PURPOSE + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, programPlan.getDescription());
            ps.setInt(2, programPlan.getProgramID());
            ps.setString(3, programPlan.getProgramName());
            ps.setString(4, programPlan.getType());
            ps.setString(5, programPlan.getPurpose());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramPlanDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramPlan> getListOfProgramPlans() {
        ArrayList<ProgramPlan> programPlans = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramPlan.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programPlans = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramPlanDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programPlans;
    }
    
    public ProgramPlan getProgramPlanInfo(int programID) {
        ArrayList<ProgramPlan> programPlans = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramPlan.TABLE_NAME + " WHERE " + ProgramPlan.COLUMN_PROGRAM_ID + " = ?");
            ps.setInt(1, programID);

            ResultSet rs = ps.executeQuery();
            programPlans = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramPlanDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programPlans.get(0);
    }
    
    public ProgramPlan getProgramPlanInfo(String programName) {
        ArrayList<ProgramPlan> programPlans = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramPlan.TABLE_NAME + " WHERE " + ProgramPlan.COLUMN_PROGRAM_NAME + " = ?");
            ps.setString(1, programName);

            ResultSet rs = ps.executeQuery();
            programPlans = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramPlanDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programPlans.get(0);
    }

    private ArrayList<ProgramPlan> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramPlan> programPlans = new ArrayList<>();
        while (rs.next()) {
            ProgramPlan programPlan = new ProgramPlan();
            programPlan.setDescription(rs.getString(ProgramPlan.COLUMN_DESCRIPTION));
            programPlan.setProgramID(rs.getInt(ProgramPlan.COLUMN_PROGRAM_ID));
            programPlan.setProgramName(rs.getString(ProgramPlan.COLUMN_PROGRAM_NAME));
            programPlan.setType(rs.getString(ProgramPlan.COLUMN_TYPE));
            programPlan.setPurpose(rs.getString(ProgramPlan.COLUMN_PURPOSE));
            programPlans.add(programPlan);
        }
        return programPlans;
    }
}
