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
import objects.SeedType;

/**
 *
 * @author RubySenpaii
 */
public class SeedTypeDAO {

    public boolean addSeedType(SeedType seedType) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + SeedType.TABLE_NAME + " "
                    + "(" + SeedType.COLUMN_SEED_TYPE_ID + ", " + SeedType.COLUMN_TYPE_NAME + ") " 
                    + "VALUES(?, ?)");
            ps.setInt(1, seedType.getSeedTypeID());
            ps.setString(2, seedType.getTypeName());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedTypeDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }
    
    public ArrayList<SeedType> getListOfSeedType(){
        ArrayList<SeedType> seedTypes = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + SeedType.TABLE_NAME);
            
            ResultSet rs = ps.executeQuery();
            seedTypes = getDataFromResultSet(rs);
            
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedTypeDAO.class.getName()).log(Level.SEVERE, null, x);
        } return seedTypes;
    }
    
    private ArrayList<SeedType> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<SeedType> seedTypes = new ArrayList<>();
        while (rs.next()) {
            SeedType seedType = new SeedType();
            seedType.setSeedTypeID(rs.getInt(SeedType.COLUMN_SEED_TYPE_ID));
            seedType.setTypeName(rs.getString(SeedType.COLUMN_TYPE_NAME));
            seedTypes.add(seedType);
        }
        return seedTypes;
    }
}
