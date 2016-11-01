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
import objects.FAMembers;

/**
 *
 * @author RubySenpaii
 */
public class FAMembersDAO {
    
    public boolean addFarmerMembers(FAMembers faMember) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + FAMembers.TABLE_NAME + " "
                    + "(" + FAMembers.COLUMN_ASSOCIATION_ID + ", " + FAMembers.COLUMN_FARMER_ID + ", " +  ") "
                    + "VALUES(?, ?)");
            ps.setInt(1, faMember.getAssociationID());
            ps.setInt(2, faMember.getFarmerID());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FAMembersDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<FAMembers> getListOfFarmerMembers() {
        ArrayList<FAMembers> faMembers = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + FAMembers.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            faMembers = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FAMembersDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return faMembers;
    }

    private ArrayList<FAMembers> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<FAMembers> faMembers = new ArrayList<>();
        while (rs.next()) {
            FAMembers famember = new FAMembers();
            famember.setAssociationID(rs.getInt(FAMembers.COLUMN_ASSOCIATION_ID));
            famember.setFarmerID(rs.getInt(FAMembers.COLUMN_FARMER_ID));
            faMembers.add(famember);
        }
        return faMembers;
    }
}
