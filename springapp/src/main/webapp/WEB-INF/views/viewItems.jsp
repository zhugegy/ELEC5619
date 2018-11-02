<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
	<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
h1{
text-align:center;
font-size:40;
font-family:Arial;
color:#000000}
</style>


		<title>Shop</title>
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
			Shop
			
		</h1>
		
		<p style="text-align:center;">
		
			Items for viewing
			<br><br>
			<td><a href = "Wantedtosell/${itm.item_id }">Wantedtosell</a></td>
			&nbsp;
			
			&nbsp;
			<td><a href = "UpdateItem/${itm.item_id }">Update</a></td>
			&nbsp;
		</p>
		
		<table border="2">
		<table id="customers">
  <thead>
  
    <td>
    
      <th>Name</th>
      <th>Price</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items="${model.items}" var="itm">
       <tr>
       	 <td></td>
       	 <td><a href = "viewSpecificItem/${itm.item_id }">${itm.name}</a></td>
         <td>${itm.price}</td>
         <td><a href = "delete/${itm.item_id }">delete</a></td>
         <td><a href = "addtoCart/${itm.item_id }">addtoCart</a></td>
       </tr>
     </c:forEach>
  </tbody>
</table>
		

		
	</body>
</html>