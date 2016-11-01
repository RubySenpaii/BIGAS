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
import objects.Barangay;

/**
 *
 * @author RubySenpaii
 */
public class BarangayDAO {

    public boolean addBarangay(Barangay barangay) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Barangay.TABLE_NAME + " "
                    + "(" + Barangay.COLUMN_BARANGAY_ID + ", " + Barangay.COLUMN_BARANGAY_NAME + ", " + Barangay.COLUMN_MUNICIPALITY_ID + ", " + Barangay.COLUMN_AREA + ") "
                    + "VALUES(?, ?, ?, ?)");
            ps.setInt(1, barangay.getBarangayID());
            ps.setString(2, barangay.getBarangayName());
            ps.setInt(3, barangay.getMunicipalityID());
            ps.setDouble(4, barangay.getArea());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(BarangayDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<Barangay> getListOfBarangayz() {
        ArrayList<Barangay> barangays = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Barangay.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            barangays = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(BarangayDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return barangays;
    }

    private ArrayList<Barangay> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Barangay> barangays = new ArrayList<>();
        while (rs.next()) {
            Barangay barangay = new Barangay();
            barangay.setArea(rs.getDouble(Barangay.COLUMN_AREA));
            barangay.setBarangayID(rs.getInt(Barangay.COLUMN_BARANGAY_ID));
            barangay.setBarangayName(rs.getString(Barangay.COLUMN_BARANGAY_NAME));
            barangay.setMunicipalityID(rs.getInt(Barangay.COLUMN_MUNICIPALITY_ID));
            barangays.add(barangay);
        }
        return barangays;
    }
}
