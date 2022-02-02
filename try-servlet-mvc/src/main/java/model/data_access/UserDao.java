package model.data_access;

import model.bean.User;
import view.bean.LoginForm;

import java.util.List;

public interface UserDao {

	/**
	 * 验证登录信息
	 */
	User checkLoginInfo(LoginForm info);

	/**
	 * 按条件获取用户
	 */
	List<User> getUsers();

}
