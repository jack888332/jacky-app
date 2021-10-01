package demo.servlet.part3;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkLoginStatus")
@SuppressWarnings("serial")
public class BrowserCacheDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		boolean flag = false; // 信号-找到目标cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("lastTime".equals(name)) {
					flag = true;
					String formerValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
					response.getWriter().write("上次访问时间：" + formerValue);
					cookie.setValue(URLEncoder.encode(getFormattedTime(), "UTF-8"));
					cookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(cookie);
				}
				break;
			}
		}
		if (!flag) {
			response.getWriter().write("欢迎首次登录");
			Cookie cookie1 = new Cookie("lastTime", URLEncoder.encode(getFormattedTime(), "UTF-8"));
			cookie1.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookie1);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getFormattedTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd kk:mm:ss", new Locale("zh", "CN"));
		return sdf.format(Calendar.getInstance().getTime());
	}
}
