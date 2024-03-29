package domain;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static DataSource ds;

	// 类加载初始化
	static {
		try {
			Properties props = new Properties();
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取连接
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static DataSource getDataSource() {
		return ds;
	}

	// 关闭资源
	public static void close(AutoCloseable... resourceList) {
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
