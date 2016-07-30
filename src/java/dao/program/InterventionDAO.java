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
import objects.program.Intervention;

/**
 *
 * @author RubySenpaii
 */
public class InterventionDAO {

    public ArrayList<Intervention> getInterventions() {
        ArrayList<Intervention> interventions = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Intervention");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Intervention intervention = new Intervention();
                intervention.setInterventionID(rs.getInt("InterventionID"));
                intervention.setInterventionName(rs.getString("InterventionName"));
                intervention.setPurpose(rs.getString("Purpose"));
                interventions.add(intervention);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterventionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interventions;
    }
    
    public Intervention getInterventionWithID(int interventionID) {
        Intervention intervention = new Intervention();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Intervention WHERE InterventionID = ?");
            ps.setInt(1, interventionID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intervention.setInterventionID(rs.getInt("InterventionID"));
                intervention.setInterventionName(rs.getString("InterventionName"));
                intervention.setPurpose(rs.getString("Purpose"));
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterventionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return intervention;
    }
}
