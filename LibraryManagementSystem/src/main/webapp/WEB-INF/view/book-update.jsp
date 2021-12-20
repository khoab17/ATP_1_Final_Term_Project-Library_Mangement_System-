<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/17/2021
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Update</title>
    <%@ include file="header.jsp" %>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form:form action="saveUpdate" method="post"  modelAttribute="book" class="form-control" style="width: 30% ;margin-left:30% ;margin-top: 2%" >
    <h4 >Update Book</h4>
    <hr>
    <label>Book Title</label><form:errors path="title" cssClass="error"/>
    <form:input class="form-control" type="text"  path="title" />


    <label>Publisher</label><form:errors path="publisher" cssClass="error"/>
    <form:input class="form-control" type="text" path="publisher" />


    <label>Author</label><form:errors path="author" cssClass="error"/>
    <form:input class="form-control" type="text" path="author" />


    <label>Number OF Copies</label><form:errors path="numberOfCopies" cssClass="error"/>
    <form:input class="form-control" type="number" path="numberOfCopies"/>

    <label>Available Copies</label><form:errors path="numberOfAvailableCopies" cssClass="error"/>
    <form:input class="form-control" type="number" path="numberOfAvailableCopies"/>

    <label>Category</label>
    <form:select path="categoryId" class="form-select form-select-sm form-control" aria-label=".form-select-sm example">
        <form:options items="${categories}" />
    </form:select>
    <br>


    <form:hidden path="id" value="${book.id}"></form:hidden>
    <br>
    <input type="submit" class="btn-sm btn-primary btn" value="Save">
    <a class="btn btn-sm btn-secondary" href="list">Back</a>
</form:form>

</body>
</html>