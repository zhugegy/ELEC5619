<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
	<head>
		<title>USYD Forum</title>
	<style>
		h1{
		background-color:#87CEEB;
		padding-top:50px;
		padding-bottom:50px;
		text-align:center;
		font-family:Segoe UI Light;
		color:#FFFFFF;
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
		<br><br>
		<!-- link to the register page -->
			<h1><a href="<c:url value="/user/register.htm"/>">Register</a></h1>			
		<br>		
		<!-- link to the login page -->
			<h1><a href="<c:url value="/user/login.htm"/>">Login</a></h1>
		<br>
		<!-- link to the user management page -->
			<h1><a href="<c:url value="/user/manage.htm"/>">User management</a></h1>
		<br>

	</body>
</html>