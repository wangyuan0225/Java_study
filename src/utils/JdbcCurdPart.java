package utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: utils
 * @Author: yuan wang
 * @CreateTime: 2023-01-06  15:29
 * @Description: 基于工具类的curd
 * @Version: 1.0
 */
public class JdbcCurdPart {

	public void testInsert() throws SQLException {

		Connection connection = JdbcUtils.getConnection();

		JdbcUtils.freeConnection(connection);

	}

}
