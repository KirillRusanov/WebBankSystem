<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <title>Error</title>
</head>
<body>
<div class="alert alert-danger" role="alert">
    <h4 class="alert-heading">Oops... Confirmation error</h4>
    <p>Try to verify your account a little later</p>
    <p>${message}</p>
    <hr>
    <p class="mb-0"><a class="alert-link" href="/api/index">Go to menu!</a></p>
</div>
</body>
</html>
