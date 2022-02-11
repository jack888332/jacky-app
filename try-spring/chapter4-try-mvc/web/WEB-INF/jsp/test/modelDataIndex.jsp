<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="modelDateAction/modelAndView">ModelAndView</a>
	<br>
	<a href="modelDateAction/modelMap">ModelMap</a>
	<br>
	<a href="modelDateAction/sessionAttributes">@SessionAttributes</a>
	<br>
	<form action="modelDateAction/modelAttribute" method="post">
		<input type="hidden" name="id" value="1">
	 	<table>
			<tr>
				<td>账号</td>
				<td><input type='text' name='username' value="Jack" /></td>
			</tr>
			<tr>
				<td>省份</td>
				<td><input type='text' name='address.province' value="guangdong" /></td>
			</tr>
			<tr>
				<td>城市</td>
				<td><input type='text' name='address.city' value="guangzhou" /></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>