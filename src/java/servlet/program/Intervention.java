/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.program;

import dao.DatabaseDAO;
import dao.database.MunicipalityDAO;
import dao.people.EmployeeDAO;
import dao.people.FarmerInterventionDAO;
import dao.program.InterventionDAO;
import dao.program.InterventionDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.GenericObject;
import objects.people.Employee;
import objects.program.InterventionDetail;
import servlet.BaseServlet;
import servlet.database.FarmerList;

/**
 *
 * @author RubySenpaii
 */
public class Intervention extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();
            
            //going to cropprotection.jsp
            getInterventionList(request, response, session, context);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(FarmerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getInterventionList(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        InterventionDAO idao = new InterventionDAO();
        InterventionDetailDAO iddao = new InterventionDetailDAO();
        MunicipalityDAO mdao = new MunicipalityDAO();
        FarmerInterventionDAO fidao = new FarmerInterventionDAO();
        EmployeeDAO edao = new EmployeeDAO();
        
        ArrayList<GenericObject> interventions = new ArrayList<>();
        
        ArrayList<InterventionDetail> interventionDetails = iddao.getPrograms();
        for (int a = 0; a < interventionDetails.size(); a++) {
            objects.program.Intervention intervention = idao.getInterventionWithID(interventionDetails.get(a).getInterventionID());
            String name = intervention.getInterventionName();
            String purpose = intervention.getPurpose();
            String municipalityName=  mdao.getMunicipalityWithID(interventionDetails.get(a).getMunicipality()).getMunicipalityName();
            int farmers = fidao.getInterventionsWithInterventionID(interventionDetails.get(a)).size();
            Employee employee = edao.getEmployeeWithID(interventionDetails.get(a).getHeadedBy());
            String employeeName = employee.getLastName() + ", " + employee.getFirstName() + " " + employee.getMiddleName();
            
            GenericObject interven = new GenericObject();
            interven.setAttribute1(name);
            interven.setAttribute2(purpose);
            interven.setAttribute3(municipalityName);
            interven.setAttribute4(farmers + " farmers");
            interven.setAttribute5(employeeName);
            interven.setAttribute6(interventionDetails.get(a).getStartDate());
            interven.setAttribute7(interventionDetails.get(a).getEndDate());
            interven.setAttribute8(interventionDetails.get(a).getRemarks());
            interventions.add(interven);
        }

        session.setAttribute("interventions", interventions);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-programs/interventionlist.jsp");
        rd.forward(request, response);
    }
}
