/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.ProgramDeployedDAO;
import dao.ProgramPlanDAO;
import dao.WeeklyReportsDAO;
import extra.Formatter;
import extra.GenericObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.ProgramDeployed;
import objects.ProgramPlan;

/**
 *
 * @author RubySenpaii
 */
public class Dashboard extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        objects.Employee userLogged = (objects.Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("goToDashboard")) {
                goToDashboard(request, response);
            }
        } else if (userLogged.getAuthority().equals("MAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("goToDashboard")) {
                goToMAODashboard(request, response);
            }
        }
    }

    private void goToDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        ArrayList<GenericObject> suggestedProgramsProduction = new ArrayList<>();
        ArrayList<GenericObject> suggestedProgramsPlanting = new ArrayList<>();
        ArrayList<GenericObject> activeProgramsProduction = new ArrayList<>();
        ArrayList<GenericObject> activeProgramsPlanting = new ArrayList<>();

        ArrayList<ProgramPlan> programPlans = new ProgramPlanDAO().getListOfProgramPlans();
        for (int a = 0; a < programPlans.size(); a++) {
            if (programPlans.get(a).getPurpose().contains("Production")) {
                GenericObject suggestedProgramProduction = new GenericObject();
                suggestedProgramProduction.setAttribute1(programPlans.get(a).getProgramName());
                suggestedProgramProduction.setAttribute2(programPlans.get(a).getDescription());
                suggestedProgramProduction.setAttribute3(programPlans.get(a).getProgramID() + "");
                suggestedProgramsProduction.add(suggestedProgramProduction);
            }

            if (programPlans.get(a).getPurpose().contains("Planting") || programPlans.get(a).getPurpose().contains("Growth")) {
                GenericObject suggestedProgramPlanting = new GenericObject();
                suggestedProgramPlanting.setAttribute1(programPlans.get(a).getProgramName());
                suggestedProgramPlanting.setAttribute2(programPlans.get(a).getDescription());
                suggestedProgramPlanting.setAttribute3(programPlans.get(a).getProgramID() + "");
                suggestedProgramsPlanting.add(suggestedProgramPlanting);
            }
        }

        ArrayList<ProgramDeployed> programsDeployed = new ProgramDeployedDAO().getListOfActiveProgramsDeployed();
        for (int a = 0; a < programsDeployed.size(); a++) {
            ProgramPlan plan = new ProgramPlanDAO().getProgramPlanInfo(programsDeployed.get(a).getProgramID());
            if (plan.getPurpose().contains("Production")) {
                GenericObject activeProgramProduction = new GenericObject();
                activeProgramProduction.setAttribute1(plan.getProgramName());
                activeProgramProduction.setAttribute2(plan.getDescription());
                activeProgramProduction.setAttribute3(programsDeployed.get(a).getStatus());
                activeProgramProduction.setAttribute4(programsDeployed.get(a).getDateStarted());
                activeProgramProduction.setAttribute5(programsDeployed.get(a).getProgramDeployedID() + "");
                activeProgramsProduction.add(activeProgramProduction);
            }
            if (plan.getPurpose().contains("Planting") || plan.getPurpose().contains("Growth")) {
                GenericObject activeProgramPlanting = new GenericObject();
                activeProgramPlanting.setAttribute1(plan.getProgramName());
                activeProgramPlanting.setAttribute2(plan.getDescription());
                activeProgramPlanting.setAttribute3(programsDeployed.get(a).getStatus());
                activeProgramPlanting.setAttribute4(programsDeployed.get(a).getDateStarted());
                activeProgramPlanting.setAttribute5(programsDeployed.get(a).getProgramDeployedID() + "");
                activeProgramsPlanting.add(activeProgramPlanting);
            }
        }

        session.setAttribute("suggestedProgramsProduction", suggestedProgramsProduction);
        session.setAttribute("suggestedProgramsPlanting", suggestedProgramsPlanting);
        session.setAttribute("activeProgramsPlanting", activeProgramsPlanting);
        session.setAttribute("activeProgramsProduction", activeProgramsProduction);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/paodashboard.jsp");
        rd.forward(request, response);
    }

    private void goToMAODashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String stage = "";
        String season = "";

        if (month >= 10 && month <= 4) {
            season = "Wet Season";
        } else {
            season = "Dry Season";
        }

        WeeklyReportsDAO wrdao = new WeeklyReportsDAO();
        double farmPercentage = 0;
        if (month == 4 || month == 10) {
            stage = "Newly Planted";
            farmPercentage = (double) wrdao.getNewlyPlanted().size() / wrdao.getListOfWeeklyReports().size() * 100;
        } else if (month == 5 || month == 11) {
            stage = "Vegetative";
            farmPercentage = (double) wrdao.getVegetative().size() / wrdao.getListOfWeeklyReports().size() * 100;
        } else if (month == 6 || month == 12) {
            stage = "Reproductive";
            farmPercentage = (double) wrdao.getReproductive().size() / wrdao.getListOfWeeklyReports().size() * 100;
        } else {
            stage = "Maturity";
            farmPercentage = (double) wrdao.getHarvested().size() / wrdao.getListOfWeeklyReports().size() * 100;
        }

        farmPercentage = Formatter.round(farmPercentage, 2);
        System.out.println(stage + farmPercentage);

        session.setAttribute("currStage", stage);
        session.setAttribute("farmPercentage", farmPercentage);
        session.setAttribute("season", season);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/mao/homepage.jsp");
        rd.forward(request, response);
    }
}
