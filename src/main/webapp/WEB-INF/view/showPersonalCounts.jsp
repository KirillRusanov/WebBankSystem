<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="../../resources/css/main.css"/>">
</head>

<body>
<h2 align="center"> Counts: </h2>

<table border="1" align="center">

    <th>Id</th>
    <th>Number</th>
    <th>Balance</th>
    <th>Currency</th>

    <c:forEach var="count" items="${countList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td><a href="/bank/api/count/${count.id}">${count.number}</a></td>
            <td>${count.balance}</td>
            <td>${count.currency}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>