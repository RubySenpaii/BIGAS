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
import objects.Municipality;

/**
 *
 * @author RubySenpaii
 */
public class MunicipalityDAO {
    public ArrayList<Municipality> getMunicipalities() {
        ArrayList<Municipality> municipalities = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Municipality");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Municipality municipality = new Municipality();
                municipality.setMunicipalityID(rs.getInt("MunicipalityID"));
                municipality.setMunicipalityName(rs.getString("MunicipalityName"));
                municipality.setDistrict(rs.getInt("District"));
                municipality.setArea(rs.getDouble("Area"));
                municipalities.add(municipality);
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MunicipalityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return municipalities;
    }
    
    public Municipality getMunicipalityWithID(int municipalityID) {
        Municipality municipality = new Municipality();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Municipality WHERE MunicipalityID = ?");
            ps.setInt(1, municipalityID);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                municipality.setMunicipalityID(rs.getInt("MunicipalityID"));
                municipality.setMunicipalityName(rs.getString("MunicipalityName"));
                municipality.setDistrict(rs.getInt("District"));
                municipality.setArea(rs.getDouble("Area"));
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MunicipalityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return municipality;
    }
}
