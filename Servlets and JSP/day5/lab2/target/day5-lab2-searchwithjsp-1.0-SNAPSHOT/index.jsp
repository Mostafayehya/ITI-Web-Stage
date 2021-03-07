<%@ page import="java.util.*,domain.User" %>

<html>
<head>
    <title>Search</title>
</head>
<body>


<div style='width:40%; margin:30px auto;'>

    <FORM action="SearchFormServlet" method=POST>
        <h1 style='font-size:300%; font-weight: bold;'>Search form</h1>
        <p>Please enter first name, last name or part of any</p>
        <BR><span style='font-size:200%; font-weight: bold;'> Name: </span><INPUT TYPE=TEXT NAME=userInput>
        <INPUT TYPE=SUBMIT VALUE=Submit>
    </FORM>

</div>
<BR><BR><BR><BR>


<% List<User> userlist = (List<User>) request.getAttribute("userList");
    if (userlist != null && !userlist.isEmpty()) {%>


<div style='width:80%; margin:30px auto;'>

    <table style='width:80%; margin:30px auto;'>

        <tr style='font-size:200%; font-weight: bold;'>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User Name</th>
            <th>Password</th>
        </tr>


        <% for (int i = 0; i < userlist.size(); i++) {%>

        <tr>
            <td style='text-align:center'><%out.println(userlist.get(i).getFirstName());%></td>
            <td style='text-align:center'><%out.println(userlist.get(i).getLastName());%></td>
            <td style='text-align:center'><%out.println(userlist.get(i).getUserName());%></td>
            <td style='text-align:center'><%out.println(userlist.get(i).getPassword());%></td>
        </tr>

        <% } %>
    </table>
</div>
<% } %>


</div>
</body>
</html>
