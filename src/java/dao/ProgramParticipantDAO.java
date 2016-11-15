

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
import objects.ProgramParticipant;

/**
 *
 * @author RubySenpaii
 */
public class ProgramParticipantDAO {
    
    public boolean addProgramParticipant(ProgramParticipant programPariticipant) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramParticipant.TABLE_NAME + " "
                    + "(" + ProgramParticipant.COLUMN_FARMER_ID + ", " + ProgramParticipant.COLUMN_FERTILIZER_ACQUIRED + ", " 
                    + ProgramParticipant.COLUMN_PROGRAM_DEPLOYED_ID + ", " + ProgramParticipant.COLUMN_SEEDS_ACQUIRED + ") "
                    + "VALUES(?, ?, ?, ?)");
            ps.setInt(1, programPariticipant.getFarmerID());
            ps.setDouble(2, programPariticipant.getFertilizerAcquired());
            ps.setInt(3, programPariticipant.getProgramDeployedID());
            ps.setDouble(4, programPariticipant.getSeedsAcquired());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramParticipantDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramParticipant> getListOfProgramParticipant() {
        ArrayList<ProgramParticipant> programPariticipants = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramParticipant.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programPariticipants = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramParticipantDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programPariticipants;
    }
    
    public ArrayList<ProgramParticipant> getListOfProgramParticipantProgramDeployed(int programDeployedID) {
        ArrayList<ProgramParticipant> programPariticipants = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramParticipant.TABLE_NAME + " WHERE " + ProgramParticipant.COLUMN_PROGRAM_DEPLOYED_ID + " = ?");
            ps.setInt(1, programDeployedID);

            ResultSet rs = ps.executeQuery();
            programPariticipants = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramParticipantDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programPariticipants;
    }

    private ArrayList<ProgramParticipant> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramParticipant> programPariticipants = new ArrayList<>();
        while (rs.next()) {
            ProgramParticipant programPariticipant = new ProgramParticipant();
            programPariticipant.setFarmerID(rs.getInt(ProgramParticipant.COLUMN_FARMER_ID));
            programPariticipant.setFertilizerAcquired(rs.getDouble(ProgramParticipant.COLUMN_FERTILIZER_ACQUIRED));
            programPariticipant.setProgramDeployedID(rs.getInt(ProgramParticipant.COLUMN_PROGRAM_DEPLOYED_ID));
            programPariticipant.setSeedsAcquired(rs.getDouble(ProgramParticipant.COLUMN_SEEDS_ACQUIRED));
            programPariticipants.add(programPariticipant);
        }
        return programPariticipants;
    }
}
