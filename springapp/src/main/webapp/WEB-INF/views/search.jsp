<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
	<head>
	</head>
	<body>
		<form action="search" method="get">
			ID: <input type="text" name="id"/>
			<input type="submit" value="Search"/>
		</form>
		<p>
			<c:out value="${model.now}"/>
		</p>
		
		<h3>Users</h3>
		<c:forEach items="${model.users }" var="u">
		
			ID: <c:out value="${u.id}"/>
			Username: <c:out value="${u.username}"/>
			<i>Password: <c:out value="${u.password}"/></i>
			<br>
			<br>
		</c:forEach>
		
	</body>
</html>