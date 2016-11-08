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
import dao.ProblemDatabaseDAO;
import dao.ProgramDeployedDAO;
import dao.ProgramPlanDAO;
import dao.ProgramProblemDAO;
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
import objects.Farm;
import objects.Municipality;
import objects.PlantingProblem;
import objects.PlantingReport;
import objects.Plot;
import objects.ProblemDatabase;
import objects.ProgramDeployed;
import objects.ProgramProblem;
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
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewProblemLogs")) {
                System.out.println("Retrieving summarize problem logs for PAO");
                viewProblemLogsPAO(request, response);
            }
        }
    }

    private void viewProblemLogsPAO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        /**
         * problemName, problemDetails, municipalities, totalAreaAffected,
         * programDeployedID interventionDeployed
         */
        ArrayList<GenericObject> summarizedProblemLogs = new ArrayList<>();

        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getYearListOfPlantingReportsFor(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        ArrayList<PlantingProblem> plantingProblems = new PlantingProblemDAO().getListOfPlantingProblemsFromPlantingReport(plantingReports.get(d).getPlantingReportID());
                        for (int e = 0; e < plantingProblems.size(); e++) {
                            ProblemDatabase problemInfo = new ProblemDatabaseDAO().getProblemWithProblemID(plantingProblems.get(e).getProblemID());
                            int programDeployedID = 0;
                            try {
                                programDeployedID = new ProgramProblemDAO().getProgramForProblemReport(plantingProblems.get(e).getProblemReportID()).getProgramDeployedID();
                            } catch (IndexOutOfBoundsException x) {
                                System.out.println("No program deployed for planting problem id#" + plantingProblems.get(e).getPlantingReportID());
                            }

                            int index = -1;
                            for (int f = 0; f < summarizedProblemLogs.size(); f++) {
                                //improve to 3 conditions problem name, municipality and intervention deployed
                                if (summarizedProblemLogs.get(f).getAttribute1().equals(problemInfo.getProblemName())
                                        && summarizedProblemLogs.get(f).getAttribute3().equals(municipalities.get(a).getMunicipalityName())
                                        && summarizedProblemLogs.get(f).getAttribute6().equals(String.valueOf(programDeployedID))) {
                                    index = f;
                                }
                            }

                            if (index != -1) {
                                double areaAffected = Double.parseDouble(summarizedProblemLogs.get(index).getAttribute4());
                                summarizedProblemLogs.get(index).setAttribute4(String.valueOf(areaAffected + plantingProblems.get(e).getAreaAffected()));
                            } else {

                                GenericObject problem = new GenericObject();
                                problem.setAttribute1(problemInfo.getProblemName());
                                problem.setAttribute2(problemInfo.getDescription());
                                problem.setAttribute3(municipalities.get(a).getMunicipalityName());
                                problem.setAttribute4(String.valueOf(plantingProblems.get(e).getAreaAffected()));
                                if (programDeployedID != 0) {
                                    ProgramDeployed programDeployed = new ProgramDeployedDAO().getProgramDeployedDetails(programDeployedID);
                                    String programName = new ProgramPlanDAO().getProgramPlanInfo(programDeployed.getProgramID()).getProgramName();
                                    problem.setAttribute5(programName);
                                    problem.setAttribute6(String.valueOf(programDeployedID));
                                } else {
                                    problem.setAttribute5("No programs deployeed.");
                                    problem.setAttribute6(String.valueOf(-1));
                                }
                                problem.setAttribute7(String.valueOf(problemInfo.getProblemID()));
                                System.out.println(problem.getAttribute1() + " " + problem.getAttribute2() + " " + problem.getAttribute3() + " " + problem.getAttribute4() + " added.");
                                summarizedProblemLogs.add(problem);
                            }
                        }
                    }
                }
            }
        }

        session.setAttribute("problemLogs", summarizedProblemLogs);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/problemlist.jsp");
        rd.forward(request, response);
    }
}
