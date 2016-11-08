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
import objects.ProgramDeployed;

/**
 *
 * @author RubySenpaii
 */
public class ProgramDeployedDAO {
    
    public boolean addProgramDeployed(ProgramDeployed programDeployed) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramDeployed.TABLE_NAME + " "
                    + "(" + ProgramDeployed.COLUMN_DATE_ENDED + ", " + ProgramDeployed.COLUMN_DATE_STARTED + ", " + ProgramDeployed.COLUMN_FERTILIZER_ID + ", " 
                    + ProgramDeployed.COLUMN_FERTILIZIER_PROVIDED + ", " + ProgramDeployed.COLUMN_PROGRAM_DEPLOYED_ID + ", " + ProgramDeployed.COLUMN_PROGRAM_ID + ", " 
                    + ProgramDeployed.COLUMN_SEED_PROVIDED + ", " + ProgramDeployed.COLUMN_SEED_VARIETY_ID + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, programDeployed.getDateEnded());
            ps.setString(2, programDeployed.getDateStarted());
            ps.setInt(3, programDeployed.getFertilizerID());
            ps.setDouble(4, programDeployed.getFertilizerProvided());
            ps.setInt(5, programDeployed.getProgramDeployedID());
            ps.setInt(6, programDeployed.getProgramID());
            ps.setDouble(7, programDeployed.getSeedProvided());
            ps.setInt(8, programDeployed.getSeedVarietyID());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramDeployedDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramDeployed> getListOfProgramsDeployed() {
        ArrayList<ProgramDeployed> programsDeployed = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramDeployed.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programsDeployed = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramDeployedDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programsDeployed;
    }
    
    public ProgramDeployed getProgramDeployedDetails(int programDeployedID) {
        ArrayList<ProgramDeployed> programsDeployed = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramDeployed.TABLE_NAME + " WHERE " + ProgramDeployed.COLUMN_PROGRAM_DEPLOYED_ID + " = ?");
            ps.setInt(1, programDeployedID);

            ResultSet rs = ps.executeQuery();
            programsDeployed = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramDeployedDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programsDeployed.get(0);
    }

    private ArrayList<ProgramDeployed> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramDeployed> programsDeployed = new ArrayList<>();
        while (rs.next()) {
            ProgramDeployed programDeployed = new ProgramDeployed();
            programDeployed.setDateEnded(rs.getString(ProgramDeployed.COLUMN_DATE_ENDED));
            programDeployed.setDateStarted(rs.getString(ProgramDeployed.COLUMN_DATE_STARTED));
            programDeployed.setFertilizerID(rs.getInt(ProgramDeployed.COLUMN_FERTILIZER_ID));
            programDeployed.setFertilizerProvided(rs.getDouble(ProgramDeployed.COLUMN_FERTILIZIER_PROVIDED));
            programDeployed.setProgramDeployedID(rs.getInt(ProgramDeployed.COLUMN_PROGRAM_DEPLOYED_ID));
            programDeployed.setProgramID(rs.getInt(ProgramDeployed.COLUMN_PROGRAM_ID));
            programDeployed.setSeedProvided(rs.getDouble(ProgramDeployed.COLUMN_SEED_PROVIDED));
            programDeployed.setSeedVarietyID(rs.getInt(ProgramDeployed.COLUMN_SEED_VARIETY_ID));
            programsDeployed.add(programDeployed);
        }
        return programsDeployed;
    }
}
