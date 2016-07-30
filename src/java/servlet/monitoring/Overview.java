/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.monitoring;

import dao.MonitoringDAO;
import dao.database.MunicipalityDAO;
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
import objects.database.Municipality;
import objects.farm.Farm;
import objects.farm.SeedPlanted;
import objects.farm.SeedStage;
import servlet.BaseServlet;

/**
 *
 * @author RubySenpaii
 */
public class Overview extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();

            //going to overview.jsp
            getMunicipalOverview(request, response, session, context);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getMunicipalOverview(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        /*MonitoringDAO mondao = new MonitoringDAO();
        ArrayList<GenericObject> municipals = mondao.getMunicipalOverview();

        session.setAttribute("municipals", municipals);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-monitoring/overview.jsp");
        rd.forward(request, response);*/

        MunicipalityDAO mundao = new MunicipalityDAO();
        SeedStageDAO ssdao = new SeedStageDAO();
        SeedPlantedDAO spdao = new SeedPlantedDAO();
        FarmDAO fdao = new FarmDAO();

        ArrayList<Municipality> municipalities = mundao.getMunicipalities();
        ArrayList<GenericObject> objects = new ArrayList<>();
        
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject object = new GenericObject();
            int municipalID = municipalities.get(a).getMunicipalityID();

            ArrayList<Farm> farms = fdao.getFarmsInMunicipality(municipalID);
            double areaPlanted = 0, areaHarvested = 0, harvested = 0;

            for (int b = 0; b < farms.size(); b++) {
                ArrayList<SeedPlanted> seedsPlanted = spdao.getSeedPlantedOfFarm(farms.get(b).getFarmID());
                for (int c = 0; c < seedsPlanted.size(); c++) {
                    areaPlanted += seedsPlanted.get(c).getArea();

                    int plantedID = seedsPlanted.get(c).getPlantedID();
                    SeedStage seedStage = ssdao.getSeedStagesOfPlanted(plantedID);

                    if (seedStage.getCropStageID() == 4) {
                        areaHarvested += seedsPlanted.get(c).getArea();
                        harvested += seedStage.getHarvested();
                    }
                }
            }

            double projected = Math.round(areaPlanted * 2.5 * 0.91 * 100) / 100.0;
            double targetProduction = Math.round(areaPlanted * 4.2 * 100) / 100.0;

            object.setAttribute1(municipalities.get(a).getMunicipalityName());
            object.setAttribute2(areaPlanted + " ha");
            object.setAttribute3(projected + " MT");
            object.setAttribute4(areaHarvested + " ha");
            object.setAttribute5(harvested + " MT");
            object.setAttribute6(projected + harvested + " MT");
            object.setAttribute7(targetProduction + " MT");
            objects.add(object);
        }
        session.setAttribute("municipals", objects);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-monitoring/overview.jsp");
        rd.forward(request, response);
    }
}
