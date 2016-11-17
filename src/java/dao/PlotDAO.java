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
import objects.Plot;

/**
 *
 * @author RubySenpaii
 */
public class PlotDAO {

    public boolean createPlot(Plot plot) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Plot.TABLE_NAME + " "
                    + "(" + Plot.COLUMN_FARM_ID + ", " + Plot.COLUMN_PLOT_NUMBER + ", " + Plot.COLUMN_PLOT_ID + ", " + Plot.COLUMN_PLOT_PLANTED + ", "
                    + Plot.COLUMN_PLOT_SIZE + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, plot.getFarmID());
            ps.setInt(2, plot.getPlotNumber());
            ps.setInt(3, plot.getPlotID());
            ps.setInt(4, plot.getPlotPlanted());
            ps.setDouble(5, plot.getPlotSize());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }
    
    public boolean updatePlantingProblem(Plot plot) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE " + Plot.TABLE_NAME + 
                    " SET " + Plot.COLUMN_FARM_ID + " = ?, " + Plot.COLUMN_PLOT_ID + " = ?, " + Plot.COLUMN_PLOT_NUMBER + " = ?, "
                    + Plot.COLUMN_PLOT_PLANTED + " = ?, " + Plot.COLUMN_PLOT_SIZE + " = ? "
                    + "WHERE " + Plot.COLUMN_PLOT_ID + " = ?");
            ps.setInt(1, plot.getFarmID());
            ps.setInt(2, plot.getPlotID());
            ps.setInt(3, plot.getPlotNumber());
            ps.setInt(4, plot.getPlotPlanted());
            ps.setDouble(5, plot.getPlotSize());
            ps.setInt(6, plot.getPlotID());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlotDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } return true;
    }

    public ArrayList<Plot> getListOfPlots() {
        ArrayList<Plot> plots = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Plot.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            plots = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plots;
    }
    
    public ArrayList<Plot> getListOfPlotsFromFarm(int farmID) {
        ArrayList<Plot> plots = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Plot.TABLE_NAME + " WHERE " + Plot.COLUMN_FARM_ID + " = ?");
            ps.setInt(1, farmID);

            ResultSet rs = ps.executeQuery();
            plots = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plots;
    }

    private ArrayList<Plot> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Plot> plots = new ArrayList<>();
        while (rs.next()) {
            Plot plot = new Plot();
            plot.setFarmID(rs.getInt(Plot.COLUMN_FARM_ID));
            plot.setPlotNumber(rs.getInt(Plot.COLUMN_PLOT_NUMBER));
            plot.setPlotID(rs.getInt(Plot.COLUMN_PLOT_ID));
            plot.setPlotPlanted(rs.getInt(Plot.COLUMN_PLOT_PLANTED));
            plot.setPlotSize(rs.getDouble(Plot.COLUMN_PLOT_SIZE));
            plots.add(plot);
        }
        return plots;
    }
}
