<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/18/2021
  Time: 10:49 PM
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
    <title>Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
</head>


<body>
<br>
<div class="mainContent">

    <table style="margin-left: 5%">
        <tr>
            <th><a   class="btn-primary btn-sm" href="pending">Pending Requests</a></th>
            <th><a  class="btn-primary btn-sm" href="approved">Approved Requests</a></th>
            <th><a   class="btn-danger btn-sm" href="dismissed">Dismissed Requests</a></th>
        </tr>
    </table>

    <table class="table table-sm table-striped"style="width:90%;margin-left: 5%;margin-right:5%;">
        <h2 style="margin-left:5% ">Pending Requests</h2>
        <thead class="thead-dark" >
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author</th>
            <th>Edition</th>
            <th>Note</th>
            <th>Status</th>
            <th>Student ID</th>
            <th>Action</th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${requests}" var="request" >
            <tr>
                <td>${request.id}</td>
                <td>${request.title}</td>
                <td>${request.author}</td>
                <td>${request.edition}</td>
                <td>${request.note}</td>
                <td>${request.status}</td>
                <td>${request.studentId}</td>
                <td><a class="btn-primary btn-sm" href="">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<br><br><br><br><br><br>
</body>
</html>

