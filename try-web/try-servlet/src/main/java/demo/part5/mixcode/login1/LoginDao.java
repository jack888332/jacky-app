package demo.part5.mixcode.login1;

import domain.JDBCUtils;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
