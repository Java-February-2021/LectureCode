<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Football dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Football dot Com</h1>
<a href="/add">Add A Team</a>
<hr>
<table class="table table-striped table-dark">
<thead>
<td>ID</td>
<td>Team Name</td>
<td>City</td>
<td>Players</td>
</thead>
<tbody>
<c:forEach items="${allTeams}" var="team">
<tr>
<td><c:out value="${team.id}"/></td>
<td><a href="/${team.id}"><c:out value="${team.name}"/></a></td>
<td><c:out value="${team.city}"/></td>
<td><c:out value="${team.players}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>