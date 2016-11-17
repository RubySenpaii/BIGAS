/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.mobile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.BarangayDAO;
import dao.EmployeeDAO;
import dao.FarmDAO;
import dao.FarmerDAO;
import dao.FertilizerDAO;
import dao.MunicipalityDAO;
import dao.PlantingProblemDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import dao.PlotFertilizerDAO;
import dao.ProblemDatabaseDAO;
import dao.SeedTypeDAO;
import dao.SeedVarietyDAO;
import dao.TechnicianFarmDAO;
import dao.WeeklyReportsDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objects.Barangay;
import objects.Employee;
import objects.Farm;
import objects.Farmer;
import objects.Fertilizer;
import objects.Municipality;
import objects.PlantingProblem;
import objects.PlantingReport;
import objects.Plot;
import objects.PlotFertilizer;
import objects.ProblemDatabase;
import objects.SeedType;
import objects.SeedVariety;
import objects.TechnicianFarm;
import objects.WeeklyReports;

/**
 *
 * @author RubySenpaii
 */
public class MobileDatabaseSync extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dataToBeRetrieved = request.getParameter("dataToBeRetrieved");

        System.out.println("start sending data");
        if (dataToBeRetrieved.equals("barangays")) {
            sendBarangayData(request, response);
        } else if (dataToBeRetrieved.equals("municipalities")) {
            sendMunicipalData(request, response);
        } else if (dataToBeRetrieved.equals("employees")) {
            sendEmployeeListData(request, response);
        } else if (dataToBeRetrieved.equals("technicianFarms")) {
            sendTechnicianFarmListData(request, response);
        } else if (dataToBeRetrieved.equals("seedTypes")) {
            sendSeedTypeData(request, response);
        } else if (dataToBeRetrieved.equals("seedVarieties")) {
            sendSeedVarietyData(request, response);
        } else if (dataToBeRetrieved.equals("fertilizers")) {
            sendFertilizerData(request, response);
        } else if (dataToBeRetrieved.equals("farms")) {
            sendFarmData(request, response);
        } else if (dataToBeRetrieved.equals("farmers")) {
            sendFarmerData(request, response);
        } else if (dataToBeRetrieved.equals("problems")) {
            sendProblemDatabaseData(request, response);
        }

        if (dataToBeRetrieved.equals("getData")) {
            retrieveDataFromMobile(request, response);
            response.getWriter().write("done download");
        }
    }

    private void sendBarangayData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send barangay data to mobile");
        ArrayList<Barangay> barangays = new BarangayDAO().getListOfBarangays();
        response.getWriter().write(new Gson().toJson(barangays));
    }

    private void sendMunicipalData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send municipal data to mobile");
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        response.getWriter().write(new Gson().toJson(municipalities));
    }

    private void sendEmployeeListData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send employee list data to mobile");
        ArrayList<Employee> employees = new EmployeeDAO().getListOfEmployee();
        response.getWriter().write(new Gson().toJson(employees));
    }

    private void sendTechnicianFarmListData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send technician farm list data to mobile");
        ArrayList<TechnicianFarm> technicianFarms = new TechnicianFarmDAO().getListOfTechncianFarm();
        response.getWriter().write(new Gson().toJson(technicianFarms));
    }

    private void sendSeedTypeData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send seed type data to mobile");
        ArrayList<SeedType> seedTypes = new SeedTypeDAO().getListOfSeedType();
        response.getWriter().write(new Gson().toJson(seedTypes));
    }

    private void sendSeedVarietyData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send seed variety data to mobile");
        ArrayList<SeedVariety> seedVarieties = new SeedVarietyDAO().getListOfSeedVarieties();
        response.getWriter().write(new Gson().toJson(seedVarieties));
    }

    private void sendFertilizerData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send fertilizer data to mobile");
        ArrayList<Fertilizer> fertilizers = new FertilizerDAO().getListOfFertilizers();
        response.getWriter().write(new Gson().toJson(fertilizers));
    }

    private void sendFarmData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send farm data to mobile");
        ArrayList<Farm> farms = new FarmDAO().getListOfFarms();
        response.getWriter().write(new Gson().toJson(farms));
    }

    private void sendFarmerData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send farmer data to mobile");
        ArrayList<Farmer> farmers = new FarmerDAO().getListOfFarmers();
        response.getWriter().write(new Gson().toJson(farmers));
    }

    private void sendProblemDatabaseData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send problem database data to mobile");
        ArrayList<ProblemDatabase> problems = new ProblemDatabaseDAO().getListOfProblems();
        response.getWriter().write(new Gson().toJson(problems));
    }

    private void retrieveDataFromMobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("send problem database data to mobile");
        
        int addCount = 0;
        int updateCount = 0;
        System.out.println("plot input form mobile upload");
        ArrayList<Plot> plots = new Gson().fromJson(request.getParameter("plots"), new TypeToken<List<Plot>>() {
        }.getType());
        for (int a = 0; a < plots.size(); a++) {
            if (a < new PlotDAO().getListOfPlots().size()) {
                if (new PlotDAO().updatePlantingProblem(plots.get(a))) {
                    updateCount++;
                }
            } else if (new PlotDAO().createPlot(plots.get(a))) {
                addCount++;
            } else {
                System.out.println(plots.get(a).getPlotID() + " not added/updated");
            }
        }
        System.out.println("plot input count updated: " + updateCount);
        System.out.println("plot input count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("plot fertilizer input from mobile upload");
        ArrayList<PlotFertilizer> plotFertilizer = new Gson().fromJson(request.getParameter("plotFertilizers"), new TypeToken<List<PlotFertilizer>>() {
        }.getType());
        for (int a = 0; a < plotFertilizer.size(); a++) {
            if (a < new PlotFertilizerDAO().getListOfPlotFertilizers().size()) {
                if (new PlotFertilizerDAO().updatePlotFertilizer(plotFertilizer.get(a))) {
                    updateCount++;
                }
            } else if (new PlotFertilizerDAO().addPlotFertilizer(plotFertilizer.get(a))) {
                addCount++;
            } else {
                System.out.println(plotFertilizer.get(a).getPlotID() + " " + plotFertilizer.get(a).getDateApplied() + " not added/updated");
            }
        }
        System.out.println("plot fertilizer count updated: " + updateCount);
        System.out.println("plot fertilizer count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("planting reports from mobile upload");
        ArrayList<PlantingReport> plantingReports = new Gson().fromJson(request.getParameter("plantingReports"), new TypeToken<List<PlantingReport>>() {
        }.getType());
        for (int a = 0; a < plantingReports.size(); a++) {
            if (a < new PlantingReportDAO().getListOfPlantingReports().size()) {
                if (new PlantingReportDAO().updatePlantingProblem(plantingReports.get(a))) {
                    updateCount++;
                }
            } else if (new PlantingReportDAO().createPlantingReport(plantingReports.get(a))) {
                addCount++;
            } else {
                System.out.println(plantingReports.get(a).getPlantingReportID() + " not added/updated");
            }
        }
        System.out.println("planting report input count updated: " + updateCount);
        System.out.println("planting report input count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("weekly reports from mobile upload");
        ArrayList<WeeklyReports> weeklyReports = new Gson().fromJson(request.getParameter("weeklyReports"), new TypeToken<List<WeeklyReports>>() {
        }.getType());
        for (int a = 0; a < weeklyReports.size(); a++) {
            if (a < new WeeklyReportsDAO().getListOfWeeklyReports().size()) {
                if (new WeeklyReportsDAO().updateWeeklyReport(weeklyReports.get(a))) {
                    updateCount++;
                }
            } else if (new WeeklyReportsDAO().createWeeklyReport(weeklyReports.get(a))) {
                addCount++;
            } else {
                System.out.println(weeklyReports.get(a).getPlantingReportID() + " " + weeklyReports.get(a).getDateReported() + " not added/updated");
            }
        }
        System.out.println("weekly reports count updated: " + updateCount);
        System.out.println("weekly reports count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("problem database update from mobile");
        ArrayList<ProblemDatabase> problemDatabase = new Gson().fromJson(request.getParameter("problems"), new TypeToken<List<ProblemDatabase>>() {
        }.getType());
        for (int a = 0; a < problemDatabase.size(); a++) {
            if (a < new ProblemDatabaseDAO().getListOfProblems().size()) {
                if (new ProblemDatabaseDAO().updatePlantingProblem(problemDatabase.get(a))) {
                    updateCount++;
                }
            } else if (new ProblemDatabaseDAO().recordProblem(problemDatabase.get(a))) {
                addCount++;
            } else {
                System.out.println(problemDatabase.get(a).getProblemID() + " not added/updated");
            }
        }
        System.out.println("problem database count updated: " + updateCount);
        System.out.println("problem database count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("planting problems from mobile upload");
        ArrayList<PlantingProblem> plantingProblems = new Gson().fromJson(request.getParameter("plantingProblems"), new TypeToken<List<PlantingProblem>>() {
        }.getType());
        for (int a = 0; a < plantingProblems.size(); a++) {
            if (a < new PlantingProblemDAO().getListOfPlantingProblems().size()) {
                if (new PlantingProblemDAO().updatePlantingProblem(plantingProblems.get(a))) {
                    updateCount++;
                }
            } else if (new PlantingProblemDAO().reportPlantingProblem(plantingProblems.get(a))) {
                addCount++;
            } else {
                System.out.println(plantingProblems.get(a).getProblemReportID() + " not added/updated");
            }
        }
        System.out.println("planting problem input count updated: " + updateCount);
        System.out.println("planting problem input count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("farm updates from mobile");
        ArrayList<Farm> farms = new Gson().fromJson(request.getParameter("farms"), new TypeToken<List<Farm>>() {
        }.getType());
        for (int a = 0; a < farms.size(); a++) {
            if (a < new FarmDAO().getListOfFarms().size()) {
                if (new FarmDAO().updateFarm(farms.get(a))) {
                    updateCount++;
                }
            } else if (new FarmDAO().addFarm(farms.get(a))) {
                addCount++;
            } else {
                System.out.println(farms.get(a).getFarmID() + " not added/updated");
            }
        }
        System.out.println("farm count updated: " + updateCount);
        System.out.println("farm count added: " + addCount);
        
        addCount = 0;
        updateCount = 0;
        System.out.println("farmer updates from mobile");
        ArrayList<Farmer> farmers = new Gson().fromJson(request.getParameter("farmers"), new TypeToken<List<Farmer>>() {
        }.getType());
        for (int a = 0; a < farmers.size(); a++) {
            if (a < new FarmerDAO().getListOfFarmers().size()) {
                if (new FarmerDAO().updateFarmer(farmers.get(a))) {
                    updateCount++;
                }
            } else if (new FarmerDAO().addFarmer(farmers.get(a))) {
                addCount++;
            } else {
                System.out.println(farmers.get(a).getFarmerID() + " not added/updated");
            }
        }
        System.out.println("farmer count updated: " + updateCount);
        System.out.println("farmer count added: " + addCount);
    }
}
