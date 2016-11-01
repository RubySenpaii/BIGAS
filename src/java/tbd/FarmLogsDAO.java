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
import tbd.FarmLogs;

/**
 *
 * @author RubySenpaii
 */
public class FarmLogsDAO {
    
    public boolean createFarmLog(FarmLogs farmLog) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + FarmLogs.TABLE_NAME + " "
                    + "(" + FarmLogs.COLUMN_ASSIGNED_FARM_ID + ", " + FarmLogs.COLUMN_DATE_VISITED + ") "
                    + "VALUES(?, ?)");
            ps.setInt(1, farmLog.getAssignedFarmedID());
            ps.setString(2, farmLog.getDateVisited());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmLogsDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<FarmLogs> getListOfFarmLogs() {
        ArrayList<FarmLogs> farmLogs = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareCall("SELECT * FROM " + FarmLogs.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            farmLogs = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmLogsDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return farmLogs;
    }

    private ArrayList<FarmLogs> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<FarmLogs> farmLogs = new ArrayList<>();
        while (rs.next()) {
            FarmLogs farmLog = new FarmLogs();
            farmLog.setAssignedFarmedID(rs.getInt(FarmLogs.COLUMN_ASSIGNED_FARM_ID));
            farmLog.setDateVisited(rs.getString(FarmLogs.COLUMN_DATE_VISITED));
            farmLogs.add(farmLog);
        }
        return farmLogs;
    }
}
