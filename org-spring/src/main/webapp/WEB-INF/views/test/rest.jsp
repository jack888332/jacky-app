<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${contextPath}/springmvc/testRest/1">Test Rest Get</a>
	<BR>
	<form action="${contextPath}/springmvc/testRest" method="post">
		<input type="submit" value="Test Rest Post">
	</form>
	<BR>
	<form action="${contextPath}/springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="Test Rest DELETE">
	</form>
	<BR>
	<form action="${contextPath}/springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="Test Rest PUT">
	</form>
	<BR>
</body>
</html>