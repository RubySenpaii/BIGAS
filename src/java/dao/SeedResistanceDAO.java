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
import objects.SeedResistance;

/**
 *
 * @author RubySenpaii
 */
public class SeedResistanceDAO {
    
    public boolean addSeedResistance(SeedResistance seedResistance) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + SeedResistance.TABLE_NAME + " "
                    + "(" + SeedResistance.COLUMN_PROBLEM_ID + ", " + SeedResistance.COLUMN_SEED_VARIETY_ID + ", " + SeedResistance.COLUMN_TOLERANCE_LEVEL+ ") "
                    + "VALUES(?, ?, ?)");
            ps.setInt(1, seedResistance.getProblemID());
            ps.setString(2, seedResistance.getSeedVarietyID());
            ps.setString(3, seedResistance.getToleranceLevel());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedResistanceDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<SeedResistance> getListOfSeedResistance() {
        ArrayList<SeedResistance> seedResistances = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + SeedResistance.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            seedResistances = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SeedResistanceDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return seedResistances;
    }

    private ArrayList<SeedResistance> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<SeedResistance> seedResistances = new ArrayList<>();
        while (rs.next()) {
            SeedResistance seedResistance = new SeedResistance();
            seedResistance.setProblemID(rs.getInt(SeedResistance.COLUMN_PROBLEM_ID));
            seedResistance.setSeedVarietyID(rs.getString(SeedResistance.COLUMN_SEED_VARIETY_ID));
            seedResistance.setToleranceLevel(rs.getString(SeedResistance.COLUMN_TOLERANCE_LEVEL));
            seedResistances.add(seedResistance);
        }
        return seedResistances;
    }
}
