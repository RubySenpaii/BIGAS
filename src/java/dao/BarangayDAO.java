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
import objects.Barangay;

/**
 *
 * @author RubySenpaii
 */
public class BarangayDAO {

    public ArrayList<Barangay> getBarangays() {
        ArrayList<Barangay> barangays = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Barangay");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Barangay barangay = new Barangay();
                barangay.setBarangayID(rs.getInt("BarangayID"));
                barangay.setBarangayName(rs.getString("BarangayName"));
                barangay.setMunicipalityID(rs.getInt("MunicipalityID"));
                barangay.setArea(rs.getDouble("Area"));
                barangays.add(barangay);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barangays;
    }

    public ArrayList<Barangay> getBarangaysFromMunicipality(String municipalityName) {
        ArrayList<Barangay> barangays = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT B.*\n"
                    + "FROM Barangay B JOIN Municipality M ON B.MunicipalityID = M.MunicipalityID\n"
                    + "WHERE M.MunicipalityName = ?");
            ps.setString(1, municipalityName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Barangay barangay = new Barangay();
                barangay.setBarangayID(rs.getInt("BarangayID"));
                barangay.setBarangayName(rs.getString("BarangayName"));
                barangay.setMunicipalityID(rs.getInt("MunicipalityID"));
                barangay.setArea(rs.getDouble("Area"));
                barangays.add(barangay);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barangays;
    }
}
