package demo.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 配置文件放在CLASSPATH跟目录
		ComboPooledDataSource cpds = new ComboPooledDataSource();

		for (int i = 1; i <= 11; i++) {
			Connection connection = cpds.getConnection();
			System.out.println(i + " : " + connection);
			if (i == 5) {
				connection.close();
			}
		}

		// resultSetType:
		// TYPE_FORWARD_ONLY、TYPE_SCROLL_INSENSITIVE、TYPE_SCROLL_SENSITIVE
		// resultSetConcurrency:
		// CONCUR_READ_ONLY、CONCUR_UPDATABLE
		// resultSetHoldability:
		// HOLD_CURSORS_OVER_COMMIT、CLOSE_CURSORS_AT_COMMIT

	}

}
