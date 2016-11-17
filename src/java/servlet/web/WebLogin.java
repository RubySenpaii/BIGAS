/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.EmployeeDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Employee;

/**
 *
 * @author RubySenpaii
 */
public class WebLogin extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String path = "";
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            EmployeeDAO empdao = new EmployeeDAO();
            System.out.println("Retrieving employee information of " + username);
            Employee employee = empdao.getEmployeeWithUsernameAndPassword(username, password);

            HttpSession session = request.getSession();
            session.setAttribute("userLogged", employee);

            if (employee.getAuthority().equals("PAO")) {
                System.out.println("Directing to PAO homepage - View Problem List");
                path = "/Dashboard?action=goToDashboard";
            } else if (employee.getAuthority().equals("MAO")) {
                path = "/web/mao/";
            }

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("No empployee found!\nIndex Out of Bounds Exception");
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/web/login.jsp");
            rd.forward(request, response);
        }
    }
}
