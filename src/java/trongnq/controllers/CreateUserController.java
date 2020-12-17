/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongnq.daos.UserDAO;
import trongnq.define.Define;

/**
 *
 * @author Quoc
 */
public class CreateUserController extends HttpServlet {

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
        String url = Define.CREATE_USER_PAGE;
        try {
            UserDAO userDao = new UserDAO();
            String newUserID = request.getParameter("txtNewUserID");
            String newUserPassword = request.getParameter("txtNewUserPassword");
            String newUserPhone = request.getParameter("txtNewUserPhone");
            String newUserName = request.getParameter("txtNewUserName");
            String newUserAddress = request.getParameter("txtNewUserAddress");
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String newUserCreateDate = dateFormat.format(cal.getTime());
            //Validation: ID( duplicate? )
            if (userDao.checkIfUserIDIsExisted(newUserID)) {
                request.setAttribute("INSERT_FAIL", "USER ID Already Register, Please choose another one!");
            } else {
                userDao.insertANewUser(newUserID, newUserPassword, Define.ACTIVE, newUserPhone, Define.USER,
                        newUserName, newUserAddress, newUserCreateDate);
                request.setAttribute("INSERT_SUCCESS", "Insert user (" + newUserID + ") successfully!");
            }
        } catch (Exception e) {
            url = Define.ERROR_PAGE;
            request.setAttribute("ERROR", "ERROR at CreateUserController: " + e.getMessage());
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
