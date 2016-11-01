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
import objects.ProgramObjectives;

/**
 *
 * @author RubySenpaii
 */
public class ProgramObjectivesDAO {
    
    public boolean addProgramObjective(ProgramObjectives programObjective) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramObjectives.TABLE_NAME + " "
                    + "(" + ProgramObjectives.COLUMN_INDICATOR + ", " + ProgramObjectives.COLUMN_PROGRAM_ID + ", " + ProgramObjectives.COLUMN_TARGET_VALUE + ") "
                    + "VALUES(?, ?, ?)");
            ps.setString(1, programObjective.getIndicator());
            ps.setInt(2, programObjective.getProgramID());
            ps.setDouble(3, programObjective.getTargetValue());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramObjectivesDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramObjectives> getListOfProgramObjectives() {
        ArrayList<ProgramObjectives> programObjectives = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramObjectives.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programObjectives = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramObjectivesDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programObjectives;
    }

    private ArrayList<ProgramObjectives> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramObjectives> programObjectives = new ArrayList<>();
        while (rs.next()) {
            ProgramObjectives programObjective = new ProgramObjectives();
            programObjective.setIndicator(rs.getString(ProgramObjectives.COLUMN_INDICATOR));
            programObjective.setProgramID(rs.getInt(ProgramObjectives.COLUMN_PROGRAM_ID));
            programObjective.setTargetValue(rs.getDouble(ProgramObjectives.COLUMN_TARGET_VALUE));
            programObjectives.add(programObjective);
        }
        return programObjectives;
    }
}
