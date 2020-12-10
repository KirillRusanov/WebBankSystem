<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Clients: </h2>

<table border="1">

    <th>Id</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Pass number</th>
    <th>Phone number</th>

    <c:forEach var="client" items="${clientList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${client.name}</td>
            <td>${client.surname}</td>
            <td>${client.passNumber}</td>
            <td>${client.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>