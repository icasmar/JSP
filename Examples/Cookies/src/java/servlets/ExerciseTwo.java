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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CookieUtils;

@WebServlet(name = "ExerciseTwo", urlPatterns = {"/ExerciseTwo"})
public class ExerciseTwo extends HttpServlet {

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
            String firstName =
                checkVal(request.getParameter("firstName"),
                CookieUtils.getCookieValue(request, "firstName", null),
                "Unknown first name");
            String lastName =
                checkVal(request.getParameter("lastName"),
                CookieUtils.getCookieValue(request, "lastName", null),
                "Unknown last name");
            String emailAddress =
                checkVal(request.getParameter("emailAddress"),
                CookieUtils.getCookieValue(request, "emailAddress", null),
                "Unknown email address");
            Cookie c1 = new Cookie("firstName", firstName);
            c1.setMaxAge(60*60*24*365);
            response.addCookie(c1);
            Cookie c2 = new Cookie("lastName", lastName);
            c2.setMaxAge(60*60*24*365);
            response.addCookie(c2);
            Cookie c3 = new Cookie("emailAddress", emailAddress);
            c3.setMaxAge(60*60*24*365);
            response.addCookie(c3);
            PrintWriter out = response.getWriter();
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
                out.println(docType +
                    "<HTML>\n" +
                    "<HEAD><TITLE>Register form</TITLE></HEAD>\n" +
                    "<BODY>\n" +
                    "<H1>Register form</H1>\n" +
                    "<P>First Name: " + firstName + "</P>" +
                    "<P>Last Name: " + lastName + "</P>" +
                    "<P>Email address: " + emailAddress + "</P>" +
                    "</BODY></HTML>");
    }
    
    private String checkVal(String orig, String cookieVal,String replacement) {
        if ((orig != null) && (!orig.equals(""))) {
            return(orig);
        }
        else if (cookieVal != null) {
            return(cookieVal);
        }
        else {
            return("<FONT COLOR=RED><B>" + replacement + "</B></FONT>");
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
