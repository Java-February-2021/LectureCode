<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Football Team</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form:form method="POST" action="/add" modelAttribute="team">
<div class="form-group">
<form:label path="name">Team Name:
<form:errors path="name"/>
<form:input path="name"/></form:label>
</div>
<div class="form-group">
<form:label path="city">City:
<form:errors path="city"/>
<form:input path="city"/></form:label>
</div>
<div class="form-group">
<form:label path="players">Name:
<form:errors path="players"/>
<form:input path="players"/></form:label>
</div>
<button>Add Team!</button>

</form:form>
<hr>
<h3>Html way For Adding Teams</h3>
<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>
<hr>

<form action="/add" method="POST">
<div class="form-group">
<label for="name">Team Name</label>
<input type="text" name="name">
</div>
<div class="form-group">
<label for="name">City</label>
<input type="text" name="city">
</div>
<div class="form-group">
<label for="name"># of players</label>
<input type="text" name="players">
</div>

<button>Add Team!</button>
</form>
</div>
</body>
</html>