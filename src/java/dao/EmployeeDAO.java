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

/**
 *
 * @author RubySenpaii
 */
public class EmployeeDAO {

    public boolean registerEmployee(Employee employee) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Employee.TABLE_NAME + " "
                    + "(" + Employee.COLUMN_ADDRESS + ", " + Employee.COLUMN_AUTHORITY + ", " + Employee.COLUMN_BIRTHDAY + ", " + Employee.COLUMN_CONTACT_NO + ", "
                    + Employee.COLUMN_EMPLOYEE_ID + ", " + Employee.COLUMN_FIRST_NAME + ", " + Employee.COLUMN_FLAG + ", " + Employee.COLUMN_GENDER + ", "
                    + Employee.COLUMN_LAST_NAME + ", " + Employee.COLUMN_MIDDLE_NAME + ", " + Employee.COLUMN_MUNICIPALITY_ID + ", "
                    + Employee.COLUMN_PASSWORD + ", " + Employee.COLUMN_USERNAME + ") "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, employee.getAddress());
            ps.setString(2, employee.getAuthority());
            ps.setString(3, employee.getBirthday());
            ps.setString(4, employee.getContactNo());
            ps.setInt(5, employee.getEmployeeID());
            ps.setString(6, employee.getFirstName());
            ps.setInt(7, employee.getFlag());
            ps.setString(8, employee.getGender());
            ps.setString(9, employee.getLastName());
            ps.setString(10, employee.getMiddleName());
            ps.setInt(11, employee.getMunicipalityID());
            ps.setString(12, employee.getPassword());
            ps.setString(13, employee.getUsername());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, x);
            return false;
        }
        return true;
    }

    public ArrayList<Employee> getListOfEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Employee.TABLE_NAME);

            ResultSet rs = ps.executeQuery();
            employees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return employees;
    }

    public ArrayList<Employee> getListOfEmployeeOfMunicipal(String municipal) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee E JOIN Municipality M ON E.MunicipalityID = M.MunicipalityID WHERE M.MunicipalityName = ?");
            ps.setString(1, municipal);

            ResultSet rs = ps.executeQuery();
            employees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return employees;
    }

    public Employee getEmployeeWithUsernameAndPassword(String username, String password) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Employee.TABLE_NAME
                    + " WHERE " + Employee.COLUMN_USERNAME + " = ? AND " + Employee.COLUMN_PASSWORD + " = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            employees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return employees.get(0);
    }

    public Employee getEmployeeWithName(String name) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee e "
                    + "WHERE concat_ws(', ',e.lastname,e.firstname) like ?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            employees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return employees.get(0);
    }

    public Employee getEmployeeDetailsWithID(int employeeID) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Employee.TABLE_NAME
                    + " WHERE " + Employee.COLUMN_EMPLOYEE_ID + " = ?");
            ps.setInt(1, employeeID);

            ResultSet rs = ps.executeQuery();
            employees = getDataFromResultSet(rs);

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException x) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return employees.get(0);
    }

    private ArrayList<Employee> getDataFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setAddress(rs.getString(Employee.COLUMN_ADDRESS));
            employee.setAuthority(rs.getString(Employee.COLUMN_AUTHORITY));
            employee.setBirthday(rs.getString(Employee.COLUMN_BIRTHDAY));
            employee.setContactNo(rs.getString(Employee.COLUMN_CONTACT_NO));
            employee.setEmployeeID(rs.getInt(Employee.COLUMN_EMPLOYEE_ID));
            employee.setFirstName(rs.getString(Employee.COLUMN_FIRST_NAME));
            employee.setFlag(rs.getInt(Employee.COLUMN_FLAG));
            employee.setGender(rs.getString(Employee.COLUMN_GENDER));
            employee.setLastName(rs.getString(Employee.COLUMN_LAST_NAME));
            employee.setMiddleName(rs.getString(Employee.COLUMN_MIDDLE_NAME));
            employee.setMunicipalityID(rs.getInt(Employee.COLUMN_MUNICIPALITY_ID));
            employee.setPassword(rs.getString(Employee.COLUMN_PASSWORD));
            employee.setUsername(rs.getString(Employee.COLUMN_USERNAME));
            employees.add(employee);
        }
        return employees;
    }
}
