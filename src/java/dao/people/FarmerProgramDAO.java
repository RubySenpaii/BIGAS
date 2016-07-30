/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.people;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.people.FarmerProgram;

/**
 *
 * @author RubySenpaii
 */
public class FarmerProgramDAO {

    public ArrayList<FarmerProgram> getFarmers() {
        ArrayList<FarmerProgram> farmers = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FarmerProgram");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FarmerProgram farmer = new FarmerProgram();
                farmer.setProgramCode(rs.getString("ProgramCode"));
                farmer.setProgramNo(rs.getInt("ProgramNo"));
                farmer.setFarmerID(rs.getInt("FarmerID"));
                farmer.setSeedReceived(rs.getInt("SeedReceived"));
                farmer.setFertilizerReceived(rs.getInt("FertilizerReceived"));
                farmers.add(farmer);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmers;
    }

    public ArrayList<FarmerProgram> getFarmersFromProgram(String programCode, int programNo) {
        ArrayList<FarmerProgram> farmers = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FarmerProgram WHERE programCode = ? AND ProgramNo = ?");
            ps.setString(1, programCode);
            ps.setInt(2, programNo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FarmerProgram farmer = new FarmerProgram();
                farmer.setProgramCode(rs.getString("ProgramCode"));
                farmer.setProgramNo(rs.getInt("ProgramNo"));
                farmer.setFarmerID(rs.getInt("FarmerID"));
                farmer.setSeedReceived(rs.getInt("SeedReceived"));
                farmer.setFertilizerReceived(rs.getInt("FertilizerReceived"));
                farmers.add(farmer);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FarmerProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmers;
    }
}
