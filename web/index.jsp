<%-- 
    Document   : index
    Created on : Dec 16, 2020, 11:08:24 AM
    Author     : Quoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="trongnq.define.Define"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <!-- load stylesheets -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="./css/table.css" type="text/css" >
        <script>
            $(function () {
                $("#datepicker").datepicker({
                    dateFormat: 'dd/mm/yy'
                });
            });
            $(function () {
                $("#datepicker2").datepicker({
                    dateFormat: 'dd/mm/yy'
                });
            });
            function setOrderIDOnclick(orderID) {
                document.getElementById("selectedOrderID").value = orderID;
            }
            function setRoomIDOnClick(bookID) {

                document.getElementById("selectedRoomID").value = roomID;
            }
        </script>
    </head>

    <body>
        <c:choose>
            <c:when test="${empty sessionScope.USER_INFO}">
                <form action="login" method="POST">
                    <input type="text" name="txtUserID" placeholder="User ID" required/>
                    <input type="password" name="txtUserPassword" placeholder="User Password" required/>
                    <button type="submit" name="btnAction" value="Login">Login</button>
                    <button type="reset">Reset</button>
                </form>
                <c:if test="${not empty requestScope.LOGIN_FAIL}">
                    <br/>
                    <font color="red">${requestScope.LOGIN_FAIL}</font>
                    <a href="createuser.jsp"> Register </a>
                </c:if>
                <c:if test="${empty sessionScope.USER_GOOGLE_INFO}">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8085/L.P00002/LoginGoogle&response_type=code
                       &client_id=762410788550-qbbaujc9sec370sntc17phr9aq5utf1t.apps.googleusercontent.com&approval_prompt=force "> login with Gmail</> 
                    </c:if>
                </c:when>
                <c:otherwise>
                    <form action="logout" method="POST">
                        Hello ${sessionScope.USER_INFO.getUserID()}! Your role is ${sessionScope.USER_INFO.getUserRoleName()}.
                        <button type="submit" name="btnAction" value="Logout">Logout</button>
                    </form>
                    <br/>
                    <!-- ADMIN VIEW -->
                    <c:if test="${sessionScope.USER_INFO.getUserRoleID() == Define.ADMIN}">
                        <h1> ADMIN VIEW </h1>
                    </c:if>
                    <!-- USER VIEW -->
                    <c:if test="${sessionScope.USER_INFO.getUserRoleID() == Define.USER}">
                        <h1> USER VIEW </h1>
                    </c:if>
                    <!-- Google Sign in -->
                    <c:if test="${not empty sessionScope.USER_GOOGLE_INFO}">
                        <form action="loginGoogle" method="POST">
                            id <c:out value="id"/>
                            name <c:out value="name"/>
                            email <c:out value="email"/>
                        </form>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <!-- ALL USER CAN USE SEARCH FUNCTION -->
            <h1>Search Room</h1>
            <form action="searchRoom" method="GET">
                Check in Date <input type="text"  name="txtCheckInDate" id="datepicker" /> 
                <br/><br/>
                Check out Date <input type="text"  name="txtCheckOutDate" id="datepicker2" />
                <br><br/>
                <button type="submit" name="btnAction" value="Search"> Find Room </button>
            </form>
            <!-- USER CLICKED SEARCH -->
            <c:if test="${not empty sessionScope.SEARCH_ROOM_INFO_LIST}">
                <form action="roomBooking" method="POST">
                    <input id="selectedRoomID" type="hidden" name="selectedRoomID"/>
                    <div id="container">
                        <table>
                            <thead>
                                <tr>
                                    <th>Room ID</th>
                                    <th>Room Type</th>
                                    <th>Room Price</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.SEARCH_ROOM_INFO_LIST}" var="roomInfo" varStatus="counter">
                                    <tr>
                                        <td>${roomInfo.getRoomID()}</td>
                                        <td>${roomInfo.getRoomTypeName()}</td>
                                        <td>${roomInfo.getRoomPrice()}</td>
                                        <c:if test="${empty sessionScope.USER_INFO}">
                                            <td>
                                                <p>Login To Booking</p>
                                            </td>
                                        </c:if>
                                        <c:if test="${sessionScope.USER_INFO.getUserRoleID() == Define.USER}">
                                            <td align="center">
                                                <button type="submit" name="btnAction" value="AddToCart" onclick="setRoomIDOnClick('${roomInfo.getRoomID()}')"> Booking </button>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>

            </c:if>
    </body>
</html>
