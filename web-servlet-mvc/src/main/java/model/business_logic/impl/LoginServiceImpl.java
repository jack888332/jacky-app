package model.business_logic.impl;

import model.bean.User;
import model.business_logic.LoginService;
import model.data_access.UserDao;
import model.data_access.impl.UserDaoImpl;
import view.bean.LoginForm;

public class LoginServiceImpl implements LoginService{

	@Override
	public User checkLoginInfo(LoginForm info) {
		UserDao userDao = new UserDaoImpl();
		return userDao.checkLoginInfo(info);
	}

}
