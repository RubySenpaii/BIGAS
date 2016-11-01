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
import objects.ProgramSurvey;

/**
 *
 * @author RubySenpaii
 */
public class ProgramSurveyDAO {
    
    public boolean createProgramSurvey(ProgramSurvey programSurvey) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + ProgramSurvey.TABLE_NAME + " "
                    + "(" + ProgramSurvey.COLUMN_PROGRAM_ID + ", " + ProgramSurvey.COLUMN_QUESTION + ", " 
                    + ProgramSurvey.COLUMN_QUESTION_NO + ", " + ProgramSurvey.COLUMN_TYPE + ") "
                    + "VALUES(?, ?, ?, ?)");
            ps.setInt(1, programSurvey.getProgramID());
            ps.setString(2, programSurvey.getQuestion());
            ps.setInt(3, programSurvey.getQuestionNo());
            ps.setString(4, programSurvey.getType());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramSurveyDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<ProgramSurvey> getListOfAlert() {
        ArrayList<ProgramSurvey> programSurveys = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + ProgramSurvey.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            programSurveys = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(ProgramSurveyDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return programSurveys;
    }

    private ArrayList<ProgramSurvey> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<ProgramSurvey> programSurveys = new ArrayList<>();
        while (rs.next()) {
            ProgramSurvey programSurvey = new ProgramSurvey();
            programSurvey.setProgramID(rs.getInt(ProgramSurvey.COLUMN_PROGRAM_ID));
            programSurvey.setQuestion(rs.getString(ProgramSurvey.COLUMN_QUESTION));
            programSurvey.setQuestionNo(rs.getInt(ProgramSurvey.COLUMN_QUESTION_NO));
            programSurvey.setType(rs.getString(ProgramSurvey.COLUMN_TYPE));
            programSurveys.add(programSurvey);
        }
        return programSurveys;
    }
}
