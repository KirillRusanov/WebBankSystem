<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <link type="text/css" href="<c:url value="../../resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="../../resources/css/main.css"/>" rel="stylesheet">
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
                <button id="profile" type="button" class="btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Profile</a>
                    <a class="dropdown-item" href="/bank/api/auth/registration">Sign up</a>
                    <a class="dropdown-item" href="/bank/api/auth/login">Sign in</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/bank/api/auth/logout">Logout</a>
                </div>
            </div>
        </ul>
    </div>
</nav>

<div class="count-workplace">
    <div class="workplace-header">
<div class="create-count">
    <h2 class="display-5">Active accounts: </h2>
    <div class="create-menu">
        <form:form action="/bank/api/count/create" method="POST" modelAttribute="count">
            <form:input path="number" type="text" class="form-control" placeholder="count number"/>
            <form:errors path="number" cssClass="text-danger"/>

            <form:select path="currency" class="custom-select custom-select-sm">
                <option selected>BYN</option>
                <option value="RUS">RUS</option>
                <option value="USD">USD</option>
            </form:select>
                <button type="submit" class="btn btn-dark">Create</button>
        </form:form>
        </div>
    </div>
    </div>
<div class="counts">
<div class="row row-cols-3">
    <c:forEach var="count" items="${countList}" varStatus="status">
            <div class="col">
                <div class="card rounded-pill">
                    <div class="card-body">
                        <h5 class="card-title">Account: *${count.number}</h5>
                        <p class="card-text">Currency: ${count.currency} | Cards: ${count.cards.size()}</p>
                        <p class="card-text">Balance: ${count.balance} </p>
                        <a href="/bank/api/card/list?id=${count.id}" class="btn btn-dark">cards</a>
                        <a href="/bank/api/count/${count.id}/delete" class="btn btn-dark">close</a>
                    </div>
                </div>
            </div>
    </c:forEach>
</div>
</div>
</div>
</body>
</html>