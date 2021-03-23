<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chat application with AJAX</title>

    <script src="https://code.jquery.com/jquery-1.9.1.min.js"
            integrity="sha256-wS9gmOZBqsqWxgIVgA8Y9WcQOa7PgSIX+rPA0VL2rbQ=" crossorigin="anonymous"></script>
    <script src="script.js"></script>
</head>
<body>


<div align="center">
    <header>Chat Room</header>
    <form name="chatForm" method="post" action="">

        Your Name : <input type="text" name="name"/><br>

        Your Message: <input type="text" name="message"/><br><br>

        <input id="sendButton" type="button" value="Send"/><br>

    </form>

    <br><br>

    <table id="chatTable" border="1">
        <tbody>
        <tr><th>User</th><th>Message</th></tr>
        </tbody>
    </table>

</div>
</form>
</body>
</html>