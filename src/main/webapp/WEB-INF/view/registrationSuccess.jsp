<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css">
    <link type="text/css" href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <title>Success registration</title>
</head>
<body>
<div class="alert alert-success" role="alert">
    <h4 class="alert-heading">You have successfully registered</h4>
    <p>A verification email has been sent to: "${email}"</p>
    <hr>
    <p class="mb-0"><a class="alert-link" href="/api/auth/login">Go to authorization!</a></p>
</div>
</body>
</html>
