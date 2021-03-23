

<%@taglib prefix="custom" uri="/WEB-INF/newtag_library.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Cutstom tag</title>
</head>
<body>

    
    <h1>Online Users : <c:out value="${applicationScope.userCount}" /> </h1>
    
    <h1>Page Hits : <c:out value="${applicationScope.pageHits}" /> </h1>

    

</body>
</html>
