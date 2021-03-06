/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.ajax;

import dao.FarmDAO;
import dao.MunicipalityDAO;
import dao.PlantingProblemDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import dao.TargetProductionDAO;
import extra.Formatter;
import extra.GenericObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
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
import objects.PlantingProblem;
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

        JSONObject jsonObjects = new JSONObject();
        try {
            jsonObjects.put("districtShare", getDistrictProductionShareData());
            jsonObjects.put("targetMonitoring", getActualVsTargetData());
            jsonObjects.put("target", new TargetProductionDAO().getListOfTargetProductionForYear(Calendar.getInstance().get(Calendar.YEAR)).getTarget());

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
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plot.getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        double amountHarvest = plantingReports.get(d).getAmountHarvested();
                        double plotProductionYield = amountHarvest;
                        if (amountHarvest != 0) {
                            productionYield += plotProductionYield;
                        }
                    }
                }
            }
            productionYield = Formatter.round(productionYield, 2);
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
    private JSONArray getActualVsTargetData() {
        JSONArray jarrayProduction = new JSONArray();

        System.out.println("Data gathering for actual vs target:");
        /**
         * attr1 = month attr2 = value
         */
        ArrayList<GenericObject> actualVsTarget = new ArrayList<>();
        for (int a = 0; a < 12; a++) {
            GenericObject object = new GenericObject();
            object.setAttribute1(new DateFormatSymbols().getMonths()[a] + " " + Calendar.getInstance().get(Calendar.YEAR));
            object.setAttribute2("0");
            actualVsTarget.add(object);
        }
        ArrayList<Farm> farms = new FarmDAO().getListOfFarms();
        for (int a = 0; a < farms.size(); a++) {
            ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(a).getFarmID());
            for (int b = 0; b < plots.size(); b++) {
                ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(b).getPlotID());
                for (int c = 0; c < plantingReports.size(); c++) {
                    int month = Integer.parseInt(plantingReports.get(c).getDateHarvested().substring(0, 2));
                    
                    if (month == 1) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 2) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 3) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 4) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 5) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 6) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 7) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 8) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 9) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 10) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 11) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    } else if (month == 12) {
                        double actualValue = Double.parseDouble(actualVsTarget.get(month - 1).getAttribute2());
                        actualValue += plantingReports.get(c).getAmountHarvested();
                        actualValue = Formatter.round(actualValue, 2);
                        actualVsTarget.get(month - 1).setAttribute2(String.valueOf(actualValue));
                    }
                }
            }
        }

        for (int a = 0; a < actualVsTarget.size(); a++) {
            if (a > 0) {
                double value = Double.parseDouble(actualVsTarget.get(a - 1).getAttribute2());
                value += Double.parseDouble(actualVsTarget.get(a).getAttribute2());
                actualVsTarget.get(a).setAttribute2(String.valueOf(value));
            }
        }

        for (int a = 0; a < actualVsTarget.size(); a++) {
            try {
                JSONObject object = new JSONObject();
                object.put("month", actualVsTarget.get(a).getAttribute1());
                object.put("value", Double.parseDouble(actualVsTarget.get(a).getAttribute2()));
                System.out.println(actualVsTarget.get(a).getAttribute1() + " - " + actualVsTarget.get(a).getAttribute2() + " added for actual vs target");
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
        for (int a = 0; a < municipalities.size(); a++) {
            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {

                    }
                }
            }
        }

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
