package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: druid
 * @Author: yuan wang
 * @CreateTime: 2023-01-06  14:42
 * @Description: TODO: 连接池使用类
 * @Version: 1.0
 */
public class DruidUsePart {

	/**
	 * @description: 直接使用代码设置连接池连接参数方式
	 * 1. 创建一个druid对象
	 *
	 * 2.设置连接池参数[必须][非必须]
	 *
	 * 3.获取连接[通用方法，所有连接池都一样]
	 *
	 * 4.回收连接[通用方法，所有连接池都一样]
	 *
	 * @author: yuan wang 
	 * @date: 2023/1/6 14:45 
	 **/
	public void testHard() throws Exception{

		//连接池对象
		DruidDataSource dataSource = new DruidDataSource();

		//设置参数
		//必须 连接数据库驱动类的全限定符[注册驱动] | url | user | password
		dataSource.setUrl("jdbc:mysql://192.168.211.128:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		//非必须 初始化连接数量，最大的连接数量……
		dataSource.setInitialSize(5);//初始化数量
		dataSource.setMaxActive(10);//最大连接数量

		//获取连接
		DruidPooledConnection connection = dataSource.getConnection();

		//数据库curd

		//回收连接(释放变回收)
		connection.close();

	}

	/**
	 * @description: 通过读取外部配置文件的方法，实例化druid连接池对象
	 * @author: yuan wang
	 * @date: 2023/1/6 14:57
	 **/
	public void testSoft() throws Exception {

		//1.读取外部配置文件Properties
		Properties properties = new Properties();

		//src下的文件，可以使用类加载器提供的方法，外部文件输入完整文件夹路径
		InputStream ips = DruidUsePart.class.getClassLoader().getResourceAsStream("druid.properties");

		properties.load(ips);

		//2.使用连接池工具类的工厂模式，创建连接池

		DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

		Connection connection = dataSource.getConnection();

		//数据库curd

		connection.close();


	}

	@Test
	public void test() throws Exception {
		testSoft();
	}

}
