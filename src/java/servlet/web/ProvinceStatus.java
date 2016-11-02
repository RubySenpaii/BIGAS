/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Employee;

/**
 *
 * @author RubySenpaii
 */
public class ProvinceStatus extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("uesrLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewProvincialLevelFarmStatus")) {
                System.out.println("Retrieving details of provincial status");
                reviewProvincialStatusForPAO(request, response);
            }
        }
    }
    
    //go to farmstatus.jsp for pao
    private void reviewProvincialStatusForPAO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
