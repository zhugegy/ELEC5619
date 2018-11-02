<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="forum.viewAuthor.title" /></title>
	</head>
	<body>
		<a href=<fmt:message key="forum.homepage" />><IMG SRC="https://s1.ax1x.com/2018/10/30/i22J6P.jpg"></a>
		<a href=<fmt:message key="user.homepage" />>Account</a>
		|
		<a href=<fmt:message key="forum.homepage" />>Forum</a>
		|
		<a href=<fmt:message key="shop.homepage" />>Shop</a>
		|
		<a href=<fmt:message key="cart.homepage" />>Cart</a>
		|
		<a href=<fmt:message key="help.homepage" />>Help</a>
		|
		<h1>
			<fmt:message key="forum.viewAuthor.heading" />
		</h1>
		<p>
			<IMG SRC="${model.pic}">
			<br>
			name: <c:out value="${model.name}" />
			<br>
			company: <c:out value="${model.company}" />
			<br>
			email: <c:out value="${model.email}" />
			<br>
			repos: <c:out value="${model.repos}" />
			<br>
			followers: <c:out value="${model.followers}" />
			<br>
			following: <c:out value="${model.following}" />
			
		</p>
		
		<br>

		<a href = "../viewAllTopics">Back to All Topics</a>
		<br>
		
		
	</body>
</html>