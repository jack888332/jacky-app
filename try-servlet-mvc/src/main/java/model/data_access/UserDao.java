package model.data_access;

import java.util.List;

import model.bean.User;
import view.bean.LoginForm;

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
