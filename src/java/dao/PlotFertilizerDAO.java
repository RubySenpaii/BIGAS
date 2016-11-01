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
import objects.PlotFertilizer;

/**
 *
 * @author RubySenpaii
 */
public class PlotFertilizerDAO {
    
    public boolean addPlotFertilizer(PlotFertilizer plotFertilizer) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + PlotFertilizer.TABLE_NAME + " "
                    + "(" + PlotFertilizer.COLUMN_DATE_APPLIED + ", " + PlotFertilizer.COLUMN_FERTILIZER_APPLIED + ", " + PlotFertilizer.COLUMN_FERTILIZER_ID + ", " 
                    + PlotFertilizer.COLUMN_PLOT_ID + ", " + PlotFertilizer.COLUMN_REMARKS + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, plotFertilizer.getDateApplied());
            ps.setDouble(2, plotFertilizer.getFertilizerApplied());
            ps.setInt(3, plotFertilizer.getFertilizerID());
            ps.setInt(4, plotFertilizer.getPlotID());
            ps.setString(5, plotFertilizer.getRemarks());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotFertilizerDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<PlotFertilizer> getListOfPlotFertilizers() {
        ArrayList<PlotFertilizer> plotFertilizers = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlotFertilizer.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            plotFertilizers = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotFertilizerDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plotFertilizers;
    }

    private ArrayList<PlotFertilizer> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<PlotFertilizer> plotFertilizers = new ArrayList<>();
        while (rs.next()) {
            PlotFertilizer plotFertilizer = new PlotFertilizer();
            plotFertilizer.setDateApplied(rs.getString(PlotFertilizer.COLUMN_DATE_APPLIED));
            plotFertilizer.setFertilizerApplied(rs.getDouble(PlotFertilizer.COLUMN_FERTILIZER_APPLIED));
            plotFertilizer.setFertilizerID(rs.getInt(PlotFertilizer.COLUMN_FERTILIZER_ID));
            plotFertilizer.setPlotID(rs.getInt(PlotFertilizer.COLUMN_PLOT_ID));
            plotFertilizer.setRemarks(rs.getString(PlotFertilizer.COLUMN_REMARKS));
            plotFertilizers.add(plotFertilizer);
        }
        return plotFertilizers;
    }
}
