<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><c:out value="${model.topic.title}" /></title>
		
<style>
div {
    background-color: lightgrey;
    width: 460px;
    border: 5px solid green;
    padding: 25px;
    margin: 25px;
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
			<fmt:message key="forum.viewTopic.heading" />
			<c:out value="${model.topic.title}" />
		</h1>
		<p>
			<br>
			<div>
			# 0
			<br>
			<b><c:out value="${model.topic.author}" /></b>
			<fmt:message key="forum.viewTopic.said" />
			<fmt:message key="forum.viewTopic.at" />
			<b><c:out value="${model.topic.date}" /></b>
			<fmt:message key="forum.viewTopic.maohao" />
			<br>
			<fmt:message key="forum.viewTopic.line2" />
			<br>
			<br>
			<c:out value="${model.topic.content}" />
			</div>
			<c:set var = "stringElements" value = "${fn:split(model.topic.appendix, '#')}" />

			<c:forEach var="i" begin="1" end="${model.topic.replyCount}">
    				<c:set var = "strings" value = "${fn:split(stringElements[i], '$')}" />   				
					<div>
    				# <c:out value="${i}" />
    				<br>
    				<b><c:out value="${strings[0]}" /></b>
  					<fmt:message key="forum.viewTopic.said" />
					<fmt:message key="forum.viewTopic.at" />
  					<b><c:out value="${strings[1]}" /></b>
  					<fmt:message key="forum.viewTopic.maohao" />
					<br>
					<fmt:message key="forum.viewTopic.line2" />
					<br>
					<br>
  					<c:out value="${strings[2]}" />
  					<br>
  					<br>
  					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  					<a href = "../editSpecificReply/${model.topic.id }/${i}">Edit</a>
  					|
  					<a href = "../deleteSpecificReply/${model.topic.id }/${i}">Delete</a>
  					<br>
  					</div>
 			</c:forEach>			
			
		</p>
		
		<br>
		<font size="+3"><a href = "../replySpecificTopic/${model.topic.id }">Reply</a></font>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<font size="+3"><a href = "../viewAllTopics">Back to All Topics</a></font>
		<br>
		
		
	</body>
</html>