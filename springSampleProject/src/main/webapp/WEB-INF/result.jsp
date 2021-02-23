<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open Mic Night Reuslts</title>
</head>
<body>
<h1>That was Funny!</h1>
<hr>
<p>Name: <c:out value="${viewModelName}"/></p>
<p>Email: <c:out value="${viewModelEmail}"/></p>
<p>Joke: <c:out value="${viewModelJoke}"/></p>
</body>
</html>