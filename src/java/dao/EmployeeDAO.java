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
import objects.Employee;
import objects.FarmerIntervention;

/**
 *
 * @author RubySenpaii
 */
public class EmployeeDAO {
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt("EmployeeID"));
                employee.setMunicipalityID(rs.getInt("MunicipalityID"));
                employee.setLastName(rs.getString("LastName"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setMiddleName(rs.getString("MiddleName"));
                employee.setAddress(rs.getString("Address"));
                employee.setBirthday(rs.getString("Birthday"));
                employee.setAuthority(rs.getString("Authority"));
                employee.setGender(rs.getString("Gender"));
                employee.setContactNo(rs.getString("ContactNo"));
                employee.setUsername(rs.getString("Username"));
                employee.setPassword(rs.getString("Password"));
                employees.add(employee);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    public Employee getEmployeeWithID(int employeeID) {
        Employee employee = new Employee();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE employeeID = ?");
            ps.setInt(1, employeeID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employee.setEmployeeID(rs.getInt("EmployeeID"));
                employee.setMunicipalityID(rs.getInt("MunicipalityID"));
                employee.setLastName(rs.getString("LastName"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setMiddleName(rs.getString("MiddleName"));
                employee.setAddress(rs.getString("Address"));
                employee.setBirthday(rs.getString("Birthday"));
                employee.setAuthority(rs.getString("Authority"));
                employee.setGender(rs.getString("Gender"));
                employee.setContactNo(rs.getString("ContactNo"));
                employee.setUsername(rs.getString("Username"));
                employee.setPassword(rs.getString("Password"));
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
}
