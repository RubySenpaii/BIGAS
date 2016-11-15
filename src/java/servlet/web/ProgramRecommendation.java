/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.PlantingProblemDAO;
import dao.ProgramPlanDAO;
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
import objects.ProgramPlan;

/**
 *
 * @author RubySenpaii
 */
public class ProgramRecommendation extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("recommendProgram")) {
                System.out.println("Retrieving programs for recommendation");
                getRecommendedPrograms(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }

    private void getRecommendedPrograms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        ArrayList<ProgramPlan> recommendedPrograms = new ArrayList<>();

        String problemIdentified = request.getParameter("problemIdentified");
        String municipalityName = request.getParameter("municipality");
        String problemID = request.getParameter("problemId");
        String[] problem = problemIdentified.split(" ");
        System.out.println(problemIdentified + " problem identified");
        ArrayList<ProgramPlan> programPlans = new ProgramPlanDAO().getListOfProgramPlans();
        for (int a = 0; a < programPlans.size(); a++) {
            for (int b = 0; b < problem.length; b++) {
                if (programPlans.get(a).getPurpose().contains(problem[b])) {
                    System.out.println(programPlans.get(a).getProgramName() + " has been added");
                    recommendedPrograms.add(programPlans.get(a));
                }
            }
        }

        session.setAttribute("recommendedPrograms", recommendedPrograms);
        session.setAttribute("municipalityName", municipalityName);
        session.setAttribute("problemDatabaseID", problemID);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/programrecommendation.jsp");
        rd.forward(request, response);
    }
}
