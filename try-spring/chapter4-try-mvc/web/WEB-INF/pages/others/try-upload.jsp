<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ch">
<head>

</head>
<body>
    <form action="handlerForUploadFile/" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/>
        <input type="submit" value="上传">
    </form>
</body>
</html>