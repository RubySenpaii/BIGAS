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
import objects.Program;

/**
 *
 * @author RubySenpaii
 */
public class ProgramDAO {

    public ArrayList<Program> getPrograms() {
        ArrayList<Program> programs = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Program");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Program program = new Program();
                program.setProgramCode(rs.getString("ProgramCode"));
                program.setProgramName(rs.getString("ProgramName"));
                program.setDescription(rs.getString("Description"));
                programs.add(program);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programs;
    }
    
    public String getProgramDescription(String programCode) {
        String description = "";
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Program WHERE ProgramCode = ?");
            ps.setString(1, programCode);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                description = rs.getString("Description");
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return description;
    }
}
