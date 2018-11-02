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
</style>
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
</style>
	<style>
	h1{
	text-align: center;
	font-size:30;
	font-family:Arial;
	}
	tbody{
	text-align:center;
	font-size:20;
	font-family:Arial;
	}
	p{
	text-align:center;
	font-size:20;
	font-family:Arial;
	}
	</style>
		<title><c:out value="${model.item.item_id}" /></title>
	</head>
	<br>
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
			Item Information:
			<c:out value="${model.item.name}" />
		</h1>
		<br>
		<p>
			==========================
			<c:out value="${model.now}" />
			==========================
			<br><br>
			<table border="2">
			<br>
  <thead>
  <table id="customers">
    <td>
      <th>item_id</th>
      <th>name</th>
      <th>category</th>
      <th>quntity</th>
      <th>price</th>
      <th>seller</th>
      <th>description</th>
    </td>
  </thead>
  <tbody>
       <tr>
       	 <td></td>
       	 <td>${model.item.item_id}</td>
         <td>${model.item.name}</td>
         <td>${model.item.category}</td>
         <td>${model.item.quntity}</td>
         <td>${model.item.price}</td>
         <td>${model.item.seller}</td>
         <td>${model.item.description}</td>
         <td><a href = "addtoCart/${model.item.item_id }">addtoCart</a></td>
         <td><a href = "UpdateItem/${itm.item_id }">Update</a></td>
       </tr>

  </tbody>
</table>
		</p>		
	</body>
</html>