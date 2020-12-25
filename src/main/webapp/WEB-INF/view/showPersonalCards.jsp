<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="../../resources/css/main.css"/>">
</head>

<body>
<h2 align="center">Cards: </h2>

<table border="1" align="center">

    <th>Id</th>
    <th>Number</th>
    <th>Pin</th>
    <th>Term</th>

    <c:forEach var="card" items="${cardList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${card.number}</td>
            <td>${card.pin}</td>
            <td>${card.term}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>