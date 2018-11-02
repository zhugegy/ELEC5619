<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Edit a user on this page</title>
		<style>
		h1{
		background-color:#87CEEB;
		padding-top:15px;
		padding-bottom:15px;
		text-align:center;
		font-family:Segoe UI Light;
		color:#FFFFFF;
		font-size:30;
		}
		</style>
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
		<img src="https://vignette.wikia.nocookie.net/bungostraydogs/images/1/1e/Profile-icon-9.png/revision/latest?cb=20171030104015" alt="" class="profile" height="25" width="25" align="right">
		
		<!-- link to the register page -->
			<p  style="text-align:right;"><a href="<c:url value="/user/register.htm"/>">Register</a>|

		<!-- link to the login page -->
			<a href="<c:url value="/user/login.htm"/>">Login</a>|
		
		<!-- link to the user management page -->
			<a href="<c:url value="/user/manage.htm"/>">User management</a></p>
	
		<h1>You can edit the user shown below</h1>
		<sf:form method="POST" modelAttribute="user">
			<fieldset>
				<table>
					<tr>
						<th><label for="user_username">Username:</label></th>
						<td><sf:input path="username"/></td>
					</tr>
					<tr>
						<th><label for="user_password">Password:</label></th>
						<td><sf:input path="password"/></td>
					</tr>
					<tr>
						<th><input type="button" Value="Back" onClick="javascript:history.back(-1);"></th>
						<!-- This hidden field is required for Hibernate to recognize this Product -->
						<td><sf:hidden path="id"/>
						<td><input type="submit" value="Done"/></td>
					</tr>
				</table>
			</fieldset>
		</sf:form>
	</body>
</html>