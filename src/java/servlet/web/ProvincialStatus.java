/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.ProgramDeployedDAO;
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
import objects.ProgramDeployed;
import objects.ProgramPlan;

/**
 *
 * @author RubySenpaii
 */
public class ProvincialStatus extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        Employee userLogged = (Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("getProvincialStatus")) {
                System.out.println("Retrieveing info for provincial status");
                getProvincialStatus(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }
    
    private void getProvincialStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        
        /**
         * name, type, description, status, date started
         */
        ArrayList<GenericObject> activePrograms = new ArrayList<>();
        
        ArrayList<ProgramDeployed> programDeployment = new ProgramDeployedDAO().getListOfActiveProgramsDeployed();
        for (int a = 0; a < programDeployment.size(); a++) {
            GenericObject activeProgram = new GenericObject();
            ProgramPlan programplan = new ProgramPlanDAO().getProgramPlanInfo(programDeployment.get(a).getProgramID());
            activeProgram.setAttribute1(programplan.getProgramName());
            activeProgram.setAttribute2(programplan.getType());
            activeProgram.setAttribute3(programplan.getDescription());
            activeProgram.setAttribute4(programDeployment.get(a).getStatus());
            activeProgram.setAttribute5(programDeployment.get(a).getDateStarted());
            activePrograms.add(activeProgram);
        }
        
        session.setAttribute("activePrograms", activePrograms);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/provincestatus.jsp");
        rd.forward(request, response);
    }
}
