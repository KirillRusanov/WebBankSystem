<%@ page import="java.util.List" %>
<%@ page import="banksystem.entity.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Users</title>
</head>

<body>
<div>
  <h1>Super app!</h1>
</div>

<div>
  <div>
    <div>
      <h2>Users</h2>
    </div>
    <%
      List<Client> names = (List<Client>) request.getAttribute("clients");

      if (names != null && !names.isEmpty()) {
        out.println("<ui>");
        for (Client s : names) {
          out.println("<li>" + s.getName() + "</li>");
        }
        out.println("</ui>");
      } else out.println("<p>There are no users yet!</p>");
    %>
  </div>
</div>

<div>
  <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>