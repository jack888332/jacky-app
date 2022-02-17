<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
<!-- EL:JSP默认支持  JSTL:JSP标准标签库 -->
</head>
<body>
	<!-- Java片段 -->
	<%
		request.setAttribute("flag1", 1);
		session.setAttribute("flag2", 5);
	
		ArrayList<String> list = new ArrayList<String>();
		list.add("money");
		list.add("honey");
		list.add("funny");
		request.setAttribute("names", list);
	%>

	<c:if test="${flag1 == 3}">
		<p>命中</p>
	</c:if>

	<c:choose>
		<c:when test="${flag1 == 1}">
			<p>番薯</p>
		</c:when>
		<c:when test="${flag1 == 2}">
			<p>葡萄</p>
		</c:when>
		<c:when test="${flag1 == 3}">
			<p>苹果</p>
		</c:when>
		<c:otherwise>
			<p>啥都没有</p>
		</c:otherwise>
	</c:choose>

	<c:forEach begin="1" end="8" step="2" var="i" varStatus="s">
		<p>${i}#${s.index}#${s.count}</p>
	</c:forEach>

	<c:forEach items="${names}" var="name" varStatus="s">
		<p>${name}#${s.index}#${s.count}</p>
	</c:forEach>

</body>

</html>