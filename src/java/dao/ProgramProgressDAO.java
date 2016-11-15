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
import objects.ProgramProgress;

/**
 *
 * @author RubySenpaii
 */
public class ProgramProgressDAO {
    
    public boolean recordProgramProgress(ProgramProgress programProgress) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramProgress.TABLE_NAME + " "
                    + "(" + ProgramProgress.COLUMN_DATE + ", " + ProgramProgress.COLUMN_PROCEDURE_NO + ", " + ProgramProgress.COLUMN_PROGRAM_DEPLOYED_ID + ", " 
                    + ProgramProgress.COLUMN_REMARKS + ", " + ProgramProgress.COLUMN_REPORTED_BY + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, programProgress.getDate());
            ps.setInt(2, programProgress.getProcedureNo());
            ps.setInt(3, programProgress.getProgramDeployedID());
            ps.setString(4, programProgress.getRemarks());
            ps.setInt(5, programProgress.getReportedBy());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramProgressDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramProgress> getListOfProgramProgresses() {
        ArrayList<ProgramProgress> programProgresses = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramProgress.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programProgresses = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramProgressDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programProgresses;
    }
    
    public ArrayList<ProgramProgress> getListOfProgramProgressesForProgramDeployed(int programDeployed) {
        ArrayList<ProgramProgress> programProgresses = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramProgress.TABLE_NAME + " WHERE " + ProgramProgress.COLUMN_PROGRAM_DEPLOYED_ID + " = ?");
            ps.setInt(1, programDeployed);

            ResultSet rs = ps.executeQuery();
            programProgresses = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramProgressDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programProgresses;
    }

    private ArrayList<ProgramProgress> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramProgress> programProgresses = new ArrayList<>();
        while (rs.next()) {
            ProgramProgress programProgress = new ProgramProgress();
            programProgress.setDate(rs.getString(ProgramProgress.COLUMN_DATE));
            programProgress.setProcedureNo(rs.getInt(ProgramProgress.COLUMN_PROCEDURE_NO));
            programProgress.setProgramDeployedID(rs.getInt(ProgramProgress.COLUMN_PROGRAM_DEPLOYED_ID));
            programProgress.setRemarks(rs.getString(ProgramProgress.COLUMN_REMARKS));
            programProgress.setReportedBy(rs.getInt(ProgramProgress.COLUMN_REPORTED_BY));
            programProgresses.add(programProgress);
        }
        return programProgresses;
    }
}
