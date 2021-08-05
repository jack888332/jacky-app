<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form</title>
</head>
<body>
	<form action="userForm" method="post">
		<table>
			<tr>
				<td>账号</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>省份</td>
				<td><input type='text' name='address.province' /></td>
			</tr>
			<tr>
				<td>城市</td>
				<td><input type='text' name='address.city' /></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>