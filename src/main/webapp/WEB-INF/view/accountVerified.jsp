<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" href="<c:url value="../../resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="../../resources/css/main.css"/>" rel="stylesheet">
    <title>accountVerified</title>
</head>
<body>
<div class="alert alert-success" role="alert">
    <h4 class="alert-heading">You have successfully verified</h4>
    <p>Your account has been activated and email is verified!</p>
    <hr>
    <p class="mb-0"><a class="alert-link" href="/api/auth/login">Go to authorization!</a></p>
</div>
</body>
</html>
