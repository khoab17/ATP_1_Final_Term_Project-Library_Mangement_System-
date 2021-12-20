<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/18/2021
  Time: 7:54 PM
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
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form:form action="save" method="post"  modelAttribute="issue" class="form-control" style="width: 30% ;margin-left:30% ;margin-top: 2%" >
    <h4 >Create an Issue</h4>
    <hr>
    <label>Student ID</label><form:errors path="studentId" cssClass="error"/>
    <form:input class="form-control" type="number"  path="studentId" />


    <label>Book ID</label><form:errors path="bookId" cssClass="error"/>
    <form:input class="form-control" type="number" path="bookId" />


    <label>Date of Issue</label><form:errors path="dateOfIssue" cssClass="error"/>
    <form:input class="form-control" type="date" path="dateOfIssue" />


    <label>Date of Return</label><form:errors path="dateOfReturn" cssClass="error"/>
    <form:input class="form-control" type="date" path="dateOfReturn"/>

    <form:hidden path="status" value="borrowed"></form:hidden>

    <br>
    <input type="submit" class="btn-sm btn-primary btn" value="Save">
    <a class="btn btn-sm btn-secondary" href="list">Back</a>

</form:form>

</body>
</html>