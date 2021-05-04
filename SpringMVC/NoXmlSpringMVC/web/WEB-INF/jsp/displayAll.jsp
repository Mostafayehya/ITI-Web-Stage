<%-- 
    Document   : displayAll
    Created on : May 4, 2021, 6:03:01 AM
    Author     : moust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Display All</h1>


        <table>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>



</html>
