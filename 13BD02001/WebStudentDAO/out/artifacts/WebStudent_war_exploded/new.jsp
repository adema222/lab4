<%--
  Created by IntelliJ IDEA.
  User: Alimzhan
  Date: 16.10.2014
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");

    out.print(message);
%>
</body>
</html>
