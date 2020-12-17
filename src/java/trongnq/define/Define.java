/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.define;

/**
 *
 * @author Quoc
 */
public class Define {

    //JSP pages
    public static final String INDEX_PAGE = "index.jsp";
    public static final String ERROR_PAGE = "error.jsp";
    public static final String CREATE_USER_PAGE = "createuser.jsp";
    //Login status
    public static final int FAILED_LOGIN = -1;

    //User role
    public static final int ADMIN = 0;
    public static final int USER = 1;

    //User Status //Room Status
    public static final int ACTIVE = 1;
    public static final int DEACTIVE_ = 0;
    
    //Google login
    public static String GOOGLE_CLIENT_ID = "762410788550-qbbaujc9sec370sntc17phr9aq5utf1t.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "ClJdMVp1Q1ibvjVKyfruMYCB";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8085/L.P00002/loginGoogle";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
