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
import objects.WeeklyReports;

/**
 *
 * @author RubySenpaii
 */
public class WeeklyReportsDAO {
    
    public boolean createWeeklyReport(WeeklyReports weeklyReport) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + WeeklyReports.TABLE_NAME + " "
                    + "(" + WeeklyReports.COLUMN_CROP_STAGE + ", " + WeeklyReports.COLUMN_DATE_REPORTED + ", " + WeeklyReports.COLUMN_HEIGHT + ", " 
                    + WeeklyReports.COLUMN_IMAGE + ", " + WeeklyReports.COLUMN_PLANTING_REPORT_ID + ", " + WeeklyReports.COLUMN_WATER_LEVEL + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, weeklyReport.getCropStage());
            ps.setString(2, weeklyReport.getDateReported());
            ps.setDouble(3, weeklyReport.getHeight());
            ps.setString(4, weeklyReport.getImage());
            ps.setInt(5, weeklyReport.getPlantingReportID());
            ps.setDouble(6, weeklyReport.getWaterLevel());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(WeeklyReportsDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<WeeklyReports> getListOfWeeklyReports() {
        ArrayList<WeeklyReports> weeklyReports = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + WeeklyReports.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            weeklyReports = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(WeeklyReportsDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return weeklyReports;
    }

    private ArrayList<WeeklyReports> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<WeeklyReports> weeklyReports = new ArrayList<>();
        while (rs.next()) {
            WeeklyReports weeklyReport = new WeeklyReports();
            weeklyReport.setCropStage(rs.getString(WeeklyReports.COLUMN_CROP_STAGE));
            weeklyReport.setDateReported(rs.getString(WeeklyReports.COLUMN_DATE_REPORTED));
            weeklyReport.setHeight(rs.getDouble(WeeklyReports.COLUMN_HEIGHT));
            weeklyReport.setImage(rs.getString(WeeklyReports.COLUMN_IMAGE));
            weeklyReport.setPlantingReportID(rs.getInt(WeeklyReports.COLUMN_PLANTING_REPORT_ID));
            weeklyReport.setWaterLevel(rs.getDouble(WeeklyReports.COLUMN_WATER_LEVEL));
            weeklyReports.add(weeklyReport);
        }
        return weeklyReports;
    }
}