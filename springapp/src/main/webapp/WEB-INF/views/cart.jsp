<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
		
		<style>
			/* Body */
			body {
				font-family: source-sans-pro;
				background-color: #f2f2f2;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				margin-left: 0px;
				font-style: normal;
				font-weight: 200;
			}
			/* Container */
			.container {
				width: 90%;
				margin-left: auto;
				margin-right: auto;
				height: 1000px;
				background-color: #FFFFFF;
			}
			/* Navigation */
			header {
				width: 100%;
				height: 5%;
				background-color: #6d808a;
				border-bottom: 1px solid #2C9AB7;
			}
			.logo {
				color: #fff;
				font-weight: bold;
				text-align: undefined;
				width: 10%;
				float: left;
				margin-top: 15px;
				margin-left: 25px;
				letter-spacing: 4px;
			}
			nav {
				float: right;
				width: 50%;
				text-align: right;
				margin-right: 25px;
			}
			header nav ul {
				list-style: none;
				float: right;
			}
			nav ul li {
				float: left;
				color: #FFFFFF;
				font-size: 14px;
				text-align: left;
				margin-right: 25px;
				letter-spacing: 2px;
				font-weight: bold;
				transition: all 0.3s linear;
			}
			ul li a {
				color: #FFFFFF;
				text-decoration: none;
			}
			.hero_header {
				color: #FFFFFF;
				text-align: center;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				margin-left: 0px;
				letter-spacing: 4px;
			}
			/* Hero Section */
			.hero {
				background-color: #B3B3B3;
				padding-top: 7px;
				padding-bottom: 7px;
			}
			}
			
			/* Stats Gallery */
			.stats {
				color: #717070;
				margin-bottom: 5px;
				
			}
			.gallery {
				clear: both;
				display: inline-block;
				width: 100%;
				background-color: #FFFFFF;
				padding-bottom: 35px;
				padding-top: 0px;
				margin-bottom: 0px;
			}
			.thumbnail {
				width: 100%;
				text-align: center;
				margin-top: 35px;
			}
			.gallery .thumbnail h4 {
				margin-top: 5px;
				margin-right: 5px;
				margin-bottom: 5px;
				margin-left: 5px;
				color: #52BAD5;
			}
			.gallery .thumbnail p {
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				margin-left: 0px;
				color: #A3A3A3;
			}
			footer {
				background-color: #FFFFFF;
				padding-bottom: 35px;
			}
			.button {
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
				vertical-align: middle;
				border-radius: 0px;
				text-transform: uppercase;
				font-weight: bold;
				letter-spacing: 2px;
				border: 3px solid #52bad5;
				color: #FFFFFF;
				transition: all 0.3s linear;
			}
		</style>
	</head>
	<body>		
	<div class="container">
		 <header>
		 <h4 class="logo">My Cart</h4>
		 <nav><ul>
		 <li><a href="cart.htm">cart</a></li>
		 <li><a href="order.htm">order</a></li>
		 <li><a href="sale.htm">sales record</a></li>
		 <li><a href=<fmt:message key="user.homepage" />>Account</a></li>
		
		<li><a href=<fmt:message key="forum.homepage" />>Forum</a></li>
		
		<li><a href=<fmt:message key="shop.homepage" />>Shop</a></li>
				
		<li><a href=<fmt:message key="help.homepage" />>Help</a></li>
		 </ul></nav>
		 </header>

		<p>
			<c:out value="${model.now}" />
		</p>
		<section class="hero">
		<h3 class="hero_header">Items</h3>
		</section>
		<sf:form method="POST" modelAttribute="cart">
		<div class="gallery">
		<c:forEach items="${model.carts}" var="prod">
				<div class="thumbnail">
				<h1 class="stats"><c:out value="${prod.name}" /></h1>
				<h4><i>$<c:out value="price: ${prod.price}" /></i></h4>
				<p><c:out value="description: ${prod.description}" /> </p>
				<p><c:out value="seller: ${prod.seller}" /> </p>
				<p><c:out value="quantity: ${prod.quantity}" /> </p>
			<div class="button">	
			<p><a href="cart/edit/${prod.id }">edit</a></p>
			<p><a href="cart/delete/${prod.id }" onclick="return confirmd()">delete</a></p>             
			<br>
			<p><a href="cart/checkout/${prod.id }">checkout</a></p>
			<br>
			</div>
			</div>
		</c:forEach>
		</div>
		</sf:form>

		
		<a href="cart/add/${prod.id }">add</a>  
	</div>
	</body>
</html>