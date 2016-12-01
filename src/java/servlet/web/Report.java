/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.web;

import dao.FarmDAO;
import dao.MunicipalityDAO;
import dao.PlantingProblemDAO;
import dao.PlantingReportDAO;
import dao.PlotDAO;
import extra.GenericObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

/**
 *
 * @author RubySenpaii
 */
public class Report extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = (String) session.getAttribute("action");
        objects.Employee userLogged = (objects.Employee) session.getAttribute("userLogged");

        if (userLogged.getAuthority().equals("PAO")) {
            System.out.println(userLogged.getUsername() + " has authority level: " + userLogged.getAuthority());
            if (action.equals("getReports")) {
                System.out.println("Retrieving info for reports");
                getReportInfo(request, response);
            } else {
                session.setAttribute("action", "invalid");
            }
        }
    }

    private void getReportInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        ArrayList<GenericObject> planteds = new ArrayList<>();
        ArrayList<GenericObject> harvesteds = new ArrayList<>();
        ArrayList<GenericObject> damageds = new ArrayList<>();
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();
        for (int a = 0; a < municipalities.size(); a++) {
            GenericObject planted = new GenericObject();
            GenericObject harvested = new GenericObject();
            GenericObject damaged = new GenericObject();

            planted.setAttribute1(municipalities.get(a).getMunicipalityName());
            harvested.setAttribute1(municipalities.get(a).getMunicipalityName());
            damaged.setAttribute1(municipalities.get(a).getMunicipalityName());

            double plantedIrrigatedHybridHYTAProgram = 0;
            double plantedIrrigatedHybridHYTADemo = 0;
            double plantedIrrigatedHybridDirect = 0;
            double plantedIrrigatedHybridMTD = 0;
            double plantedIrrigatedHybridPLGU = 0;
            double plantedIrrigatedHybridTotal = 0;
            double plantedIrrigatedRegisteredCSB = 0;
            double plantedIrrigatedRegisteredSG = 0;
            double plantedIrrigatedRegisteredMTD = 0;
            double plantedIrrigatedRegisteredOthers = 0;
            double plantedIrrigatedRegisteredTotal = 0;
            double plantedIrrigatedCertifiedRehab = 0;
            double plantedIrrigatedCertified3rd = 0;
            double plantedIrrigatedCertifiedMLGU = 0;
            double plantedIrrigatedCertifiedDirect = 0;
            double plantedIrrigatedCertifiedOthers = 0;
            double plantedIrrigatedCertifiedTotal = 0;
            double plantedIrrigatedGoodHQSCSB = 0;
            double plantedIrrigatedGoodHQSUntagged = 0;
            double plantedIrrigatedGoodFHSS = 0;
            double plantedIrrigatedGoodGSR = 0;
            double plantedIrrigatedGoodTotal = 0;
            double plantedIrrigatedUpland = 0;
            double plantedIrrigatedTotal = 0;

            double plantedRainfedHybridHYTAProgram = 0;
            double plantedRainfedHybridHYTADemo = 0;
            double plantedRainfedHybridDirect = 0;
            double plantedRainfedHybridMTD = 0;
            double plantedRainfedHybridPLGU = 0;
            double plantedRainfedHybridTotal = 0;
            double plantedRainfedRegisteredCSB = 0;
            double plantedRainfedRegisteredSG = 0;
            double plantedRainfedRegisteredMTD = 0;
            double plantedRainfedRegisteredOthers = 0;
            double plantedRainfedRegisteredTotal = 0;
            double plantedRainfedCertifiedRehab = 0;
            double plantedRainfedCertified3rd = 0;
            double plantedRainfedCertifiedMLGU = 0;
            double plantedRainfedCertifiedDirect = 0;
            double plantedRainfedCertifiedOthers = 0;
            double plantedRainfedCertifiedTotal = 0;
            double plantedRainfedGoodHQSCSB = 0;
            double plantedRainfedGoodHQSUntagged = 0;
            double plantedRainfedGoodFHSS = 0;
            double plantedRainfedGoodGSR = 0;
            double plantedRainfedGoodTotal = 0;
            double plantedRainfedUpland = 0;
            double plantedRainfedTotal = 0;

            double plantedTotalHybridHYTAProgram = 0;
            double plantedTotalHybridHYTADemo = 0;
            double plantedTotalHybridDirect = 0;
            double plantedTotalHybridMTD = 0;
            double plantedTotalHybridPLGU = 0;
            double plantedTotalHybridTotal = 0;
            double plantedTotalRegisteredCSB = 0;
            double plantedTotalRegisteredSG = 0;
            double plantedTotalRegisteredMTD = 0;
            double plantedTotalRegisteredOthers = 0;
            double plantedTotalRegisteredTotal = 0;
            double plantedTotalCertifiedRehab = 0;
            double plantedTotalCertified3rd = 0;
            double plantedTotalCertifiedMLGU = 0;
            double plantedTotalCertifiedDirect = 0;
            double plantedTotalCertifiedOthers = 0;
            double plantedTotalCertifiedTotal = 0;
            double plantedTotalGoodHQSCSB = 0;
            double plantedTotalGoodHQSUntagged = 0;
            double plantedTotalGoodFHSS = 0;
            double plantedTotalGoodGSR = 0;
            double plantedTotalGoodTotal = 0;
            double plantedTotalUpland = 0;
            double plantedTotalTotal = 0;

            double harvestedIrrigatedHybridHYTAProgram = 0;
            double harvestedIrrigatedHybridHYTADemo = 0;
            double harvestedIrrigatedHybridDirect = 0;
            double harvestedIrrigatedHybridMTD = 0;
            double harvestedIrrigatedHybridPLGU = 0;
            double harvestedIrrigatedHybridTotal = 0;
            double harvestedIrrigatedRegisteredCSB = 0;
            double harvestedIrrigatedRegisteredSG = 0;
            double harvestedIrrigatedRegisteredMTD = 0;
            double harvestedIrrigatedRegisteredOthers = 0;
            double harvestedIrrigatedRegisteredTotal = 0;
            double harvestedIrrigatedCertifiedRehab = 0;
            double harvestedIrrigatedCertified3rd = 0;
            double harvestedIrrigatedCertifiedMLGU = 0;
            double harvestedIrrigatedCertifiedDirect = 0;
            double harvestedIrrigatedCertifiedOthers = 0;
            double harvestedIrrigatedCertifiedTotal = 0;
            double harvestedIrrigatedGoodHQSCSB = 0;
            double harvestedIrrigatedGoodHQSUntagged = 0;
            double harvestedIrrigatedGoodFHSS = 0;
            double harvestedIrrigatedGoodGSR = 0;
            double harvestedIrrigatedGoodTotal = 0;
            double harvestedIrrigatedUpland = 0;
            double harvestedIrrigatedTotal = 0;

            double harvestedRainfedHybridHYTAProgram = 0;
            double harvestedRainfedHybridHYTADemo = 0;
            double harvestedRainfedHybridDirect = 0;
            double harvestedRainfedHybridMTD = 0;
            double harvestedRainfedHybridPLGU = 0;
            double harvestedRainfedHybridTotal = 0;
            double harvestedRainfedRegisteredCSB = 0;
            double harvestedRainfedRegisteredSG = 0;
            double harvestedRainfedRegisteredMTD = 0;
            double harvestedRainfedRegisteredOthers = 0;
            double harvestedRainfedRegisteredTotal = 0;
            double harvestedRainfedCertifiedRehab = 0;
            double harvestedRainfedCertified3rd = 0;
            double harvestedRainfedCertifiedMLGU = 0;
            double harvestedRainfedCertifiedDirect = 0;
            double harvestedRainfedCertifiedOthers = 0;
            double harvestedRainfedCertifiedTotal = 0;
            double harvestedRainfedGoodHQSCSB = 0;
            double harvestedRainfedGoodHQSUntagged = 0;
            double harvestedRainfedGoodFHSS = 0;
            double harvestedRainfedGoodGSR = 0;
            double harvestedRainfedGoodTotal = 0;
            double harvestedRainfedUpland = 0;
            double harvestedRainfedTotal = 0;

            double harvestedTotalHybridHYTAProgram = 0;
            double harvestedTotalHybridHYTADemo = 0;
            double harvestedTotalHybridDirect = 0;
            double harvestedTotalHybridMTD = 0;
            double harvestedTotalHybridPLGU = 0;
            double harvestedTotalHybridTotal = 0;
            double harvestedTotalRegisteredCSB = 0;
            double harvestedTotalRegisteredSG = 0;
            double harvestedTotalRegisteredMTD = 0;
            double harvestedTotalRegisteredOthers = 0;
            double harvestedTotalRegisteredTotal = 0;
            double harvestedTotalCertifiedRehab = 0;
            double harvestedTotalCertified3rd = 0;
            double harvestedTotalCertifiedMLGU = 0;
            double harvestedTotalCertifiedDirect = 0;
            double harvestedTotalCertifiedOthers = 0;
            double harvestedTotalCertifiedTotal = 0;
            double harvestedTotalGoodHQSCSB = 0;
            double harvestedTotalGoodHQSUntagged = 0;
            double harvestedTotalGoodFHSS = 0;
            double harvestedTotalGoodGSR = 0;
            double harvestedTotalGoodTotal = 0;
            double harvestedTotalUpland = 0;
            double harvestedTotalTotal = 0;

            double damagedIrrigatedHybridHYTAProgram = 0;
            double damagedIrrigatedHybridHYTADemo = 0;
            double damagedIrrigatedHybridDirect = 0;
            double damagedIrrigatedHybridMTD = 0;
            double damagedIrrigatedHybridPLGU = 0;
            double damagedIrrigatedHybridTotal = 0;
            double damagedIrrigatedRegisteredCSB = 0;
            double damagedIrrigatedRegisteredSG = 0;
            double damagedIrrigatedRegisteredMTD = 0;
            double damagedIrrigatedRegisteredOthers = 0;
            double damagedIrrigatedRegisteredTotal = 0;
            double damagedIrrigatedCertifiedRehab = 0;
            double damagedIrrigatedCertified3rd = 0;
            double damagedIrrigatedCertifiedMLGU = 0;
            double damagedIrrigatedCertifiedDirect = 0;
            double damagedIrrigatedCertifiedOthers = 0;
            double damagedIrrigatedCertifiedTotal = 0;
            double damagedIrrigatedGoodHQSCSB = 0;
            double damagedIrrigatedGoodHQSUntagged = 0;
            double damagedIrrigatedGoodFHSS = 0;
            double damagedIrrigatedGoodGSR = 0;
            double damagedIrrigatedGoodTotal = 0;
            double damagedIrrigatedUpland = 0;
            double damagedIrrigatedTotal = 0;

            double damagedRainfedHybridHYTAProgram = 0;
            double damagedRainfedHybridHYTADemo = 0;
            double damagedRainfedHybridDirect = 0;
            double damagedRainfedHybridMTD = 0;
            double damagedRainfedHybridPLGU = 0;
            double damagedRainfedHybridTotal = 0;
            double damagedRainfedRegisteredCSB = 0;
            double damagedRainfedRegisteredSG = 0;
            double damagedRainfedRegisteredMTD = 0;
            double damagedRainfedRegisteredOthers = 0;
            double damagedRainfedRegisteredTotal = 0;
            double damagedRainfedCertifiedRehab = 0;
            double damagedRainfedCertified3rd = 0;
            double damagedRainfedCertifiedMLGU = 0;
            double damagedRainfedCertifiedDirect = 0;
            double damagedRainfedCertifiedOthers = 0;
            double damagedRainfedCertifiedTotal = 0;
            double damagedRainfedGoodHQSCSB = 0;
            double damagedRainfedGoodHQSUntagged = 0;
            double damagedRainfedGoodFHSS = 0;
            double damagedRainfedGoodGSR = 0;
            double damagedRainfedGoodTotal = 0;
            double damagedRainfedUpland = 0;
            double damagedRainfedTotal = 0;

            double damagedTotalHybridHYTAProgram = 0;
            double damagedTotalHybridHYTADemo = 0;
            double damagedTotalHybridDirect = 0;
            double damagedTotalHybridMTD = 0;
            double damagedTotalHybridPLGU = 0;
            double damagedTotalHybridTotal = 0;
            double damagedTotalRegisteredCSB = 0;
            double damagedTotalRegisteredSG = 0;
            double damagedTotalRegisteredMTD = 0;
            double damagedTotalRegisteredOthers = 0;
            double damagedTotalRegisteredTotal = 0;
            double damagedTotalCertifiedRehab = 0;
            double damagedTotalCertified3rd = 0;
            double damagedTotalCertifiedMLGU = 0;
            double damagedTotalCertifiedDirect = 0;
            double damagedTotalCertifiedOthers = 0;
            double damagedTotalCertifiedTotal = 0;
            double damagedTotalGoodHQSCSB = 0;
            double damagedTotalGoodHQSUntagged = 0;
            double damagedTotalGoodFHSS = 0;
            double damagedTotalGoodGSR = 0;
            double damagedTotalGoodTotal = 0;
            double damagedTotalUpland = 0;
            double damagedTotalTotal = 0;

            ArrayList<Farm> farms = new FarmDAO().getListOfFarmsInMunicipal(municipalities.get(a).getMunicipalityName());
            for (int b = 0; b < farms.size(); b++) {
                ArrayList<Plot> plots = new PlotDAO().getListOfPlotsFromFarm(farms.get(b).getFarmID());
                for (int c = 0; c < plots.size(); c++) {
                    ArrayList<PlantingReport> plantingReports = new PlantingReportDAO().getListOfPlantingReportFromPlotID(plots.get(c).getPlotID());
                    for (int d = 0; d < plantingReports.size(); d++) {
                        ArrayList<PlantingProblem> plantingProblems = new PlantingProblemDAO().getListOfPlantingProblemsFromPlantingReport(plantingReports.get(d).getPlantingReportID());
                        double damage = 0;
                        for (int e = 0; e < plantingProblems.size(); e++) {
                            damage += plantingProblems.get(e).getAreaAffected();
                        }

                        if (farms.get(b).getEcosystem().contains("Irrigated")) {
                            if (farms.get(b).getEcosystem().contains("Upland")) {
                                plantedIrrigatedUpland += plots.get(c).getPlotSize();
                                harvestedIrrigatedUpland += plantingReports.get(d).getAmountHarvested();
                                damagedIrrigatedUpland += damage;
                            }
                            System.out.println(plantingReports.get(d).getSeedType() + " " + plantingReports.get(d).getSeedAcquisition());
                            if (plantingReports.get(d).getSeedType().equalsIgnoreCase("Certified")) {
                                if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("Rehab")) {
                                    plantedIrrigatedCertifiedRehab += plots.get(c).getPlotSize();
                                    harvestedIrrigatedCertifiedRehab += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedCertifiedRehab += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("3rd Crop")) {
                                    plantedIrrigatedCertified3rd += plots.get(c).getPlotSize();
                                    harvestedIrrigatedCertified3rd += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedCertified3rd += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("PLGU/MLGU")) {
                                    plantedIrrigatedCertifiedMLGU += plots.get(c).getPlotSize();
                                    harvestedIrrigatedCertifiedMLGU += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedCertifiedMLGU += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("Direct Purchased")) {
                                    plantedIrrigatedCertifiedDirect += plots.get(c).getPlotSize();
                                    harvestedIrrigatedCertifiedDirect += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedCertifiedDirect += damage;
                                } else {
                                    plantedIrrigatedCertifiedOthers += plots.get(c).getPlotSize();
                                    harvestedIrrigatedCertifiedOthers += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedCertifiedOthers += damage;
                                }
                            } else if (plantingReports.get(d).getSeedType().equalsIgnoreCase("Good")) {
                                if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HQS(CSB)")) {
                                    plantedIrrigatedGoodHQSCSB += plots.get(c).getPlotSize();
                                    harvestedIrrigatedGoodHQSCSB += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedGoodHQSCSB += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HQS(Untagged)")) {
                                    plantedIrrigatedGoodHQSUntagged += plots.get(c).getPlotSize();
                                    harvestedIrrigatedGoodHQSUntagged += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedGoodHQSUntagged += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("FHSS")) {
                                    plantedIrrigatedGoodFHSS += plots.get(c).getPlotSize();
                                    harvestedIrrigatedGoodFHSS += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedGoodFHSS += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("GSR Lines")) {
                                    plantedIrrigatedGoodGSR += plots.get(c).getPlotSize();
                                    harvestedIrrigatedGoodGSR += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedGoodGSR += damage;
                                } else {
                                    System.out.println("unkown at line 355");
                                }
                            } else if (plantingReports.get(d).getSeedType().equalsIgnoreCase("Registered")) {
                                if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("CSB")) {
                                    plantedIrrigatedRegisteredCSB += plots.get(c).getPlotSize();
                                    harvestedIrrigatedRegisteredCSB += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedRegisteredCSB += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("SEED Prod(SG)")) {
                                    plantedIrrigatedRegisteredSG += plots.get(c).getPlotSize();
                                    harvestedIrrigatedRegisteredSG += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedRegisteredSG += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("MTD/PTD")) {
                                    plantedIrrigatedRegisteredMTD += plots.get(c).getPlotSize();
                                    harvestedIrrigatedRegisteredMTD += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedRegisteredMTD += damage;
                                } else {
                                    plantedIrrigatedRegisteredOthers += plots.get(c).getPlotSize();
                                    harvestedIrrigatedRegisteredOthers += plantingReports.get(d).getAmountHarvested();
                                    damagedIrrigatedRegisteredOthers += damage;
                                }
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HYTA Program")) {
                                plantedIrrigatedHybridHYTAProgram += plots.get(c).getPlotSize();
                                harvestedIrrigatedHybridHYTAProgram += plantingReports.get(d).getAmountHarvested();
                                damagedIrrigatedHybridHYTAProgram += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HYTA Demo")) {
                                plantedIrrigatedHybridHYTADemo += plots.get(c).getPlotSize();
                                harvestedIrrigatedHybridHYTADemo += plantingReports.get(d).getAmountHarvested();
                                damagedIrrigatedHybridHYTADemo += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("Direct Purchased")) {
                                plantedIrrigatedHybridDirect += plots.get(c).getPlotSize();
                                harvestedIrrigatedHybridDirect += plantingReports.get(d).getAmountHarvested();
                                damagedIrrigatedHybridDirect += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("MTD/PTD (Cluster)")) {
                                plantedIrrigatedHybridMTD += plots.get(c).getPlotSize();
                                harvestedIrrigatedHybridMTD += plantingReports.get(d).getAmountHarvested();
                                damagedIrrigatedHybridMTD += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("PLGU/MLGU")) {
                                plantedIrrigatedHybridPLGU += plots.get(c).getPlotSize();
                                harvestedIrrigatedHybridPLGU += plantingReports.get(d).getAmountHarvested();
                                damagedIrrigatedHybridPLGU += damage;
                            } else {
                                System.out.println("Unknown at line 396");
                            }
                        } else if (farms.get(b).getEcosystem().contains("Rainfed")) {
                            if (farms.get(b).getEcosystem().contains("Upland")) {
                                plantedRainfedUpland += plots.get(c).getPlotSize();
                                harvestedRainfedUpland += plantingReports.get(d).getAmountHarvested();
                                damagedRainfedTotal += damage;
                            }
                            if (plantingReports.get(d).getSeedType().equalsIgnoreCase("Certified")) {
                                if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("Rehab")) {
                                    plantedRainfedCertifiedRehab += plots.get(c).getPlotSize();
                                    harvestedRainfedCertifiedRehab += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedCertifiedRehab += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("3rd Crop")) {
                                    plantedRainfedCertified3rd += plots.get(c).getPlotSize();
                                    harvestedRainfedCertified3rd += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedCertified3rd += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("PLGU/MLGU")) {
                                    plantedRainfedCertifiedMLGU += plots.get(c).getPlotSize();
                                    harvestedRainfedCertifiedMLGU += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedCertifiedMLGU += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("Direct Purchased")) {
                                    plantedRainfedCertifiedDirect += plots.get(c).getPlotSize();
                                    harvestedRainfedCertifiedDirect += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedCertifiedDirect += damage;
                                } else {
                                    plantedRainfedCertifiedOthers += plots.get(c).getPlotSize();
                                    harvestedRainfedCertifiedOthers += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedCertifiedOthers += damage;
                                }
                            } else if (plantingReports.get(d).getSeedType().equalsIgnoreCase("Good")) {
                                if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HQS(CSB)")) {
                                    plantedRainfedGoodHQSCSB += plots.get(c).getPlotSize();
                                    harvestedRainfedGoodHQSCSB += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedGoodHQSCSB += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HQS(Untagged)")) {
                                    plantedRainfedGoodHQSUntagged += plots.get(c).getPlotSize();
                                    harvestedRainfedGoodHQSUntagged += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedGoodHQSUntagged += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("FHSS")) {
                                    plantedRainfedGoodFHSS += plots.get(c).getPlotSize();
                                    harvestedRainfedGoodFHSS += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedGoodFHSS += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("GSR Lines")) {
                                    plantedRainfedGoodGSR += plots.get(c).getPlotSize();
                                    harvestedRainfedGoodGSR += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedGoodGSR += damage;
                                } else {
                                    System.out.println("unkown at line 444");
                                }
                            } else if (plantingReports.get(d).getSeedType().equalsIgnoreCase("Registered")) {
                                if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("CSB")) {
                                    plantedRainfedRegisteredCSB += plots.get(c).getPlotSize();
                                    harvestedRainfedRegisteredCSB += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedRegisteredCSB += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("SEED Prod(SG)")) {
                                    plantedRainfedRegisteredSG += plots.get(c).getPlotSize();
                                    harvestedRainfedRegisteredSG += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedRegisteredSG += damage;
                                } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("MTD/PTD")) {
                                    plantedRainfedRegisteredMTD += plots.get(c).getPlotSize();
                                    harvestedRainfedRegisteredMTD += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedRegisteredMTD += damage;
                                } else {
                                    plantedRainfedRegisteredOthers += plots.get(c).getPlotSize();
                                    harvestedRainfedRegisteredOthers += plantingReports.get(d).getAmountHarvested();
                                    damagedRainfedRegisteredOthers += damage;
                                }
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HYTA Program")) {
                                plantedRainfedHybridHYTAProgram += plots.get(c).getPlotSize();
                                harvestedRainfedHybridHYTAProgram += plantingReports.get(d).getAmountHarvested();
                                damagedRainfedHybridHYTAProgram += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("HYTA Demo")) {
                                plantedRainfedHybridHYTADemo += plots.get(c).getPlotSize();
                                harvestedRainfedHybridHYTADemo += plantingReports.get(d).getAmountHarvested();
                                damagedRainfedHybridHYTADemo += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("Direct Purchased")) {
                                plantedRainfedHybridDirect += plots.get(c).getPlotSize();
                                harvestedRainfedHybridDirect += plantingReports.get(d).getAmountHarvested();
                                damagedRainfedHybridDirect += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("MTD/PTD (Cluster)")) {
                                plantedRainfedHybridMTD += plots.get(c).getPlotSize();
                                harvestedRainfedHybridMTD += plantingReports.get(d).getAmountHarvested();
                                damagedRainfedHybridMTD += damage;
                            } else if (plantingReports.get(d).getSeedAcquisition().equalsIgnoreCase("PLGU/MLGU")) {
                                plantedRainfedHybridPLGU += plots.get(c).getPlotSize();
                                harvestedRainfedHybridPLGU += plantingReports.get(d).getAmountHarvested();
                                damagedRainfedHybridPLGU += damage;
                            } else {
                                System.out.println("Unknown at line 485");
                            }
                        }
                    }
                }
            }

            //planted irrigated
            planted.setAttribute2(String.valueOf(plantedIrrigatedHybridHYTAProgram));
            planted.setAttribute3(String.valueOf(plantedIrrigatedHybridHYTADemo));
            planted.setAttribute4(String.valueOf(plantedIrrigatedHybridDirect));
            planted.setAttribute5(String.valueOf(plantedIrrigatedHybridMTD));
            planted.setAttribute6(String.valueOf(plantedIrrigatedHybridPLGU));

            plantedIrrigatedHybridTotal = plantedIrrigatedHybridHYTAProgram + plantedIrrigatedHybridHYTADemo + plantedIrrigatedHybridDirect + plantedIrrigatedHybridMTD + plantedIrrigatedHybridPLGU;
            planted.setAttribute7(String.valueOf(plantedIrrigatedHybridTotal));

            planted.setAttribute8(String.valueOf(plantedIrrigatedRegisteredCSB));
            planted.setAttribute9(String.valueOf(plantedIrrigatedRegisteredSG));
            planted.setAttribute10(String.valueOf(plantedIrrigatedRegisteredMTD));
            planted.setAttribute11(String.valueOf(plantedIrrigatedRegisteredOthers));

            plantedIrrigatedRegisteredTotal = plantedIrrigatedRegisteredCSB + plantedIrrigatedRegisteredSG + plantedIrrigatedRegisteredMTD + plantedIrrigatedRegisteredOthers;
            planted.setAttribute12(String.valueOf(plantedIrrigatedRegisteredTotal));

            planted.setAttribute13(String.valueOf(plantedIrrigatedCertifiedRehab));
            planted.setAttribute14(String.valueOf(plantedIrrigatedCertified3rd));
            planted.setAttribute15(String.valueOf(plantedIrrigatedCertifiedMLGU));
            planted.setAttribute16(String.valueOf(plantedIrrigatedCertifiedDirect));
            planted.setAttribute17(String.valueOf(plantedIrrigatedCertifiedOthers));

            plantedIrrigatedCertifiedTotal = plantedIrrigatedCertifiedRehab + plantedIrrigatedCertified3rd + plantedIrrigatedCertifiedMLGU + plantedIrrigatedCertifiedDirect + plantedIrrigatedCertifiedOthers;
            planted.setAttribute18(String.valueOf(plantedIrrigatedCertifiedTotal));

            planted.setAttribute19(String.valueOf(plantedIrrigatedGoodHQSCSB));
            planted.setAttribute20(String.valueOf(plantedIrrigatedGoodHQSUntagged));
            planted.setAttribute21(String.valueOf(plantedIrrigatedGoodFHSS));
            planted.setAttribute22(String.valueOf(plantedIrrigatedGoodGSR));

            plantedIrrigatedGoodTotal = plantedIrrigatedGoodHQSCSB + plantedIrrigatedGoodHQSUntagged + plantedIrrigatedGoodFHSS + plantedIrrigatedGoodGSR;
            planted.setAttribute23(String.valueOf(plantedIrrigatedGoodTotal));
            
            planted.setAttribute24(String.valueOf(plantedIrrigatedUpland));
            plantedIrrigatedTotal = plantedIrrigatedRegisteredTotal + plantedIrrigatedCertifiedTotal + plantedIrrigatedGoodTotal + plantedIrrigatedHybridTotal;
            planted.setAttribute25(String.valueOf(plantedIrrigatedTotal));
            
            //planted rainfed
            planted.setAttribute26(String.valueOf(plantedRainfedHybridHYTAProgram));
            planted.setAttribute27(String.valueOf(plantedRainfedHybridHYTADemo));
            planted.setAttribute28(String.valueOf(plantedRainfedHybridDirect));
            planted.setAttribute29(String.valueOf(plantedRainfedHybridMTD));
            planted.setAttribute30(String.valueOf(plantedRainfedHybridPLGU));

            plantedRainfedHybridTotal = plantedRainfedHybridHYTAProgram + plantedRainfedHybridHYTADemo + plantedRainfedHybridDirect + plantedRainfedHybridMTD + plantedRainfedHybridPLGU;
            planted.setAttribute31(String.valueOf(plantedRainfedHybridTotal));

            planted.setAttribute32(String.valueOf(plantedRainfedRegisteredCSB));
            planted.setAttribute33(String.valueOf(plantedRainfedRegisteredSG));
            planted.setAttribute34(String.valueOf(plantedRainfedRegisteredMTD));
            planted.setAttribute35(String.valueOf(plantedRainfedRegisteredOthers));

            plantedRainfedRegisteredTotal = plantedRainfedRegisteredCSB + plantedRainfedRegisteredSG + plantedRainfedRegisteredMTD + plantedRainfedRegisteredOthers;
            planted.setAttribute36(String.valueOf(plantedRainfedRegisteredTotal));

            planted.setAttribute37(String.valueOf(plantedRainfedCertifiedRehab));
            planted.setAttribute38(String.valueOf(plantedRainfedCertified3rd));
            planted.setAttribute39(String.valueOf(plantedRainfedCertifiedMLGU));
            planted.setAttribute40(String.valueOf(plantedRainfedCertifiedDirect));
            planted.setAttribute41(String.valueOf(plantedRainfedCertifiedOthers));

            plantedRainfedCertifiedTotal = plantedRainfedCertifiedRehab + plantedRainfedCertified3rd + plantedRainfedCertifiedMLGU + plantedRainfedCertifiedDirect + plantedRainfedCertifiedOthers;
            planted.setAttribute42(String.valueOf(plantedRainfedCertifiedTotal));

            planted.setAttribute43(String.valueOf(plantedRainfedGoodHQSCSB));
            planted.setAttribute44(String.valueOf(plantedRainfedGoodHQSUntagged));
            planted.setAttribute45(String.valueOf(plantedRainfedGoodFHSS));
            planted.setAttribute46(String.valueOf(plantedRainfedGoodGSR));

            plantedRainfedGoodTotal = plantedRainfedGoodHQSCSB + plantedRainfedGoodHQSUntagged + plantedRainfedGoodFHSS + plantedRainfedGoodGSR;
            planted.setAttribute47(String.valueOf(plantedRainfedGoodTotal));
            
            planted.setAttribute48(String.valueOf(plantedRainfedUpland));
            plantedRainfedTotal = plantedRainfedRegisteredTotal + plantedRainfedCertifiedTotal + plantedRainfedGoodTotal + plantedRainfedHybridTotal;
            planted.setAttribute49(String.valueOf(plantedRainfedTotal));
            
            //planted total
            plantedTotalHybridHYTAProgram = plantedIrrigatedHybridHYTAProgram + plantedRainfedHybridHYTAProgram;
            planted.setAttribute50(String.valueOf(plantedTotalHybridHYTAProgram));
            plantedTotalHybridHYTADemo = plantedIrrigatedHybridHYTADemo + plantedRainfedHybridHYTADemo;
            planted.setAttribute51(String.valueOf(plantedTotalHybridHYTADemo));
            plantedTotalHybridDirect = plantedIrrigatedHybridDirect + plantedRainfedHybridDirect;
            planted.setAttribute52(String.valueOf(plantedTotalHybridDirect));
            plantedTotalHybridMTD = plantedIrrigatedHybridMTD + plantedRainfedHybridMTD;
            planted.setAttribute53(String.valueOf(plantedTotalHybridMTD));
            plantedTotalHybridPLGU = plantedIrrigatedHybridPLGU + plantedRainfedHybridPLGU;
            planted.setAttribute54(String.valueOf(plantedTotalHybridPLGU));

            plantedTotalHybridTotal = plantedTotalHybridHYTAProgram + plantedTotalHybridHYTADemo + plantedTotalHybridDirect + plantedTotalHybridMTD + plantedTotalHybridPLGU;
            planted.setAttribute55(String.valueOf(plantedTotalHybridTotal));

            plantedTotalRegisteredCSB = plantedIrrigatedRegisteredCSB + plantedRainfedRegisteredCSB;
            planted.setAttribute56(String.valueOf(plantedTotalRegisteredCSB));
            plantedTotalRegisteredSG = plantedIrrigatedRegisteredSG + plantedRainfedRegisteredSG;
            planted.setAttribute57(String.valueOf(plantedTotalRegisteredSG));
            plantedTotalRegisteredMTD = plantedIrrigatedRegisteredMTD + plantedRainfedRegisteredMTD;
            planted.setAttribute58(String.valueOf(plantedTotalRegisteredMTD));
            plantedTotalRegisteredOthers = plantedIrrigatedRegisteredOthers + plantedRainfedRegisteredOthers;
            planted.setAttribute59(String.valueOf(plantedTotalRegisteredOthers));

            plantedTotalRegisteredTotal = plantedTotalRegisteredCSB + plantedTotalRegisteredSG + plantedTotalRegisteredMTD + plantedTotalRegisteredOthers;
            planted.setAttribute60(String.valueOf(plantedTotalRegisteredTotal));

            plantedTotalCertifiedRehab = plantedIrrigatedCertifiedRehab + plantedRainfedCertifiedRehab;
            planted.setAttribute61(String.valueOf(plantedTotalCertifiedRehab));
            plantedTotalCertified3rd = plantedIrrigatedCertified3rd + plantedRainfedCertified3rd;
            planted.setAttribute62(String.valueOf(plantedTotalCertified3rd));
            plantedTotalCertifiedMLGU = plantedIrrigatedCertifiedMLGU + plantedRainfedCertifiedMLGU;
            planted.setAttribute63(String.valueOf(plantedTotalCertifiedMLGU));
            plantedTotalCertifiedDirect = plantedIrrigatedCertifiedDirect + plantedRainfedCertifiedDirect;
            planted.setAttribute64(String.valueOf(plantedTotalCertifiedDirect));
            plantedTotalCertifiedOthers = plantedIrrigatedCertifiedOthers + plantedRainfedCertifiedOthers;
            planted.setAttribute65(String.valueOf(plantedTotalCertifiedOthers));

            plantedTotalCertifiedTotal = plantedTotalCertifiedRehab + plantedTotalCertified3rd + plantedTotalCertifiedMLGU + plantedTotalCertifiedDirect + plantedTotalCertifiedOthers;
            planted.setAttribute66(String.valueOf(plantedTotalCertifiedTotal));

            plantedTotalGoodHQSCSB = plantedIrrigatedGoodHQSCSB + plantedRainfedGoodHQSCSB;
            planted.setAttribute67(String.valueOf(plantedTotalGoodHQSCSB));
            plantedTotalGoodHQSUntagged = plantedIrrigatedGoodHQSUntagged + plantedRainfedGoodHQSUntagged;
            planted.setAttribute68(String.valueOf(plantedTotalGoodHQSUntagged));
            plantedTotalGoodFHSS = plantedIrrigatedGoodFHSS + plantedRainfedGoodFHSS;
            planted.setAttribute69(String.valueOf(plantedTotalGoodFHSS));
            plantedTotalGoodGSR = plantedIrrigatedGoodGSR + plantedRainfedGoodGSR;
            planted.setAttribute70(String.valueOf(plantedTotalGoodGSR));

            plantedTotalGoodTotal = plantedTotalGoodHQSCSB + plantedTotalGoodHQSUntagged + plantedTotalGoodFHSS + plantedTotalGoodGSR;
            planted.setAttribute71(String.valueOf(plantedTotalGoodTotal));
            
            plantedTotalUpland = plantedIrrigatedUpland + plantedRainfedUpland;
            planted.setAttribute72(String.valueOf(plantedTotalUpland));
            plantedTotalTotal = plantedTotalRegisteredTotal + plantedTotalCertifiedTotal + plantedTotalGoodTotal + plantedTotalHybridTotal;
            planted.setAttribute73(String.valueOf(plantedTotalTotal));
            
            //harvested irrigated
            harvested.setAttribute2(String.valueOf(harvestedIrrigatedHybridHYTAProgram));
            harvested.setAttribute3(String.valueOf(harvestedIrrigatedHybridHYTADemo));
            harvested.setAttribute4(String.valueOf(harvestedIrrigatedHybridDirect));
            harvested.setAttribute5(String.valueOf(harvestedIrrigatedHybridMTD));
            harvested.setAttribute6(String.valueOf(harvestedIrrigatedHybridPLGU));

            harvestedIrrigatedHybridTotal = harvestedIrrigatedHybridHYTAProgram + harvestedIrrigatedHybridHYTADemo + harvestedIrrigatedHybridDirect + harvestedIrrigatedHybridMTD + harvestedIrrigatedHybridPLGU;
            harvested.setAttribute7(String.valueOf(harvestedIrrigatedHybridTotal));

            harvested.setAttribute8(String.valueOf(harvestedIrrigatedRegisteredCSB));
            harvested.setAttribute9(String.valueOf(harvestedIrrigatedRegisteredSG));
            harvested.setAttribute10(String.valueOf(harvestedIrrigatedRegisteredMTD));
            harvested.setAttribute11(String.valueOf(harvestedIrrigatedRegisteredOthers));

            harvestedIrrigatedRegisteredTotal = harvestedIrrigatedRegisteredCSB + harvestedIrrigatedRegisteredSG + harvestedIrrigatedRegisteredMTD + harvestedIrrigatedRegisteredOthers;
            harvested.setAttribute12(String.valueOf(harvestedIrrigatedRegisteredTotal));

            harvested.setAttribute13(String.valueOf(harvestedIrrigatedCertifiedRehab));
            harvested.setAttribute14(String.valueOf(harvestedIrrigatedCertified3rd));
            harvested.setAttribute15(String.valueOf(harvestedIrrigatedCertifiedMLGU));
            harvested.setAttribute16(String.valueOf(harvestedIrrigatedCertifiedDirect));
            harvested.setAttribute17(String.valueOf(harvestedIrrigatedCertifiedOthers));

            harvestedIrrigatedCertifiedTotal = harvestedIrrigatedCertifiedRehab + harvestedIrrigatedCertified3rd + harvestedIrrigatedCertifiedMLGU + harvestedIrrigatedCertifiedDirect + harvestedIrrigatedCertifiedOthers;
            harvested.setAttribute18(String.valueOf(harvestedIrrigatedCertifiedTotal));

            harvested.setAttribute19(String.valueOf(harvestedIrrigatedGoodHQSCSB));
            harvested.setAttribute20(String.valueOf(harvestedIrrigatedGoodHQSUntagged));
            harvested.setAttribute21(String.valueOf(harvestedIrrigatedGoodFHSS));
            harvested.setAttribute22(String.valueOf(harvestedIrrigatedGoodGSR));

            harvestedIrrigatedGoodTotal = harvestedIrrigatedGoodHQSCSB + harvestedIrrigatedGoodHQSUntagged + harvestedIrrigatedGoodFHSS + harvestedIrrigatedGoodGSR;
            harvested.setAttribute23(String.valueOf(harvestedIrrigatedGoodTotal));
            
            harvested.setAttribute24(String.valueOf(harvestedIrrigatedUpland));
            harvestedIrrigatedTotal = harvestedIrrigatedRegisteredTotal + harvestedIrrigatedCertifiedTotal + harvestedIrrigatedGoodTotal + harvestedIrrigatedHybridTotal;
            harvested.setAttribute25(String.valueOf(harvestedIrrigatedTotal));
            
            //harvested rainfed
            harvested.setAttribute26(String.valueOf(harvestedRainfedHybridHYTAProgram));
            harvested.setAttribute27(String.valueOf(harvestedRainfedHybridHYTADemo));
            harvested.setAttribute28(String.valueOf(harvestedRainfedHybridDirect));
            harvested.setAttribute29(String.valueOf(harvestedRainfedHybridMTD));
            harvested.setAttribute30(String.valueOf(harvestedRainfedHybridPLGU));

            harvestedRainfedHybridTotal = harvestedRainfedHybridHYTAProgram + harvestedRainfedHybridHYTADemo + harvestedRainfedHybridDirect + harvestedRainfedHybridMTD + harvestedRainfedHybridPLGU;
            harvested.setAttribute31(String.valueOf(harvestedRainfedHybridTotal));

            harvested.setAttribute32(String.valueOf(harvestedRainfedRegisteredCSB));
            harvested.setAttribute33(String.valueOf(harvestedRainfedRegisteredSG));
            harvested.setAttribute34(String.valueOf(harvestedRainfedRegisteredMTD));
            harvested.setAttribute35(String.valueOf(harvestedRainfedRegisteredOthers));

            harvestedRainfedRegisteredTotal = harvestedRainfedRegisteredCSB + harvestedRainfedRegisteredSG + harvestedRainfedRegisteredMTD + harvestedRainfedRegisteredOthers;
            harvested.setAttribute36(String.valueOf(harvestedRainfedRegisteredTotal));

            harvested.setAttribute37(String.valueOf(harvestedRainfedCertifiedRehab));
            harvested.setAttribute38(String.valueOf(harvestedRainfedCertified3rd));
            harvested.setAttribute39(String.valueOf(harvestedRainfedCertifiedMLGU));
            harvested.setAttribute40(String.valueOf(harvestedRainfedCertifiedDirect));
            harvested.setAttribute41(String.valueOf(harvestedRainfedCertifiedOthers));

            harvestedRainfedCertifiedTotal = harvestedRainfedCertifiedRehab + harvestedRainfedCertified3rd + harvestedRainfedCertifiedMLGU + harvestedRainfedCertifiedDirect + harvestedRainfedCertifiedOthers;
            harvested.setAttribute42(String.valueOf(harvestedRainfedCertifiedTotal));

            harvested.setAttribute43(String.valueOf(harvestedRainfedGoodHQSCSB));
            harvested.setAttribute44(String.valueOf(harvestedRainfedGoodHQSUntagged));
            harvested.setAttribute45(String.valueOf(harvestedRainfedGoodFHSS));
            harvested.setAttribute46(String.valueOf(harvestedRainfedGoodGSR));

            harvestedRainfedGoodTotal = harvestedRainfedGoodHQSCSB + harvestedRainfedGoodHQSUntagged + harvestedRainfedGoodFHSS + harvestedRainfedGoodGSR;
            harvested.setAttribute47(String.valueOf(harvestedRainfedGoodTotal));
            
            harvested.setAttribute48(String.valueOf(harvestedRainfedUpland));
            harvestedRainfedTotal = harvestedRainfedRegisteredTotal + harvestedRainfedCertifiedTotal + harvestedRainfedGoodTotal + harvestedRainfedHybridTotal;
            harvested.setAttribute49(String.valueOf(harvestedRainfedTotal));
            
            //harvested total
            harvestedTotalHybridHYTAProgram = harvestedIrrigatedHybridHYTAProgram + harvestedRainfedHybridHYTAProgram;
            harvested.setAttribute50(String.valueOf(harvestedTotalHybridHYTAProgram));
            harvestedTotalHybridHYTADemo = harvestedIrrigatedHybridHYTADemo + harvestedRainfedHybridHYTADemo;
            harvested.setAttribute51(String.valueOf(harvestedTotalHybridHYTADemo));
            harvestedTotalHybridDirect = harvestedIrrigatedHybridDirect + harvestedRainfedHybridDirect;
            harvested.setAttribute52(String.valueOf(harvestedTotalHybridDirect));
            harvestedTotalHybridMTD = harvestedIrrigatedHybridMTD + harvestedRainfedHybridMTD;
            harvested.setAttribute53(String.valueOf(harvestedTotalHybridMTD));
            harvestedTotalHybridPLGU = harvestedIrrigatedHybridPLGU + harvestedRainfedHybridPLGU;
            harvested.setAttribute54(String.valueOf(harvestedTotalHybridPLGU));

            harvestedTotalHybridTotal = harvestedTotalHybridHYTAProgram + harvestedTotalHybridHYTADemo + harvestedTotalHybridDirect + harvestedTotalHybridMTD + harvestedTotalHybridPLGU;
            harvested.setAttribute55(String.valueOf(harvestedTotalHybridTotal));

            harvestedTotalRegisteredCSB = harvestedIrrigatedRegisteredCSB + harvestedRainfedRegisteredCSB;
            harvested.setAttribute56(String.valueOf(harvestedTotalRegisteredCSB));
            harvestedTotalRegisteredSG = harvestedIrrigatedRegisteredSG + harvestedRainfedRegisteredSG;
            harvested.setAttribute57(String.valueOf(harvestedTotalRegisteredSG));
            harvestedTotalRegisteredMTD = harvestedIrrigatedRegisteredMTD + harvestedRainfedRegisteredMTD;
            harvested.setAttribute58(String.valueOf(harvestedTotalRegisteredMTD));
            harvestedTotalRegisteredOthers = harvestedIrrigatedRegisteredOthers + harvestedRainfedRegisteredOthers;
            harvested.setAttribute59(String.valueOf(harvestedTotalRegisteredOthers));

            harvestedTotalRegisteredTotal = harvestedTotalRegisteredCSB + harvestedTotalRegisteredSG + harvestedTotalRegisteredMTD + harvestedTotalRegisteredOthers;
            harvested.setAttribute60(String.valueOf(harvestedTotalRegisteredTotal));

            harvestedTotalCertifiedRehab = harvestedIrrigatedCertifiedRehab + harvestedRainfedCertifiedRehab;
            harvested.setAttribute61(String.valueOf(harvestedTotalCertifiedRehab));
            harvestedTotalCertified3rd = harvestedIrrigatedCertified3rd + harvestedRainfedCertified3rd;
            harvested.setAttribute62(String.valueOf(harvestedTotalCertified3rd));
            harvestedTotalCertifiedMLGU = harvestedIrrigatedCertifiedMLGU + harvestedRainfedCertifiedMLGU;
            harvested.setAttribute63(String.valueOf(harvestedTotalCertifiedMLGU));
            harvestedTotalCertifiedDirect = harvestedIrrigatedCertifiedDirect + harvestedRainfedCertifiedDirect;
            harvested.setAttribute64(String.valueOf(harvestedTotalCertifiedDirect));
            harvestedTotalCertifiedOthers = harvestedIrrigatedCertifiedOthers + harvestedRainfedCertifiedOthers;
            harvested.setAttribute65(String.valueOf(harvestedTotalCertifiedOthers));

            harvestedTotalCertifiedTotal = harvestedTotalCertifiedRehab + harvestedTotalCertified3rd + harvestedTotalCertifiedMLGU + harvestedTotalCertifiedDirect + harvestedTotalCertifiedOthers;
            harvested.setAttribute66(String.valueOf(harvestedTotalCertifiedTotal));

            harvestedTotalGoodHQSCSB = harvestedIrrigatedGoodHQSCSB + harvestedRainfedGoodHQSCSB;
            harvested.setAttribute67(String.valueOf(harvestedTotalGoodHQSCSB));
            harvestedTotalGoodHQSUntagged = harvestedIrrigatedGoodHQSUntagged + harvestedRainfedGoodHQSUntagged;
            harvested.setAttribute68(String.valueOf(harvestedTotalGoodHQSUntagged));
            harvestedTotalGoodFHSS = harvestedIrrigatedGoodFHSS + harvestedRainfedGoodFHSS;
            harvested.setAttribute69(String.valueOf(harvestedTotalGoodFHSS));
            harvestedTotalGoodGSR = harvestedIrrigatedGoodGSR + harvestedRainfedGoodGSR;
            harvested.setAttribute70(String.valueOf(harvestedTotalGoodGSR));

            harvestedTotalGoodTotal = harvestedTotalGoodHQSCSB + harvestedTotalGoodHQSUntagged + harvestedTotalGoodFHSS + harvestedTotalGoodGSR;
            harvested.setAttribute71(String.valueOf(harvestedTotalGoodTotal));
            
            harvestedTotalUpland = harvestedIrrigatedUpland + harvestedRainfedUpland;
            harvested.setAttribute72(String.valueOf(harvestedTotalUpland));
            harvestedTotalTotal = harvestedTotalRegisteredTotal + harvestedTotalCertifiedTotal + harvestedTotalGoodTotal + harvestedTotalHybridTotal;
            harvested.setAttribute73(String.valueOf(harvestedTotalTotal));
            
            //damaged irrigated
            damaged.setAttribute2(String.valueOf(damagedIrrigatedHybridHYTAProgram));
            damaged.setAttribute3(String.valueOf(damagedIrrigatedHybridHYTADemo));
            damaged.setAttribute4(String.valueOf(damagedIrrigatedHybridDirect));
            damaged.setAttribute5(String.valueOf(damagedIrrigatedHybridMTD));
            damaged.setAttribute6(String.valueOf(damagedIrrigatedHybridPLGU));

            damagedIrrigatedHybridTotal = damagedIrrigatedHybridHYTAProgram + damagedIrrigatedHybridHYTADemo + damagedIrrigatedHybridDirect + damagedIrrigatedHybridMTD + damagedIrrigatedHybridPLGU;
            damaged.setAttribute7(String.valueOf(damagedIrrigatedHybridTotal));

            damaged.setAttribute8(String.valueOf(damagedIrrigatedRegisteredCSB));
            damaged.setAttribute9(String.valueOf(damagedIrrigatedRegisteredSG));
            damaged.setAttribute10(String.valueOf(damagedIrrigatedRegisteredMTD));
            damaged.setAttribute11(String.valueOf(damagedIrrigatedRegisteredOthers));

            damagedIrrigatedRegisteredTotal = damagedIrrigatedRegisteredCSB + damagedIrrigatedRegisteredSG + damagedIrrigatedRegisteredMTD + damagedIrrigatedRegisteredOthers;
            damaged.setAttribute12(String.valueOf(damagedIrrigatedRegisteredTotal));

            damaged.setAttribute13(String.valueOf(damagedIrrigatedCertifiedRehab));
            damaged.setAttribute14(String.valueOf(damagedIrrigatedCertified3rd));
            damaged.setAttribute15(String.valueOf(damagedIrrigatedCertifiedMLGU));
            damaged.setAttribute16(String.valueOf(damagedIrrigatedCertifiedDirect));
            damaged.setAttribute17(String.valueOf(damagedIrrigatedCertifiedOthers));

            damagedIrrigatedCertifiedTotal = damagedIrrigatedCertifiedRehab + damagedIrrigatedCertified3rd + damagedIrrigatedCertifiedMLGU + damagedIrrigatedCertifiedDirect + damagedIrrigatedCertifiedOthers;
            damaged.setAttribute18(String.valueOf(damagedIrrigatedCertifiedTotal));

            damaged.setAttribute19(String.valueOf(damagedIrrigatedGoodHQSCSB));
            damaged.setAttribute20(String.valueOf(damagedIrrigatedGoodHQSUntagged));
            damaged.setAttribute21(String.valueOf(damagedIrrigatedGoodFHSS));
            damaged.setAttribute22(String.valueOf(damagedIrrigatedGoodGSR));

            damagedIrrigatedGoodTotal = damagedIrrigatedGoodHQSCSB + damagedIrrigatedGoodHQSUntagged + damagedIrrigatedGoodFHSS + damagedIrrigatedGoodGSR;
            damaged.setAttribute23(String.valueOf(damagedIrrigatedGoodTotal));
            
            damaged.setAttribute24(String.valueOf(damagedIrrigatedUpland));
            damagedIrrigatedTotal = damagedIrrigatedRegisteredTotal + damagedIrrigatedCertifiedTotal + damagedIrrigatedGoodTotal + damagedIrrigatedHybridTotal;
            damaged.setAttribute25(String.valueOf(damagedIrrigatedTotal));
            
            //damaged rainfed
            damaged.setAttribute26(String.valueOf(damagedRainfedHybridHYTAProgram));
            damaged.setAttribute27(String.valueOf(damagedRainfedHybridHYTADemo));
            damaged.setAttribute28(String.valueOf(damagedRainfedHybridDirect));
            damaged.setAttribute29(String.valueOf(damagedRainfedHybridMTD));
            damaged.setAttribute30(String.valueOf(damagedRainfedHybridPLGU));

            damagedRainfedHybridTotal = damagedRainfedHybridHYTAProgram + damagedRainfedHybridHYTADemo + damagedRainfedHybridDirect + damagedRainfedHybridMTD + damagedRainfedHybridPLGU;
            damaged.setAttribute31(String.valueOf(damagedRainfedHybridTotal));

            damaged.setAttribute32(String.valueOf(damagedRainfedRegisteredCSB));
            damaged.setAttribute33(String.valueOf(damagedRainfedRegisteredSG));
            damaged.setAttribute34(String.valueOf(damagedRainfedRegisteredMTD));
            damaged.setAttribute35(String.valueOf(damagedRainfedRegisteredOthers));

            damagedRainfedRegisteredTotal = damagedRainfedRegisteredCSB + damagedRainfedRegisteredSG + damagedRainfedRegisteredMTD + damagedRainfedRegisteredOthers;
            damaged.setAttribute36(String.valueOf(damagedRainfedRegisteredTotal));

            damaged.setAttribute37(String.valueOf(damagedRainfedCertifiedRehab));
            damaged.setAttribute38(String.valueOf(damagedRainfedCertified3rd));
            damaged.setAttribute39(String.valueOf(damagedRainfedCertifiedMLGU));
            damaged.setAttribute40(String.valueOf(damagedRainfedCertifiedDirect));
            damaged.setAttribute41(String.valueOf(damagedRainfedCertifiedOthers));

            damagedRainfedCertifiedTotal = damagedRainfedCertifiedRehab + damagedRainfedCertified3rd + damagedRainfedCertifiedMLGU + damagedRainfedCertifiedDirect + damagedRainfedCertifiedOthers;
            damaged.setAttribute42(String.valueOf(damagedRainfedCertifiedTotal));

            damaged.setAttribute43(String.valueOf(damagedRainfedGoodHQSCSB));
            damaged.setAttribute44(String.valueOf(damagedRainfedGoodHQSUntagged));
            damaged.setAttribute45(String.valueOf(damagedRainfedGoodFHSS));
            damaged.setAttribute46(String.valueOf(damagedRainfedGoodGSR));

            damagedRainfedGoodTotal = damagedRainfedGoodHQSCSB + damagedRainfedGoodHQSUntagged + damagedRainfedGoodFHSS + damagedRainfedGoodGSR;
            damaged.setAttribute47(String.valueOf(damagedRainfedGoodTotal));
            
            damaged.setAttribute48(String.valueOf(damagedRainfedUpland));
            damagedRainfedTotal = damagedRainfedRegisteredTotal + damagedRainfedCertifiedTotal + damagedRainfedGoodTotal + damagedRainfedHybridTotal;
            damaged.setAttribute49(String.valueOf(damagedRainfedTotal));
            
            //damaged total
            damagedTotalHybridHYTAProgram = damagedIrrigatedHybridHYTAProgram + damagedRainfedHybridHYTAProgram;
            damaged.setAttribute50(String.valueOf(damagedTotalHybridHYTAProgram));
            damagedTotalHybridHYTADemo = damagedIrrigatedHybridHYTADemo + damagedRainfedHybridHYTADemo;
            damaged.setAttribute51(String.valueOf(damagedTotalHybridHYTADemo));
            damagedTotalHybridDirect = damagedIrrigatedHybridDirect + damagedRainfedHybridDirect;
            damaged.setAttribute52(String.valueOf(damagedTotalHybridDirect));
            damagedTotalHybridMTD = damagedIrrigatedHybridMTD + damagedRainfedHybridMTD;
            damaged.setAttribute53(String.valueOf(damagedTotalHybridMTD));
            damagedTotalHybridPLGU = damagedIrrigatedHybridPLGU + damagedRainfedHybridPLGU;
            damaged.setAttribute54(String.valueOf(damagedTotalHybridPLGU));

            damagedTotalHybridTotal = damagedTotalHybridHYTAProgram + damagedTotalHybridHYTADemo + damagedTotalHybridDirect + damagedTotalHybridMTD + damagedTotalHybridPLGU;
            damaged.setAttribute55(String.valueOf(damagedTotalHybridTotal));

            damagedTotalRegisteredCSB = damagedIrrigatedRegisteredCSB + damagedRainfedRegisteredCSB;
            damaged.setAttribute56(String.valueOf(damagedTotalRegisteredCSB));
            damagedTotalRegisteredSG = damagedIrrigatedRegisteredSG + damagedRainfedRegisteredSG;
            damaged.setAttribute57(String.valueOf(damagedTotalRegisteredSG));
            damagedTotalRegisteredMTD = damagedIrrigatedRegisteredMTD + damagedRainfedRegisteredMTD;
            damaged.setAttribute58(String.valueOf(damagedTotalRegisteredMTD));
            damagedTotalRegisteredOthers = damagedIrrigatedRegisteredOthers + damagedRainfedRegisteredOthers;
            damaged.setAttribute59(String.valueOf(damagedTotalRegisteredOthers));

            damagedTotalRegisteredTotal = damagedTotalRegisteredCSB + damagedTotalRegisteredSG + damagedTotalRegisteredMTD + damagedTotalRegisteredOthers;
            damaged.setAttribute60(String.valueOf(damagedTotalRegisteredTotal));

            damagedTotalCertifiedRehab = damagedIrrigatedCertifiedRehab + damagedRainfedCertifiedRehab;
            damaged.setAttribute61(String.valueOf(damagedTotalCertifiedRehab));
            damagedTotalCertified3rd = damagedIrrigatedCertified3rd + damagedRainfedCertified3rd;
            damaged.setAttribute62(String.valueOf(damagedTotalCertified3rd));
            damagedTotalCertifiedMLGU = damagedIrrigatedCertifiedMLGU + damagedRainfedCertifiedMLGU;
            damaged.setAttribute63(String.valueOf(damagedTotalCertifiedMLGU));
            damagedTotalCertifiedDirect = damagedIrrigatedCertifiedDirect + damagedRainfedCertifiedDirect;
            damaged.setAttribute64(String.valueOf(damagedTotalCertifiedDirect));
            damagedTotalCertifiedOthers = damagedIrrigatedCertifiedOthers + damagedRainfedCertifiedOthers;
            damaged.setAttribute65(String.valueOf(damagedTotalCertifiedOthers));

            damagedTotalCertifiedTotal = damagedTotalCertifiedRehab + damagedTotalCertified3rd + damagedTotalCertifiedMLGU + damagedTotalCertifiedDirect + damagedTotalCertifiedOthers;
            damaged.setAttribute66(String.valueOf(damagedTotalCertifiedTotal));

            damagedTotalGoodHQSCSB = damagedIrrigatedGoodHQSCSB + damagedRainfedGoodHQSCSB;
            damaged.setAttribute67(String.valueOf(damagedTotalGoodHQSCSB));
            damagedTotalGoodHQSUntagged = damagedIrrigatedGoodHQSUntagged + damagedRainfedGoodHQSUntagged;
            damaged.setAttribute68(String.valueOf(damagedTotalGoodHQSUntagged));
            damagedTotalGoodFHSS = damagedIrrigatedGoodFHSS + damagedRainfedGoodFHSS;
            damaged.setAttribute69(String.valueOf(damagedTotalGoodFHSS));
            damagedTotalGoodGSR = damagedIrrigatedGoodGSR + damagedRainfedGoodGSR;
            damaged.setAttribute70(String.valueOf(damagedTotalGoodGSR));

            damagedTotalGoodTotal = damagedTotalGoodHQSCSB + damagedTotalGoodHQSUntagged + damagedTotalGoodFHSS + damagedTotalGoodGSR;
            damaged.setAttribute71(String.valueOf(damagedTotalGoodTotal));
            
            damagedTotalUpland = damagedIrrigatedUpland + damagedRainfedUpland;
            damaged.setAttribute72(String.valueOf(damagedTotalUpland));
            damagedTotalTotal = damagedTotalRegisteredTotal + damagedTotalCertifiedTotal + damagedTotalGoodTotal + damagedTotalHybridTotal;
            damaged.setAttribute73(String.valueOf(damagedTotalTotal));

            planteds.add(planted);
            harvesteds.add(harvested);
            damageds.add(damaged);
        }
        
        session.setAttribute("planted", planteds);
        session.setAttribute("harvested", harvesteds);
        session.setAttribute("damaged", damageds);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pao/reports.jsp");
        rd.forward(request, response);
    }
}
