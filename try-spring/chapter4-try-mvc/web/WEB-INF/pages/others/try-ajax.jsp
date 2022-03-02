<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function () {
            $("#button1").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/handlerForTryAjax/testAjax",
                    method: "POST",
                    contentType: "application/json; charset=UTF-8", //请求的媒体格式
                    dataType: "json", //将响应的数据类型
                    data: JSON.stringify({"id": 8888, "username": "jacky", "password": "jack123456", "address": null}), //请求数据
                    success: function (data) {
                        alert(data.username);
                        alert(data.password);
                    }
                })
            })
        });
    </script>
</head>
<body>
<button id="button1">发送Ajax请求</button>
</body>
</html>