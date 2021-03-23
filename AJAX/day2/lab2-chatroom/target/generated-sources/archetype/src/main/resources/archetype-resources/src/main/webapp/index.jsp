#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chat application with AJAX</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="script.js"></script>
</head>


<body onload="setInterval('getAllMessages()',2000)">

<!-- Just an image -->

<div align="center">
    <nav align="center" class="navbar navbar-dark bg-primary p-3 mb-2 bg-dark text-white">
        <h1 class="p-3 mb-2 bg-dark text-white" align="center">Chat application </h1>
    </nav>
    <h1>Chat Room</h1>

    <form style="width: 30%;">
        <div   class="mb-3">
            <label for="name" class="form-label">Your Name</label>
            <input type="text" class="form-control" id="name" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Message</label>
            <input type="text" class="form-control" id="message">
        </div>

        <input id="sendButton" type="button" value="Send" class="btn btn-primary"/>
    </form>

    <br><br>

    <table style="width: 50%;" id="chatTable" class="table-primary" border="1">

        <thead  class="table-dark">
        <th>User</th>
        <th>Message</th>
        </thead>

        <tbody id="tableBody">

        </tbody>
    </table>

</div>
</form>

<script>
    function getAllMessages() {

        ${symbol_dollar}.post("ChatServlet", function (data, status) {
            ${symbol_dollar}("${symbol_pound}tableBody").empty();
            var messageList = JSON.parse(data);
            for (var i = 0; i < messageList.length; i++) {

                var message = messageList[i];
                var markup = "<tr><td>" + message.sender + "</td><td>" + message.message + "</td></tr>";
                console.log(markup);
                ${symbol_dollar}("${symbol_pound}tableBody").append(markup);
            }

        });
    }
</script>

</body>
</html>