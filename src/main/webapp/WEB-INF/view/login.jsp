<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <link type="text/css" href="<c:url value="../../resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="../../resources/css/main.css"/>" rel="stylesheet">
    <title>Login</title>
</head>
<body>
<section class="container">
    <div class="main_auth">
        <h1 class="display-2">Authorization</h1>
        <div class="mx-auto border my-5 py-3 px-3 form">
            <form:form action="/bank/api/auth/login" method="POST" modelAttribute="client">
                <div class="mb-3">
                    <form:label path="username" class="form-label">Username:</form:label>
                    <form:input path="username" type="text" class="form-control"/>
                    <form:errors path="username" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password:</form:label>
                    <form:input path="password" type="password" class="form-control"/>
                    <form:errors path="password" cssClass="text-danger"/>
                </div>
                <div class="my_button">
                    <input class="btn btn-primary" type="submit" value="Sign in"/>
                </div>
            </form:form>
        </div>
    </div>
</section>
</body>
</html>