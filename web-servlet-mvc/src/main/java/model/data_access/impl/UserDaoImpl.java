package model.data_access.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import common.JDBCUtils;
import model.bean.User;
import model.data_access.UserDao;
import view.bean.LoginForm;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public User checkLoginInfo(LoginForm info) {
		try {
			String sql = "select * from user where username = ? and password = ?";
			User loginedUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
					info.getUsername(), info.getPassword());
			return loginedUser;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> getUsers() {
		try {
			String sql = "select * from user";
			List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
			return users;
		} catch (DataAccessException e) {
			return null;
		}
	}
}
