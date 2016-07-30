/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.program;

import dao.database.MunicipalityDAO;
import dao.people.FarmerDAO;
import dao.people.FarmerProgramDAO;
import dao.program.ProgramDAO;
import dao.program.ProgramDetailDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.GenericObject;
import objects.database.Municipality;
import objects.people.Farmer;
import objects.program.ProgramDetail;
import servlet.BaseServlet;
import servlet.database.FarmerList;

/**
 *
 * @author RubySenpaii
 */
public class ProgramDetails extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();

            String programCode = request.getParameter("programCode");

            if (programCode.equals("FFS")) {
                getFFSDetails(request, response, session, context);
            } else if (programCode.equals("TD")) {
                getTDDetails(request, response, session, context);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(FarmerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getFFSDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        ProgramDAO pdao = new ProgramDAO();
        ProgramDetailDAO pddao = new ProgramDetailDAO();
        MunicipalityDAO mdao = new MunicipalityDAO();
        FarmerProgramDAO fpdao = new FarmerProgramDAO();

        String description = pdao.getProgramDescription("FFS");
        ArrayList<GenericObject> programs = new ArrayList<>();

        ArrayList<ProgramDetail> programDetails = pddao.getProgramDetailsWithProgramCode("FFS");
        for (int a = 0; a < programDetails.size(); a++) {
            GenericObject program = new GenericObject();
            String programID = programDetails.get(a).getProgramCode() + "-" + programDetails.get(a).getProgramNo();
            Municipality municipality = mdao.getMunicipalityWithID(programDetails.get(a).getMunicipal());
            int numberFarmers = fpdao.getFarmersFromProgram(programDetails.get(a).getProgramCode(), programDetails.get(a).getProgramNo()).size();
            String projectHead = "";

            program.setAttribute1(programID);
            program.setAttribute2(municipality.getMunicipalityName());
            program.setAttribute3(programDetails.get(a).getProgress());
            program.setAttribute4(numberFarmers + " farmers");
            program.setAttribute5(projectHead);
            program.setAttribute6(programDetails.get(a).getStartDate());
            program.setAttribute7(programDetails.get(a).getEndDate());
            programs.add(program);
        }

        session.setAttribute("description", description);
        session.setAttribute("programs", programs);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-programs/farmerfieldschool.jsp");
        rd.forward(request, response);
    }
    
    protected void getTDDetails (HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        ProgramDAO pdao = new ProgramDAO();
        ProgramDetailDAO pddao = new ProgramDetailDAO();
        FarmerProgramDAO fpdao = new FarmerProgramDAO();
        FarmerDAO frdao = new FarmerDAO();
        
        String description = pdao.getProgramDescription("TD");
        ArrayList<GenericObject> programs = new ArrayList<>();
        
        ArrayList<ProgramDetail> programDetails = pddao.getProgramDetailsWithProgramCode("TD");
        for (int a = 0; a < programDetails.size(); a++) {
            String programID = programDetails.get(a).getProgramCode() + "-" + programDetails.get(a).getProgramNo();
            int numberFarmers = fpdao.getFarmersFromProgram(programDetails.get(a).getProgramCode(), programDetails.get(a).getProgramNo()).size();
            Farmer farmer = frdao.getFarmerWithID(programDetails.get(a).getUpdatedBy());
            String farmerName = farmer.getLastName() + ", " + farmer.getFirstName() + " " + farmer.getMiddleName();
            
            
            GenericObject program = new GenericObject();
            program.setAttribute1(programID);
            program.setAttribute2(programDetails.get(a).getLocaton());
            program.setAttribute3(numberFarmers + " farmers");
            program.setAttribute4(programDetails.get(a).getProgress());
            program.setAttribute5(farmerName);
            program.setAttribute6(programDetails.get(a).getUpdatedTime());
            programs.add(program);
        }
        
        session.setAttribute("description", description);
        session.setAttribute("programs", programs);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-programs/technologydemonstration.jsp");
        rd.forward(request, response);
    }
}
