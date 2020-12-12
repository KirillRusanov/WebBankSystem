<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="../../resources/css/main.css"/>" rel="stylesheet">
</head>

<h2 align="center">Clients: </h2>

<table border="1" align="center">

    <th>Id</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Patronymic</th>
    <th>Address</th>
    <th>Pass number</th>
    <th>Date Birth</th>
    <th>Phone number</th>

    <c:forEach var="client" items="${clientList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td><a href="/bank/api/client/${client.id}">${client.name}</a></td>
            <td>${client.surname}</td>
            <td>${client.patronymic}</td>
            <td>${client.address}</td>
            <td>${client.passNumber}</td>
            <td>${client.birthday}</td>
            <td>${client.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>