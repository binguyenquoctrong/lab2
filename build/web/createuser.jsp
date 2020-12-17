<%-- 
    Document   : createuser
    Created on : Dec 16, 2020, 11:45:44 AM
    Author     : Quoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/login.css" type="text/css" >
        <title>Create Account</title>
    </head>
    <body>

        <div class="signup">
            <div class="signup-connect">
                <h1>Create your account</h1>
                <a href="#" class="btn btn-social btn-facebook"><i class="fa fa-facebook"></i> Log in  with Facebook</a>
                <a href="#" class="btn btn-social btn-twitter"><i class="fa fa-twitter"></i> Log in  with Twitter</a>
                <a href="#" class="btn btn-social btn-google"><i class="fa fa-google"></i> Log in with Google</a>
                <a href="#" class="btn btn-social btn-linkedin"><i class="fa fa-linkedin"></i> Log in  with Linkedin</a>
            </div>
            <div class="signup-classic">

                <c:choose>
                    <c:when test="${empty sessionScope.USER_INFO}">
                        <h2>Or use the classical way</h2>
                        <form class="form" action="CreateUser" method="POST">
                            <fieldset class="username">
                                <input type="email" placeholder="username" name="txtNewUserID" pattern=".+@gmail.com" required/>
                            </fieldset>
                            <fieldset class="password">
                                <input type="password" placeholder="password" name="txtNewUserPassword" maxlength="50" required/>
                            </fieldset>
                            <fieldset class="email">
                                <input type="tel" placeholder="phone" maxlength="10" name="txtNewUserPhone" pattern="[0-9]{10}" >
                            </fieldset>
                            <fieldset class="email">
                                <input type="text" name="txtNewUserName" maxlength="50" placeholder="full name" />
                            </fieldset>
                            <fieldset class="email">
                                <input type="text" name="txtNewUserAddress" maxlength="50" placeholder="address" />
                            </fieldset>
                            <button type="submit" name="btnAction" value="Insert" class="btn"> Sign up</button>
                        </form>
                        <c:if test="${not empty INSERT_SUCCESS}">
                            <br/>
                            <font color="blue">${INSERT_SUCCESS}</font>
                            <br/>
                        </c:if>
                        <c:if test="${not empty INSERT_FAIL}">
                            <br/>
                            <font color="red">${INSERT_FAIL}</font>
                            <br/>
                        </c:if>
                        <a href="index.jsp"> Back to Index Page</a>
                    </c:when>
                    <c:otherwise>
                        <h1 style="color: red"> You Already Login </h1>
                        <a href="index.jsp"> Back to Index Page</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
