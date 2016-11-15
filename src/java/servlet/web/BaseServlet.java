/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
public abstract class BaseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();

            if (request.getParameter("action") != null) {
                String action = request.getParameter("action");
                session.setAttribute("action", action);
                System.out.println("Action Attempted: " + action);

                Employee userLogged = (Employee) session.getAttribute("userLogged");

                if (action.equals("attemptLogin") || userLogged.getFlag() == 1) {
                    servletAction(request, response);

                    if (((String) session.getAttribute("action")).equals("invalid") && session != null) {
                        System.out.println("Invalid Action: " + action);
                        System.out.println("Returning to provincial status page");
                        RequestDispatcher rd = context.getRequestDispatcher("/ProvincialStatus?action=getProvincialStatus");
                        rd.forward(request, response);
                    }
                } else {
                    try {
                        System.out.println("Error: Unauthorized Access! You will now be automatically logged out.");
                        session.invalidate();
                        RequestDispatcher rd = context.getRequestDispatcher("/web/login.jsp");
                        rd.forward(request, response);
                    } catch(IllegalStateException x) {
                        System.out.println("No session detected!");
                        RequestDispatcher rd = context.getRequestDispatcher("/web/login.jsp");
                        rd.forward(request, response);
                    }
                }
            } else {
                System.out.println("Error: No Action Sent! You will now be automatically logged out.");
                session.invalidate();
                RequestDispatcher rd = context.getRequestDispatcher("/web/login.jsp");
                rd.forward(request, response);
            }
        }
    }

    /**
     * Abstract method will be used in child class for logic. Extension of
     * processRequest method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected abstract void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
