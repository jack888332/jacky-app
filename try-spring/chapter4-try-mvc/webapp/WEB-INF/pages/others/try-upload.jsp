<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ch">
<head>

</head>
<body>
    <p>以传统方式上传文件</p>
    <form action="${contextPath}/handlerForUploadFile/uploadFile1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file"/>
        <input type="submit" value="上传">
    </form>

    <p>以SpringMVC方式上传文件</p>
    <form action="${contextPath}/handlerForUploadFile/uploadFile2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/>
        <input type="submit" value="上传">
    </form>

    <p>跨服务器上传</p>
    <form action="${contextPath}/handlerForUploadFile/uploadFile3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/>
        <input type="submit" value="上传">
    </form>
</body>
</html>