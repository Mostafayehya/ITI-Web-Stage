
<html>
<head>
    <title>Second JSP</title>
</head>
<body>

<jsp:useBean id="userBean" class="domain.UserBean" scope="request"/>

<h1>User Info</h1>


First Name : <jsp:getProperty name="userBean" property="firstName"/>
<br>
Last Name : <jsp:getProperty name="userBean" property="lastName"/>

</body>
</html>
