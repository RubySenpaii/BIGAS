/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd;

import dao.EmployeeDAO;
import objects.Employee;

/**
 *
 * @author RubySenpaii
 */
public class test {

    public static void main(String[] args) {
        EmployeeDAO edao = new EmployeeDAO();
        Employee emp = edao.getEmployeeWithName("Karino, Akihiro");
        System.out.println(emp.getAddress());
    }
}
