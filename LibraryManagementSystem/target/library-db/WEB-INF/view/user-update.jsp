<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/20/2021
  Time: 12:48 PM
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
        .error{color: red;}
    </style>
</head>
<body>
<form:form action="saveUpdate" method="post" modelAttribute="credentialUser"  class="form-control" style="width: 40% ;margin-left:30% ;margin-top: 2%">
    <h4>Update</h4>
    <hr>
    <label class="mr-2">User ID:</label>
    <label>${credentialUser.user.userId}</label><br>
    <label class="mr-2">User Type:</label>
    <label>${credentialUser.credential.role}</label><br>

    <label>First Name</label><form:errors path="user.firstName" cssClass="error" />
    <form:input class="form-control" type="text"  path="user.firstName" value="${credentialUser.user.firstName}" />

    <label>Last Name</label><form:errors path="user.lastName" cssClass="error" />
    <form:input class="form-control" type="text" path="user.lastName" value="${credentialUser.user.lastName}" />

    <label class="mr-2 mt-2">Gender:</label>
    <form:radiobutton class="mr-1"  path="user.gender" value="Male" /><label>Male</label>
    <form:radiobutton class="mr-1"  path="user.gender" value="Female"/><label>Female</label>
    <form:errors path="user.gender" cssClass="error" /><br>


    <label>Date Of Birth</label><form:errors path="user.dateOfBirth" cssClass="error" />
    <form:input class="form-control" type="date" path="user.dateOfBirth" value="${credentialUser.user.dateOfBirth}"/>

    <label>Contact</label><form:errors path="user.contact" cssClass="error" />
    <form:input class="form-control" type="text" path="user.contact" value="${credentialUser.user.contact}"/>

    <label>Email</label><form:errors path="credential.email" cssClass="error" />
    <form:input class="form-control" type="email" path="credential.email" value="${credentialUser.credential.email}"/>

    <form:hidden path="credential.id" value="${credentialUser.credential.id}"></form:hidden>
    <form:hidden path="credential.password" value="${credentialUser.credential.password}"></form:hidden>
    <form:hidden path="credential.role" value="${credentialUser.credential.role}"></form:hidden>
    <form:hidden path="user.userId" value="${credentialUser.user.userId}"></form:hidden>

    <br>
    <input type="submit" class="btn btn-sm btn-primary btn ml-4" value="Update"/>
    <a class="btn btn-sm btn-secondary ml-4" href="list">Back</a>
    <br>

</form:form>

</body>
</html>
