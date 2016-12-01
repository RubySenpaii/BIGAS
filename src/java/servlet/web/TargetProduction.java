/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.FarmDAO;
import dao.MunicipalityDAO;
import dao.PlantingProblemDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import dao.TargetProductionDAO;
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
import objects.Farm;
import objects.Municipality;
import objects.PlantingProblem;
import objects.PlantingReport;
import objects.Plot;

/**
 *
 * @author RubySenpaii
 */
public class TargetProduction extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        objects.Employee userLogged = (objects.Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("goToTargetProduction")) {
                System.out.println("Retrieveing info for target prod");
                goToTargetProduction(request, response);
            } else if (action.equals("submitTargetProd")) {
                System.out.println("submit target prod amount");
                
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }

    protected void goToTargetProduction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        ArrayList<GenericObject> municipalitiesProduction = new ArrayList<>();
        
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject municipalityProduction = new GenericObject();
            municipalityProduction.setAttribute1(municipalities.get(a).getMunicipalityName());
            
            double planted = 0, harvested = 0, damaged = 0;
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        ArrayList<PlantingProblem> plantingProblems = new PlantingProblemDAO().getListOfPlantingProblemsFromPlantingReport(plantingReports.get(d).getPlantingReportID());
                        for (int e = 0; e < plantingProblems.size(); e++) {
                            damaged += plantingProblems.get(e).getAreaAffected();
                        }
                        
                        planted += plantingReports.get(d).getSeedPlanted();
                        harvested += plantingReports.get(d).getAmountHarvested();
                    }
                }
            }
            damaged = Formatter.round(damaged, 2);
            planted = Formatter.round(planted, 2);
            harvested = Formatter.round(harvested, 2);
            municipalityProduction.setAttribute2(String.valueOf(planted));
            municipalityProduction.setAttribute3(String.valueOf(harvested));
            municipalityProduction.setAttribute4(String.valueOf(damaged));
            municipalitiesProduction.add(municipalityProduction);
        }
        
        session.setAttribute("municipalitiesProduction", municipalitiesProduction);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/targetproduction.jsp");
        rd.forward(request, response);
    }
    
    protected void submitTargetProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        String path = "/TargetProduction?action=goToTargetProduction";
        
        double targetProduction  = Double.parseDouble(request.getParameter("targetProd"));
        objects.Employee userLogged = (objects.Employee) session.getAttribute("userLogged");
        
        objects.TargetProduction targetProductionObj = new objects.TargetProduction();
        targetProductionObj.setSetBy(userLogged.getEmployeeID());
        targetProductionObj.setTarget(targetProduction);
        targetProductionObj.setYear(Calendar.getInstance().get(Calendar.YEAR));
        
        boolean success = new TargetProductionDAO().createTargetProduction(targetProductionObj);
        if (success) {
            path = "/ProvincialStatus?action=getProvincialStatus";
        }
        RequestDispatcher rd = context.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
