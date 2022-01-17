<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 根据CLASSPATH中搜索类 -->
<%@ page import="orm.bean.User"%>

<html>
<head>
<meta charset="UTF-8">
<title>user table</title>
<link rel="stylesheet" type="text/css" href="./mix.css" />

</head>
<body>
	<%
	ArrayList<User> userList = new ArrayList<User>();
	userList.add(new User(1, "Jack", "123"));
	userList.add(new User(2, "Rose", "1234"));
	userList.add(new User(3, "Mike", "12345"));
	userList.add(new User(4, "Tony", "123456"));
	request.setAttribute("users", userList);
	%>

	<table>
		<tr class="head">
			<td>编号</td>
			<td>账号</td>
			<td>密码</td>
			<td>注册时间</td>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="s">
			<tr class="row" onclick="setRowStyle(this, ${s.index})">
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.regdate}</td>
			</tr>
		</c:forEach>
	</table>

	<script src="./mix.js"></script>
</body>
</html>