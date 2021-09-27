package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDL {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); //注册驱动
		String url = "jdbc:mysql://47.94.161.113:3306/demo";
		Connection session = DriverManager.getConnection(url, "root", "Jack_19900922#");

		Statement statement = session.createStatement();

		String sql = "create table user(id int primary key auto_increment,username varchar(20) not null,"
				+ "password varchar(20) not null, birthday date)";
		statement.execute(sql);

		close(statement, session);
	}

	// 关闭资源
	private static void close(AutoCloseable... resourceList) {
		for (AutoCloseable resource : resourceList) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
