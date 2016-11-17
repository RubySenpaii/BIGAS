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
import extra.GenericObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            System.out.println("data written for transfer");
            response.getWriter().write("[" + jsonObjects.toString() + "]");
        } catch (JSONException ex) {
            Logger.getLogger(PAOProvinceStatus.class.getName()).log(Level.SEVERE, null, ex);
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
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        double plantingReport = plantingReports.get(d).getSeedPlanted() / plots.get(c).getPlotSize();
                        plantingTotal += plantingReport;
                    }
                }
            }
            planting.setAttribute2(plantingTotal + "");
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
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        double productionReport = plantingReports.get(d).getAmountHarvested() / plots.get(c).getPlotSize();
                        productionTotal += productionReport;
                    }
                }
            }
            
            production.setAttribute2(productionTotal + "");
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
