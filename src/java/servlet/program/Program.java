/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.program;

import dao.program.ProgramDAO;
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
import servlet.BaseServlet;

/**
 *
 * @author RubySenpaii
 */
public class Program extends BaseServlet {

    @Override
    protected void servletAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ServletContext context = getServletContext();
            
            //going to programlist.jsp
            getProgramList(request, response, session, context);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getProgramList(HttpServletRequest request, HttpServletResponse response, HttpSession session, ServletContext context)
            throws ServletException, IOException {
        ProgramDAO pdao = new ProgramDAO();
        
        ArrayList<objects.program.Program> programs = pdao.getPrograms();
        
        session.setAttribute("programs", programs);
        
        RequestDispatcher rd = context.getRequestDispatcher("/web/pages-programs/programlist.jsp");
        rd.forward(request, response);
    }
}
