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
import objects.FertilizerNutrients;

/**
 *
 * @author RubySenpaii
 */
public class FertilizerNutrientsDAO {

    public boolean addFertilizerNutrient(FertilizerNutrients fertilizerNutrients) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + FertilizerNutrients.TABLE_NAME + " "
                    + "(" + FertilizerNutrients.COLUMN_FERTILIZER_ID + ", " + FertilizerNutrients.COLUMN_MINERAL + ", " + FertilizerNutrients.COLUMN_PERCENTAGE + ") "
                    + "VALUES(?, ?, ?)");
            ps.setInt(1, fertilizerNutrients.getFertilizerID());
            ps.setString(2, fertilizerNutrients.getMineral());
            ps.setDouble(3, fertilizerNutrients.getPercentage());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FertilizerNutrientsDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<FertilizerNutrients> getListOfFertilizerNutrients() {
        ArrayList<FertilizerNutrients> fertilizerNutrients = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + FertilizerNutrients.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            fertilizerNutrients = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(FertilizerNutrientsDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return fertilizerNutrients;
    }

    private ArrayList<FertilizerNutrients> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<FertilizerNutrients> fertilizerNutrients = new ArrayList<>();
        while (rs.next()) {
            FertilizerNutrients fertilizerNutrient = new FertilizerNutrients();
            fertilizerNutrient.setFertilizerID(rs.getInt(FertilizerNutrients.COLUMN_FERTILIZER_ID));
            fertilizerNutrient.setMineral(rs.getString(FertilizerNutrients.COLUMN_MINERAL));
            fertilizerNutrient.setPercentage(rs.getDouble(FertilizerNutrients.COLUMN_PERCENTAGE));
            fertilizerNutrients.add(fertilizerNutrient);
        }
        return fertilizerNutrients;
    }
}
