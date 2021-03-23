<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Team Details</title>
</head>
<body>
<div class="container">
<h2>Details For ${team.name}</h2>
<p><a href="/profile/${team.owner.id}">Owner ${team.owner.fullName}</a></p>
<h3>Liked By:</h3>
<ol>
<c:forEach items="${team.likers}" var="user">
<li>${user.fullName}</li>
</c:forEach>
</ol>
<hr>
<h2>Name:</h2>
<p>${team.name}</p>
<h2>City</h2>
<p>${team.city}</p>
<h2># Of Players</h2>
<p>${team.players}</p>
<hr>
<h3>Players On Roster</h3>
<table class="table table-dark">
<thead>
<tr>
<td>Name</td>
<td>Number</td>
<td>Weight</td>
</tr>
</thead>
<tbody>
<c:forEach items="${team.playersOnTeam}" var="player">
<tr>
<td>${player.name}</td>
<td>${player.number}</td>
<td>${player.weight}</td>
<td>${player.date}</td>
</tr>
</c:forEach>

</tbody>
</table>
<c:choose>
<c:when test="${team.mascot != null }">
<h2>Mascot</h2>
<hr>
<p>Name: ${team.mascot.name }</p>

<p>Cheer: ${team.mascot.cheer}</p>

<p>Type: ${team.mascot.type}</p>
</c:when>
<c:otherwise>
<h3>Add Mascot</h3>
<hr>
<form:form method="POST" action="/mascot/${team.id}" modelAttribute="mascot">
<div class="form-group">
<form:label path="name">Name
<form:errors path="name"/>
<form:input path="name"/></form:label>
</div>
<div class="form-group">
<form:label path="cheer">Cheer
<form:errors path="cheer"/>
<form:input path="cheer"/></form:label>
</div>

<div class="form-group">
<form:label path="type">Type
<form:errors path="type"/>
<form:input path="type"/></form:label>
</div>


<button>Create Mascot</button>

</form:form>
</c:otherwise>
</c:choose>

<hr>
<c:if test="${team.owner.id == user.id }">
<h3>Edit This Team</h3>

<form:form method="POST" action="/edit/${team.id}" modelAttribute="team">
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
<button>Edit Team!</button>
</form:form>
<a href="/delete/${team.id}" class="btn btn-danger">Delete</a>
</c:if>
</body>
</html>