<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-1.9.1.min.js" integrity="sha256-wS9gmOZBqsqWxgIVgA8Y9WcQOa7PgSIX+rPA0VL2rbQ=" crossorigin="anonymous"></script>

    <script src="script.js"></script>
</head>
<body>

<div align ="center">
    <h1>This is a new h1 element to test auto deploy</h1>

    <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>

    <br><br>


    <div id="div1"><h2>Let jqeury change this text</h2></div>
    <button>Get External content</button>

</div>


</script>
</body>
</html>