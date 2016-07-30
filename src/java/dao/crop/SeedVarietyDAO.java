/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.crop;

import dao.people.FarmerDAO;
import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.crop.SeedVariety;
import objects.people.Farmer;

/**
 *
 * @author RubySenpaii
 */
public class SeedVarietyDAO {

    public ArrayList<SeedVariety> getSeedVarietes() {
        ArrayList<SeedVariety> seedVarieties = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM SeedVariety");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SeedVariety seedVariety = new SeedVariety();
                seedVariety.setSeedVarietyID(rs.getInt("SeedVarietyID"));
                seedVariety.setVarietyName(rs.getString("SeedVarietyName"));
                seedVariety.setSeedTypeID(rs.getInt("SeedTypeID"));
                seedVariety.setMaturityDayMin(rs.getInt("MaturityDayMin"));
                seedVariety.setMaturityDayMax(rs.getInt("MaturityDayMax"));
                seedVarieties.add(seedVariety);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SeedVarietyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seedVarieties;
    }
    
    public SeedVariety getSeedVarietyOf(int seedVarietyID) {
        SeedVariety seedVariety = new SeedVariety();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM SeedVariety WHERE SeedVarietyID = ?");
            ps.setInt(1, seedVarietyID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                seedVariety.setSeedVarietyID(rs.getInt("SeedVarietyID"));
                seedVariety.setVarietyName(rs.getString("VarietyName"));
                seedVariety.setSeedTypeID(rs.getInt("SeedTypeID"));
                seedVariety.setMaturityDayMin(rs.getInt("MaturityDayMin"));
                seedVariety.setMaturityDayMax(rs.getInt("MaturityDayMax"));
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SeedVarietyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seedVariety;
    }
}
