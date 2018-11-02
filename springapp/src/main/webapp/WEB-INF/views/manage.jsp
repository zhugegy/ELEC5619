<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
	<head>
		<title>User management</title>
		<style>
		h3{
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
			
		<p>
			<c:out value="${model.now}"/>
		</p>
		
		<h3>Users</h3>
		<p  style="text-align:center;"><c:forEach items="${model.users }" var="u">		
			ID: <c:out value="${u.id}"/>
			&emsp;&emsp;
			Username: <c:out value="${u.username}"/>
			&emsp;&emsp;
			<i>Password: <c:out value="${u.password}"/></i>
			&emsp;
			<a href="user/edit/${u.id }">edit</a>
			&emsp;
			<a href="user/delete/${u.id }">delete</a>
			<br>
			<br>
		</c:forEach></p>
		
		<br>
		<h3>
		Where is the user from the world?
		</h3>
		
		<br>
		<meta name="viewport" content="initial-scale=1.0">
	    <meta charset="utf-8">
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
	    </style>
	    <div id="map"></div>
	    <script>
	      var map;
	      function initMap() {
	        map = new google.maps.Map(document.getElementById('map'), {
	          center: {lat: -34.397, lng: 150.644},
	          zoom: 8
	        });
	      }
	    </script>
	    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD-gvlu9Z6YwGfZA6uC-Cxsam3DTYnsHQc&callback=initMap"
	    async defer></script>
		
		
	</body>
</html>