<%@include file="pageCommon.jsp" %>
<html>

<body>
<h1>Spring MVC hello world</h1>
<h1>spring:message:
    <spring:message code="field.msg"/>
</h1>
<h1>${msg}</h1>

<form method="post" action="${pageContext.servletContext.contextPath}/app/security/user">
    <input type="submit" value="UserAction">
</form>
<form method="post" action="${pageContext.servletContext.contextPath}/app/security/admin">
    <input type="submit" value="AdminAction">
</form>
</body>
</html>