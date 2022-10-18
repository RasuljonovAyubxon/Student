<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.09.2022
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UNIVE</title>
</head>
<body>
<table border="">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Street</th>
        <th>Action</th>
    </tr>
</table>
<c:forEach items="${Univers}" var="univer" >
    <tr>
        <td>${univer.id}</td>
        <td>${univer.name}</td>
        <td>${univer.street}</td>
        <td><a href="/delete/${univer.id}">DELETE</a></td>
        <td><a href="edit-form/${univer.id}">EDIT</a></td>
    </tr>
</c:forEach>
</body>
</html>

