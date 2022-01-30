package service.impl;

import java.util.List;

import model.bean.User;
import model.data_access.UserDao;
import model.data_access.impl.UserDaoImpl;
import service.UserCenterService;

public class UserCenterServiceImpl implements UserCenterService{

	@Override
	public List<User> getAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUsers();
	}

}
