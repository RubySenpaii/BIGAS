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
import objects.farm.SeedStage;

/**
 *
 * @author RubySenpaii
 */
public class SeedStageDAO {

    public ArrayList<SeedStage> getSeedStages() {
        ArrayList<SeedStage> seedStages = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM SeedStage");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SeedStage seedStage = new SeedStage();
                seedStage.setCropStageID(rs.getInt("CropStageID"));
                seedStage.setPlantedID(rs.getInt("PlantedID"));
                seedStage.setUpdatedBy(rs.getInt("UpdatedBy"));
                seedStage.setDateUpdated(rs.getString("DateUpdated"));
                seedStage.setHarvested(rs.getDouble("Harvested"));
                seedStage.setRemarks(rs.getString("Remarks"));
                seedStages.add(seedStage);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SeedStageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seedStages;
    }

    public SeedStage getSeedStagesOfPlanted(int plantedID) {
        SeedStage seedStage = new SeedStage();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT SS.*\n"
                    + "FROM SeedStage SS, (SELECT S2.PlantedID, MAX(CropStageID) AS 'CropStageID' FROM SeedStage S2 WHERE S2.PlantedID = ? GROUP BY S2.PlantedID) T1\n"
                    + "WHERE SS.PlantedID = ? AND SS.CropStageID = T1.CropStageID");
            ps.setInt(1, plantedID);
            ps.setInt(2, plantedID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                seedStage.setCropStageID(rs.getInt("CropStageID"));
                seedStage.setPlantedID(rs.getInt("PlantedID"));
                seedStage.setUpdatedBy(rs.getInt("UpdatedBy"));
                seedStage.setDateUpdated(rs.getString("DateUpdated"));
                seedStage.setHarvested(rs.getDouble("Harvested"));
                seedStage.setRemarks(rs.getString("Remarks"));
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SeedStageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seedStage;
    }
}
