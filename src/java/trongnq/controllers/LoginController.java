/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongnq.daos.UserDAO;
import trongnq.define.Define;
import trongnq.dtos.UserDTO;

/**
 *
 * @author Quoc
 */
public class LoginController extends HttpServlet {

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
            String userID = request.getParameter("txtUserID");
            String userPassword = request.getParameter("txtUserPassword");
            UserDAO userDao = new UserDAO();
            int userRole = userDao.getUserRoleByLogin(userID, userPassword);
            if (userRole == Define.FAILED_LOGIN) {
                request.setAttribute("LOGIN_FAIL", "Your ID or Password is INVALID!");
            } else {
                UserDTO userInfo = new UserDTO(userID, userRole);
                session.setAttribute("USER_INFO", userInfo);
            }
        } catch (Exception e) {
            request.setAttribute("ERROR", "ERROR at LoginController: " + e.getMessage());
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
