<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<t:layout>
<h3>Profile</h3>
<hr>
<ul>
<h3>Teams Owned</h3>
<c:forEach items="${user.teamsOwned }" var="team">
<li><a href="${team.id}">${team.name}</a></li>
</c:forEach>
</ul>
</t:layout>