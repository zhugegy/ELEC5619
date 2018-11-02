<%@ include file="/WEB-INF/views/include.jsp"%><html><html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Please add a new item on this page</title>
			<style>
	h1{
	text-align: center;
	font-size:30;
	font-family:Arial;
	}
	form{
	text-align:center;
	font-size:20;
	font-family:Arial;
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

		<h1>Hi, firstly, you can update the new item, and then delete the original item</h1>
		<form action="add" method="post">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Name: <input type="text" name="name"/>
			<br><br>
			&nbsp;&nbsp;&nbsp;
			Category: <input type="text" name="category"/>
			<br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Seller: <input type="text" name="seller"/>
			<br><br>
			&nbsp;&nbsp;&nbsp;
			Seller_id: <input type="text" name="seller_id"/>
			<br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Quntity: <input type="text" name="quntity"/>
			<br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Price: <input type="text" name="price"/>
			<br><br>
			Description: <input type="text" name="description"/>
			&nbsp;&nbsp;&nbsp;
			<br>
			<br>
			<br>
			<input type="submit" value="Update"/>
		</form>
	</body>
</html>