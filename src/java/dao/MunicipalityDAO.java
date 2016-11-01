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
import objects.Municipality;

/**
 *
 * @author RubySenpaii
 */
public class MunicipalityDAO {

    public boolean addMuncipality(Municipality municipality) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Municipality.TABLE_NAME + " "
                    + "(" + Municipality.COLUMN_AREA + ", " + Municipality.COLUMN_DISTRICT + ", " + Municipality.COLUMN_LATITUDE + ", "
                    + Municipality.COLUMN_LONGITUDE + ", " + Municipality.COLUMN_MUNICIPALITY_ID + ", " + Municipality.COLUMN_MUNICIPALITY_NAME + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            ps.setDouble(1, municipality.getArea());
            ps.setInt(2, municipality.getDisctrict());
            ps.setDouble(3, municipality.getLatitude());
            ps.setDouble(4, municipality.getLongitude());
            ps.setInt(5, municipality.getMunicipalityID());
            ps.setString(6, municipality.getMunicipalityName());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(MunicipalityDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<Municipality> getListOfMunicipalities() {
        ArrayList<Municipality> municipalities = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Municipality.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            municipalities = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(MunicipalityDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return municipalities;
    }

    private ArrayList<Municipality> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Municipality> municipalities = new ArrayList<>();
        while (rs.next()) {
            Municipality municipality = new Municipality();
            municipality.setArea(rs.getDouble(Municipality.COLUMN_AREA));
            municipality.setDisctrict(rs.getInt(Municipality.COLUMN_DISTRICT));
            municipality.setLatitude(rs.getDouble(Municipality.COLUMN_LATITUDE));
            municipality.setLongitude(rs.getDouble(Municipality.COLUMN_LONGITUDE));
            municipality.setMunicipalityID(rs.getInt(Municipality.COLUMN_MUNICIPALITY_ID));
            municipality.setMunicipalityName(rs.getString(Municipality.COLUMN_MUNICIPALITY_NAME));
            municipalities.add(municipality);
        }
        return municipalities;
    }
}
