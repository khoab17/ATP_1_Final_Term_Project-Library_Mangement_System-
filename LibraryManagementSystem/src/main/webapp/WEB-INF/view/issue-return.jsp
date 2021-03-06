<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/20/2021
  Time: 4:21 PM
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

    <table style="margin-left: 5%" >
        <tr>
            <td>
                <a  class="btn-sm btn-primary" href="${pageContext.request.contextPath}/issue/list">All issues</a>
            </td>
            <td>
                <a  class="btn-sm btn-primary" href="${pageContext.request.contextPath}/issue/return">Return Request</a>
            </td>
            <td>
                <a  class="btn-sm btn-primary" href="${pageContext.request.contextPath}/issue/create">Create an Issue</a>
            </td>
        </tr>
    </table>

    <table class="table table-sm table-striped"style="width:90%;margin-left: 5%;margin-right:5%;">
        <h2 style="margin-left:5% ">Issue List</h2>
        <thead class="thead-dark" >
        <tr>
            <th>Id</th>
            <th>Date Of Issue</th>
            <th>Return Date</th>
            <th>Student ID</th>
            <th>Book ID</th>
            <th>Status</th>
            <th>Fine</th>
            <th>Comment</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach items="${issues}" var="issue" >
            <tr>
                <td>${issue.issueId}</td>
                <td>${issue.dateOfIssue}</td>
                <td>${issue.dateOfReturn}</td>
                <td>${issue.studentId}</td>
                <td>${issue.bookId}</td>
                <td>${issue.status}</td>
                <td>${issue.fine}</td>
                <td>${issue.comment}</td>
                <td>
                    <a class="btn-primary btn-sm" href="${pageContext.request.contextPath}/issue/approve?id=${issue.issueId}">Approve</a>
                    <a class="btn-danger btn-sm" href="${pageContext.request.contextPath}/issue/fine?id=${issue.issueId}">Make a Fine</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>

<br><br><br><br><br><br>
</body>
</html>
