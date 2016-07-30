/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.program;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.program.InterventionDetail;

/**
 *
 * @author RubySenpaii
 */
public class InterventionDetailDAO {
    
    public ArrayList<InterventionDetail> getPrograms() {
        ArrayList<InterventionDetail> interventionDetails = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM InterventionDetail");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InterventionDetail interventionDetail = new InterventionDetail();
                interventionDetail.setInterventionID(rs.getInt("InterventionID"));
                interventionDetail.setMunicipality(rs.getInt("MunicipalityID"));
                interventionDetail.setHandledBy(rs.getInt("HandledBy"));
                interventionDetail.setStartDate(rs.getString("StartDate"));
                interventionDetail.setEndDate(rs.getString("EndDate"));
                interventionDetail.setRemarks(rs.getString("Remarks"));
                interventionDetails.add(interventionDetail);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterventionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interventionDetails;
    }
    
    public ArrayList<InterventionDetail> getProgramsWithInterventionID(int interventionID) {
        ArrayList<InterventionDetail> interventionDetails = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM InterventionDetail WHERE InterventionID = ?");
            ps.setInt(1, interventionID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InterventionDetail interventionDetail = new InterventionDetail();
                interventionDetail.setInterventionID(rs.getInt("InterventionID"));
                interventionDetail.setMunicipality(rs.getInt("MunicipalityID"));
                interventionDetail.setHandledBy(rs.getInt("HandledBy"));
                interventionDetail.setStartDate(rs.getString("StartDate"));
                interventionDetail.setEndDate(rs.getString("EndDate"));
                interventionDetail.setRemarks(rs.getString("Remarks"));
                interventionDetails.add(interventionDetail);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterventionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interventionDetails;
    }
}
