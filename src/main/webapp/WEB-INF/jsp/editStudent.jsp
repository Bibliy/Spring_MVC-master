<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.2019
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>last_name</th>
        <th>phone</th>
        <th>age</th>
    </tr>

    <c:forEach items="${Student}" var="p">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.firstName}"/></td>
            <td><c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.phone}"/></td>
            <td><c:out value="${student.age}"/></td>
            <td><a href="update?id=${p.id}">Edit</a></td>
            <td><a href="delete?id=${p.id}">Delete</a></td>
        </tr>

    </c:forEach>
    </tr>
</table>
</body>
</html>
