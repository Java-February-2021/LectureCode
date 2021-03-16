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
<p>Welcome <c:out value="${loggedInUser.fullName}"/></p>
<a href="/add">Add A Team</a> | <a href="/player/new">Add A Player</a> | <a href="/logout">Logout</a>
<hr>
<table class="table table-striped table-dark">
<thead>
<td>Action</td>
<td>Team Name</td>
<td>City</td>
<td>Players</td>
<td>Number Of Likes</td>
</thead>
<tbody>
<c:forEach items="${allTeams}" var="team">
<tr>
<td>
<c:choose>
<c:when test="${team.likers.contains(loggedInUser)}">
<a href="/unlike/${team.id}">UnLike</a>
</c:when>
<c:otherwise>
<a href="/like/${team.id}">Like!</a>
</c:otherwise>
</c:choose>
</td>


<td><a href="/${team.id}"><c:out value="${team.name}"/></a></td>
<td><c:out value="${team.city}"/></td>
<td><c:out value="${team.players}"/></td>
<td><c:out value="${team.likers.size() }"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>