<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
<meta charset="UTF-8">
<title>login</title>
<script src="multi-page.js"></script>
<link rel="stylesheet" type="text/css" href="multi-page.css" />
</head>
<body>
	<div class="main">
		<form action="${pageContext.request.contextPath}/exercise-login2/login" method="POST">
			<table>
				<tr>
					<td>账号</td>
					<td>
						<input type="text" name="username" placeholder="账号">
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="text" name="password" placeholder="密码">
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td>
						<input type="text" name="checkcode" placeholder="验证码">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<img id="checkcode" src="${pageContext.request.contextPath}/exercise-login2/checkcode" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登录">
					</td>
				</tr>
			</table>
		</form>
		<div class="error"><%=request.getAttribute("error-1")%></div>
		<div class="error"><%=request.getAttribute("error-2")%></div>
		<div><%=request.getAttribute("user")%></div>
	</div>
</body>

</html>