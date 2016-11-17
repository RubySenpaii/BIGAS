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
import objects.Farm;
import objects.Municipality;

/**
 *
 * @author RubySenpaii
 */
public class FarmDAO {

    public boolean addFarm(Farm farm) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Farm.TABLE_NAME + " "
                    + "(" + Farm.COLUMN_BARANGAY_ID + ", " + Farm.COLUMN_ECOSYSTEM + ", " + Farm.COLUMN_FARM_AREA + ", " + Farm.COLUMN_FARM_ID + ", " + Farm.COLUMN_FARM_NAME
                    + ", " + Farm.COLUMN_LATITUDE + ", " + Farm.COLUMN_LONGITUDE + ", " + Farm.COLUMN_FARM_UPDATED + ", " + Farm.COLUMN_FARM_ADDRESS + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, farm.getBarangayID());
            ps.setString(2, farm.getEcosystem());
            ps.setDouble(3, farm.getFarmArea());
            ps.setInt(4, farm.getFarmID());
            ps.setString(5, farm.getFarmName());
            ps.setDouble(6, farm.getLatitude());
            ps.setDouble(7, farm.getLongitude());
            ps.setInt(8, farm.getFarmUpdated());
            ps.setString(9, farm.getFarmAddress());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }
    
    public boolean updateFarm(Farm farm) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE " + Farm.TABLE_NAME + 
                    " SET " + Farm.COLUMN_BARANGAY_ID + " = ?, " + Farm.COLUMN_ECOSYSTEM + " = ?, " + Farm.COLUMN_FARM_ADDRESS + " = ?, "
                    + Farm.COLUMN_FARM_AREA + " = ?, " + Farm.COLUMN_FARM_ID + " = ?, " + Farm.COLUMN_FARM_NAME + " = ?, "
                    + Farm.COLUMN_FARM_UPDATED + " = ?, " + Farm.COLUMN_LATITUDE + " = ?, " + Farm.COLUMN_LONGITUDE + " = ? "
                    + "WHERE " + Farm.COLUMN_FARM_ID + " = ?");
            ps.setInt(1, farm.getBarangayID());
            ps.setString(2, farm.getEcosystem());
            ps.setString(3, farm.getFarmAddress());
            ps.setDouble(4, farm.getFarmArea());
            ps.setInt(5, farm.getFarmID());
            ps.setString(6, farm.getFarmName());
            ps.setInt(7, farm.getFarmUpdated());
            ps.setDouble(8, farm.getLatitude());
            ps.setDouble(9, farm.getLongitude());
            ps.setInt(10, farm.getFarmID());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlantingProblemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } return true;
    }

    public ArrayList<Farm> getListOfFarms() {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Farm.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            farms = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedTypeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return farms;
    }
    
    public ArrayList<Farm> getListOfFarmsInMunicipal(String municipality) {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * "
                    + "FROM " + Farm.TABLE_NAME + " F JOIN " + Barangay.TABLE_NAME + " B ON F.BarangayID = B.BarangayID "
                    + "JOIN " + Municipality.TABLE_NAME + " M on M.MunicipalityID = B.MunicipalityID "
                    + "WHERE M.MunicipalityName = ?");
            ps.setString(1, municipality);

            ResultSet rs = ps.executeQuery();
            farms = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedTypeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return farms;
    }

    private ArrayList<Farm> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Farm> farms = new ArrayList<>();
        while (rs.next()) {
            Farm farm = new Farm();
            farm.setBarangayID(rs.getInt(Farm.COLUMN_BARANGAY_ID));
            farm.setEcosystem(rs.getString(Farm.COLUMN_ECOSYSTEM));
            farm.setFarmArea(rs.getDouble(Farm.COLUMN_FARM_AREA));
            farm.setFarmID(rs.getInt(Farm.COLUMN_FARM_ID));
            farm.setFarmName(rs.getString(Farm.COLUMN_FARM_NAME));
            farm.setLatitude(rs.getDouble(Farm.COLUMN_LATITUDE));
            farm.setLongitude(rs.getDouble(Farm.COLUMN_LONGITUDE));
            farm.setFarmUpdated(rs.getInt(Farm.COLUMN_FARM_UPDATED));
            farm.setFarmAddress(rs.getString(Farm.COLUMN_FARM_ADDRESS));
            farms.add(farm);
        }
        return farms;
    }
}
