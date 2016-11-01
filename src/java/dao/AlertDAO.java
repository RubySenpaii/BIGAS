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
import objects.Alert;

/**
 *
 * @author RubySenpaii
 */
public class AlertDAO {

    public boolean createAlert(Alert alert) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Alert.TABLE_NAME + " "
                    + "(" + Alert.COLUMN_ALERT_ID + ", " + Alert.COLUMN_DATE + ", " + Alert.COLUMN_MESSAGE + ", " + Alert.COLUMN_REPORTED_BY + ", " + Alert.COLUMN_VALIDITY + ") "
                    + "VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, alert.getAlertID());
            ps.setString(2, alert.getDate());
            ps.setString(3, alert.getMessage());
            ps.setInt(4, alert.getReportedBy());
            ps.setString(5, alert.getValidity());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(AlertDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<Alert> getListOfAlert() {
        ArrayList<Alert> alerts = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Alert.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            alerts = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(AlertDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return alerts;
    }

    private ArrayList<Alert> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Alert> alerts = new ArrayList<>();
        while (rs.next()) {
            Alert alert = new Alert();
            alert.setAlertID(rs.getInt(Alert.COLUMN_ALERT_ID));
            alert.setDate(rs.getString(Alert.COLUMN_DATE));
            alert.setMessage(rs.getString(Alert.COLUMN_MESSAGE));
            alert.setReportedBy(rs.getInt(Alert.COLUMN_REPORTED_BY));
            alert.setValidity(rs.getString(Alert.COLUMN_VALIDITY));
            alerts.add(alert);
        }
        return alerts;
    }
}
