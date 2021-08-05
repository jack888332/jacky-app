package demo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJdbcUtil {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/jacky";
		Connection session = DriverManager.getConnection(url, "root", "Jack_19900922");

		// resultSetType:
		// TYPE_FORWARD_ONLY、TYPE_SCROLL_INSENSITIVE、TYPE_SCROLL_SENSITIVE
		// resultSetConcurrency:
		// CONCUR_READ_ONLY、CONCUR_UPDATABLE
		// resultSetHoldability:
		// HOLD_CURSORS_OVER_COMMIT、CLOSE_CURSORS_AT_COMMIT
		Statement statement = session.createStatement();

		String sql = "create table user(" + "id int primary key auto_increment," + "nickname varchar(20) not null,"
				+ "password varchar(20) not null," + "birthday date" + ")";

		Boolean result = statement.execute(sql);
		System.out.println(result);
		// PreparedStatement ps;
		// CallableStatement cs;
		// ResultSet rs;

		close(statement);
		close(session);
	}

	// 关闭资源
	private static void close(AutoCloseable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
