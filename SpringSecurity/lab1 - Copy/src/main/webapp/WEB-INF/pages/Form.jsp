<%@include file="pageCommon.jsp" %>

<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>

<form:form method="POST"
           action="${pageContext.servletContext.contextPath}/app/security/submit" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="username"><spring:message code="field.username"/></form:label></td>
            <td><form:input path="username"/></td>
            <td><form:errors path="username"/></td>

        </tr>
        <tr>
            <td><form:label path="password"><spring:message code="field.password"/></form:label></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
            <%--        <tr>--%>
            <%--            <td><form:errors path="*"/></td>--%>
            <%--        </tr>--%>
        <tr>
            <input type="checkbox" name="remember-me">
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>