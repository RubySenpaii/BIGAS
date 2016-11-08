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
import objects.ProgramProblem;

/**
 *
 * @author RubySenpaii
 */
public class ProgramProblemDAO {
    
    public boolean reportProgramProblem(ProgramProblem programProblem) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramProblem.TABLE_NAME + " "
                    + "(" + ProgramProblem.COLUMN_PROBLEM_REPORT_ID + ", " + ProgramProblem.COLUMN_PROGRAM_DEPLOYED_ID + ") "
                    + "VALUES(?, ?)");
            ps.setInt(1, programProblem.getProblemReportID());
            ps.setInt(2, programProblem.getProgramDeployedID());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramProblemDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramProblem> getListOfProgramProgblems() {
        ArrayList<ProgramProblem> programProblems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramProblem.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programProblems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramProblemDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programProblems;
    }
    
    public ProgramProblem getProgramForProblemReport(int problemReportID) {
        ArrayList<ProgramProblem> programProblems = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramProblem.TABLE_NAME + " WHERE " + ProgramProblem.COLUMN_PROBLEM_REPORT_ID + " = ?");
            ps.setInt(1, problemReportID);

            ResultSet rs = ps.executeQuery();
            programProblems = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramProblemDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programProblems.get(0);
    }

    private ArrayList<ProgramProblem> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramProblem> programProblems = new ArrayList<>();
        while (rs.next()) {
            ProgramProblem programProblem = new ProgramProblem();
            programProblem.setProblemReportID(rs.getInt(ProgramProblem.COLUMN_PROBLEM_REPORT_ID));
            programProblem.setProgramDeployedID(rs.getInt(ProgramProblem.COLUMN_PROGRAM_DEPLOYED_ID));
            programProblems.add(programProblem);
        }
        return programProblems;
    }
}
