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
                    + "(" + ProgramPlan.COLUMN_DESCRIPTION + ", " + ProgramPlan.COLUMN_HEADED_BY + ", " + ProgramPlan.COLUMN_PROGRAM_ID + ", " 
                    + ProgramPlan.COLUMN_PROGRAM_NAME + ", " + ProgramPlan.COLUMN_TYPE + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, programPlan.getDescription());
            ps.setString(2, programPlan.getHeadedBy());
            ps.setInt(3, programPlan.getProgramID());
            ps.setString(4, programPlan.getProgramName());
            ps.setString(5, programPlan.getType());

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

    private ArrayList<ProgramPlan> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramPlan> programPlans = new ArrayList<>();
        while (rs.next()) {
            ProgramPlan programPlan = new ProgramPlan();
            programPlan.setDescription(rs.getString(ProgramPlan.COLUMN_DESCRIPTION));
            programPlan.setHeadedBy(rs.getString(ProgramPlan.COLUMN_HEADED_BY));
            programPlan.setProgramID(rs.getInt(ProgramPlan.COLUMN_PROGRAM_ID));
            programPlan.setProgramName(rs.getString(ProgramPlan.COLUMN_PROGRAM_NAME));
            programPlan.setType(rs.getString(ProgramPlan.COLUMN_TYPE));
            programPlans.add(programPlan);
        }
        return programPlans;
    }
}
