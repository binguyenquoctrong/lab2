/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.dtos;

import java.io.Serializable;
import trongnq.daos.UserDAO;

/**
 *
 * @author Quoc
 */
public class UserDTO implements Serializable {

    private String userID;
    private int userRoleID;

    public UserDTO() {
    }

    public UserDTO(String userID, int userRoleID) {
        this.userID = userID;
        this.userRoleID = userRoleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUserRoleName() throws Exception {
        UserDAO userDao = new UserDAO();
        return userDao.getUserRoleNameByRoleID(userRoleID);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", userRoleID=" + userRoleID + '}';
    }
}
