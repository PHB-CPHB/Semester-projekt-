/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PressentationLayer;

import DataAccessLayer.DBConnector;
import DataAccessLayer.PolygonDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ejer
 */
@WebServlet(name = "AddBuildingController", urlPatterns = {"/AddBuildingController"})
public class AddBuildingController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DBConnector.getConnection();
            HttpSession session = request.getSession(true);
            PolygonDatabase Data = (PolygonDatabase) session.getAttribute("database");
            ResultSet rs = null;
            Statement statement = null;
            Connection connection = null;
            String nextJSP = null;
            String doThis = request.getParameter("doThis");
            doThis = doThis.toLowerCase();
            statement = connection.createStatement();
            String building_name = (String) request.getParameter("name");
            String building_adress = (String) request.getParameter("adress");
            String building_zipcode = (String) request.getParameter("zipcode");
            String building_parcelno = (String) request.getParameter("parcel");
            String building_city = (String) request.getParameter("city");
            String building_size = (String) request.getParameter("size");
            String building_year = (String) request.getParameter("year");
            String building_type = (String) request.getParameter("type");
            switch (doThis) {
                case "add":
                    //inserts into database!
                    if ("zipcode".equals(building_zipcode) && "adress".equals(building_adress) && "parcel".equals(building_parcelno)) {
                        nextJSP = "Cusadd.jsp";
                    } else {
                        
                        nextJSP = "CustomerBuildings.jsp";
                    }
                    response.sendRedirect(nextJSP);
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddBuildingController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddBuildingController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
