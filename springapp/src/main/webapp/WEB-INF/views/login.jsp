<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
	<head>
		<title>Login</title>
	<style type="text/css">
	h1 {
	background-color:#87CEEB;
	padding-top:150px;
	padding-bottom:150px;
	text-align:center;
	font-family:Segoe UI Light;
	color:#FFFFFF;
	}
	form{
	text-align:center;		 
	}
	input{
	width: 200px;
	margin-top: 40px;
	margin-right: auto;
	margin-bottom: auto;
	margin-left: auto;
	padding-top: 20px;
	padding-right: 10px;
	padding-bottom: 20px;
	padding-left: 10px;
	text-align: center;
	border-radius: 0px;
	font-weight: bold;
	letter-spacing: 2px;
	border: 3px solid #DCDCDC;
	color: #696969;
	transition: all 0.3s linear;
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

	<h1>You can login your account on this page</h1>
	<f:form method="POST" action="${pageContext.request.contextPath}/user/validateUser">
		&emsp;&emsp;&emsp;&nbsp;ID: &nbsp;<input type="text" name="id"/>
		<br>
		Password: <input type="password" name="password"/>
		<br>
 		<input type="reset" value="Reset"/>
		&emsp;&emsp;&emsp;
		<input type="submit" value="Login"/>
<!-- 		&emsp;&emsp;&emsp;
		<input type="button" Value="Back" onClick="javascript:history.back(-1);"> -->
	</f:form>

	</body>
</html>