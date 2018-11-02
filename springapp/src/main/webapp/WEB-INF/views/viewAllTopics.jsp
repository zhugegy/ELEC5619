<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="forum.viewAll.title" /></title>
		
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
.right {
    float: right;
    width: 200px;
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
		<h1>
			<fmt:message key="forum.viewAll.heading" />
		</h1>
		<p>
			<fmt:message key="forum.viewAll.greeting" />
			<c:out value="${model.now}" />
			
			<div class="right">
			<IMG SRC="https://s1.ax1x.com/2018/10/30/i2fR78.png">
			<font size="+3"><a href="<c:url value="searchTopics.htm"/>">Search</a></font>
			</div>
		</p>
		
		<table border="2" id="customers">
  <thead>
    <td>
      <th>Tags</th>
      <th>Replies</th>
      <th>Title</th>
      <th>Author</th>
      <th>Date</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items="${model.topics}" var="topi">
       <tr>
       	 <td></td>
       	 <c:set var = "stringTags" value = "${fn:split(topi.appendix, '#')}" />
       	 <c:set var = "stringTag" value = "${fn:split(stringTags[0], ',')}" />
       	 	<td>
       	 	<c:forEach items="${stringTag}" var="Tgs">
       	 		<a href = "searchSpecificTag/${Tgs}">${Tgs}</a>
       	 		&nbsp;&nbsp;
       	 	</c:forEach>
       	 </td>
         <td>${topi.replyCount}</td>
         <td><a href = "viewSpecificTopic/${topi.id }">${topi.title}</a></td>
         <td><a href = "viewSpecificAuthor/${topi.author }">${topi.author}</a></td>
         <td>${topi.date}</td>
         <td><a href = "deleteSpecificTopic/${topi.id }">delete</a></td>
       </tr>
     </c:forEach>
  </tbody>
</table>
		

	
		<!-- link to the increase price page -->
		
		<br>
		<font size="+3"><a href="<c:url value="postANewTopic.htm"/>">Post A New Topic</a></font>
		<br>
		
		
	</body>
</html>