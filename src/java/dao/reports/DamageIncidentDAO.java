/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.reports;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.reports.DamageIncident;

/**
 *
 * @author RubySenpaii
 */
public class DamageIncidentDAO {

    public ArrayList<DamageIncident> getDamageIncidents() {
        ArrayList<DamageIncident> damageIncidents = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM DamageIncident");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DamageIncident damageIncident = new DamageIncident();
                damageIncident.setIncidentID(rs.getInt("IncidentID"));
                damageIncident.setPlantedID(rs.getInt("PlantedID"));
                damageIncident.setDamageID(rs.getInt("DamageID"));
                damageIncident.setAreaAffected(rs.getDouble("AreaAffected"));
                damageIncident.setImage(rs.getString("Image"));
                damageIncident.setRemarks(rs.getString("Remarks"));
                damageIncident.setDate(rs.getString("Date"));
                damageIncident.setHandledBy(rs.getInt("HandledBy"));
                damageIncidents.add(damageIncident);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DamageIncidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return damageIncidents;
    }
    
    public ArrayList<DamageIncident> getDamageIncidentsOfPlanted(int plantedID) {
        ArrayList<DamageIncident> damageIncidents = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM DamageIncident WHERE PlantedID = ?");
            ps.setInt(1, plantedID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DamageIncident damageIncident = new DamageIncident();
                damageIncident.setIncidentID(rs.getInt("IncidentID"));
                damageIncident.setPlantedID(rs.getInt("PlantedID"));
                damageIncident.setDamageID(rs.getInt("DamageID"));
                damageIncident.setAreaAffected(rs.getDouble("AreaAffected"));
                damageIncident.setImage(rs.getString("Image"));
                damageIncident.setRemarks(rs.getString("Remarks"));
                damageIncident.setDate(rs.getString("Date"));
                damageIncident.setHandledBy(rs.getInt("HandledBy"));
                damageIncidents.add(damageIncident);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DamageIncidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return damageIncidents;
    }
}
