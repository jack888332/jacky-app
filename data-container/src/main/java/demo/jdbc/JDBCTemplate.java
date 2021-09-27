package demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import orm.domain.User;

public class JDBCTemplate {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Test
	public void test1() {
		String sql = "update user set password = ?";
		int rows = template.update(sql, "8768686");
		Assert.assertTrue(rows > 0);
	}

	@Test
	public void test2() {
		String sql = "insert into user values(null, ?, ?, null)";
		int rows = template.update(sql, "Rose", "545345345");
		Assert.assertTrue(rows > 0);
	}

	@Test
	public void test3() {
		String sql = "delete from user where id = ?";
		int rows = template.update(sql, "4");
		Assert.assertTrue(rows > 0);
	}

	@Test
	public void test4() {
		String sql = "select * from user where id = ?";
		Map<String, Object> row = template.queryForMap(sql, "2");
		System.out.println(row);
	}

	@Test
	public void test5() {
		String sql = "select * from user";
		List<Map<String, Object>> rows = template.queryForList(sql);
		for (Map<String, Object> row : rows) {
			System.out.println(row);
		}
	}

	@Test
	public void test6() {
		String sql = "select * from user";
		List<User> rows = template.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
		});

		for (User row : rows) {
			System.out.println(row);
		}
	}

	@Test
	public void test7() {
		String sql = "select * from user";
		List<User> rows = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
		for (User row : rows) {
			System.out.println(row);
		}
	}

	@Test
	public void test8() {
		String sql = "select count(id) from user";
		Integer rowsCount = template.queryForObject(sql, Integer.class);
		System.out.println(rowsCount);
	}
}
