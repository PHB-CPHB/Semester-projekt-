/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PressentationLayer;

import DataAccessLayer.DBFacade;
import ServiceLayer.Controller;
import ServiceLayer.Entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author philliphbrink
 */
@WebServlet(name = "DeleteBuildingController", urlPatterns = {"/DeleteBuildingController"})
public class DeleteBuildingController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
    
    // Made by Michael
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession(true);
        Controller con = (Controller) session.getAttribute("Controller");

        String do_this = request.getParameter("do_this");
        if (do_this == null) {
            forward(request, response, "/customerLoggedIn.jsp");
            return;
        }
        switch (do_this) {
            case "delete":
                String building_id_name = request.getParameter("deletebuilding");
                int building_id = Integer.parseInt(building_id_name);
                con.deleteBuilding(building_id);
                forward(request, response, "/DeleteBuilding.jsp");
            case "report":
                forward(request,response,"/Report.jsp");
                break;
                //Made by Tim
            case "Return":
                Customer LoggedIn = (Customer) session.getAttribute("LoggedInCustomer");
                if(LoggedIn.getUser_role().equals("customer")){
                    forward(request, response, "/CustomerLoggedIn.jsp");
                }else if(LoggedIn.getUser_role().equals("admin")){
                    forward(request,response,"/AdminLoggedIn.jsp");
                }
                break;
            case "Request":
                con.requestCheckUp();
                forward(request,response, "/DeketeBuilding.jsp");
                
                
          /*  case "addBuilding":   
                forward(request, response, "/AddBuilding.jsp");*/


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

    private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
