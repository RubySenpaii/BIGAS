/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.ajax;

import com.google.gson.Gson;
import dao.EmployeeDAO;
import dao.MunicipalityDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objects.Employee;
import objects.Municipality;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RubySenpaii
 */
public class PAOProgramProdAutoComplete extends HttpServlet {

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
        ArrayList<Municipality> municipalities = new MunicipalityDAO().getListOfMunicipalities();

        String municipalityName = request.getParameter("municipalityName");
        System.out.println("municipality name retrieved: " + municipalityName);
        if (municipalityName.equals("search")) {
            ArrayList<String> municipalityNames = new ArrayList<>();
            for (int a = 0; a < municipalities.size(); a++) {
                municipalityNames.add(municipalities.get(a).getMunicipalityName());
            }

            Gson gson = new Gson();
            String json = gson.toJson(municipalityNames);
            System.out.println("number of municipalities found with keyword: " + municipalityNames.size());

            response.getWriter().write("{\"suggestions\":" + json + "}");
        } else {
            ArrayList<String> employeeNames = new ArrayList<>();
            ArrayList<Employee> employees = new EmployeeDAO().getListOfEmployeeOfMunicipal(municipalityName);
            for (int a = 0; a < employees.size(); a++) {
                employeeNames.add(employees.get(a).getLastName() + ", " + employees.get(a).getFirstName());
            }

            Gson gson = new Gson();
            String json = gson.toJson(employeeNames);
            System.out.println("number of employees found in municipality: " + employeeNames.size());

            response.getWriter().write("{\"suggestions\":" + json + "}");
        }
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
