/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.SimpleItem;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ShowItem", urlPatterns = {"/ShowItem"})
public class ShowItem extends HttpServlet {

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
        HttpSession session = request.getSession();
        synchronized(session) {
            @SuppressWarnings("unchecked")
            List<SimpleItem> previousItems =
            (List<SimpleItem>)session.getAttribute("previousItems");
            if (previousItems == null) {
                previousItems = new ArrayList<SimpleItem>();
            }
            String itemName = request.getParameter("itemName");
            if ((itemName != null) && (!itemName.trim().equals(""))) {
                SimpleItem item = findItem(itemName, previousItems);
                if (item != null) {
                    item.incrementItemCount();
                } else {
                    item = new SimpleItem(itemName);
                    previousItems.add(item);
                }
            }
            session.setAttribute("previousItems", previousItems);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String title = "Items Purchased";
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
                    out.println(docType +
                    "<HTML>\n" +
                    "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                    "<H1>" + title + "</H1>");
            if (previousItems.size() == 0) {
                out.println("<I>No items</I>");
            } else {
                out.println("<UL>");
                for(SimpleItem item: previousItems) {
                    out.println("  <LI>" + item);
                }
            out.println("</UL>");
            }
        out.println("</BODY></HTML>");
        }
    }
    
    private SimpleItem findItem(String itemName,
                              List<SimpleItem> previousItems) {
        for(SimpleItem item: previousItems) {
            if (item.getItemName().equals(itemName)) {
                return(item);
            }
        }
        return(null);
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
