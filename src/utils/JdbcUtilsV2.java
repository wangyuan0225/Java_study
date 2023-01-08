package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: utils
 * @Author: yuan wang
 * @CreateTime: 2023-01-06  15:45
 * @Description: TODO: 内部包含一个连接池对象，并且对外提供获取连接和回收连接的方法
 * 工具类的方法推荐写成静态，外部调用会更方便
 * <p>
 * 实现：
 * 属性  连接池对象 [实例化一次]
 * 单例模式
 * static{
 * 全局调用一次
 * }
 * 方法
 * 对外提供连接的方法
 * 回收外部传入连接方法
 * @Version: 2.0
 */
public class JdbcUtilsV2 {

	private static DataSource dataSource = null;

	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	static {
		//初始化实例对象
		Properties properties = new Properties();
		InputStream ips = JdbcUtilsV2.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			properties.load(ips);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws SQLException {

		//查看线程本地变量中是否存在
		Connection connection = tl.get();

		//第一次没有
		if (connection == null) {
			connection = dataSource.getConnection();
			tl.set(connection);
		}
		return connection;
	}

	public static void freeConnection() throws SQLException {

		Connection connection = tl.get();
		if(connection != null){
			tl.remove();
			connection.setAutoCommit(true);//回到默认状态
			connection.close();
		}

		connection.close();
	}

}
