package demo.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/downloadResource")
@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、获取请求参数中的资源名称
		String imageName = req.getParameter("imageName");
		// 2、获取服务器文件在操作系统中的真实路径
		ServletContext context = this.getServletContext();
		// 3、字节输入流关联到该文件
		FileInputStream fis = new FileInputStream(context.getRealPath("/images/" + imageName));
		// 4、设置相应头，告诉浏览器以附件形式打开文件（弹出文件下载提示框）
		resp.setHeader("content-type", context.getMimeType(imageName));
		resp.setHeader("content-disposition", "attachment;filename=" + imageName);
		// 5、字节输入流读取文件数据进内存缓冲区，再写进字节输出流
		ServletOutputStream sos = resp.getOutputStream();
		byte[] buffer = new byte[1024 * 8];
		int lenth = 0;
		while ((lenth = fis.read(buffer)) != -1) {
			sos.write(buffer, 0, lenth);
		}
		fis.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
