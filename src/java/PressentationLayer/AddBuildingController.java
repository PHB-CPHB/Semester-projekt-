/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PressentationLayer;

import DataAccessLayer.DBConnector;
import DataAccessLayer.DBFacade;
import DataAccessLayer.PolygonDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
       /* try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddBuildingController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
            //processRequest(request, response);
        HttpSession session = request.getSession(true);
            DBFacade DBF = (DBFacade) session.getAttribute("database");
            String username = (String) session.getAttribute("username");
            String do_this = request.getParameter("do_this");
            String building_name = request.getParameter("name");
            String building_adress = request.getParameter("address");
            String zipcode = request.getParameter("zipcode");
            int building_zipcode = Integer.parseInt(zipcode);
            String building_parcelno = request.getParameter("parcel");
            String areasize = request.getParameter("size");
            int building_areasize = Integer.parseInt(areasize);
            String year = request.getParameter("year");
            int building_year = Integer.parseInt(year);
            String building_type = request.getParameter("type");
            String building_floor = request.getParameter("floor");
            if (do_this == null) {
            forward(request, response, "/customerLoggedIn.jsp");
            return;
            }
            switch (do_this) {
                case "add":
                    //inserts into database!
                    if ("zipcode".equals(building_zipcode) && "adress".equals(building_adress) && "parcel".equals(building_parcelno)) {
                        forward(request, response, "/AddBuilding.jsp");
                    } else {
                        DBF.addBuilding(building_name, building_type, building_adress, building_floor, building_type, building_type, building_adress, building_parcelno, building_floor);
                        forward(request, response, "/DeleteBuilding.jsp");
                    }
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

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}
