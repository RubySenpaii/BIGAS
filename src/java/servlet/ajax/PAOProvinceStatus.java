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
        JSONArray jarrayDistrict = new JSONArray();

        JSONObject jsonObjects = new JSONObject();

        /**
         * attr1 = district attr2 = municipalities attr3 = productionYield
         */
        ArrayList<GenericObject> objects = new ArrayList<GenericObject>();

        System.out.println("Data gathered for district production share:");
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject object = new GenericObject();
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            object.setAttribute1("District " + municipalities.get(a).getDisctrict());
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
            objects.add(object);
        }

        for (int a = 0; a < objects.size(); a++) {
            try {
                JSONObject districtShare = new JSONObject();
                districtShare.put("district", objects.get(a).getAttribute1());
                districtShare.put("municipality", objects.get(a).getAttribute2());
                districtShare.put("productionYield", Double.parseDouble(objects.get(a).getAttribute3()));
                jarrayDistrict.put(districtShare);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        }

        try {
            System.out.println("transferring data to json");
            jsonObjects.put("districtShare", jarrayDistrict);
        } catch (JSONException ex) {
            Logger.getLogger(PAOProvinceStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("[" + jsonObjects.toString() + "]");
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
