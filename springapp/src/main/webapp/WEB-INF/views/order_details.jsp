<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Order Details</title>
		<style>
		      /* Always set the map height explicitly to define the size of the div
		       * element that contains the map. */
		      #map {
		        height: 100%;
		      }
		      /* Optional: Makes the sample page fill the window. */
		      html, body {
		        height: 100%;
		        margin: 0;
		        padding: 0;
		      }
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
		<h4 class="logo">Please check the Order Information and confirm the transaction</h4>
		</header>
		<div id="map"></div>
		<script>
		      var map;
		      function initMap() {
		        map = new google.maps.Map(document.getElementById('map'), {
		          center: {lat: -33.888531, lng: 151.187358},
		          zoom: 18
		        });
		      }
   		 </script>
    	 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAdnvWJa8Uwn0dC5-R6g1BK13kyH_q0Gvk&callback=initMap"
    async defer></script>		
			<sf:form method="POST" modelAttribute="sale">
			<fieldset>
				<table>
					<tr>
						<th><label for="sale_location">Location: </label></th>
						<td><sf:input path="location" /></td>
					</tr>
					<tr>
						<th><label for="sale_time">Time to meet:</label></th>
						<td><sf:input path="time" /></td>
					</tr>
					<tr>
						<th><label for="sale_contact">Contact Information:</label></th>
						<td><sf:input path="contact" /></td>
					</tr>
					<tr>
						<th><label for="sale_quantity">Quantity:</label></th>
						<td><sf:input path="quantity" /></td>
					</tr>
					<tr>			
						<td><input type="submit" value="Confirm"/></a></td>
						
					</tr>
				</table>			
			</fieldset>
			
		</sf:form>
		</div>
	</body>
</html>