/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.GenericObject;
import objects.reports.DamageIncident;

/**
 *
 * @author RubySenpaii
 */
public class MonitoringDAO {

    /**
     * retrieve custom municipal list for overview.jsp
     *
     * @return
     */
    public ArrayList<GenericObject> getMunicipalOverview() {
        ArrayList<GenericObject> objects = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT M.MunicipalityName, CS.Stage, SUM(SP.Area) AS 'Area', SUM(SS.Harvested) AS 'Harvested'\n"
                    + "FROM (SELECT MAX(SeedStage.DateUpdated) AS 'DateUpdated', SeedStage.PlantedID\n"
                    + "	      FROM SeedStage\n"
                    + "	      GROUP BY SeedStage.PlantedID) AS T1, \n"
                    + "       SeedStage SS JOIN Employee E ON SS.UpdatedBy = E.EmployeeID\n"
                    + "			JOIN CropStage CS ON CS.CropStageID = SS.CropStageID\n"
                    + "                 JOIN SeedPlanted SP ON SS.PlantedID = SP.PlantedID\n"
                    + "                 JOIN SeedVariety SV ON SP.SeedVarietyID = SV.SeedVarietyID\n"
                    + "                 JOIN Farm F ON SP.FarmID = F.FarmID\n"
                    + "                 JOIN Barangay B ON B.BarangayID = F.BarangayID\n"
                    + "                 JOIN Municipality M ON M.MunicipalityID = B.MunicipalityID\n"
                    + "                 JOIN Season S ON S.SeasonID = SP.SeasonID\n"
                    + "WHERE SS.DateUpdated = T1.DateUpdated AND SS.PlantedID = T1.PlantedID AND S.SeasonName = ? \n"
                    + "GROUP BY M.MunicipalityName, CS.Stage;");
            ps.setString(1, "Dry Season");

            int counter = 0;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (counter != 0 && objects.get(counter - 1).getAttribute1().equals(rs.getString("MunicipalityName"))) {
                    double areaPlanted = rs.getDouble("Area");

                    String pArea = objects.get(counter - 1).getAttribute2();
                    String ppMT = objects.get(counter - 1).getAttribute3();
                    String hArea = objects.get(counter - 1).getAttribute4();
                    String hpMT = objects.get(counter - 1).getAttribute5();

                    double plArea = Double.parseDouble(pArea.split(" ")[0]);
                    double pplMT = Double.parseDouble(ppMT.split(" ")[0]);
                    double haArea = Double.parseDouble(hArea.split(" ")[0]);
                    double hpaMT = Double.parseDouble(hpMT.split(" ")[0]);

                    double totalArea = 0, harvested = 0, projected = 0;
                    if (rs.getString("Stage").equals("Harvest")) {
                        totalArea = areaPlanted + haArea;
                        harvested = rs.getDouble("Harvested") + hpaMT;
                        objects.get(counter - 1).setAttribute4(totalArea + " ha");
                        objects.get(counter - 1).setAttribute5(harvested + " MT");
                    } else {
                        totalArea = areaPlanted + plArea;
                        projected = Math.round(areaPlanted * 2.5 * 0.91 * 100) / 100.0 + pplMT;
                        objects.get(counter - 1).setAttribute2(totalArea + " ha");
                        objects.get(counter - 1).setAttribute3(projected + " MT");
                    }

                    double estimated = projected + harvested;
                    objects.get(counter - 1).setAttribute6(estimated + " MT");
                    objects.get(counter - 1).setAttribute7(Math.round(totalArea * 2.2 * 100) / 100.0 + " MT");

                } else {
                    GenericObject object = new GenericObject();
                    object.setAttribute1(rs.getString("MunicipalityName"));

                    double areaPlanted = rs.getDouble("Area");
                    double projected = 0, harvested = 0;

                    if (rs.getString("Stage").equals("Harvest")) {
                        harvested = rs.getDouble("Harvested");
                        object.setAttribute2("0 ha");
                        object.setAttribute3("0 MT");
                        object.setAttribute4(areaPlanted + " ha");
                        object.setAttribute5(harvested + " MT");
                    } else {
                        projected = Math.round(areaPlanted * 2.5 * 0.91 * 100) / 100.0;
                        object.setAttribute2(areaPlanted + " ha");
                        object.setAttribute3(projected + " MT");
                        object.setAttribute4("0 ha");
                        object.setAttribute5("0 MT");
                    }

                    double estimated = projected + harvested;
                    object.setAttribute6(estimated + " MT");
                    object.setAttribute7(Math.round(areaPlanted * 2.2 * 100) / 100.0 + " MT");
                    objects.add(object);
                    counter++;
                }
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects;
    }

    public ArrayList<GenericObject> getBarangayOverview(String municipalName, int seasonID) {
        ArrayList<GenericObject> objects = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT SUM(SP.Area) AS 'Area', B.BarangayName, T1.Harvested\n"
                    + "FROM SeedPlanted SP JOIN Farm F ON SP.FarmID = F.FarmID\n"
                    + "			   JOIN Barangay B ON B.BarangayID = F.BarangayID\n"
                    + "                    JOIN Municipality M ON M.MunicipalityID = B.MunicipalityID, \n"
                    + "                    (SELECT PlantedID, SUM(Harvested) AS Harvested FROM SeedStage GROUP BY PlantedID) AS T1\n"
                    + "WHERE M.MunicipalityName = ? AND SP.SeasonID = ? AND T1.PlantedID = SP.PlantedID\n"
                    + "GROUP BY B.BarangayName");
            ps.setString(1, municipalName);
            ps.setInt(2, seasonID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GenericObject object = new GenericObject();
                object.setAttribute1(rs.getString("BarangayName"));
                double area = rs.getDouble("Area");
                object.setAttribute2(area + " ha");
                double production = rs.getDouble("Harvested");
                object.setAttribute3(production + " MT");
                int yield = (int) (production / area * 100);
                object.setAttribute4(yield + "%");
                objects.add(object);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects;
    }

    public ArrayList<GenericObject> getCropGrowthOfEachFarmer() {
        ArrayList<GenericObject> objects = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT FR.LastName, FR.FirstName, FR.MiddleName, SV.VarietyName, SS.CropStageID, SP.Area\n"
                    + "FROM (SELECT MAX(SeedStage.DateUpdated) AS 'DateUpdated', SeedStage.PlantedID\n"
                    + "		FROM SeedStage\n"
                    + "	GROUP BY SeedStage.PlantedID) AS T1, \n"
                    + "    SeedStage SS JOIN SeedPlanted SP ON SP.PlantedID = SS.PlantedID\n"
                    + "			JOIN Farm F ON F.FarmID = SP.FarmID\n"
                    + "                 JOIN Farmer FR ON F.FarmID = FR.FarmID\n"
                    + "                 JOIN SeedVariety SV ON SV.SeedVarietyID = SP.SeedVarietyID\n"
                    + "WHERE T1.PlantedID = SP.PlantedID AND T1.DateUpdated = SS.DateUpdated AND SP.SeasonID = 1");

            ResultSet rs = ps.executeQuery();
            int counter = 0;
            while (rs.next()) {

                String name = rs.getString("LastName") + ", " + rs.getString("FirstName") + " " + rs.getString("MiddleName");
                String variety = rs.getString("VarietyName");
                int stageID = rs.getInt("CropStageID");
                double area = rs.getDouble("Area");

                if (counter != 0 && objects.get(counter - 1).getAttribute1().equals(name) && objects.get(counter - 1).getAttribute2().equals(variety)) {
                    double value = 0;
                    if (stageID == 1) {
                        value = Double.parseDouble(objects.get(counter - 1).getAttribute3().split(" ")[0]);
                        value += area;
                        objects.get(counter - 1).setAttribute3(value + " ha");
                    } else if (stageID == 2) {
                        value = Double.parseDouble(objects.get(counter - 1).getAttribute4().split(" ")[0]);
                        value += area;
                        objects.get(counter - 1).setAttribute4(value + " ha");
                    } else if (stageID == 3) {
                        value = Double.parseDouble(objects.get(counter - 1).getAttribute5().split(" ")[0]);
                        value += area;
                        objects.get(counter - 1).setAttribute5(value + " ha");
                    } else if (stageID == 4) {
                        value = Double.parseDouble(objects.get(counter - 1).getAttribute6().split(" ")[0]);
                        value += area;
                        objects.get(counter - 1).setAttribute6(value + " ha");
                    } else {

                    }
                } else {
                    GenericObject object = new GenericObject();
                    object.setAttribute1(name);
                    object.setAttribute2(variety);
                    if (stageID == 1) {
                        object.setAttribute3(area + " ha");
                        object.setAttribute4("0 ha");
                        object.setAttribute5("0 ha");
                        object.setAttribute6("0 ha");
                    } else if (stageID == 2) {
                        object.setAttribute3("0 ha");
                        object.setAttribute4(area + " ha");
                        object.setAttribute5("0 ha");
                        object.setAttribute6("0 ha");
                    } else if (stageID == 3) {
                        object.setAttribute3("0 ha");
                        object.setAttribute4("0 ha");
                        object.setAttribute5(area + " ha");
                        object.setAttribute6("0 ha");
                    } else if (stageID == 4) {
                        object.setAttribute3("0 ha");
                        object.setAttribute4("0 ha");
                        object.setAttribute5("0 ha");
                        object.setAttribute6(area + " ha");
                    } else {

                    }
                    objects.add(object);
                    counter++;
                }
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects;
    }

    public ArrayList<GenericObject> getProductionOfFarmersInBarangay(String barangayName) {
        ArrayList<GenericObject> objects = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT FR.LastName, FR.FirstName, FR.MiddleName, SP.PlantedID, SV.VarietyName, SUM(SP.Area) AS 'Area', SUM(SS.Harvested) AS 'Harvested'\n"
                    + "FROM (SELECT MAX(SeedStage.DateUpdated) AS 'DateUpdated', SeedStage.PlantedID\n"
                    + "		FROM SeedStage\n"
                    + "        GROUP BY SeedStage.PlantedID) AS T1, \n"
                    + "    Farmer FR JOIN Farm F ON F.FarmID = FR.FarmID\n"
                    + "              JOIN SeedPlanted SP ON SP.FarmID = F.FarmID\n"
                    + "              JOIN SeedVariety SV ON SP.SeedVarietyID = SV.SeedVarietyID\n"
                    + "              JOIN SeedStage SS ON SS.PlantedID = SP.PlantedID\n"
                    + "              JOIN Barangay B ON B.BarangayID = F.BarangayID\n"
                    + "WHERE T1.PlantedID = SP.PlantedID AND T1.DateUpdated = SS.DateUpdated AND B.BarangayName = ?\n"
                    + "GROUP BY FR.LastName, FR.FirstName, FR.MiddleName, SP.PlantedID, SV.VarietyName;");
            ps.setString(1, barangayName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GenericObject object = new GenericObject();
                String name = rs.getString("LastName") + ", " + rs.getString("FirstName") + " " + rs.getString("MiddleName");
                object.setAttribute1(name);
                object.setAttribute2(rs.getInt("PlantedID") + "");
                object.setAttribute3(rs.getString("VarietyName"));
                object.setAttribute4(rs.getDouble("Area") + "");
                object.setAttribute5(rs.getDouble("Harvested") + "");
                objects.add(object);
            }

            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects;
    }
    
    public ArrayList<DamageIncident> getIncidentsOf(int plantedID) {
        ArrayList<DamageIncident> incidents = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM DamageIncident WHERE = ?");
            ps.setInt(1, plantedID);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DamageIncident incident = new DamageIncident();
                incident.setPlantedID(plantedID);
                incident.setIncidentID(rs.getInt("IncidentID"));
                incident.setDamageID(rs.getInt("DamageID"));
                incident.setAreaAffected(rs.getDouble("AreaAffected"));
                incident.setImage(rs.getString("Image"));
                incident.setRemarks(rs.getString("Remarks"));
                incident.setDate(rs.getString("Date"));
                incident.setHandledBy(rs.getInt("HandledBy"));
                incidents.add(incident);
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return incidents;
    }
    
    public ArrayList<GenericObject> getProgramsForBarangay(String barangay) {
        ArrayList<GenericObject> objects = new ArrayList<>();
        try {
            DBConnectionFactory db = DBConnectionFactory.getInstance();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                
            }
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects;
    }
}
