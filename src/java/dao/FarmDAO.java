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
import objects.Farm;

/**
 *
 * @author RubySenpaii
 */
public class FarmDAO {

    public ArrayList<Farm> getFarms() {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Farm");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farms;
    }

    public ArrayList<Farm> getFarmsInMunicipality(int municipalID) {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT F.*\n"
                    + "FROM Farm F JOIN Barangay B ON F.BarangayID = B.BarangayID\n"
                    + "			JOIN Municipality M ON B.MunicipalityID = M.MunicipalityID\n"
                    + "WHERE M.MunicipalityID = ?");
            ps.setInt(1, municipalID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm();
                farm.setFarmID(rs.getInt("FarmID"));
                farm.setBarangayID(rs.getInt("BarangayID"));
                farm.setFarmName(rs.getString("FarmName"));
                farm.setFarmArea(rs.getDouble("FarmArea"));
                farm.setEcosystem(rs.getString("Ecosystem"));
                farms.add(farm);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farms;
    }
    
    public ArrayList<Farm> getFarmsInBarangay(String barangayName) {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT F.*\n"
                    + "FROM Farm F JOIN Barangay B ON F.BarangayID = B.BarangayID\n"
                    + "WHERE B.BarangayName = ?");
            ps.setString(1, barangayName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm();
                farm.setFarmID(rs.getInt("FarmID"));
                farm.setBarangayID(rs.getInt("BarangayID"));
                farm.setFarmName(rs.getString("FarmName"));
                farm.setFarmArea(rs.getDouble("FarmArea"));
                farm.setEcosystem(rs.getString("Ecosystem"));
                farms.add(farm);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farms;
    }
}
