<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/18/2021
  Time: 2:11 PM
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
<form:form action="save" method="post" modelAttribute="credentialUser"  class="form-control" style="width: 40% ;margin-left:30% ;margin-top: 2%">
    <h4>User Registration</h4>
    <hr>
    <label class="mr-2">User Type:</label>
    <form:radiobutton class=" mr-1"  path="credential.role" value="Admin"/><label>Admin</label>
    <form:radiobutton class="mr-1"   path="credential.role" value="Student"/><label>Student</label><br>
    <form:errors path="credential.role" cssClass="error" />

    <label>First Name</label><form:errors path="user.firstName" cssClass="error" />
    <form:input class="form-control" type="text"  path="user.firstName" />

    <label>Last Name</label><form:errors path="user.lastName" cssClass="error" />
    <form:input class="form-control" type="text" path="user.lastName" />

    <label class="mr-2 mt-2">Gender:</label>
    <form:radiobutton class="mr-1"  path="user.gender" value="Male" /><label>Male</label>
    <form:radiobutton class="mr-1"  path="user.gender" value="Female"/><label>Female</label><br>
    <form:errors path="user.gender" cssClass="error" />

    <label>Date Of Birth</label><form:errors path="user.dateOfBirth" cssClass="error" />
    <form:input class="form-control" type="date" path="user.dateOfBirth"/>

    <label>Contact</label><form:errors path="user.contact" cssClass="error" />
    <form:input class="form-control" type="text" path="user.contact"/>

    <label>Email</label><form:errors path="user.email" cssClass="error" />
    <form:input class="form-control" type="email" path="user.email"/>

    <label>Password</label><form:errors path="credential.password" cssClass="error" />
    <form:password class="form-control"  path="credential.password"/><br>

    <input type="submit" class="btn btn-sm btn-primary btn ml-4" value="Save"/>
    <a class="btn btn-sm btn-secondary ml-4" href="list">Back</a>
    <br>

</form:form>

</body>
</html>
