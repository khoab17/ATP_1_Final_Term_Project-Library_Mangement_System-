<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/14/2021
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Update</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<form action="save" method="post" class="form-control" style="width: 40% ;margin-left:30% ;margin-top: 2%">
    <h4>User Registration</h4>
    <hr>
    <label class="mr-2">User Type:</label>
        <input class=" mr-1" type="radio" name="role" value="Admin" checked><label>Admin</label>
        <input class="mr-1" type="radio" name="role" value="Student"><label>Student</label><br>

    <label>First Name</label>
    <input class="form-control" type="text"  name="firstName" >

    <label>Last Name</label>
    <input class="form-control" type="text" name="lastName" >

    <label class="mr-2 mt-2">Gender:</label>
        <input class="mr-1" type="radio" name="gender" value="Male"><label>Male</label>
        <input class="mr-1" type="radio" name="gender" value="Female"><label>Female</label><br>


    <label>Date Of Birth</label>
    <input class="form-control" type="date" name="dateOfBirth">

    <label>Contact</label>
    <input class="form-control" type="text" name="contact">

    <label>Email</label>
    <input class="form-control" type="email" name="email">

    <label>Password</label>
    <input class="form-control" type="password" name="password"><br>

    <input type="submit" class="btn btn-sm btn-primary btn ml-4" value="Save">
    <a class="btn btn-sm btn-secondary ml-4" href="list">Back</a>
    <br>
</form>

</body>
</html>
