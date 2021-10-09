package exercise.login1;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import orm.domain.JDBCUtils;
import orm.domain.User;

public class LoginDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	public User login(User loginInfo) {
		try {
			String sql = "select * from user where username = ? and password = ?";
			User targetUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
					loginInfo.getUsername(), loginInfo.getPassword());
			return targetUser;
		} catch (DataAccessException e) {
			// 记录日志
			return null;
		}
	}
}
