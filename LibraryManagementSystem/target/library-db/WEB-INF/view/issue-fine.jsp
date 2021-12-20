<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/20/2021
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Add</title>
    <%@ include file="header.jsp" %>
    <title>fine</title>
</head>
<body>
    <form action="fine/submit" method="post"  style="width: 30% ;margin-left:30% ;margin-top: 2%">

        <h3>Make a Fine</h3>
        <hr>

        <label>Issue ID:</label>${issue.issueId}<br>
        <label>Date Of Issue:</label>${issue.dateOfIssue}<br>
        <label>Date Of Return:</label>${issue.dateOfReturn}<br>
        <label>Student ID:</label>${issue.studentId}<br>
        <label>Book ID:</label>${issue.bookId}<br>

        <input type="hidden" name="issueId" value="${issue.issueId}">
        <input type="hidden" name="dateOfIssue" value="${issue.dateOfIssue}">
        <input type="hidden" name="dateOfReturn" value="${issue.dateOfReturn}">
        <input type="hidden" name="studentId" value="${issue.studentId}">
        <input type="hidden" name="bookId" value="${issue.bookId}">
        <input type="hidden" name="status" value="${issue.status}">

        <label>Fine</label>
        <input class="form-control" type="number" name="fine" required><br>

        <label>Comment</label>
        <textarea class="form-control" name="comment" ></textarea>

        <br>
        <input type="submit" class="btn-sm btn-primary btn" value="Save">
        <a class="btn btn-sm btn-secondary" href="${pageContext.request.contextPath}/issue/return">Back</a>

    </form>
</body>
</html>
