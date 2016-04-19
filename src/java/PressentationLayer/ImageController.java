/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PressentationLayer;

import DataAccessLayer.DBConnector;
import ServiceLayer.Controller;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Floor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "ImageController", urlPatterns = {"/ImageController"})
@MultipartConfig
public class ImageController extends HttpServlet {

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
                System.out.println("0");
            InputStream photoStream = getPhotos();

            // Prepare streams.
            BufferedInputStream input = null;
            BufferedOutputStream output = null;
            System.out.println("1");
            try {
                System.out.println("2");
                // Open streams
                input = new BufferedInputStream(photoStream, 16177215);

                response.setContentType("image/jpeg");

                output = new BufferedOutputStream(response.getOutputStream(),
                        16177215);
                System.out.println("3");
                // Write file contents to response.
                byte[] buffer = new byte[16177215];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }

            } finally {
                output.close();
                input.close();
            }

            //Redirect it to profile page
            
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
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
        String do_this = request.getParameter("do_this");
        HttpSession session = request.getSession(true);
        Controller con = (Controller) session.getAttribute("Controller");
     //   Floor floor = new Floor;
       // switch (do_this) {
         //   case "set image":
                Part filePart = request.getPart("file");
                InputStream inputstream = filePart.getInputStream();
                con.setImage(inputstream);
                forward(request, response, "/AdminBuildings.jsp");
           // case "get image":
             //   request.getParameter(Floor.getFloor_building_id());
               // request.getParameter(Floor.getFloor_number());
        
        
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
