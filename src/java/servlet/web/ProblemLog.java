/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.PlantingProblemDAO;
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
import objects.Employee;
import objects.PlantingProblem;
import servlet.web.BaseServlet;

/**
 *
 * @author RubySenpaii
 */
public class ProblemLog extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("uesrLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewProblemLogs")) {
                System.out.println("Retrieving problem logs for PAO");
                viewProblemLogsPAO(request, response);
            }
        }
    }

    private void viewProblemLogsPAO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        PlantingProblemDAO ppdao = new PlantingProblemDAO();
        ArrayList<PlantingProblem> plantingProblems = ppdao.getListOfPlantingProblems();

        session.setAttribute("plantingProblems", plantingProblems);

        RequestDispatcher rd = context.getRequestDispatcher("");
        rd.forward(request, response);
    }
}
