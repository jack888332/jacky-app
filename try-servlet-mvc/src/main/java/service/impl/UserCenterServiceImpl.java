package service.impl;

import model.bean.User;
import model.data_access.UserDao;
import model.data_access.impl.UserDaoImpl;
import service.UserCenterService;

import java.util.List;

public class UserCenterServiceImpl implements UserCenterService{

	@Override
	public List<User> getAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUsers();
	}

}
