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
import objects.SeedVariety;

/**
 *
 * @author RubySenpaii
 */
public class SeedVarietyDAO {
    
    public boolean addSeedVariety(SeedVariety seedVariety) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + SeedVariety.TABLE_NAME + " "
                    + "(" + SeedVariety.COLUMN_AVG_YIELD + ", " + SeedVariety.COLUMN_CONDITION + ", " 
                    + SeedVariety.COLUMN_GRAIN_SIZE + ", " + SeedVariety.COLUMN_HEIGHT + ", " + SeedVariety.COLUMN_MATURITY + ", "
                    + SeedVariety.COLUMN_MAXIMUM_YIELD + ", " + SeedVariety.COLUMN_MILLING_RECOVERY + ", " + SeedVariety.COLUMN_SEED_TYPE_ID + ", "
                    + SeedVariety.COLUMN_SEED_VARIETY_ID + ", " + SeedVariety.COLUMN_VARIETY_NAME + ", " + SeedVariety.COLUMN_WATER_SOURCE  + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, seedVariety.getAcquired());
            ps.setDouble(2, seedVariety.getAverageYield());
            ps.setString(3, seedVariety.getCondition());
            ps.setString(4, seedVariety.getGrainSize());
            ps.setDouble(5, seedVariety.getHeight());
            ps.setInt(6, seedVariety.getMaturity());
            ps.setDouble(7, seedVariety.getMaximumYield());
            ps.setDouble(8, seedVariety.getMillingRecovery());
            ps.setInt(9, seedVariety.getSeedTypeID());
            ps.setString(10, seedVariety.getSeedVarietyID());
            ps.setString(11, seedVariety.getVarietyName());
            ps.setString(12, seedVariety.getWaterSource());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedVarietyDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<SeedVariety> getListOfSeedVarieties() {
        ArrayList<SeedVariety> seedVarieties = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + SeedVariety.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            seedVarieties = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedVarietyDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return seedVarieties;
    }
    
    public SeedVariety getSeedVarietyDetails(String seedVarietyID) {
        ArrayList<SeedVariety> seedVarieties = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + SeedVariety.TABLE_NAME + " WHERE " + SeedVariety.COLUMN_SEED_VARIETY_ID + " = ?");
            ps.setString(1, seedVarietyID);

            ResultSet rs = ps.executeQuery();
            seedVarieties = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedVarietyDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return seedVarieties.get(0);
    }

    private ArrayList<SeedVariety> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<SeedVariety> seedVarieties = new ArrayList<>();
        while (rs.next()) {
            SeedVariety seedVariety = new SeedVariety();
            seedVariety.setAverageYield(rs.getDouble(SeedVariety.COLUMN_AVG_YIELD));
            seedVariety.setCondition(rs.getString(SeedVariety.COLUMN_CONDITION));
            seedVariety.setGrainSize(rs.getString(SeedVariety.COLUMN_GRAIN_SIZE));
            seedVariety.setHeight(rs.getDouble(SeedVariety.COLUMN_HEIGHT));
            seedVariety.setMaturity(rs.getInt(SeedVariety.COLUMN_MATURITY));
            seedVariety.setMaximumYield(rs.getDouble(SeedVariety.COLUMN_MAXIMUM_YIELD));
            seedVariety.setMillingRecovery(rs.getDouble(SeedVariety.COLUMN_MILLING_RECOVERY));
            seedVariety.setSeedTypeID(rs.getInt(SeedVariety.COLUMN_SEED_TYPE_ID));
            seedVariety.setSeedVarietyID(rs.getString(SeedVariety.COLUMN_SEED_VARIETY_ID));
            seedVariety.setVarietyName(rs.getString(SeedVariety.COLUMN_VARIETY_NAME));
            seedVariety.setWaterSource(rs.getString(SeedVariety.COLUMN_WATER_SOURCE));
            seedVarieties.add(seedVariety);
        }
        return seedVarieties;
    }
}
