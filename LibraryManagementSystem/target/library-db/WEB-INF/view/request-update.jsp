<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/20/2021
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
    <style>
        .error{
            margin-left: 2%;
            color: red;
        }
    </style>
    <title>Update</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/request/update/save" method="post"  modelAttribute="request" class="form-control" style="width: 30% ;margin-left:30% ;margin-top: 2%" >
    <h4 >Update Request</h4>
    <hr>
    <label>ID:</label>${request.id}<br>
    <form:hidden path="id" value="${request.id}"></form:hidden>

    <label>Student ID:</label>${request.studentId}<br>
    <form:hidden path="studentId" value="${request.studentId}"></form:hidden>

    <label>Title</label><form:errors path="title" cssClass="error"/>
    <form:input class="form-control" type="text"  path="title" value="${request.title}"/>


    <label>Author</label><form:errors path="author" cssClass="error"/>
    <form:input class="form-control" type="text" path="author" value="${request.author}"/>


    <label>Edition</label><form:errors path="edition" cssClass="error"/>
    <form:input class="form-control" type="text" path="edition" value="${request.edition}" />


    <label>Note</label><form:errors path="note" cssClass="error"/>
    <form:textarea class="form-control" path="note" value="${request.note}"/>

    <label>Status</label><form:errors path="status" cssClass="error"/>
    <form:input class="form-control" type="text" path="status" value="${request.status}" />


    <br>
    <input type="submit" class="btn-sm btn-primary btn" value="Update">
    <a class="btn btn-sm btn-secondary" href="${pageContext.request.contextPath}/request/list">Back</a>

</form:form>
</body>
</html>
