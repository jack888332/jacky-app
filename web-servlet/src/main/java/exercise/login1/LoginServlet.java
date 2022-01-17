package exercise.login1;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import orm.bean.User;

@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.设置编码
		req.setCharacterEncoding("UTF-8");
		// 2.获取请求参数
//		User loginInfo = new User();
//		loginInfo.setUsername(req.getParameter("username"));
//		loginInfo.setPassword(req.getParameter("password"));
		Map<String, String[]> map = req.getParameterMap();
		User loginInfo = new User();
		try {
			BeanUtils.populate(loginInfo, map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3.调用DAO
		LoginDao loginDao = new LoginDao();
		User user = loginDao.login(loginInfo);

		if (user == null) {
			// 登录失败
			req.getRequestDispatcher("/login-fail").forward(req, resp);
		} else {
			// 登录成功
			req.setAttribute("user", user);
			req.getRequestDispatcher("/login-success").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
