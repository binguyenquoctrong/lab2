/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongnq.daos.RoomDAO;
import trongnq.define.Define;
import trongnq.dtos.RoomDTO;

/**
 *
 * @author Quoc
 */
public class SearchRoomController extends HttpServlet {

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
        String url = Define.INDEX_PAGE;
        HttpSession session = request.getSession();
        try {
            String checkInDate = request.getParameter("txtCheckInDate");
            String checkOutDate = request.getParameter("txtCheckOutDate");
            RoomDAO roomDAO = new RoomDAO();
            // ArrayList<RoomDTO> searchRoomInfoList = roomDAO.searchRoomBySearchValues(checkInDate, checkOutDate);
            ArrayList<RoomDTO> searchRoomInfoList = roomDAO.displayAllRoom();
            session.setAttribute("SEARCH_ROOM_INFO_LIST", searchRoomInfoList);
        } catch (Exception e) {
            request.setAttribute("ERROR", "ERROR at SearchRoomController: " + e.getMessage());
            url = Define.ERROR_PAGE;
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
