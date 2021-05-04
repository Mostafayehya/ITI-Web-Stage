<%-- 
    Document   : upload
    Created on : May 4, 2021, 1:57:38 PM
    Author     : moust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" conte   nt="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello File upload!</h1>
        
        <form method="POST" action="uploadfile" enctype="multipart/form-data">
            
            File to upload: <input type="file" name="file"/>
            
            Name: <input type="text" name="name"/>
            
            <input type="submit" value="Upload"/>
        </form>
        
        
    </body>
</html>
