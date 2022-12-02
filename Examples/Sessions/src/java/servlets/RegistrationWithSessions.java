/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "RegistrationWithSessions", urlPatterns = {"/Registration"})
public class RegistrationWithSessions extends HttpServlet {

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
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        synchronized(session) {
            String firstName =
                check(request.getParameter("firstName"),
                    session.getAttribute("firstName"));
            String lastName =
                check(request.getParameter("lastName"),
                    session.getAttribute("lastName"));
            String emailAddress =
                check(request.getParameter("emailAddress"),
                    session.getAttribute("emailAddress"));
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("emailAddress", emailAddress);
            PrintWriter out = response.getWriter();
            String title = "Registering with Sessions";
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
                out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY>\n" +
                  "<H1>" + title + "</H1>\n" +
                  "<UL>\n" +
                  "  <LI><B>First Name</B>: " +
                  firstName + "\n" +
                  "  <LI><B>Last Name</B>: " +
                  lastName + "\n" +
                  "  <LI><B>Email address</B>: " +
                  emailAddress + "\n" +
                  "</UL>\n" +
                  "</BODY></HTML>");
        }
    }
    
    // session.getAttribute() DEVUELVE UN OBJETO 
    // QUE PUEDE SER NULL SI NO ESTÁ INICIALIZADO
    private String check(String orig, Object sessionVal) {
        if ((orig != null) && (!orig.equals(""))) {
            return(orig);
        } else if (sessionVal != null) {
            return((String)sessionVal);
        } else {
            return("<P>None<P>");
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
