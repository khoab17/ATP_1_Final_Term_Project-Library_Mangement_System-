<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 12/19/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .error{
            margin-left: 4%;
            color: red;
            text-align:center
        }

    </style>
    <title>login</title>
</head>
<body>
${userRole}${userEmail}

<form:form action="${pageContext.request.contextPath}/authenticate" modelAttribute="login" style="width: 26% ;margin-left:37% ;margin-top: 2% " >

    <h3 style="color: deepskyblue">Log in</h3>
    <hr>

    <p style="align-content: center;color: red">${errormessage}</p>
    <p style="align-content: center;color: red">${loginFirst}</p>

    <label>Email</label> <form:errors path="email" cssClass="error"></form:errors>
    <form:input class="form-control" type="text" path="email"></form:input>

    <label>Password</label><form:errors  path="password" cssClass="error"></form:errors>
    <form:input class="form-control" type="password" path="password"></form:input>

    <br>
    <input type="submit" class="btn btn-sm btn-primary btn  form-control" value="Login"/>

</form:form>


</body>
</html>
