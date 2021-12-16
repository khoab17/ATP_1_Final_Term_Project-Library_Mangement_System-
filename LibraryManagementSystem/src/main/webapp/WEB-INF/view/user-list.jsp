<%--
  Created by IntelliJ IDEA.
  User: kawsu
  Date: 11/29/2021
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>User List</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <br>
        <h2>User List: <a class="btn btn-sm btn-primary" href="create">Create a new User</a></h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table class="table-sm">
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th></th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td> ${user.firstName} </td>
                    <td> ${user.lastName} </td>
                    <td>
                    <td><a class="btn-primary btn-sm" href="update?id=${user.id}">Edit</a></td>
                    <td><a class="btn-danger btn-sm" href="delete?id=${user.id}">Delete</a></td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
