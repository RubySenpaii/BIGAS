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
import tbd.SeedCategory;

/**
 *
 * @author RubySenpaii
 */
public class SeedCategoryDAO {
    
    public boolean addSeedCategory(SeedCategory seedCategory) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + SeedCategory.TABLE_NAME + " "
                    + "(" + SeedCategory.COLUMN_CATEGORY_ID + ", " + SeedCategory.COLUMN_SEED_CATEGORY + ", " + SeedCategory.COLUMN_SEED_TYPE_ID + ") "
                    + "VALUES(?, ?, ?)");
            ps.setString(1, seedCategory.getCategoryID());
            ps.setString(2, seedCategory.getSeedCategory());
            ps.setInt(3, seedCategory.getSeedTypeID());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedCategoryDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<SeedCategory> getListOfSeedCategories() {
        ArrayList<SeedCategory> seedCategories = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareCall("SELECT * FROM " + SeedCategory.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            seedCategories = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedCategoryDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return seedCategories;
    }

    private ArrayList<SeedCategory> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<SeedCategory> seedCategories = new ArrayList<>();
        while (rs.next()) {
            SeedCategory seedCategory = new SeedCategory();
            seedCategory.setCategoryID(rs.getString(SeedCategory.COLUMN_CATEGORY_ID));
            seedCategory.setSeedCategory(rs.getString(SeedCategory.COLUMN_CATEGORY_ID));
            seedCategory.setSeedTypeID(rs.getInt(SeedCategory.COLUMN_CATEGORY_ID));
            seedCategories.add(seedCategory);
        }
        return seedCategories;
    }
}
