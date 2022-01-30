<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String, String> genders = new HashMap<String, String>();
		genders.put("0", "Mail");
		genders.put("1", "Femail");
		request.setAttribute("genders", genders);
	%>

	<!-- from标签能够便于开发表单页面及表单值得回显 -->
	<form:form action="emp" method="post" modelAttribute="employee">
		<table>
			<tr>
				<td>姓名</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><form:radiobuttons path="gender" items="${genders}" /></td>
			</tr>
			<tr>
				<td>部门</td>
				<td><form:select path="department.id" items="${departments}" itemLabel="name" itemValue="id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>