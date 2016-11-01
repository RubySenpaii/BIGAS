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
import objects.SurveyFeedback;

/**
 *
 * @author RubySenpaii
 */
public class SurveyFeedbackDAO {
    
    public boolean recordSurveyFeedback(SurveyFeedback surveyFeedback) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + SurveyFeedback.TABLE_NAME + " "
                    + "(" + SurveyFeedback.COLUMN_COMMENT + ", " + SurveyFeedback.COLUMN_PROGRAM_ID + ", " 
                    + SurveyFeedback.COLUMN_QUESTION_NO + ", " + SurveyFeedback.COLUMN_VALUE + ") "
                    + "VALUES(?, ?, ?, ?)");
            ps.setString(1, surveyFeedback.getComment());
            ps.setInt(2, surveyFeedback.getProgramID());
            ps.setInt(3, surveyFeedback.getQuestionNo());
            ps.setInt(4, surveyFeedback.getValue());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SurveyFeedbackDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<SurveyFeedback> getListOfSurveyFeedbacks() {
        ArrayList<SurveyFeedback> surveyFeedbacks = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + SurveyFeedback.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            surveyFeedbacks = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(SurveyFeedbackDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return surveyFeedbacks;
    }

    private ArrayList<SurveyFeedback> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<SurveyFeedback> surveyFeedbacks = new ArrayList<>();
        while (rs.next()) {
            SurveyFeedback surveyFeedback = new SurveyFeedback();
            surveyFeedback.setComment(rs.getString(SurveyFeedback.COLUMN_COMMENT));
            surveyFeedback.setProgramID(rs.getInt(SurveyFeedback.COLUMN_PROGRAM_ID));
            surveyFeedback.setQuestionNo(rs.getInt(SurveyFeedback.COLUMN_QUESTION_NO));
            surveyFeedback.setValue(rs.getInt(SurveyFeedback.COLUMN_VALUE));
            surveyFeedbacks.add(surveyFeedback);
        }
        return surveyFeedbacks;
    }
}
