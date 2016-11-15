/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.PlantingProblemDAO;
import dao.ProblemDatabaseDAO;
import extra.GenericObject;
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
import objects.ProblemDatabase;

/**
 *
 * @author RubySenpaii
 */
public class Damage extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewProblemLogs")) {
                System.out.println("view damage monitoring");
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }
    
    private void viewDamageMonitoring(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        ArrayList<GenericObject> problems = new ArrayList<>();
        ArrayList<PlantingProblem> plantingProblems = new PlantingProblemDAO().getListOfPlantingProblems();
        for (int a = 0; a < plantingProblems.size(); a++) {
            ProblemDatabase problemDatabase = new ProblemDatabaseDAO().getProblemWithProblemID(plantingProblems.get(a).getProblemID());
            
            GenericObject problem = new GenericObject();
            problem.setAttribute1(problemDatabase.getProblemName());
            problem.setAttribute2(problemDatabase.getDescription());
            problem.setAttribute3("");
        }
        
        RequestDispatcher rd = context.getRequestDispatcher("");
        rd.forward(request, response);
    }
}
