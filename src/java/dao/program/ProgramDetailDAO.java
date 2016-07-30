/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.program;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.program.Program;
import objects.program.ProgramDetail;

/**
 *
 * @author RubySenpaii
 */
public class ProgramDetailDAO {
    
    public ArrayList<ProgramDetail> getProgramDetails() {
        ArrayList<ProgramDetail> programDetails = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ProgramDetail");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProgramDetail programDetail = new ProgramDetail();
                programDetail.setProgramCode(rs.getString("ProgramCode"));
                programDetail.setProgramNo(rs.getInt("ProgramNo"));
                programDetail.setLocaton(rs.getString("Location"));
                programDetail.setMunicipal(rs.getInt("Municipal"));
                programDetail.setProgress(rs.getString("Progress"));
                programDetail.setStartDate(rs.getString("StartDate"));
                programDetail.setEndDate(rs.getString("EndDate"));
                programDetail.setUpdatedBy(rs.getInt("UpdatedBy"));
                programDetail.setUpdatedTime(rs.getString("UpdateTime"));
                programDetail.setSeedProvided(rs.getInt("SeedProvided"));
                programDetail.setSeedBags(rs.getInt("SeedBags"));
                programDetail.setFertilizerProvided(rs.getInt("FertilizerProvided"));
                programDetail.setFertilizerBags(rs.getInt("FertilizerBags"));
                programDetail.setCause(rs.getString("Cause"));
                programDetails.add(programDetail);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programDetails;
    }
    
    public ArrayList<ProgramDetail> getProgramDetailsWithProgramCode(String progamCode) {
        ArrayList<ProgramDetail> programDetails = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ProgramDetail WHERE ProgramCode = ?");
            ps.setString(1, progamCode);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProgramDetail programDetail = new ProgramDetail();
                programDetail.setProgramCode(rs.getString("ProgramCode"));
                programDetail.setProgramNo(rs.getInt("ProgramNo"));
                programDetail.setLocaton(rs.getString("Location"));
                programDetail.setMunicipal(rs.getInt("Municipal"));
                programDetail.setProgress(rs.getString("Progress"));
                programDetail.setStartDate(rs.getString("StartDate"));
                programDetail.setEndDate(rs.getString("EndDate"));
                programDetail.setUpdatedBy(rs.getInt("UpdatedBy"));
                programDetail.setUpdatedTime(rs.getString("UpdateTime"));
                programDetail.setSeedProvided(rs.getInt("SeedProvided"));
                programDetail.setSeedBags(rs.getInt("SeedBags"));
                programDetail.setFertilizerProvided(rs.getInt("FertilizerProvided"));
                programDetail.setFertilizerBags(rs.getInt("FertilizerBags"));
                programDetail.setCause(rs.getString("Cause"));
                programDetails.add(programDetail);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programDetails;
    }
}
