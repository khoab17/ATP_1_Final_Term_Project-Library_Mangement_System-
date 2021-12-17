<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/17/2021
  Time: 4:14 PM
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
    <table class="table table-sm table-striped"style="width:90%;margin-left: 5%;margin-right:5%;">
        <a  style="margin-left: 5%" class="btn-sm btn-primary" href="create">Add a Book</a>
        <h2 style="margin-left:5% ">Book List</h2>
        <thead class="thead-dark" >
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Publisher</th>
            <th>Author</th>
            <th>Number Of Copies</th>
            <th>Available Copies</th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${books}" var="book" >
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.publisher}</td>
                <td>${book.author}</td>
                <td>${book.numberOfCopies}</td>
                <td>${book.numberOfAvailableCopies}</td>
                <td><a class="btn-primary btn-sm" href="update?id=${book.id}">Edit</a></td>

            </tr>
        </c:forEach>




    </table>
</div>

<br><br><br><br><br><br>
</body>
</html>