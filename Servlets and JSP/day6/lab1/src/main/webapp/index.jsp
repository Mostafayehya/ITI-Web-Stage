<%@ page import="java.util.*,domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Search</title>
    </head>
    <body>


        <div style='width:40%; margin:30px auto;'>

            <FORM action="/test/SearchFormServlet" method=POST>
                <h1 style='font-size:300%; font-weight: bold;'>Search form</h1>
                <p>Please enter first name, last name or part of any</p>
                <BR><span style='font-size:200%; font-weight: bold;'> Name: </span><INPUT TYPE=TEXT NAME=userInput>
                <INPUT TYPE=SUBMIT VALUE=Submit>
            </FORM>

        </div>
        <BR><BR><BR><BR>



        <c:if test="${!empty userList}">
            <div style='width:80%; margin:30px auto;'>

                <table style='width:80%; margin:30px auto;'>

                    <tr style='font-size:200%; font-weight: bold;'>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>User Name</th>
                        <th>Password</th>
                    </tr>



                    <c:forEach items="${userList}" var="user">

                        <tr>
                            <td style='text-align:center'>${user.firstName}</td>
                            <td style='text-align:center'>${user.lastName}</td>
                            <td style='text-align:center'>${user.userName}</td>
                            <td style='text-align:center'>${user.password}</td>
                        </tr>

                    </c:forEach>

                </table>
            </div>
        </c:if>

    </body>
</html>
