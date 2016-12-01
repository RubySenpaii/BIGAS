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
                    + "(" + PlantingReport.COLUMN_AMOUNT_HARVESTED + ", " + PlantingReport.COLUMN_DATE_PLANTED + ", " + PlantingReport.COLUMN_PLANTING_REPORT_ID + ", "
                    + PlantingReport.COLUMN_PLOT_ID + ", " + PlantingReport.COLUMN_SEASON + ", " + PlantingReport.COLUMN_SEED_PLANTED + ", "
                    + PlantingReport.COLUMN_SEED_VARIETY_ID + ", " + PlantingReport.COLUMN_YEAR + ", " + PlantingReport.COLUMN_PLANTING_METHOD +  ", " 
                    + PlantingReport.COLUMN_DATE_HARVESTED + ", " + PlantingReport.COLUMN_SEED_ACQUISITION + ", " + PlantingReport.COLUMN_SEED_TYPE + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setDouble(1, plantingReport.getAmountHarvested());
            ps.setString(2, plantingReport.getDatePlanted());
            ps.setInt(3, plantingReport.getPlantingReportID());
            ps.setInt(4, plantingReport.getPlotID());
            ps.setString(5, plantingReport.getSeason());
            ps.setDouble(6, plantingReport.getSeedPlanted());
            ps.setString(7, plantingReport.getSeedVarietyID());
            ps.setString(8, plantingReport.getYear());
            ps.setString(9, plantingReport.getPlantingMethod());
            ps.setString(10, plantingReport.getDateHarvested());
            ps.setString(11, plantingReport.getSeedAcquisition());
            ps.setString(12, plantingReport.getSeedType());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlantingReportDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }
    
    public boolean updatePlantingProblem(PlantingReport report) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE " + PlantingReport.TABLE_NAME + 
                    " SET " + PlantingReport.COLUMN_AMOUNT_HARVESTED + " = ?, " + PlantingReport.COLUMN_DATE_HARVESTED + " = ?, " + PlantingReport.COLUMN_DATE_PLANTED + " = ?, "
                    + PlantingReport.COLUMN_PLANTING_METHOD + " = ?, " + PlantingReport.COLUMN_PLANTING_REPORT_ID + " = ?, " + PlantingReport.COLUMN_PLOT_ID + " = ?, "
                    + PlantingReport.COLUMN_SEASON + " = ?, " + PlantingReport.COLUMN_SEED_PLANTED + " = ?, " + PlantingReport.COLUMN_SEED_VARIETY_ID + " = ?, " 
                    + PlantingReport.COLUMN_YEAR + " = ?, " + PlantingReport.COLUMN_SEED_TYPE + " = ? "
                    + "WHERE " + PlantingReport.COLUMN_PLANTING_REPORT_ID + " = ?");
            ps.setDouble(1, report.getAmountHarvested());
            ps.setString(2, report.getDateHarvested());
            ps.setString(3, report.getDatePlanted());
            ps.setString(4, report.getPlantingMethod());
            ps.setInt(5, report.getPlantingReportID());
            ps.setInt(6, report.getPlotID());
            ps.setString(7, report.getSeason());
            ps.setDouble(8, report.getSeedPlanted());
            ps.setString(9, report.getSeedVarietyID());
            ps.setString(10, report.getYear());
            ps.setString(11, report.getSeedType());
            ps.setInt(12, report.getPlantingReportID());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlantingReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } return true;
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
    
    public ArrayList<PlantingReport> getListOfPlantingReportFromPlotID(int plotID) {
        ArrayList<PlantingReport> plantingReports = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingReport.TABLE_NAME + " WHERE " + PlantingReport.COLUMN_PLOT_ID + " = ?");
            ps.setInt(1, plotID);

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
    
    public ArrayList<PlantingReport> getSeasonListOfPlantingReportsFor(int plotID, String season) {
        ArrayList<PlantingReport> plantingReports = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlantingReport.TABLE_NAME);
            ps.setInt(1, plotID);
            ps.setString(2, season);

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
            plantingReport.setDatePlanted(rs.getString(PlantingReport.COLUMN_DATE_PLANTED));
            plantingReport.setPlantingReportID(rs.getInt(PlantingReport.COLUMN_PLANTING_REPORT_ID));
            plantingReport.setPlotID(rs.getInt(PlantingReport.COLUMN_PLOT_ID));
            plantingReport.setSeason(rs.getString(PlantingReport.COLUMN_SEASON));
            plantingReport.setSeedPlanted(rs.getDouble(PlantingReport.COLUMN_SEED_PLANTED));
            plantingReport.setSeedVarietyID(rs.getString(PlantingReport.COLUMN_SEED_VARIETY_ID));
            plantingReport.setYear(rs.getString(PlantingReport.COLUMN_YEAR));
            plantingReport.setPlantingMethod(rs.getString(PlantingReport.COLUMN_PLANTING_METHOD));
            plantingReport.setDateHarvested(rs.getString(PlantingReport.COLUMN_DATE_HARVESTED));
            plantingReport.setSeedType(rs.getString(PlantingReport.COLUMN_SEED_TYPE));
            plantingReport.setSeedAcquisition(rs.getString(PlantingReport.COLUMN_SEED_ACQUISITION));
            plantingReports.add(plantingReport);
        }
        return plantingReports;
    }
}
