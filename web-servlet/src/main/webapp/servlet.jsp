<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.FileInputStream"%>

<html>

<head>
<meta charset="UTF-8">
<title>Servlet 转成 JSP</title>
<!-- http://localhost/mydemo/servlet.jsp?imageName=demo1.jpg -->
</head>

<body>
	<%
	// 1、获取请求参数中的资源名称
	String imageName = request.getParameter("imageName");
	// 2、获取服务器文件在操作系统中的真实路径
	ServletContext context = this.getServletContext();
	// 3、字节输入流关联到该文件
	FileInputStream fis = new FileInputStream(context.getRealPath("/images/" + imageName));
	// 4、设置相应头，告诉浏览器以附件形式打开文件（弹出文件下载提示框）
	response.setHeader("content-type", context.getMimeType(imageName));
	response.setHeader("content-disposition", "attachment;filename=" + imageName);
	// 5、字节输入流读取文件数据进内存缓冲区，再写进字节输出流
	ServletOutputStream sos = response.getOutputStream();
	byte[] buffer = new byte[1024 * 8];
	int lenth = 0;
	while ((lenth = fis.read(buffer)) != -1) {
		sos.write(buffer, 0, lenth);
	}
	fis.close();
	%>
</body>

</html>