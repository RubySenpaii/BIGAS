/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tbd.PlantingStage;

/**
 *
 * @author RubySenpaii
 */
public class PlantingStageDAO {

    public boolean addPlantingStage(PlantingStage plantingStage) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + PlantingStage.TABLE_NAME + " "
                    + "(" + PlantingStage.COLUMN_CROP_STAGE + ", " + PlantingStage.COLUMN_DATE_REPORTED + ", " + PlantingStage.COLUMN_IMAGE + ", "
                    + PlantingStage.COLUMN_PLANTING_REPORT_ID + ") "
                    + "VALUES(?, ?, ?, ?)");
            ps.setString(1, plantingStage.getCropStage());
            ps.setString(2, plantingStage.getDateReported());
            ps.setString(3, plantingStage.getImage());
            ps.setString(4, plantingStage.getPlantingReportID());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingStageDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<PlantingStage> getListOfPlantingStages() {
        ArrayList<PlantingStage> plantingStages = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareCall("SELECT * FROM " + PlantingStage.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            plantingStages = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingStageDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plantingStages;
    }

    private ArrayList<PlantingStage> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<PlantingStage> plantingStages = new ArrayList<>();
        while (rs.next()) {
            PlantingStage plantingStage = new PlantingStage();
            plantingStage.setCropStage(rs.getString(PlantingStage.COLUMN_CROP_STAGE));
            plantingStage.setDateReported(rs.getString(PlantingStage.COLUMN_DATE_REPORTED));
            plantingStage.setImage(rs.getString(PlantingStage.COLUMN_IMAGE));
            plantingStage.setPlantingReportID(rs.getString(PlantingStage.COLUMN_PLANTING_REPORT_ID));
            plantingStages.add(plantingStage);
        }
        return plantingStages;
    }
}
