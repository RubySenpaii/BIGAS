/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.BarangayDAO;
import dao.FarmDAO;
import dao.PlantingProblemDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import dao.ProgramObjectivesDAO;
import dao.ProgramPlanDAO;
import dao.ProgramProcedureDAO;
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
import objects.Barangay;
import objects.Employee;
import objects.Farm;
import objects.PlantingProblem;
import objects.PlantingReport;
import objects.Plot;
import objects.ProgramObjectives;
import objects.ProgramPlan;
import objects.ProgramProcedure;

/**
 *
 * @author RubySenpaii
 */
public class ProgramDeployment extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("deployProgram")) {
                System.out.println("Retrieving programs for deployment");
                deployProgramForPAO(request, response);
            }
        }
    }

    private void deployProgramForPAO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        String programName = request.getParameter("programName");
        ProgramPlan programPlan = new ProgramPlanDAO().getProgramPlanInfo(programName);

        ArrayList<ProgramProcedure> programProcedures = new ProgramProcedureDAO().getListOfProgramProceduresForProgram(programPlan.getProgramID());
        ArrayList<ProgramObjectives> programObjectives = new ProgramObjectivesDAO().getListOfProgramObjectivesFromProgramID(programPlan.getProgramID());

        int problemDatabaseID = Integer.parseInt((String) session.getAttribute("problemDatabaseID"));

        ArrayList<GenericObject> barangayBeneficiaries = new ArrayList<>();
        String municipality = (String) session.getAttribute("municipalityName");
        ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipality);
        System.out.println("number of farms in municipality " + farms.size());
        for (int a = 0; a < farms.size(); a++) {
            ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(a).getFarmID());
            for (int b = 0; b < plots.size(); b++) {
                ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getYearListOfPlantingReportsFor(plots.get(b).getPlotID());
                for (int c = 0; c < plantingReports.size(); c++) {
                    ArrayList<PlantingProblem> plantingProblems = new PlantingProblemDAO().getListOfPlantingProblemsFromPlantingReport(plantingReports.get(c).getPlantingReportID());
                    for (int d = 0; d < plantingProblems.size(); d++) {
                        System.out.println(problemDatabaseID + " databaseid vs " + plantingProblems.get(d).getProblemID() + " problemid");
                        if (plantingProblems.get(d).getProblemID() == problemDatabaseID) {
                            Barangay barangay = new BarangayDAO().getBarangayInfoWithBrgyID(farms.get(a).getBarangayID());
                            if (barangayBeneficiaries.isEmpty()) {
                                GenericObject barangayBeneficiary = new GenericObject();
                                barangayBeneficiary.setAttribute1(barangay.getBarangayName());
                                barangayBeneficiary.setAttribute2(String.valueOf(plantingProblems.get(d).getAreaAffected()));
                                barangayBeneficiary.setAttribute3(String.valueOf(1));
                                barangayBeneficiaries.add(barangayBeneficiary);
                                System.out.println("Barangay beneficiary added: " + barangayBeneficiary.getAttribute1() + " " + barangayBeneficiary.getAttribute2() + " " + barangayBeneficiary.getAttribute3());
                            } else {
                                for (int e = 0; e < barangayBeneficiaries.size(); e++) {
                                    if (barangayBeneficiaries.get(e).getAttribute1().equals(barangay.getBarangayName())) {
                                        double areaAffected = Double.parseDouble(barangayBeneficiaries.get(e).getAttribute2());
                                        barangayBeneficiaries.get(e).setAttribute2(String.valueOf(areaAffected + plantingProblems.get(d).getAreaAffected()));
                                        int noOfFarmers = Integer.parseInt(barangayBeneficiaries.get(e).getAttribute3());
                                        barangayBeneficiaries.get(e).setAttribute3(String.valueOf(noOfFarmers + 1));
                                        System.out.println("barangay beneficiary updated");
                                    } else if (e == barangayBeneficiaries.size() - 1) {
                                        GenericObject barangayBeneficiary = new GenericObject();
                                        barangayBeneficiary.setAttribute1(barangay.getBarangayName());
                                        barangayBeneficiary.setAttribute2(String.valueOf(plantingProblems.get(d).getAreaAffected()));
                                        barangayBeneficiary.setAttribute3(String.valueOf(1));
                                        barangayBeneficiaries.add(barangayBeneficiary);
                                        System.out.println("New barangay beneficiary added: " + barangayBeneficiary.getAttribute1() + " " + barangayBeneficiary.getAttribute2() + " " + barangayBeneficiary.getAttribute3());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("adding data gathered to session");
        session.setAttribute("programProcedures", programProcedures);
        session.setAttribute("programObjectives", programObjectives);
        session.setAttribute("barangayBeneficiaries", barangayBeneficiaries);
        session.setAttribute("programPlan", programPlan);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/programdeployment.jsp");
        rd.forward(request, response);
    }
}
