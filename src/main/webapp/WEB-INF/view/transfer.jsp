<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    <title>Your Counts</title>
</head>

<body>
<nav class="navbar navbar-expand-lg" style="background: linear-gradient(to right, #C5DDE8, #636464)">
    <a class="navbar-brand" href="#">RusBANK</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/bank/api/index">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bank/api/client/list">Clients</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bank/api/count/list">Your counts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contacts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About us</a>
            </li>
            <div class="btn-group">
                <button id="profile" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/bank/api/client/profile">Profile</a>
                    <a class="dropdown-item" href="/bank/api/auth/registration">Sign up</a>
                    <a class="dropdown-item" href="/bank/api/auth/login">Sign in</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/bank/api/auth/logout">Logout</a>
                </div>
            </div>
        </ul>
    </div>
</nav>

<div class="transfer-workplace">
    <div class="transfer-header">
        <h3 class="display-5">Balance:</h3> <p class="text-white">$ ${count.balance}</p>
    </div>
    <form:form action="/bank/api/card/transfer" method="POST" modelAttribute="transfer">
        <div class="mb-3">
            <form:label path="toCard" class="form-label text-white">Where to transfer (card number):</form:label>
                <form:input path="toCard" type="text" class="form-control"/>
                <form:errors path="toCard" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="amount" class="form-label text-white">Amount:</form:label>
            <form:input path="amount" type="text" class="form-control" aria-describedby="usernameHelp"/>
            <form:errors path="amount" cssClass="text-danger"/>
        </div>
        <form:input path="fromCard" type="hidden" value="${fromCard.number}"/>
        <div class="my_button">
            <input class="btn btn-primary" type="submit" value="Do transfer"/>
        </div>
    </form:form>
</div>
</body>
</html>