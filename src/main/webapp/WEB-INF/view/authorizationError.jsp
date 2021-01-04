<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css">
    <link type="text/css" href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <title>Failed Authorization</title>
</head>
<body>
<div class="alert alert-danger" role="alert">
    <h4 class="alert-heading">Failed Authorization</h4>
    <p>You entered an incorrect password or this user does not exist</p>
    <hr>
    <p class="mb-0"><a class="alert-link" href="/bank/api/auth/login">Try again!</a></p>
</div>
</body>
</html>
