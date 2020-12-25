<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css">
    <link type="text/css" href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <title>Home page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg" style="background-color: #86b7fe">
    <a class="navbar-brand" href="#">BankSystem</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bank/api/client/list">Clients</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bank/api/auth/registration">Registration</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bank/api/auth/login">Sign in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bank/api/auth/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
