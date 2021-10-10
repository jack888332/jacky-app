package model.business_logic.impl;

import java.util.List;

import model.bean.User;
import model.business_logic.UserCenterService;
import model.data_access.UserDao;
import model.data_access.impl.UserDaoImpl;

public class UserCenterServiceImpl implements UserCenterService{

	@Override
	public List<User> getAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUsers();
	}

}
