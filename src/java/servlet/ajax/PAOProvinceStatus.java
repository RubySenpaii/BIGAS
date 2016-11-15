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
import java.text.DateFormatSymbols;
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
public class PAOProvinceStatus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Attempting to connect to PAOProvinceStatus servlet");

        //get additional info for populating charts
        HttpSession session = request.getSession();
        String season = (String) session.getAttribute("season");

        JSONObject jsonObjects = new JSONObject();
        try {
            jsonObjects.put("districtShare", getDistrictProductionShareData());
            //jsonObjects.put("targetMonitoring", getActualVsTargetData(season));

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            System.out.println("data written for transfer");
            response.getWriter().write("[" + jsonObjects.toString() + "]");
        } catch (JSONException ex) {
            Logger.getLogger(PAOProvinceStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //this method will retrieve data for the drilldown of district production share
    private JSONArray getDistrictProductionShareData() {
        JSONArray jarrayDistrict = new JSONArray();

        /**
         * attr1 = district attr2 = municipalities attr3 = productionYield
         */
        ArrayList<GenericObject> districtProductionShare = new ArrayList<GenericObject>();

        System.out.println("Data gathering for district production share:");
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject object = new GenericObject();
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            object.setAttribute1("District " + municipalities.get(a).getDistrict());
            object.setAttribute2(municipalities.get(a).getMunicipalityName());
            double productionYield = 0;
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    Plot plot = plots.get(c);
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getYearListOfPlantingReportsFor(plot.getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        double amountHarvest = plantingReports.get(d).getAmountHarvested();
                        double area = plot.getPlotSize();
                        double plotProductionYield = amountHarvest / area;
                        if (amountHarvest != 0) {
                            productionYield += plotProductionYield;
                        }
                    }
                }
            }
            object.setAttribute3(Double.toString(productionYield));
            System.out.println(object.getAttribute1() + " " + object.getAttribute2() + " " + object.getAttribute3());
            districtProductionShare.add(object);
        }

        for (int a = 0; a < districtProductionShare.size(); a++) {
            try {
                JSONObject districtShare = new JSONObject();
                districtShare.put("district", districtProductionShare.get(a).getAttribute1());
                districtShare.put("municipality", districtProductionShare.get(a).getAttribute2());
                districtShare.put("productionYield", Double.parseDouble(districtProductionShare.get(a).getAttribute3()));
                jarrayDistrict.put(districtShare);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        }
        return jarrayDistrict;
    }

    //this method will retrieve data for the line graph in monitoring the actual vs target
    private JSONArray getActualVsTargetData(String season) {
        JSONArray jarrayProduction = new JSONArray();

        System.out.println("Data gathering for actual vs target:");
        /**
         * attr1 = month attr2 = value
         */
        ArrayList<GenericObject> actualVsTarget = new ArrayList<>();
        for (int a = 0; a < 6; a++) {
            GenericObject object = new GenericObject();
            if (season.equals("Wet")) {
                object.setAttribute1(new DateFormatSymbols().getMonths()[a]);
                object.setAttribute2("0");
            } else {
                object.setAttribute1(new DateFormatSymbols().getMonths()[a + 6]);
                object.setAttribute2("0");
            }
        }
        ArrayList<Farm> farms = new FarmDAO().getListOfFarms();
        for (int a = 0; a < farms.size(); a++) {
            ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(a).getFarmID());
            for (int b = 0; b < plots.size(); b++) {
                ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getYearListOfPlantingReportsFor(plots.get(b).getPlotID());
                for (int c = 0; c < plantingReports.size(); c++) {
                    int month = Integer.parseInt(plantingReports.get(c).getDateHarvested().substring(0, 2));
                    int difference = 1;
                    if (month < 7) {
                        difference = 7;
                    }
                    if (month == 1 || month == 6) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - difference).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualVsTarget.get(month - difference).setAttribute2(String.valueOf(actualValue));
                    }
                }
            }
        }

        for (int a = 0; a < actualVsTarget.size(); a++) {
            try {
                JSONObject object = new JSONObject();
                object.put("month", actualVsTarget.get(a).getAttribute1());
                object.put("value", Double.parseDouble(actualVsTarget.get(a).getAttribute2()));
                jarrayProduction.put(object);
            } catch (JSONException ex) {
                Logger.getLogger(PAOProvinceStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jarrayProduction;
    }
    
    //this method will retrieve info for district planting share
    private JSONArray getDistrictStagesValue() {
        JSONArray jarrayDistrictStages = new JSONArray();
        
        System.out.println("retrieve data for district stages");
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        
        return jarrayDistrictStages;
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
