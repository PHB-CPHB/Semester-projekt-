/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PressentationLayer;

import ServiceLayer.Controller;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Floor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
    // Made by Michael edit by Phillip
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //Made by Michael corrected by Phillip
        HttpSession session = request.getSession(true);
        Controller con = (Controller) session.getAttribute("Controller");
        Customer c = (Customer) session.getAttribute("LoggedInCustomer");
        String do_this = request.getParameter("do_this");
        if (do_this == null) {
            if (c.getUser_role().equals("admin")) {
                forward(request, response, "/AdminLoggedIn.jsp");
            } else {
                forward(request, response, "/customerLoggedIn.jsp");
            }
            return;
        }

        // Made by Michael
        switch (do_this) {
            case "add":

                String building_name = request.getParameter("name");
                String building_adress = request.getParameter("address");
                String zipcode = request.getParameter("zipcode");
                int building_zipcode = Integer.parseInt(zipcode);
                String building_parcel_no = request.getParameter("parcel");
                String year = request.getParameter("year");
                int building_year = Integer.parseInt(year);
                String building_type = request.getParameter("type");
                //inserts into database!
                if ("zipcode".equals(building_zipcode) && "adress".equals(building_adress) && "parcel".equals(building_parcel_no)) {
                    forward(request, response, "/AddBuilding.jsp");
                } else {
                    con.addNewBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_parcel_no, c);
                    if (c.getUser_role().equals("admin")) {
                        forward(request, response, "/AdminBuilding.jsp");
                    } else {
                        forward(request, response, "/CustomerBuildings.jsp");
                    }
                }
            
            case "viewFloor":
                try {
                String buildingid = request.getParameter("floor");
                int building_id = Integer.parseInt(buildingid);
                Building building = new Building(building_id);
                session.setAttribute("building", building);
                if (c.getUser_role().equals("admin")) {
                    forward(request, response, "/AdminFloor.jsp");
                } else {
                    forward(request, response, "/CustomerFloor.jsp");
                }
                } catch (NullPointerException ex) {
                        System.out.println(ex);
                        }
            
            case "addNewFloor":
                forward(request, response, "/addFloor.jsp");
                //Knapperne virker ikke inde i Floor så orden dem find ud af fejl "PWC6117: File "null" not found"
                //Kig methoden add floor over og tal med Michael omkring raport. Derudover så lav interfaces til mapper og ryd op i koden.
            
            case "addFloor":
                Building building = (Building) session.getAttribute("building");
                String floor_s = (String) request.getParameter("floor_size");
                int floor_size = Integer.parseInt(floor_s);
                String floor_apartments = (String) request.getParameter("floor_apartments");
                String floor_rooms = (String) request.getParameter("floor_rooms");
                con.addFloor(building, floor_size, floor_apartments, floor_rooms);
            
            case "return":
                if (c.getUser_role().equals("admin")) {
                    forward(request, response, "/AdminBuildings.jsp");
                } else {
                    forward(request, response, "/CustomerBuildings.jsp");
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
