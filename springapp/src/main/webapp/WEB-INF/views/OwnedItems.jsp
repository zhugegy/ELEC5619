<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><c:out value="${model.item.seller_id}" /></title>
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
			Owned Item Information:
			<c:out value="${model.item.seller}" />
		</h1>
		<p>
			=============================================
			<c:out value="${model.now}" />
			<br>
			<table border="2">
  <thead>
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
     <c:forEach items="${model.items}" var="itm">
       <tr>
       	 <td></td>
       	 <td>${itm.item_id}</td>
         <td>${itm.name}</td>
         <td>${itm.category}</td>
         <td>${itm.quntity}</td>
         <td>${itm.price}</td>
         <td>${itm.seller}</td>
         <td>${itm.description}</td>
         <td><a href = "delete/${itm.item_id }">delete</a></td>
       </tr>
     </c:forEach>
  </tbody>
</table>
		</p>		
	</body>
</html>