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
import objects.PlotSoil;

/**
 *
 * @author RubySenpaii
 */
public class PlotSoilDAO {

    public boolean addPlotSoil(PlotSoil plotSoil) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + PlotSoil.TABLE_NAME + " "
                    + "(" + PlotSoil.COLUMN_AMOUNT + ", " + PlotSoil.COLUMN_PLOT_ID + ", " + PlotSoil.COLUMN_SOIL_NUTRIENT + ") "
                    + "VALUES(?, ?, ?)");
            ps.setDouble(1, plotSoil.getAmount());
            ps.setInt(2, plotSoil.getPlotID());
            ps.setString(3, plotSoil.getSoilNutrient());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotSoilDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<PlotSoil> getListOfPlotSoils() {
        ArrayList<PlotSoil> plotSoils = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + PlotSoil.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            plotSoils = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(PlotSoilDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return plotSoils;
    }

    private ArrayList<PlotSoil> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<PlotSoil> plotSoils = new ArrayList<>();
        while (rs.next()) {
            PlotSoil plotSoil = new PlotSoil();
            plotSoil.setAmount(rs.getDouble(PlotSoil.COLUMN_AMOUNT));
            plotSoil.setPlotID(rs.getInt(PlotSoil.COLUMN_PLOT_ID));
            plotSoil.setSoilNutrient(rs.getString(PlotSoil.COLUMN_SOIL_NUTRIENT));
            plotSoils.add(plotSoil);
        }
        return plotSoils;
    }
}
