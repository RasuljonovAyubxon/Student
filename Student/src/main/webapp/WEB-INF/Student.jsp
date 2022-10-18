<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.09.2022
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Studet lar</title>
</head>
<body>
<table border="">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${students}" var="student" >
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.surname}</td>
        <td>${student.age}</td>
        <td><a href="/delete/${student.id}">DELETE</a></td>
        <td><a href="/edit-form/${student.id}">EDIT</a></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
