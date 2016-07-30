/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.database;

import dao.DatabaseDAO;
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
import objects.people.Farmer;
import servlet.BaseServlet;

/**
 *
 * @author RubySenpaii
 */
public class FarmerList extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();
            
            //going to farmerlst.jsp
            getFarmerList(request, response, session, context);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(FarmerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getFarmerList(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        DatabaseDAO dbdao = new DatabaseDAO();
        ArrayList<GenericObject> farmers = dbdao.getFarmersForJSP();

        session.setAttribute("farmers", farmers);

        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-database/farmerlist.jsp");
        rd.forward(request, response);
    }
}