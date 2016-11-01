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
import objects.PlantingReport;

/**
 *
 * @author RubySenpaii
 */
public class PlantingReportDAO {

    public boolean createPlantingReport(PlantingReport plantingReport) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + PlantingReport.TABLE_NAME + " "
                    + "(" + PlantingReport.COLUMN_AMOUNT_HARVESTED + ", " + PlantingReport.COLUMN_DATE_REPORTED + ", " + PlantingReport.COLUMN_PLANTING_REPORT_ID + ", "
                    + PlantingReport.COLUMN_PLOT_ID + ", " + PlantingReport.COLUMN_SEASON + ", " + PlantingReport.COLUMN_SEED_PLANTED + ", "
                    + PlantingReport.COLUMN_SEED_VARIETY_ID + ", " + PlantingReport.COLUMN_YEAR + ", " + PlantingReport.COLUMN_PLANTING_METHOD + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setDouble(1, plantingReport.getAmountHarvested());
            ps.setString(2, plantingReport.getDateReported());
            ps.setInt(3, plantingReport.getPlantingReportID());
            ps.setInt(4, plantingReport.getPlotID());
            ps.setString(5, plantingReport.getSeason());
            ps.setDouble(6, plantingReport.getSeedPlanted());
            ps.setInt(7, plantingReport.getSeedVarietyID());
            ps.setString(8, plantingReport.getYear());
            ps.setString(9, plantingReport.getPlantingMethod());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingReportDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<PlantingReport> getListOfPlantingReports() {
        ArrayList<PlantingReport> plantingReports = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingReport.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            plantingReports = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingReportDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plantingReports;
    }

    private ArrayList<PlantingReport> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<PlantingReport> plantingReports = new ArrayList<>();
        while (rs.next()) {
            PlantingReport plantingReport = new PlantingReport();
            plantingReport.setAmountHarvested(rs.getDouble(PlantingReport.COLUMN_AMOUNT_HARVESTED));
            plantingReport.setDateReported(rs.getString(PlantingReport.COLUMN_DATE_REPORTED));
            plantingReport.setPlantingReportID(rs.getInt(PlantingReport.COLUMN_PLANTING_REPORT_ID));
            plantingReport.setPlotID(rs.getInt(PlantingReport.COLUMN_PLOT_ID));
            plantingReport.setSeason(rs.getString(PlantingReport.COLUMN_SEASON));
            plantingReport.setSeedPlanted(rs.getDouble(PlantingReport.COLUMN_SEED_PLANTED));
            plantingReport.setSeedVarietyID(rs.getInt(PlantingReport.COLUMN_SEED_VARIETY_ID));
            plantingReport.setYear(rs.getString(PlantingReport.COLUMN_YEAR));
            plantingReport.setPlantingMethod(rs.getString(PlantingReport.COLUMN_PLANTING_METHOD));
            plantingReports.add(plantingReport);
        }
        return plantingReports;
    }
}
