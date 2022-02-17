<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>

<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/mime/css/mix.css" />
</head>

<body>
	<div class="main">
		<form action="${pageContext.request.contextPath}/login" method="POST">
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
						<img id="checkcode" src="${pageContext.request.contextPath}/login/checkcode" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登录">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/mime/js/mix.js"></script>

</html>