package demo.part5.mixcode.login2;

import domain.LoginInfo;
import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.Map;

@WebServlet("/exercise-login2/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("UTF-8");
		// 2.获取请求参数
		LoginInfo loginInfo = new LoginInfo();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(loginInfo, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.从session中获取刚生成的验证码
		HttpSession session = request.getSession();
		String checkcode = (String) session.getAttribute("checkcode");
		session.removeAttribute("checkcode");

		// 4.忽略大小写比较验证码
		if (checkcode != null && checkcode.equalsIgnoreCase(loginInfo.getCheckcode())) {
			LoginDao loginDao = new LoginDao();
			User user = loginDao.login(loginInfo);
			if (user == null) {
				// 登录失败
				request.setAttribute("error-2", "账号或密码错误");
				request.getRequestDispatcher("/exercise-login2/login.jsp").forward(request, response);
			} else {
				// 登录成功
				request.setAttribute("user", user.toString());
				request.getRequestDispatcher("/exercise-login2/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error-1", "验证码错误");
			request.getRequestDispatcher("/exercise-login2/login.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
