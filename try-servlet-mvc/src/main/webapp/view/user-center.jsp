<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta charset="UTF-8">
<title>user list</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/mime/css/mix.css" />
</head>

<body>
    <div id="controlBar">
    	<button id="add">添加</button>
    	<button id="add">查询</button>
    </div>
	<table>
		<tr class="head">
			<td>编号</td>
			<td>账号</td>
			<td>密码</td>
			<td>注册时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="s">
			<tr class="row" onclick="setRowStyle(this, ${s.index})">
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.regdate}</td>
				<td>
					<button id="modify">修改</button>
					<button id="delete">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

<script src="${pageContext.request.contextPath}/mime/js/mix.js"></script>

</html>