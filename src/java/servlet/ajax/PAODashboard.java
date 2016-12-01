/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.ajax;

import dao.FarmDAO;
import dao.MunicipalityDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import dao.TargetProductionDAO;
import extra.Formatter;
import extra.GenericObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Farm;
import objects.Municipality;
import objects.PlantingReport;
import objects.Plot;
import objects.TargetProduction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RubySenpaii
 */
public class PAODashboard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Attempting to connect to PAOProvinceStatus servlet");

        //get additional info for populating charts
        HttpSession session = request.getSession();
        String season = (String) session.getAttribute("season");

        JSONObject jsonObjects = new JSONObject();
        try {
            jsonObjects.put("production", getProductionArea());
            jsonObjects.put("planting", getPlantingArea());
            jsonObjects.put("productionTarget", getProductionTarget());
            jsonObjects.put("plantingTarget", getPlantingTarget());

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            System.out.println("data written for transfer");
            response.getWriter().write("[" + jsonObjects.toString() + "]");
        } catch (JSONException ex) {
            Logger.getLogger(PAODashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JSONArray getPlantingArea() {
        JSONArray jarrayProduction = new JSONArray();

        ArrayList<GenericObject> plantings = new ArrayList<>();

        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject planting = new GenericObject();

            planting.setAttribute1(municipalities.get(a).getMunicipalityName());

            double plantingTotal = 0;
            int count = 0;
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        double plantingReport = plantingReports.get(d).getSeedPlanted() / plots.get(c).getPlotSize();
                        plantingTotal += plantingReport;
                        count++;
                    }
                }
            }
            plantingTotal = Formatter.round(plantingTotal, 2);
//            if (plantingTotal > 0) {
//                plantingTotal /= count;
//            }

            planting.setAttribute2(String.valueOf(plantingTotal));
            plantings.add(planting);
            System.out.println(planting.getAttribute1() + " " + planting.getAttribute2() + " paodashboard planting added to list");
        }

        for (int a = 0; a < plantings.size(); a++) {
            try {
                JSONObject prodTotal = new JSONObject();
                prodTotal.put("municipal", plantings.get(a).getAttribute1());
                prodTotal.put("value", Double.parseDouble(plantings.get(a).getAttribute2()));
                jarrayProduction.put(prodTotal);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        }

        return jarrayProduction;
    }

    private JSONArray getProductionArea() {
        JSONArray jarrayProduction = new JSONArray();

        ArrayList<GenericObject> productions = new ArrayList<>();

        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject production = new GenericObject();

            production.setAttribute1(municipalities.get(a).getMunicipalityName());

            double productionTotal = 0;
            int count = 0;
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        double productionReport = plantingReports.get(d).getAmountHarvested() / plots.get(c).getPlotSize();
                        productionTotal += productionReport;
                        count++;
                    }
                }
            }
            productionTotal = Formatter.round(productionTotal, 2);
//            if (productionTotal > 0) {
//                productionTotal /= count;
//            }
            production.setAttribute2(String.valueOf(productionTotal));
            productions.add(production);
            System.out.println(production.getAttribute1() + " " + production.getAttribute2() + " paodashboard production added to list");
        }

        for (int a = 0; a < productions.size(); a++) {
            try {
                JSONObject prodTotal = new JSONObject();
                prodTotal.put("municipal", productions.get(a).getAttribute1());
                prodTotal.put("value", Double.parseDouble(productions.get(a).getAttribute2()));
                jarrayProduction.put(prodTotal);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        }
        return jarrayProduction;
    }
    
    private JSONArray getProductionTarget() {
        JSONArray jarrayProductionTarget = new JSONArray();

        ArrayList<GenericObject> productionTargets = new ArrayList<>();
        
        double totalHectares = 0;
        TargetProduction targetProduction  = new TargetProductionDAO().getListOfTargetProductionForYear(Calendar.getInstance().get(Calendar.YEAR));
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            totalHectares += municipalities.get(a).getArea();
        }
        
        double totalProdYield = targetProduction.getTarget() / totalHectares;
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject productionTarget = new GenericObject();
            productionTarget.setAttribute1(municipalities.get(a).getMunicipalityName());
            
            double percentage = municipalities.get(a).getArea() / totalHectares;
            System.out.println("percentage for muni " + percentage);
            double targetProductionForHarvest = totalProdYield * percentage;
            System.out.println("target prod harvest " + targetProductionForHarvest);
//            double averageProductionHarvest = targetProductionForHarvest / municipalities.get(a).getArea();
//            System.out.println("avg prod harvest " + averageProductionHarvest);
            targetProductionForHarvest = Formatter.round(targetProductionForHarvest, 2);
            productionTarget.setAttribute2(String.valueOf(targetProductionForHarvest));
            productionTargets.add(productionTarget);
            System.out.println(productionTarget.getAttribute1() + " " + productionTarget.getAttribute2() + " added to the list  ");
        }
        
        for (int a = 0; a < productionTargets.size(); a++) {
            try {
                JSONObject prodTarget = new JSONObject();
                prodTarget.put("municipal", productionTargets.get(a).getAttribute1());
                prodTarget.put("value", Double.parseDouble(productionTargets.get(a).getAttribute2()));
                jarrayProductionTarget.put(prodTarget);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        }
        
        return jarrayProductionTarget;
    }
    
    private JSONArray getPlantingTarget() {
        JSONArray jarrayPlantingTarget = new JSONArray();

        ArrayList<GenericObject> plantingTargets = new ArrayList<>();
        
        double totalHectares = 0;
        TargetProduction targetProduction  = new TargetProductionDAO().getListOfTargetProductionForYear(Calendar.getInstance().get(Calendar.YEAR));
        double totalPlantingTarget = targetProduction.getTarget() / 12.5;
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            totalHectares += municipalities.get(a).getArea();
        }
        
        double totalPlantingAvg = totalPlantingTarget / totalHectares;
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject plantingTarget = new GenericObject();
            plantingTarget.setAttribute1(municipalities.get(a).getMunicipalityName());
            
            double percentage = municipalities.get(a).getArea() / totalHectares;
            System.out.println("percentage for muni " + percentage);
            double targetPlantingAverage = totalPlantingAvg * percentage;
            System.out.println("target prod harvest " + targetPlantingAverage);
//            double averageProductionHarvest = targetProductionForHarvest / municipalities.get(a).getArea();
//            System.out.println("avg prod harvest " + averageProductionHarvest);
            targetPlantingAverage = Formatter.round(targetPlantingAverage, 2);
            plantingTarget.setAttribute2(String.valueOf(targetPlantingAverage));
            plantingTargets.add(plantingTarget);
            System.out.println(plantingTarget.getAttribute1() + " " + plantingTarget.getAttribute2() + " added to the list  ");
        }
        
        for (int a = 0; a < plantingTargets.size(); a++) {
            try {
                JSONObject plantTarget = new JSONObject();
                plantTarget.put("municipal", plantingTargets.get(a).getAttribute1());
                plantTarget.put("value", Double.parseDouble(plantingTargets.get(a).getAttribute2()));
                jarrayPlantingTarget.put(plantTarget);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        }
        
        return jarrayPlantingTarget;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
