package demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MyJdbcUtils.getConnection();
			String sql = "insert into user values(null,?,?,null)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "Jacky");
			ps.setString(2, "123456");
			int rows = ps.executeUpdate();
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyJdbcUtils.close(ps, conn);
		}
		
	}
}
