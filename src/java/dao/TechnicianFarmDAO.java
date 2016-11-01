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
import objects.TechnicianFarm;

/**
 *
 * @author RubySenpaii
 */
public class TechnicianFarmDAO {
    
    public boolean assignTechnicianFarm(TechnicianFarm technicianFarm) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TechnicianFarm.TABLE_NAME + " "
                    + "(" + TechnicianFarm.COLUMN_ASSIGNED_FARM_ID + ", " + TechnicianFarm.COLUMN_EMPLOYEE_ID + ", " + TechnicianFarm.COLUMN_END_DATE + ", " 
                    + TechnicianFarm.COLUMN_FARM_ID + ", " + TechnicianFarm.COLUMN_START_DATE + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, technicianFarm.getAssignedFarmID());
            ps.setInt(2, technicianFarm.getEmployeeID());
            ps.setString(3, technicianFarm.getEndDate());
            ps.setInt(4, technicianFarm.getFarmID());
            ps.setString(5, technicianFarm.getStartDate());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(TechnicianFarmDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<TechnicianFarm> getListOfTechncianFarm() {
        ArrayList<TechnicianFarm> technicianFarms = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + TechnicianFarm.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            technicianFarms = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(TechnicianFarmDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return technicianFarms;
    }

    private ArrayList<TechnicianFarm> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<TechnicianFarm> technicianFarms = new ArrayList<>();
        while (rs.next()) {
            TechnicianFarm technicianFarm = new TechnicianFarm();
            technicianFarm.setAssignedFarmID(rs.getInt(TechnicianFarm.COLUMN_ASSIGNED_FARM_ID));
            technicianFarm.setEmployeeID(rs.getInt(TechnicianFarm.COLUMN_EMPLOYEE_ID));
            technicianFarm.setEndDate(rs.getString(TechnicianFarm.COLUMN_END_DATE));
            technicianFarm.setFarmID(rs.getInt(TechnicianFarm.COLUMN_FARM_ID));
            technicianFarm.setStartDate(rs.getString(TechnicianFarm.COLUMN_START_DATE));
            technicianFarms.add(technicianFarm);
        }
        return technicianFarms;
    }
}
