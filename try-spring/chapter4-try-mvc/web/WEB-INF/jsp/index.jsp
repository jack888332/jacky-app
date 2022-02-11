<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"
		scope="application" />

	<a href="indexAction/gotoRest">REST</a>
	<br>
	<a href="testAction/requestParam?username=jack&age=18">@RequestParam</a>
	<br>
	<a href="testAction/requestHeader">@RequestHeader</a>
	<br>
	<a href="testAction/cookieValue">@CookieValue</a>
	<br>
	<a href="indexAction/gotoActionForm">ActionForm</a>
	<br>
	<a href="testAction/servletAPI">ServletAPI</a>
	<br>
	<a href="indexAction/gotoModelData">模型数据</a>
	<br>
	<a href="indexAction/jstlView">JSTL视图</a>
	<br>
	<a href="indexAction/customView">自定义视图</a>
	<br>
	<a href="testAction/redirect">重定向</a>
	<br>
	<a href="indexAction/crud">CRUD</a>
</body>
</html>