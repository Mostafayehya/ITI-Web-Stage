<!DOCTYPE html>
<%@include file="WEB-INF/pages/pageCommon.jsp" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
    <sec:authentication property="principal.username" var="currentUser"/>
</sec:authorize>
<h1>Hello ${currentUser}</h1>
<a href="app/security">Security</a>
<a href="app/user">User</a>
<a href="app/admin">Admin</a>
<a href="login">Login</a>
<a href="logout">Logout</a>
</body>
</html>