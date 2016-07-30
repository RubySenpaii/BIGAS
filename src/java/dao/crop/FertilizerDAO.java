/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.crop;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.crop.Fertilizer;

/**
 *
 * @author RubySenpaii
 */
public class FertilizerDAO {
    public ArrayList<Fertilizer> getFertlizers() {
        ArrayList<Fertilizer> fertilizers = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Fertilizer");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FertilizerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fertilizers;
    }
}
