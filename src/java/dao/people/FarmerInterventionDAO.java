/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.people;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.people.FarmerIntervention;
import objects.program.InterventionDetail;

/**
 *
 * @author RubySenpaii
 */
public class FarmerInterventionDAO {

    public ArrayList<FarmerIntervention> getInterventions() {
        ArrayList<FarmerIntervention> farmerInterventions = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FarmerIntervention");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FarmerIntervention farmerIntervention = new FarmerIntervention();
                farmerIntervention.setFarmerID(rs.getInt("Farmer"));
                farmerIntervention.setInterventionID(rs.getInt("InterventionID"));
                farmerIntervention.setMunicipalityID(rs.getInt("MunicipalityID"));
                farmerIntervention.setStartDate(rs.getString("StartDate"));
                farmerInterventions.add(farmerIntervention);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerInterventionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmerInterventions;
    }
    
    public ArrayList<FarmerIntervention> getInterventionsWithInterventionID(InterventionDetail interventionDetail) {
        ArrayList<FarmerIntervention> farmerInterventions = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FarmerIntervention WHERE InterventionID = ? AND MunicipalityID = ? AND StartDate = ?");
            ps.setInt(1, interventionDetail.getInterventionID());
            ps.setInt(2, interventionDetail.getMunicipality());
            ps.setString(3, interventionDetail.getStartDate());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FarmerIntervention farmerIntervention = new FarmerIntervention();
                farmerIntervention.setFarmerID(rs.getInt("Farmer"));
                farmerIntervention.setInterventionID(rs.getInt("InterventionID"));
                farmerIntervention.setMunicipalityID(rs.getInt("MunicipalityID"));
                farmerIntervention.setStartDate(rs.getString("StartDate"));
                farmerInterventions.add(farmerIntervention);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerInterventionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmerInterventions;
    }
}
