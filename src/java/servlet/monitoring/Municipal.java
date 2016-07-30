/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.monitoring;

import dao.MonitoringDAO;
import dao.database.BarangayDAO;
import dao.farm.FarmDAO;
import dao.farm.SeedPlantedDAO;
import dao.farm.SeedStageDAO;
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
import objects.database.Barangay;
import objects.farm.Farm;
import objects.farm.SeedPlanted;
import objects.farm.SeedStage;
import servlet.BaseServlet;

/**
 *
 * @author RubySenpaii
 */
public class Municipal extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();
            
            //going to overview.jsp
            getBarangayOverview(request, response, session, context);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getBarangayOverview(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        /*String municipalName = request.getParameter("municipal");
        
        MonitoringDAO mondao = new MonitoringDAO();
        ArrayList<GenericObject> barangays = mondao.getBarangayOverview(municipalName, 1);
        
        session.setAttribute("barangays", barangays);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-monitoring/municipal.jsp");
        rd.forward(request, response);*/
        String municipalName = request.getParameter("municipal");
        
        BarangayDAO bdao = new BarangayDAO();
        FarmDAO fdao = new FarmDAO();
        SeedPlantedDAO spdao = new SeedPlantedDAO();
        SeedStageDAO ssdao = new SeedStageDAO();
        
        ArrayList<GenericObject> objects = new ArrayList<>();
        
        ArrayList<Barangay> barangays = bdao.getBarangaysFromMunicipality(municipalName);
        for (int a = 0; a < barangays.size(); a++) {
            GenericObject object = new GenericObject();
            ArrayList<Farm> farms = fdao.getFarmsInBarangay(barangays.get(a).getBarangayName());
            double areaPlanted = 0, harvested = 0;
            
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<SeedPlanted> seedsPlanted = spdao.getSeedPlantedOfFarm(farms.get(b).getFarmID());
                 for (int c = 0; c < seedsPlanted.size(); c++) {
                    areaPlanted += seedsPlanted.get(c).getArea();

                    int plantedID = seedsPlanted.get(c).getPlantedID();
                    SeedStage seedStage = ssdao.getSeedStagesOfPlanted(plantedID);

                    if (seedStage.getCropStageID() == 4) {
                        harvested += seedStage.getHarvested();
                    }
                }
            }
            double percentage = Math.round(harvested / areaPlanted * 10000) / 100.0;
            object.setAttribute1(barangays.get(a).getBarangayName());
            object.setAttribute2(areaPlanted + " ha");
            object.setAttribute3(harvested + " MT");
            object.setAttribute4(percentage + "%");
            objects.add(object);
        }
        
        session.setAttribute("barangays", objects);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-monitoring/municipal.jsp");
        rd.forward(request, response);
    }
}
