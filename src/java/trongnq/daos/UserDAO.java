/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trongnq.define.Define;
import trongnq.utils.DBUtilities;

/**
 *
 * @author Quoc
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public UserDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String getUserRoleNameByRoleID(int roleID) throws Exception {
        String userRoleName = "";
        String sql = "SELECT [role].[rolename]"
                + " FROM [role]"
                + " WHERE [role].[userroleid] = ?";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roleID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                userRoleName = rs.getString("rolename");
            }
        } finally {
            closeConnection();
        }
        return userRoleName;
    }

    public int getUserRoleByLogin(String userID, String userPassword) throws Exception {
        int userRole = Define.FAILED_LOGIN;
        String sql = "SELECT [user].[userroleid]"
                + " FROM [user]"
                + " WHERE [user].[userid] = ? AND [user].[userpassword] = ?";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, userPassword);
            rs = preStm.executeQuery();
            if (rs.next()) {
                userRole = rs.getInt("userroleid");
            }
        } finally {
            closeConnection();
        }
        return userRole;
    }

    public boolean insertANewUser(String userID, String userPassword, int userStatus, String userPhone,
            int userRole, String userName, String userAddress, String userCreateDate) throws Exception {
        boolean result = false;
        String sql = "INSERT INTO [user] ([user].[userid], [user].[userpassword], [user].[userstatus], "
                + "[user].[userphone], [user].[userroleid], [user].[username], [user].[useraddress],"
                + "[user].[usercreatedate]) VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, userPassword);
            preStm.setInt(3, userStatus);
            preStm.setString(4, userPhone);
            preStm.setInt(5, userRole);
            preStm.setString(6, userName);
            preStm.setString(7, userAddress);
            preStm.setString(8, userCreateDate);
            preStm.execute();
            result = true;
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkIfUserIDIsExisted(String userID) throws Exception {
        boolean result = false;
        String sql = "SELECT [user].[userid]"
                + " FROM [user]"
                + " WHERE [user].[userid] = ?";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
