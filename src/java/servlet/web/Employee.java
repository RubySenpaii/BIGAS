/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RubySenpaii
 */
public class Employee extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        objects.Employee userLogged = (objects.Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewEmployeeList")) {
                System.out.println("view employee list");
                viewEmployeeList(request, response);
            } else if (action.equals("viewEmployeeDetails")) {
                System.out.println("view employee details");
                viewEmployeeDetails(request, response);
            } else if (action.equals("editEmployeeDetails")) {
                System.out.println("edit employee details");
                editEmployeeDetails(request, response);
            } else if (action.equals("editEmployee")) {
                System.out.println("update employee details");
                editEmployee(request, response);
            } else if (action.equals("registerEmployee")) {
                System.out.println("register employee");
                registerEmployee(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }
    
    private void viewEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        ArrayList<objects.Employee> employees = new EmployeeDAO().getListOfEmployee();
        
        session.setAttribute("employees", employees);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/employeelist.jsp");
        rd.forward(request, response);
    }
    
    private void viewEmployeeDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        
        objects.Employee employeeDetail = new EmployeeDAO().getEmployeeDetailsWithID(employeeID);
        
        session.setAttribute("employeeDetail", employeeDetail);
        session.setAttribute("view", "view");
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/employeedetail.jsp");
        rd.forward(request, response);
    }
    
    private void editEmployeeDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        
        objects.Employee employeeDetail = new EmployeeDAO().getEmployeeDetailsWithID(employeeID);
        
        session.setAttribute("employeeDetail", employeeDetail);
        session.setAttribute("view", "edit");
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/employeedetail.jsp");
        rd.forward(request, response);
    }
    
    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String addresss = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        String office = request.getParameter("office");
        String gender = request.getParameter("gender");
        String contactNo = request.getParameter("contactNo");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        objects.Employee employee = new objects.Employee();
        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        employee.setMiddleName(middleName);
        employee.setAddress(addresss);
        employee.setBirthday(birthday);
        employee.setAuthority(office);
        employee.setGender(gender);
        employee.setContactNo(contactNo);
        employee.setUsername(username);
        employee.setPassword(password);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/employeedetail.jsp");
        rd.forward(request, response);
    }
    
    private void registerEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String addresss = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        String office = request.getParameter("office");
        String gender = request.getParameter("gender");
        String contactNo = request.getParameter("contactNo");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        objects.Employee employee = new objects.Employee();
        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        employee.setMiddleName(middleName);
        employee.setAddress(addresss);
        employee.setBirthday(birthday);
        employee.setAuthority(office);
        employee.setGender(gender);
        employee.setContactNo(contactNo);
        employee.setUsername(username);
        employee.setPassword(password);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/employeedetail.jsp");
        rd.forward(request, response);
    }
}
