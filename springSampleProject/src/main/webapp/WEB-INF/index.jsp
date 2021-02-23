<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java February 2021 - Open Mic Night</title>
</head>
<body>
<h1>Open Mic Night, What's Your Joke?</h1>
<form method="POST" action="/process">
<p>Your Name: <input type="text" name="name"></p>
<p>Your email: <input type="text" name="email"></p>
<p>Your Joke: <textarea name="joke"></textarea></p>

<button>Submit Joke!</button>


</form>

</body>
</html>