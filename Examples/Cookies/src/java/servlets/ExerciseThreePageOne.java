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
import utils.CookieUtils;

/**
 *
 * @author isaac
 */
@WebServlet(name = "ExerciseThreePageOne", urlPatterns = {"/ExerciseThreePageOne"})
public class ExerciseThreePageOne extends HttpServlet {

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
            String bgColor = CookieUtils.getCookieValue(request, "bgColor", "white");
            String textColor = CookieUtils.getCookieValue(request, "textColor", "black");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String docType =
            "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
            "Transitional//EN\">\n";
                out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>Color page one</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"" + bgColor +
                   "\" TEXT=\"" + textColor + "\">\n" +
                "<H1>Color page one</H1>\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"
                           + "Proin faucibus aliquet lobortis. Mauris fermentum tristique purus ut tempus.\n"
                           + "Curabitur euismod odio congue, tincidunt risus in, vehicula ligula.\n"
                           + "Morbi ornare ante id enim euismod, in hendrerit odio tempus.\n"
                           + "Quisque lectus dui, scelerisque ac nibh ut, eleifend ultricies eros. Aliquam erat volutpat.\n"
                           + "Quisque sodales suscipit commodo. Sed tincidunt diam quam, non suscipit dui vestibulum ac.\n"
                           + "Quisque semper semper lorem, eu viverra ante pellentesque sit amet.\n"
                           + "Mauris ante dolor, rhoncus eget aliquam ac, accumsan eu libero.\n"
                           + "Nam nunc leo, volutpat non nibh at, sodales commodo eros.\n"
                           + "Vestibulum tellus eros, suscipit vitae arcu quis, malesuada cursus dolor.\n"
                           + "Sed sodales dui mi, vitae tincidunt diam placerat vitae.<br><br>" +
                "<A HREF=\"color-custom.html\">Color customization here</A>" +
                "</BODY></HTML>");
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
