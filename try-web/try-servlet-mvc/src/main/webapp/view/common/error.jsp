<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
<meta charset="UTF-8">
<title>error</title>
</head>

<body>
	<p>登录失败：账号或密码错误</p>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<button type="submit">知道了</button>
	</form>

</body>

</html>