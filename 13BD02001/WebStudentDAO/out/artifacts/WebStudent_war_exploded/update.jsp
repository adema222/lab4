
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="update" method="post">
    Add new student:<br>
    Name: <input type="text" name="name" value="${student.getName()}"><br>
    Year: <input type="text" name="year" value="${student.getYear()}"><br>
    <input type="hidden" name="id" value="${student.getId()}">
    <input type="submit">
</form>
</body>
</html>
