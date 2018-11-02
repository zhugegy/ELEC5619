<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><fmt:message key="forum.searchTopics.title" /></title>
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
			<fmt:message key="forum.searchTopics.heading" />
		</h1>
		<p>
			<fmt:message key="forum.searchTopics.greeting" />
			<c:out value="${model.now}" />
		</p>
		<form action="searchTopics" method="post">
		<select name="attributes">
		  <option value="title">title</option>
		  <option value="tag">tag</option>
		  <option value="author">author</option>
		  <option value="content">content</optioon>
		</select>
		contains <input type="text" name="tosearch" />
		<br>
		<br>
		<input type="submit" value="Search">
		<input type="button" value="Back" onclick="javascript:history.back(-1);" />
		</form>
		
		
		
	</body>
</html>