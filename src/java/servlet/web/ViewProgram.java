/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.EmployeeDAO;
import dao.FarmerDAO;
import dao.FertilizerDAO;
import dao.ProgramDeployedDAO;
import dao.ProgramEmployeesDAO;
import dao.ProgramParticipantDAO;
import dao.ProgramPlanDAO;
import dao.ProgramProcedureDAO;
import dao.ProgramProgressDAO;
import dao.SeedVarietyDAO;
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
import objects.Fertilizer;
import objects.ProgramDeployed;
import objects.ProgramEmployees;
import objects.ProgramParticipant;
import objects.ProgramPlan;
import objects.ProgramProcedure;
import objects.ProgramProgress;
import objects.SeedVariety;

/**
 *
 * @author RubySenpaii
 */
public class ViewProgram extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("viewProgramList")) {
                System.out.println("go to program history");
                goToProgramHistory(request, response);
            } else if (action.equals("viewProgramDetails")) {
                System.out.println("view deployed details");
                goToProgramDetails(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }

    private void goToProgramHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        /**
         * name, type, description, date started, status
         */
        ArrayList<GenericObject> programs = new ArrayList<>();

        ArrayList<ProgramDeployed> programsDeployed = new ProgramDeployedDAO().getListOfProgramsDeployed();
        for (int a = 0; a < programsDeployed.size(); a++) {
            ProgramPlan programPlan = new ProgramPlanDAO().getProgramPlanInfo(programsDeployed.get(a).getProgramID());

            GenericObject program = new GenericObject();
            program.setAttribute1(programPlan.getProgramName());
            program.setAttribute2(programPlan.getType());
            program.setAttribute3(programPlan.getDescription());
            program.setAttribute4(programsDeployed.get(a).getDateStarted());
            program.setAttribute5(programsDeployed.get(a).getStatus());
            program.setAttribute6(String.valueOf(programsDeployed.get(a).getProgramDeployedID()));
            programs.add(program);
        }

        session.setAttribute("programs", programs);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/programhistory.jsp");
        rd.forward(request, response);
    }

    private void goToProgramDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        int pdID = Integer.parseInt(request.getParameter("deployedID"));
        ProgramDeployed deployed = new ProgramDeployedDAO().getProgramDeployedDetails(pdID);
        ProgramPlan programPlan = new ProgramPlanDAO().getProgramPlanInfo(deployed.getProgramID());

        ArrayList<GenericObject> programMembers = new ArrayList<>();
        ArrayList<ProgramEmployees> programEmployees = new ProgramEmployeesDAO().getListOfProgramEmployeesForProgram(deployed.getProgramDeployedID());
        for (int a = 0; a < programEmployees.size(); a++) {
            GenericObject member = new GenericObject();
            Employee employee = new EmployeeDAO().getEmployeeDetailsWithID(programEmployees.get(a).getEmployeeID());
            member.setAttribute1(employee.getLastName() + ", " + employee.getFirstName());
            member.setAttribute2(programEmployees.get(a).getPosition());
            programMembers.add(member);
        }

        ArrayList<GenericObject> procedureProgress = new ArrayList<>();
        ArrayList<ProgramProgress> programProgress = new ProgramProgressDAO().getListOfProgramProgressesForProgramDeployed(pdID);
        ArrayList<ProgramProcedure> programProcedures = new ProgramProcedureDAO().getListOfProgramProceduresForProgram(programPlan.getProgramID());
        for (int a = 0; a < programProcedures.size(); a++) {
            GenericObject progress = new GenericObject();
            progress.setAttribute1(String.valueOf(programProcedures.get(a).getProcedureNo()));
            progress.setAttribute2(programProcedures.get(a).getPhase());
            progress.setAttribute3(programProcedures.get(a).getActivity());
            if (programProgress.isEmpty()) {
                progress.setAttribute4("N/A");
            }
            for (int b = 0; b < programProgress.size(); b++) {
                if (programProcedures.get(a).getProcedureNo() == programProgress.get(b).getProcedureNo()) {
                    progress.setAttribute4(programProgress.get(b).getDate());
                } else if (b == programProgress.size() - 1) {
                    progress.setAttribute4("N/A");
                }
            }
            procedureProgress.add(progress);
        }

        String seedVarietyProvided = "No seed provided";
        if (deployed.getSeedProvided() != 0) {
            SeedVariety seedVariety = new SeedVarietyDAO().getSeedVarietyDetails(deployed.getSeedVarietyID());
            seedVarietyProvided = seedVariety.getVarietyName() + " - " + deployed.getSeedProvided() + "kg";
        }
        String fertilizerProvided = "No fertilizer provided";
        if (deployed.getFertilizerProvided() != 0) {
            Fertilizer fertilizer = new FertilizerDAO().getFertilizerDetails(deployed.getFertilizerID());
            fertilizerProvided = fertilizer.getFertilizerName() + " - " + deployed.getFertilizerProvided() + "kg";
        }
        
        ArrayList<GenericObject> programParticipants = new ArrayList<>();
        ArrayList<ProgramParticipant> participants = new ProgramParticipantDAO().getListOfProgramParticipantProgramDeployed(pdID);
        for (int a = 0; a < participants.size(); a++) {
            objects.Farmer farmer = new FarmerDAO().getFarmerDetails(participants.get(a).getFarmerID());
            GenericObject participant = new GenericObject();
            participant.setAttribute1(farmer.getLastName() + ", " + farmer.getFirstName() + " " + farmer.getMiddleName());
            participant.setAttribute2(participants.get(a).getSeedsAcquired() + " kg");
            participant.setAttribute3(participants.get(a).getFertilizerAcquired() + " kg");
            programParticipants.add(participant);
        }

        session.setAttribute("programPlan", programPlan);
        session.setAttribute("programMembers", programMembers);
        session.setAttribute("procedureProgress", procedureProgress);
        session.setAttribute("seedVarietyProvided", seedVarietyProvided);
        session.setAttribute("fertilizerProvided", fertilizerProvided);
        session.setAttribute("programParticipants", programParticipants);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/programdetails.jsp");
        rd.forward(request, response);
    }
}
