<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:set scope="application" var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="router/try-REST">尝试REST</a>
	<br>
	<a href="handlerForBaseTest/requestParam?username=jack&age=18">@RequestParam</a>
	<br>
	<a href="handlerForBaseTest/requestHeader">@RequestHeader</a>
	<br>
	<a href="handlerForBaseTest/cookieValue">@CookieValue</a>
	<br>
	<a href="router/gotoActionForm">ActionForm</a>
	<br>
	<a href="handlerForBaseTest/servletAPI">ServletAPI</a>
	<br>
	<a href="router/gotoModelData">模型数据</a>
	<br>
	<a href="router/jstlView">JSTL视图</a>
	<br>
	<a href="router/customView">自定义视图</a>
	<br>
	<a href="handlerForBaseTest/redirect">重定向</a>
	<br>
	<a href="router/crud">CRUD</a>
	<br>
	<a href="router/try-ajax">尝试Ajax请求</a>
    <br>
    <a href="router/try-upload">尝试上传文件</a>
</body>
</html>