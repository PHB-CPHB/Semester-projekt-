package PressentationLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DataAccessLayer.DBFacade;
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
 * @author philliphbrink
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    // Made by Tim corrected by Oliver
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        HttpSession session = request.getSession(true);
        /*session.setAttribute("database", DBFacade.getInstance());
         session.setAttribute("Controller", Controller.getCon());
         Controller con = (Controller) session.getAttribute("Controller");
         String user = request.getParameter("username");
         String password = request.getParameter("password");
         //check if username and password maches.
         //Made by Tim
         if (con.validate(user, password) == true) {
         Customer LoggedInCustomer = con.requestAccess(user, password);
         if (LoggedInCustomer.getUser_role().equals("admin")) {
         session.setAttribute("LoggedInCustomer", LoggedInCustomer);
         forward(request, response, "/AdminLoggedIn.jsp");
         } else if (LoggedInCustomer.getUser_role().equals("customer")) {
         session.setAttribute("LoggedInCustomer", LoggedInCustomer);
         forward(request, response, "/CustomerLoggedIn.jsp");
         } else {
         forward(request, response, "/Login.jsp");
         }
                    
         } else {
         forward(request, response, "/Login.jsp");
         }
                
         forward(request, response, "/Login.jsp");
         */
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
        session.setAttribute("database", DBFacade.getInstance());
        session.setAttribute("Controller", Controller.getCon());
        Controller con = (Controller) session.getAttribute("Controller");
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        //check if username and password maches.
        //Made by Tim
        if (con.validate(user, password) == true) {
            Customer LoggedInCustomer = con.requestAccess(user, password);
            if (LoggedInCustomer.getUser_role().equals("admin")) {
                session.setAttribute("LoggedInCustomer", LoggedInCustomer);
                forward(request, response, "/AdminLoggedIn.jsp");
            } else if (LoggedInCustomer.getUser_role().equals("customer")) {
                session.setAttribute("LoggedInCustomer", LoggedInCustomer);
                forward(request, response, "/CustomerLoggedIn.jsp");
            } else {
                String Message = "You have entered a wrong password";
                request.setAttribute("Message", Message);
                forward(request, response, "/Login.jsp");
            }

        } else {
            String Message = "Please enter a correct Password and Username";
            request.setAttribute("Message", Message);
            forward(request, response, "/Login.jsp");
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
