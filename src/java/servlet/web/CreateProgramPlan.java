/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.ProgramObjectivesDAO;
import dao.ProgramPlanDAO;
import dao.ProgramProcedureDAO;
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
import objects.ProgramObjectives;
import objects.ProgramPlan;
import objects.ProgramProcedure;

/**
 *
 * @author RubySenpaii
 */
public class CreateProgramPlan extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("goToStep1")) {
                goToStep1(request, response);
            } else if (action.equals("goToStep2")) {
                goToStep2(request, response);
            } else if (action.equals("goToStep3")) {
                goToStep3(request, response);
            } else if (action.equals("createProgram")) {
                createProgram(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }

    private void goToStep1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        ProgramPlanDAO ppdao = new ProgramPlanDAO();
        int programID = ppdao.getListOfProgramPlans().size() + 1;
        
        session.setAttribute("programID", programID);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/createprogram1.jsp");
        rd.forward(request, response);
    }

    private void goToStep2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        String programName = request.getParameter("programName");
        String programType = request.getParameter("programType");
        String purpose = request.getParameter("purpose");
        String description = request.getParameter("description");
        String keyPersonnel = request.getParameter("keyPersonnel");

        ProgramPlan programPlan = new ProgramPlan();
        programPlan.setProgramName(programName);
        programPlan.setType(programType);
        programPlan.setPurpose(purpose);
        programPlan.setDescription(description);
        programPlan.setProgramID((int) session.getAttribute("programID"));

        System.out.println(programName + " has been set in session");
        session.setAttribute("programPlan", programPlan);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/createprogram2.jsp");
        rd.forward(request, response);
    }

    private void goToStep3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        double damagedArea = Double.parseDouble(request.getParameter("damagedArea"));
        double numberOfCases = Double.parseDouble(request.getParameter("numberOfCases"));

        ArrayList<ProgramObjectives> objectives = new ArrayList<>();
        if (damagedArea > 0) {
            ProgramObjectives objective = new ProgramObjectives();
            objective.setIndicator("Damaged Area");
            objective.setTargetValue(damagedArea);
            objective.setProgramID((int) session.getAttribute("programID"));
            objectives.add(objective);
        }
        if (numberOfCases > 0) {
            ProgramObjectives objective = new ProgramObjectives();
            objective.setIndicator("Number of Cases");
            objective.setTargetValue(numberOfCases);
            objective.setProgramID((int) session.getAttribute("programID"));
            objectives.add(objective);
        }

        System.out.println(objectives.size() + " objectives added");
        session.setAttribute("programObjectives", objectives);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/createprogram3.jsp");
        rd.forward(request, response);
    }

    private void createProgram(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        String[] phases = request.getParameterValues("phases");
        String[] activities = request.getParameterValues("activities");
        
        ArrayList<ProgramProcedure> procedures = new ArrayList<>();
        for (int a = 0; a < activities.length; a++) {
            ProgramProcedure procedure = new ProgramProcedure();
            procedure.setProcedureNo(a + 1);
            procedure.setPhase(phases[a]);
            procedure.setActivity(activities[a]);
            procedure.setProgramID((int) session.getAttribute("programID"));
            procedures.add(procedure);
        }
        
        System.out.println(procedures.size() + " procedure added");
        session.setAttribute("procedures", procedures);

        programEnd(request, response);
    }
    
    private void programEnd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        ProgramPlan programPlan = (ProgramPlan) session.getAttribute("programPlan");
        ArrayList<ProgramObjectives> objectives = (ArrayList<ProgramObjectives>) session.getAttribute("programObjectives");
        ArrayList<ProgramProcedure> procedures = (ArrayList<ProgramProcedure>) session.getAttribute("procedures");
        
        ProgramPlanDAO ppdao = new ProgramPlanDAO();
        ProgramObjectivesDAO podao = new ProgramObjectivesDAO();
        ProgramProcedureDAO pprdao = new ProgramProcedureDAO();
        
        boolean programCreated = ppdao.createProgramPlan(programPlan);
        System.out.println("program created: " + programCreated);
        if (programCreated) {
            int objectivesAdded = 0;
            for (int a = 0; a < objectives.size(); a++) {
                if (podao.addProgramObjective(objectives.get(a))) {
                    objectivesAdded++;
                }
            }
            System.out.println(objectivesAdded + " of " + objectives.size() + " objectives added");
            
            int procedureAdded = 0;
            for (int a = 0; a < procedures.size(); a++) {
                if (pprdao.addProgramProcedure(procedures.get(a))) {
                    procedureAdded++;
                }
            }
            System.out.println(procedureAdded + " of " + procedures.size() + " procedures added");
        }
        
        RequestDispatcher rd = context.getRequestDispatcher("/ProblemLog?action=viewProblemLogs");
        rd.forward(request, response);
    }
}
