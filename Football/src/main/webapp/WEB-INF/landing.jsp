<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select a User to Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Welcome To Football Teams dot Com</h1>
  <div class="row">
    <div class="col">
    <p>${errorFromLoggingIn}</p>
      <h4>Login</h4>
      <form method="POST" action="/login">
      <div class="form-group">
      <label>Email:</label>
      <input class="form-control" type="email" name="loginEMail">
    </div>
    <div class="form-group">
    <label>Password</label>
    <input class="form-control" type="password" name="loginPAssword">
    <button class="btn btn-success">Login!</button>
    </div>
    </form>
    </div>
    <div class="col">
      <h4>Register</h4>
			<form:form action="/registration" method="post" modelAttribute="user">
			    <div class="form-group">
			        <form:label path="fullName">Full Name</form:label>
			        <form:errors path="fullName"/>
			        <form:input class="form-control" path="fullName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="age">Age</form:label>
			        <form:errors path="age"/>
			        <form:input class="form-control" path="age"/>
			    </div>
			    <div class="form-group">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			       <form:input type="email" class="form-control" path="email"/>
			    </div>
			    <div class="form-group">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			       <form:input type="password" class="form-control" path="password"/>
			    </div>
			    <div class="form-group">
			        <form:label path="confirmPassword">Confirm Password</form:label>
			        <form:errors path="confirmPassword"/>
			       <form:input type="text" class="form-control" path="confirmPassword"/>
			    </div>
			    <input class="btn btn-primary" type="submit" value="Register!!"/>
			</form:form>
    </div>
  </div>
 </div>

</body>
</html>