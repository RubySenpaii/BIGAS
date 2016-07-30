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
import objects.GenericObject;
import objects.people.Farmer;

/**
 *
 * @author RubySenpaii
 */
public class DatabaseDAO {
    /*public ArrayList<Farmer> getListOfFarmer() {
        ArrayList<Farmer> farmers = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Farmer");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farmer farmer = new Farmer();
                farmer.setFarmerID(rs.getInt(Farmer.COLUMN_FARMERID));
                farmer.setFarmID(rs.getInt(Farmer.COLUMN_FARMID));
                farmer.setLastName(rs.getString(Farmer.COLUMN_LASTNAME));
                farmer.setFirstName(rs.getString(Farmer.COLUMN_FIRSTNAME));
                farmer.setMiddleName(rs.getString(Farmer.COLUMN_MIDDLENAME));
                farmer.setAddress(rs.getString(Farmer.COLUMN_ADDRESS));
                farmer.setContactNo(rs.getString(Farmer.COLUMN_CONTACTNO));
                farmer.setBirthday(rs.getString(Farmer.COLUMN_BIRTHDAY));
                farmers.add(farmer);
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return farmers;
    }*/
    
    /**
     * retrieve a custom farmers list for farmerlist.jsp
     * @return GenericObject (FarmerID, FarmerName, FarmName, FarmArea, Barangay, Municipal)
     */
    public ArrayList<GenericObject> getFarmersForJSP() {
        ArrayList<GenericObject> objects = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT FR.FarmerID, FR.LastName, FR.FirstName, FR.MiddleName, "
                    + "F.FarmName, F.FarmArea, B.BarangayName, M.MunicipalityName "
                    + "FROM Farmer FR JOIN Farm F ON FR.FarmID = F.FarmID "
                    + "JOIN Barangay B ON F.BarangayID = B.BarangayID "
                    + "JOIN Municipality M ON B.MunicipalityID = M.MunicipalityID;");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                GenericObject object = new GenericObject();
                object.setAttribute1(rs.getInt("FarmerID") + "");
                object.setAttribute2(rs.getString("LastName") + ", " + rs.getString("FirstName") + " " + rs.getString("MiddleName") + ".");
                object.setAttribute3(rs.getString("FarmName"));
                object.setAttribute4(rs.getInt("FarmArea") + " sqm");
                object.setAttribute5(rs.getString("BarangayName"));
                object.setAttribute6(rs.getString("MunicipalityName"));
                objects.add(object);
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return objects;
    }
}
