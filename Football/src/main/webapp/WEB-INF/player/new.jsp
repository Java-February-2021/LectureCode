<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Create New Player</h1>
<hr>
<form:form mathod="POST" action="/player/new" modelAttribute="player">
<div class="form-group">
<form:label path="team">Create A Player For Team:</form:label>
<form:errors path="team"/>
<form:select path="team">
<c:forEach items="${teams}" var="team">
<option value="${team.id}">${team.name}</option>
</c:forEach>
</form:select>
</div>

    <div class="form-group">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    </div>
    
        <div class="form-group">
    <form:label path="weight">Weight
    <form:errors path="weight"/>
    <form:input path="weight"/></form:label>
    </div>
    
        <div class="form-group">
    <form:label path="number">Number
    <form:errors path="number"/>
    <form:input path="number"/></form:label>
    </div>
    
    <button>Add Player!</button>
</form:form>
</div>
</body>
</html>