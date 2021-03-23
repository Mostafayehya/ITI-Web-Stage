<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple AJAX Example</title>


</head>
<body onload="setInterval('updateTable()',2000)">


<form name="ajaxForm" method="POST" action="">
    <input type="button" value="submit" onclick="submitForm();"/>
    <input type="text" value="" name="firstTextInput"/>
</form>
<p>
    Enter your name and email:
</p>

<form name="ajaxValidationForm" method="POST" action="">

    Name: <input type="text" id="userName" name="username" onblur="sendValidationRequest();"> <span
        id="status"></span>
    <br>
    Password: <input type="password" id="userPassword" name="email"> <br>

    <input type="button" value="Validate">

</form>
<br>

<div id="tableContainer">


</div>




<script>
    var request = null;
    var validationRequest = null;
    var updateTableRequest;

    function submitForm() {
        if (window.XMLHttpRequest)
            request = new XMLHttpRequest();
        else if (window.ActiveXObject)
            request = new ActiveXObject(Microsoft.XMLHTTP);

        request.onreadystatechange = handleRequest;

        request.open("GET", "simpleResponse.txt?t=" + new Date().getTime(), true);
        request.send(null);
    }

    function handleRequest() {
        if (request.readyState === 4)
            if (request.status === 200)
                document.ajaxForm.firstTextInput.value = "Received: " + request.responseText;
            else
                document.ajaxForm.firstTextInput.value = "Error code " + request.status;
    }

    //   ==================================SECOND SCREEN=====================================

    function sendValidationRequest() {

        if (window.XMLHttpRequest)
            validationRequest = new XMLHttpRequest();
        else if (window.ActiveXObject)
            validationRequest = new ActiveXObject(Microsoft.XMLHTTP);

        validationRequest.onreadystatechange = handleValidationStateChange;

        userNameValue = document.getElementById("userName").value;
        passwordValue = document.getElementById("userPassword").value;
        url = "/test/BasicServlet" + "?username=" + userNameValue + "&t=" + new Date().getTime();
        validationRequest.open("GET", url, true);
        validationRequest.send(null);

    }

    function handleValidationStateChange() {

        if (validationRequest.readyState === 4)
            if (
                validationRequest.status === 200) {
                document.getElementById("status").innerHTML = validationRequest.responseText;
            }
    }

    //==========================================Third Screen===================================

    function updateTable() {

        updateTableRequest = new XMLHttpRequest();

        updateTableRequest.onreadystatechange = handleUpdateTableRequestStatuChange;
        updateTableRequest.open("GET","InnerHTML.txt?t=" + new Date().getTime(), true);

        updateTableRequest.send(null);
    }

    function handleUpdateTableRequestStatuChange(){

        if(updateTableRequest.readyState===4 && updateTableRequest.status===200){
            document.getElementById("tableContainer").innerHTML =
                updateTableRequest.responseText;
        }
    }

</script>
</body>
</html>