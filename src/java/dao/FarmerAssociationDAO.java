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
import objects.FarmerAssociation;

/**
 *
 * @author RubySenpaii
 */
public class FarmerAssociationDAO {
    
    public boolean addFarmerAssociation(FarmerAssociation farmerAssociation) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + FarmerAssociation.TABLE_NAME + " "
                    + "(" + FarmerAssociation.COLUMN_ASSOCIATION_ID + ", " + FarmerAssociation.COLUMN_ASSOCIATION_NAME + ") "
                    + "VALUES(?, ?)");
            ps.setInt(1, farmerAssociation.getAssociationID());
            ps.setString(2, farmerAssociation.getAssociationName());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmerAssociationDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<FarmerAssociation> getListOfFarmerAssociation() {
        ArrayList<FarmerAssociation> farmerAssociations = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + FarmerAssociation.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            farmerAssociations = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FarmerAssociationDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return farmerAssociations;
    }

    private ArrayList<FarmerAssociation> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<FarmerAssociation> farmerAssociations = new ArrayList<>();
        while (rs.next()) {
            FarmerAssociation farmerAssociation = new FarmerAssociation();
            farmerAssociation.setAssociationID(rs.getInt(FarmerAssociation.COLUMN_ASSOCIATION_ID));
            farmerAssociation.setAssociationName(rs.getString(FarmerAssociation.COLUMN_ASSOCIATION_NAME));
            farmerAssociations.add(farmerAssociation);
        }
        return farmerAssociations;
    }
}
