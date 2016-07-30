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
import objects.people.Farmer;

/**
 *
 * @author RubySenpaii
 */
public class FarmerDAO {

    public ArrayList<Farmer> getFarmers() {
        ArrayList<Farmer> farmers = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Farmer");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farmer farmer = new Farmer();
                farmer.setFarmerID(rs.getInt("FarmerID"));
                farmer.setFarmID(rs.getInt("FarmID"));
                farmer.setLastName(rs.getString("LastName"));
                farmer.setFirstName(rs.getString("FirstName"));
                farmer.setMiddleName(rs.getString("MiddleName"));
                farmer.setAddress(rs.getString("Address"));
                farmer.setContactNo(rs.getString("ContactNo"));
                farmer.setBirthday(rs.getString("Birthday"));
                farmers.add(farmer);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmers;
    }
    
    public ArrayList<Farmer> getFarmersOnFarm(int farmID) {
        ArrayList<Farmer> farmers = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Farmer WHERE FarmID = ?");
            ps.setInt(1, farmID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farmer farmer = new Farmer();
                farmer.setFarmerID(rs.getInt("FarmerID"));
                farmer.setFarmID(rs.getInt("FarmID"));
                farmer.setLastName(rs.getString("LastName"));
                farmer.setFirstName(rs.getString("FirstName"));
                farmer.setMiddleName(rs.getString("MiddleName"));
                farmer.setAddress(rs.getString("Address"));
                farmer.setContactNo(rs.getString("ContactNo"));
                farmer.setBirthday(rs.getString("Birthday"));
                farmers.add(farmer);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmers;
    }
    
    public Farmer getFarmerWithID(int farmerID) {
        Farmer farmer = new Farmer();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Farmer WHERE FarmerID = ?");
            ps.setInt(1, farmerID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                farmer.setFarmerID(rs.getInt("FarmerID"));
                farmer.setFarmID(rs.getInt("FarmID"));
                farmer.setLastName(rs.getString("LastName"));
                farmer.setFirstName(rs.getString("FirstName"));
                farmer.setMiddleName(rs.getString("MiddleName"));
                farmer.setAddress(rs.getString("Address"));
                farmer.setContactNo(rs.getString("ContactNo"));
                farmer.setBirthday(rs.getString("Birthday"));
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmer;
    }
}
