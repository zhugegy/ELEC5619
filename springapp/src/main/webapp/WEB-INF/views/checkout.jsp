<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Checkout</title>
		<style type="text/css">
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
				width: 60%;
				margin-top: 15px;
				margin-left: 25px;
				letter-spacing: 4px;
			}
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
		</style>
	</head>
	<body>
		<div class="container">
		<header>	
		<h4 class="logo">Please fill in the details of transaction</h4>
			<form action="checkout" method="post">
			<div class="gallery">
				<table>
					<tr>
						<th>Enter the location to meet the seller and complete the transaction face-to-face</th>
						<td><input type="text" name="location"/></td>
					</tr>
					<tr>
						<th>Enter the time to meet with the seller</th>
						<td><input type="text" name="time"/></td>
					</tr>
					<tr>
						<th>Please leave your contact information for the seller to find you</th>
						<td><input type="text" name="contact"/></td>
					</tr>
					<tr>
						<th><a href="cart.htm"><button>Cancel</button></a></th>
						<td><input type="submit" value="Checkout"/></td>
					</tr>
				</table>
			</div>			
			</form>
		</header>
	</body>
</html>