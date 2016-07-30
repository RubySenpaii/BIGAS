/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.monitoring;

import dao.DatabaseDAO;
import dao.crop.SeedVarietyDAO;
import dao.farm.FarmDAO;
import dao.farm.SeedPlantedDAO;
import dao.farm.SeedStageDAO;
import dao.people.FarmerDAO;
import dao.reports.DamageIncidentDAO;
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
import objects.crop.SeedVariety;
import objects.farm.Farm;
import objects.farm.SeedPlanted;
import objects.farm.SeedStage;
import objects.people.Farmer;
import objects.reports.DamageIncident;
import servlet.BaseServlet;
import servlet.database.FarmerList;

/**
 *
 * @author RubySenpaii
 */
public class MunicipalDetails extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();

            //going to municipaldetails.jsp
            getFarmerList(request, response, session, context);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(FarmerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getFarmerList(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        String barangayName = request.getParameter("barangay");

        FarmDAO fdao = new FarmDAO();
        FarmerDAO frdao = new FarmerDAO();
        SeedPlantedDAO spdao = new SeedPlantedDAO();
        SeedVarietyDAO svdao = new SeedVarietyDAO();
        SeedStageDAO ssdao = new SeedStageDAO();
        DamageIncidentDAO didao = new DamageIncidentDAO();

        ArrayList<GenericObject> cropGrowthList = new ArrayList<>();
        ArrayList<GenericObject> productionList = new ArrayList<>();

        ArrayList<Farm> farms = fdao.getFarmsInBarangay(barangayName);
        for (int a = 0; a < farms.size(); a++) {
            GenericObject cropGrowth = new GenericObject();
            GenericObject production = new GenericObject();
            String farmName = farms.get(a).getFarmName();

            ArrayList<Farmer> farmers = frdao.getFarmersOnFarm(farms.get(a).getFarmID());
            String farmerName = "";
            for (int b = 0; b < farmers.size(); b++) {
                farmerName += farmers.get(b).getLastName() + ", " + farmers.get(b).getFirstName() + " " + farmers.get(b).getMiddleName();
                if (b + 1 != farmers.size()) {
                    farmerName += "\n";
                }
            }

            ArrayList<SeedPlanted> seedsPlanted = spdao.getSeedPlantedOfFarm(farmers.get(a).getFarmID());
            for (int b = 0; b < seedsPlanted.size(); b++) {
                int plantedID = seedsPlanted.get(b).getPlantedID(), varietyID = seedsPlanted.get(b).getSeedVarietyID();
                double areaPlanted = seedsPlanted.get(b).getArea();
                ArrayList<DamageIncident> damageIncidents = didao.getDamageIncidentsOfPlanted(plantedID);
                boolean add = true;
                for (int c = 0; c < cropGrowthList.size(); c++) {
                    if (cropGrowthList.get(c).getAttribute3().equals(svdao.getSeedVarietyOf(varietyID).getVarietyName())) {
                        //CROP GROWTH
                        SeedStage seedStage = ssdao.getSeedStagesOfPlanted(plantedID);
                        cropGrowth = getAreaPerStage(cropGrowth, seedStage, areaPlanted);
                        cropGrowthList.set(c, cropGrowth);
                        add = false;
                        
                        //PRODUCTION
                        double plantedArea = Double.parseDouble(productionList.get(c).getAttribute4().split(" ")[0]);
                        plantedArea += seedsPlanted.get(b).getArea();
                        productionList.get(c).setAttribute4(plantedArea + " ha");
                        
                        double harvested = 0;
                        if (seedStage.getCropStageID() == 4) {
                            harvested = Double.parseDouble(productionList.get(c).getAttribute5().split(" ")[0]);
                            harvested += seedStage.getHarvested();
                            productionList.get(c).setAttribute5(harvested + " MT");
                        }
                        
                        
                        double damages = Double.parseDouble(productionList.get(c).getAttribute6().split(" ")[0]);
                        damages += getTotalDamages(damageIncidents);
                        productionList.get(c).setAttribute6(damages + " ha");
                        
                        double yield = harvested / plantedArea;
                        productionList.get(c).setAttribute7(yield + "%");
                    }
                }
                if (add) {
                    //CROP GROWTH
                    cropGrowth.setAttribute1(farmName);
                    cropGrowth.setAttribute2(farmerName);
                    SeedVariety seedVariety = svdao.getSeedVarietyOf(varietyID);
                    cropGrowth.setAttribute3(seedVariety.getVarietyName());

                    SeedStage seedStage = ssdao.getSeedStagesOfPlanted(plantedID);
                    cropGrowth.setAttribute4("0 ha");
                    cropGrowth.setAttribute5("0 ha");
                    cropGrowth.setAttribute6("0 ha");
                    cropGrowth.setAttribute7("0 ha");
                    cropGrowth = getAreaPerStage(cropGrowth, seedStage, areaPlanted);
                    cropGrowthList.add(cropGrowth);
                    
                    //PRODUCTION
                    production.setAttribute1(farmName);
                    production.setAttribute2(farmerName);
                    production.setAttribute3(seedVariety.getVarietyName());
                    production.setAttribute4(seedsPlanted.get(b).getArea() + " ha");
                    
                    double harvested = 0;
                    if (seedStage.getCropStageID() == 4) {
                        harvested = seedStage.getHarvested();
                    }
                    production.setAttribute5(harvested + " MT");
                    production.setAttribute6(getTotalDamages(damageIncidents) + " ha");
                    
                    double yield = harvested / seedsPlanted.get(b).getArea();
                    production.setAttribute7(yield + "%");
                    productionList.add(production);
                }
            }
        }

        session.setAttribute("cropGrowth", cropGrowthList);
        session.setAttribute("production", productionList);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-monitoring/municipaldetails.jsp");
        rd.forward(request, response);
    }

    private GenericObject getAreaPerStage(GenericObject object, SeedStage seedStage, double areaPlanted) {
        if (seedStage.getCropStageID() == 1) {
            double area = Double.parseDouble(object.getAttribute4().split(" ")[0]);
            area += areaPlanted;
            object.setAttribute4(area + " ha");
        } else if (seedStage.getCropStageID() == 2) {
            double area = Double.parseDouble(object.getAttribute5().split(" ")[0]);
            area += areaPlanted;
            object.setAttribute5(area + " ha");
        } else if (seedStage.getCropStageID() == 3) {
            double area = Double.parseDouble(object.getAttribute6().split(" ")[0]);
            area += areaPlanted;
            object.setAttribute6(area + " ha");
        } else {
            double area = Double.parseDouble(object.getAttribute7().split(" ")[0]);
            area += areaPlanted;
            object.setAttribute7(area + " ha");
        }
        return object;
    }
    
    private double getTotalDamages (ArrayList<DamageIncident> incidents) {
        double damages = 0;
        for (int a = 0; a < incidents.size(); a++) {
            damages += incidents.get(a).getAreaAffected();
        }
        return damages;
    }
}
