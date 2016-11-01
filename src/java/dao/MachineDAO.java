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
import objects.Machine;

/**
 *
 * @author RubySenpaii
 */
public class MachineDAO {

    public boolean addMachine(Machine machine) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Machine.TABLE_NAME + " "
                    + "(" + Machine.COLUMN_COST + ", " + Machine.COLUMN_EQUIPMENT + ", " + Machine.COLUMN_MACHINE_ID + ", " + Machine.COLUMN_PROVIDED_BY + ", "
                    + Machine.COLUMN_RECIPIENT + Machine.COLUMN_UPDATED_BY + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            ps.setDouble(1, machine.getCost());
            ps.setString(2, machine.getEquipment());
            ps.setInt(3, machine.getMachineID());
            ps.setString(4, machine.getProvidedBy());
            ps.setInt(5, machine.getRecipient());
            ps.setInt(6, machine.getUpdatedBy());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(MachineDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<Machine> getListOfMachines() {
        ArrayList<Machine> machines = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Machine.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            machines = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(MachineDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return machines;
    }

    private ArrayList<Machine> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Machine> machines = new ArrayList<>();
        while (rs.next()) {
            Machine machine = new Machine();
            machine.setCost(rs.getDouble(Machine.COLUMN_COST));
            machine.setEquipment(rs.getString(Machine.COLUMN_EQUIPMENT));
            machine.setMachineID(rs.getInt(Machine.COLUMN_MACHINE_ID));
            machine.setProvidedBy(rs.getString(Machine.COLUMN_PROVIDED_BY));
            machine.setRecipient(rs.getInt(Machine.COLUMN_RECIPIENT));
            machine.setUpdatedBy(rs.getInt(Machine.COLUMN_UPDATED_BY));
            machines.add(machine);
        }
        return machines;
    }
}
