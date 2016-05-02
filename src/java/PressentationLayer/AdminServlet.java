/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PressentationLayer;

import ServiceLayer.Controller;
import ServiceLayer.Entity.Customer;
import java.io.IOException;
import java.sql.SQLException;
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
 * @author Oliver
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
         HttpSession session = request.getSession(true);
        /* Controller con = (Controller) session.getAttribute("Controller");

         String do_this = request.getParameter("do_this");
         if (do_this == null) {
         forward(request, response, "/AllUsers.jsp");
         return;
         }
         switch (do_this) {
         // Made by Michael
         case "deleteUser":
         //                String username = (String) session.getAttribute("username");
         //                
         //                String building_firm_name = request.getParameter("deletebuilding");
         //                String building_firm = request.getParameter(building_firm_name);
         //                DBF.deleteAllBuildings(building_firm);
         String user_id_name = request.getParameter("RemoveCustomer");
         int user_id = Integer.parseInt(user_id_name);
         String username = (String) session.getAttribute("username");
         con.deleteCustomer(username, user_id);
         forward(request, response, "/AllUsers.jsp");
         break;
         // Made by Oliver
         case "createUser":
         String uName = request.getParameter("username");
         String uPwd = request.getParameter("password");
         String uFirm = request.getParameter("user_firm");
         String uRole = request.getParameter("role");
         con.createCustomer(uName, uPwd, uRole, uFirm);
         forward(request, response, "/AllUsers.jsp");
         case "return":
         forward(request, response, "/AdminLoggedIn.jsp");
         break;
         case "logout":
         session.invalidate();
         forward(request,response,"/Login.jsp");
         break;
         }*/
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        HttpSession session = request.getSession(true);
        Controller con = (Controller) session.getAttribute("Controller");
        Customer c = (Customer) session.getAttribute("CustomerLoggedIn");
        String do_this = request.getParameter("do_this");
        if (do_this == null) {
            forward(request, response, "/AllUsers.jsp");
            return;
        }
        switch (do_this) {
            // Made by Michael
            // Deletes the user 
            case "deleteUser":
//                String username = (String) session.getAttribute("username");
//                
//                String building_firm_name = request.getParameter("deletebuilding");
//                String building_firm = request.getParameter(building_firm_name);
//                DBF.deleteAllBuildings(building_firm);
                String user_id_name = request.getParameter("RemoveCustomer");
                int user_id = Integer.parseInt(user_id_name);
                String username = (String) session.getAttribute("username");
                con.deleteCustomer(username, user_id);
                forward(request, response, "/AllUsers.jsp");
                break;
            // Made by Oliver
            //Creates user
            case "createUser":
                String uName = request.getParameter("username");
                String uPwd = request.getParameter("password");
                String uFirm = request.getParameter("user_firm");
                String uRole = request.getParameter("role");
                con.createCustomer(uName, uPwd, uRole, uFirm);
                forward(request, response, "/AllUsers.jsp");
                break;
            //Returns back to main menu
            case "return":
                forward(request, response, "/AdminLoggedIn.jsp");
                break;
            //Closes the session and returns the user back to login
            case "logout":
                session.invalidate();
                forward(request, response, "/Login.jsp");
                break;
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
