/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.FarmerDAO;
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
public class Farmer extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        objects.Employee userLogged = (objects.Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewFarmerList")) {
                System.out.println("view farmer list");
                viewFarmerList(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }
    
    private void viewFarmerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        ArrayList<objects.Farmer> farmerList = new FarmerDAO().getListOfFarmers();
        
        session.setAttribute("farmers", farmerList);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/farmerlist.jsp");
        rd.forward(request, response);
    }
    
    private void registerFarmer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        String contactNo = request.getParameter("contactNo");
        
        objects.Farmer farmer = new objects.Farmer();
        farmer.setAddress(address);
        farmer.setBirthday(birthday);
        farmer.setContactNo(contactNo);
    }
}
