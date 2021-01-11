<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
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
            <form:form action="/bank/api/auth/registration" method="POST" modelAttribute="client">
                <div class="mb-3">
                    <form:label path="email" class="form-label">Email:</form:label>
                    <form:input path="email" type="text" class="form-control"/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="username" class="form-label">Username:</form:label>
                    <form:input path="username" type="text" class="form-control" aria-describedby="usernameHelp"/>
                    <form:errors path="username" cssClass="text-danger"/>
                    <div id= "usernameHelp" class="form-text">This value will be used for authorization</div>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password:</form:label>
                    <form:input path="password" type="password" class="form-control" aria-describedby="usernameHelp"/>
                    <form:errors path="password" cssClass="text-danger"/>
                    <div id="passwordHelp" class="form-text">This value will be used for authorization</div>
                </div>
                <div class="panel"></div>
                <div class="mb-3">
                    <form:label path="name" class="form-label">Name:</form:label>
                    <form:input path="name" type="text" class="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="surname" class="form-label">Surname:</form:label>
                    <form:input path="surname" type="text" class="form-control"/>
                    <form:errors path="surname" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="patronymic" class="form-label">Patronymic:</form:label>
                    <form:input path="patronymic" type="text" class="form-control"/>
                    <form:errors path="patronymic" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="address" class="form-label">Address:</form:label>
                    <form:input path="address" type="text" class="form-control"/>
                    <form:errors path="address" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="passNumber" class="form-label">Passport number:</form:label>
                    <form:input path="passNumber" type="text" class="form-control"/>
                    <form:errors path="passNumber" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="birthday" class="form-label">Birthday:</form:label>
                    <form:input path="birthday" type="date" class="form-control"/>
                    <form:errors path="birthday" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="phoneNumber" class="form-label">Phone number:</form:label>
                    <form:input path="phoneNumber" type="text" class="form-control"/>
                    <form:errors path="phoneNumber" cssClass="text-danger"/>
                </div>
                <div class="my_button">
                    <input class="btn btn-primary" type="submit" value="Sign up"/>
                </div>
            </form:form>
        </div>
    </div>
</section>
</body>
</html>
