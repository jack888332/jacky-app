package service.impl;

import model.bean.User;
import model.data_access.UserDao;
import model.data_access.impl.UserDaoImpl;
import service.LoginService;
import view.bean.LoginForm;

public class LoginServiceImpl implements LoginService{

	@Override
	public User checkLoginInfo(LoginForm info) {
		UserDao userDao = new UserDaoImpl();
		return userDao.checkLoginInfo(info);
	}

}
