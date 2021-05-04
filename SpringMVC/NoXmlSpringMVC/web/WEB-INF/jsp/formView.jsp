<%-- 
    Document   : displayAll
    Created on : May 4, 2021, 6:03:01 AM
    Author     : moust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var ="contextPath" value="${pageContext.request.contextPath}"/>

        <form:form method="POST" modelAttribute="user"
                   action="${contextPath}/users/register">

            <b>
                <label for="nameInput" >Name</label>
            </b>
            <form:input id="nameInput" path="name"/>
            <form:errors path="name"/>
            <br/>
            <b>
                <label for="salaryInput" >Salary</label>
            </b>
            <form:input id="salaryInput" path="salary"/>
            <form:errors path="salary"/>
            <br/>
            <input type="submit"/>
        </form:form>

    </body>



</html>
