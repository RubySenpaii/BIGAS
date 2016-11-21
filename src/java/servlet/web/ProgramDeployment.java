/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.BarangayDAO;
import dao.EmployeeDAO;
import dao.FarmDAO;
import dao.FertilizerDAO;
import dao.PlantingProblemDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import dao.ProgramDeployedDAO;
import dao.ProgramEmployeesDAO;
import dao.ProgramObjectivesDAO;
import dao.ProgramPlanDAO;
import dao.ProgramProcedureDAO;
import dao.SeedVarietyDAO;
import extra.GenericObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import objects.Fertilizer;
import objects.PlantingProblem;
import objects.PlantingReport;
import objects.Plot;
import objects.ProgramDeployed;
import objects.ProgramEmployees;
import objects.ProgramObjectives;
import objects.ProgramPlan;
import objects.ProgramProcedure;
import objects.SeedVariety;

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
            } else if (action.equals("submitProgramDetail")) {
                System.out.println("Submit program deployment details");
                submitPAOProgramDetails(request, response);
            } else {
                session.setAttribute("action", "invalid");
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
                ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(b).getPlotID());
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
        
        ArrayList<SeedVariety> seedVarieties = new SeedVarietyDAO().getListOfSeedVarieties();
        ArrayList<Fertilizer> fertilizers = new FertilizerDAO().getListOfFertilizers();
        ArrayList<Employee> employees = new EmployeeDAO().getListOfEmployeeOfMunicipal(municipality);
        
        System.out.println("adding data gathered to session");
        session.setAttribute("programProcedures", programProcedures);
        session.setAttribute("programObjectives", programObjectives);
        session.setAttribute("barangayBeneficiaries", barangayBeneficiaries);
        session.setAttribute("programPlan", programPlan);
        session.setAttribute("seedVarieties", seedVarieties);
        session.setAttribute("fertilizers", fertilizers);
        session.setAttribute("employees", employees);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/programdeployment.jsp");
        rd.forward(request, response);
    }
    
    private void submitPAOProgramDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        String path = "";
        
        String seedVariety = request.getParameter("seedVariety");
        double seedProvided = Double.parseDouble(request.getParameter("seedAmount"));
        int fertilizerID = new FertilizerDAO().getFertilizerDetails(request.getParameter("fertilizer")).getFertilizerID();
        double fertilizerProvided = Double.parseDouble(request.getParameter("fertilizerAmount"));
        ProgramPlan programPlan = (ProgramPlan) session.getAttribute("programPlan");
        
        ProgramDeployedDAO pddao = new ProgramDeployedDAO();
        ProgramDeployed programDeployed = new ProgramDeployed();
        programDeployed.setProgramDeployedID(pddao.getListOfProgramsDeployed().size() + 1);
        programDeployed.setProgramID(programPlan.getProgramID());
        programDeployed.setSeedVarietyID(new SeedVarietyDAO().getSeedVarietyDetailsWithName(seedVariety).getSeedVarietyID());
        programDeployed.setSeedProvided(seedProvided);
        programDeployed.setFertilizerID(fertilizerID);
        programDeployed.setFertilizerProvided(fertilizerProvided);
        programDeployed.setDateStarted(sdf.format(Calendar.getInstance().getTime()));
        programDeployed.setDateEnded("12/31/9999");
        programDeployed.setStatus("Created");
        boolean created = pddao.addProgramDeployed(programDeployed);
        
        int employeeID = new EmployeeDAO().getEmployeeWithName(request.getParameter("projectLead")).getEmployeeID();
        ProgramEmployees progEmp = new ProgramEmployees();
        progEmp.setEmployeeID(employeeID);
        progEmp.setPosition("Project Lead");
        progEmp.setProgramDeployedID(pddao.getListOfProgramsDeployed().size() + 1);
        boolean pecreated = new ProgramEmployeesDAO().addProgramEmployee(progEmp);
        
        if (created && pecreated) {
            path = "/Dashboard?action=goToDashboard";
        } else {
            path = "/ProblemLog?action=viewProblemLogs";
        }
        RequestDispatcher rd = context.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
