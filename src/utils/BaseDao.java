package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: utils
 * @Author: yuan wang
 * @CreateTime: 2023-01-06  16:33
 * @Description: 封装Dao层数据库重复代码
 * TODO:
 * 		封装两个方法：一个简化非DQL，一个简化DQL
 * @Version: 1.0
 */
public abstract class BaseDao {

	/**
	 * @description: 封装简化非DQL语句
	 * @author: yuan wang
	 * @date: 2023/1/6 16:42
	 * @param: sql 带占位符的SQL语句
	 * @param: params 占位符的值 注意：传入占位符的值，必须等于SQL语句？的位置
	 * @return: int 执行影响的行数
	 **/
	//Object...表示可变参数
	public int executeUpdate(String sql, Object... params) throws SQLException {
		Connection connection = JdbcUtilsV2.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		for (int i = 1; i <= params.length; i++) {
			preparedStatement.setObject(i, params[i - 1]);
		}

		int rows = preparedStatement.executeUpdate();

		preparedStatement.close();

		//如果没有开启事务
		if (connection.getAutoCommit()) {
			JdbcUtilsV2.freeConnection();
		}

		return rows;
	}


	/**
	 * @description: 封装简化DQL语句
	 * @author: yuan wang
	 * @date: 2023/1/6 22:10
	 * @param: clazz
	 * @param: sql
	 * @param: params
	 * @return: java.util.List<T>
	 * <T> 声明一个泛型，不确定类型
	 * 1. 确定泛型User.class T = User
	 * 2.要使用反射技术属性赋值
	 **/
	public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws SQLException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		Connection connection = JdbcUtilsV2.getConnection();

		PreparedStatement statement = connection.prepareStatement(sql);

		if (params == null && params.length != 0) {
			for (int i = 1; i <= params.length; i++) {
				statement.setObject(i, params[i - 1]);
			}
		}

		ResultSet resultSet = statement.executeQuery();

		List<T> list = new ArrayList<>();

		ResultSetMetaData metaData = resultSet.getMetaData();

		int columnCount = metaData.getColumnCount();

		while (resultSet.next()) {

			T t = clazz.getDeclaredConstructor().newInstance();

			for (int i = 1; i <= columnCount; i++) {

				Object value = resultSet.getObject(i);

				String propertyName = metaData.getColumnLabel(i);

				Field field = clazz.getDeclaredField(propertyName);
				field.setAccessible(true);

				field.set(t, value);
			}
			list.add(t);
		}
		resultSet.close();
		statement.close();

		if(connection.getAutoCommit()){
			JdbcUtilsV2.freeConnection();
		}

		return list;
	}

}
