<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link type="text/css" href="<c:url value="../../resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="../../resources/css/main.css"/>" rel="stylesheet">
    <title>Registration</title>
</head>
<body>
<section class="container">
    <div class="main_auth">
        <h1 class="display-2">Registration</h1>
        <div class="mx-auto border my-5 py-3 px-3 form">
            <form action="/bank/api/auth/registration" method="POST">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input name="name" type="text" class="form-control" id="name">
                </div>
                <div class="mb-3">
                    <label for="surname" class="form-label">Surname</label>
                    <input name="surname" type="text" class="form-control" id="surname">
                </div>
                <div class="mb-3">
                    <label for="patronymic" class="form-label">Patronymic</label>
                    <input name="patronymic" type="text" class="form-control" id="patronymic">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <input name="address" type="text" class="form-control" id="address">
                </div>
                <div class="mb-3">
                    <label for="passNumber" class="form-label">Passport number</label>
                    <input name="passNumber" type="text" class="form-control" id="passNumber">
                </div>
                <div class="mb-3">
                    <label for="date" class="form-label">Birthday</label>
                    <input name="birthday" type="date" class="form-control" id="date">
                </div>
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone number</label>
                    <input name="phoneNumber" type="text" class="form-control" id="phoneNumber">
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input name="username" type="text" class="form-control" id="username" aria-describedby="usernameHelp">
                    <div id= "usernameHelp" class="form-text">This value will be used for authorization</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="password" aria-describedby="passwordHelp">
                    <div id="passwordHelp" class="form-text">This value will be used for authorization</div>
                </div>
                <div class="my_button">
                    <input class="btn btn-primary" type="submit" value="Sign up"/>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>
