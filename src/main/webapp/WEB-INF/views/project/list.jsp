<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty requestScope.employees}">
		没有任何员工信息！
	</c:if>
	<c:if test="${!empty requestScope.employees}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.employees}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.email}</td>
					<td>${emp.gender}</td>
					<td>${emp.department.name}</td>
					<td><a>修改</a></td>
					<td><a>删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br><hr><br>
	<a href="emp">Add New Employee</a>
</body>
</html>