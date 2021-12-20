<%--
  Created by IntelliJ IDEA.
  User: kawsu
  Date: 11/29/2021
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
</head>


<body>
<br>
<div class="mainContent">
    <table class="table table-sm table-striped"style="width:90%;margin-left: 5%;margin-right:5%;">
        <a  style="margin-left: 5%" class="btn-sm btn-primary" href="create">Create A new User</a>
        <h2 style="margin-left:5% ">User List:</h2>
        <thead class="thead-dark" >
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>DOB</th>
            <th>Contact</th>
            <th>Email</th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${users}" var="user" >
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.gender}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.contact}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/user/update?id=${user.userId}">Edit</a></td>
            </tr>
        </c:forEach>




    </table>
</div>

<br><br><br><br><br><br>
</body>
</html>
