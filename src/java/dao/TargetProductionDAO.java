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
import objects.TargetProduction;

/**
 *
 * @author RubySenpaii
 */
public class TargetProductionDAO {
    
    public boolean createTargetProduction(TargetProduction targetProduction) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TargetProduction.TABLE_NAME + " "
                    + "(" + TargetProduction.COLUMN_SET_BY + ", " + TargetProduction.COLUMN_TARGET + ", " + TargetProduction.COLUMN_YEAR + ") "
                    + "VALUES(?, ?, ?)");
            ps.setInt(1, targetProduction.getSetBy());
            ps.setDouble(2, targetProduction.getTarget());
            ps.setInt(3, targetProduction.getYear());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(TargetProductionDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<TargetProduction> getListOfTargetProduction() {
        ArrayList<TargetProduction> targetProductions = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + TargetProduction.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            targetProductions = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(TargetProductionDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return targetProductions;
    }
    
    public TargetProduction getListOfTargetProductionForYear(int year) {
        ArrayList<TargetProduction> targetProductions = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + TargetProduction.TABLE_NAME + " WHERE " + TargetProduction.COLUMN_YEAR + " = ?");
            ps.setInt(1, year);
            
            ResultSet rs = ps.executeQuery();
            targetProductions = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(TargetProductionDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return targetProductions.get(0);
    }

    private ArrayList<TargetProduction> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<TargetProduction> targetProductions = new ArrayList<>();
        while (rs.next()) {
            TargetProduction targetProduction = new TargetProduction();
            targetProduction.setSetBy(rs.getInt(TargetProduction.COLUMN_SET_BY));
            targetProduction.setTarget(rs.getDouble(TargetProduction.COLUMN_TARGET));
            targetProduction.setYear(rs.getInt(TargetProduction.COLUMN_YEAR));
            targetProductions.add(targetProduction);
        }
        return targetProductions;
    }
}
