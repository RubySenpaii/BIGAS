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
import objects.Farmer;

/**
 *
 * @author RubySenpaii
 */
public class FarmerDAO {

    public boolean addFarmer(Farmer farmer) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Farmer.TABLE_NAME + " "
                    + "(" + Farmer.COLUMN_ADDRESS + ", " + Farmer.COLUMN_BIRTHDAY + ", " + Farmer.COLUMN_CONTACT_NO + ", " + Farmer.COLUMN_FARMER_ID + ", "
                    + Farmer.COLUMN_FARM_ID + ", " + Farmer.COLUMN_FIRST_NAME + ", " + Farmer.COLUMN_FLAG + ", " + Farmer.COLUMN_LAST_NAME + ", " + Farmer.COLUMN_MIDDLE_NAME + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, farmer.getAddress());
            ps.setString(2, farmer.getBirthday());
            ps.setString(3, farmer.getContactNo());
            ps.setInt(4, farmer.getFarmerID());
            ps.setInt(5, farmer.getFarmID());
            ps.setString(6, farmer.getFirstName());
            ps.setInt(7, farmer.getFlag());
            ps.setString(8, farmer.getLastName());
            ps.setString(9, farmer.getMiddleName());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmerDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<Farmer> getListOfFarmers() {
        ArrayList<Farmer> farmers = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Farmer.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            farmers = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmerDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return farmers;
    }

    private ArrayList<Farmer> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Farmer> farmers = new ArrayList<>();
        while (rs.next()) {
            Farmer farmer = new Farmer();
            farmer.setAddress(rs.getString(Farmer.COLUMN_ADDRESS));
            farmer.setBirthday(rs.getString(Farmer.COLUMN_BIRTHDAY));
            farmer.setContactNo(rs.getString(Farmer.COLUMN_CONTACT_NO));
            farmer.setFarmID(rs.getInt(Farmer.COLUMN_FARMER_ID));
            farmer.setFarmerID(rs.getInt(Farmer.COLUMN_FARM_ID));
            farmer.setFirstName(rs.getString(Farmer.COLUMN_FIRST_NAME));
            farmer.setFlag(rs.getInt(Farmer.COLUMN_FLAG));
            farmer.setLastName(rs.getString(Farmer.COLUMN_LAST_NAME));
            farmer.setMiddleName(rs.getString(Farmer.COLUMN_MIDDLE_NAME));
            farmers.add(farmer);
        }
        return farmers;
    }
}
