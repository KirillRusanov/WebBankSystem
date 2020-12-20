<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link type="text/css" href="<c:url value="../../resources/css/bootstrap.css"/>" rel="stylesheet">
    <link type="text/css" href="<c:url value="../../resources/css/main.css"/>" rel="stylesheet">
    <title>Login</title>
</head>
<body>
<section class="container">
    <div class="main_auth">
        <h1>Authorization</h1>
        <div class="mx-auto border my-5 py-3 px-3 form">
            <form action="/bank/api/auth/login" method="POST">
                <div class="mb-3">
                    <label for="username" class="form-label">Email address</label>
                    <input name="username" type="text" class="form-control" id="username" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="password">
                </div>
                <div class="my_button">
                    <input class="btn btn-primary" type="submit" value="Sign in"/>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>