
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<jsp:useBean id="userBean" class="domain.UserBean" scope="request"/>
<jsp:setProperty name="userBean" property="*"/>

<jsp:forward page="SecondJSP.jsp"/>


</body>
</html>
