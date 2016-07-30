/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.farm;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.farm.SeedPlanted;

/**
 *
 * @author RubySenpaii
 */
public class SeedPlantedDAO {
    public ArrayList<SeedPlanted> getSeedPlanted() {
        ArrayList<SeedPlanted> seedPlanted = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM SeedPlanted");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SeedPlanted planted = new SeedPlanted();
                planted.setPlantedID(rs.getInt("PlantedID"));
                planted.setFarmID(rs.getInt("FarmID"));
                planted.setSeasonID(rs.getInt("SeasonID"));
                planted.setSeedVarietyID(rs.getInt("SeedVarietyID"));
                planted.setArea(rs.getDouble("Area"));
                planted.setYear(rs.getString("Year"));
                seedPlanted.add(planted);
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SeedPlantedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seedPlanted;
    }
    
    public ArrayList<SeedPlanted> getSeedPlantedOfFarm(int farmID) {
        ArrayList<SeedPlanted> seedPlanted = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM SeedPlanted WHERE FarmID = ?");
            ps.setInt(1, farmID);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SeedPlanted planted = new SeedPlanted();
                planted.setPlantedID(rs.getInt("PlantedID"));
                planted.setFarmID(rs.getInt("FarmID"));
                planted.setSeasonID(rs.getInt("SeasonID"));
                planted.setSeedVarietyID(rs.getInt("SeedVarietyID"));
                planted.setArea(rs.getDouble("Area"));
                planted.setYear(rs.getString("Year"));
                seedPlanted.add(planted);
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SeedPlantedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seedPlanted;
    }
}
