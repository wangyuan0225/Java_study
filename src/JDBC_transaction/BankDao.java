package JDBC_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: JDBC_transaction
 * @Author: yuan wang
 * @CreateTime: 2023-01-06  09:34
 * @Description: bank表的数据库操作方法存储类
 * @Version: 1.0
 */
public class BankDao {

	/**
	 * @description: 加钱的数据库操作方法（jdbc）
	 * @author: yuan wang
	 * @date: 2023/1/6 10:03
	 * @param: account 加钱的行号
	 * @param: money 加钱的金额
	 * @param: connection 连接
	 **/
	public void add(String account, int money, Connection connection) throws SQLException {
		String sql = "update t_bank set money = money + ? where account = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, money);
		statement.setObject(2, account);
		statement.executeUpdate();
		statement.close();
		System.out.println("加钱成功！");
	}

	/**
	 * @description: 减钱的数据库操作方法（jdbc）
	 * @author: yuan wang
	 * @date: 2023/1/6 10:14
	 * @param: account 减钱的行号
	 * @param: money 减钱的金额
	 * @param: connection 连接
	 **/
	public void sub(String account, int money, Connection connection) throws SQLException {
		String sql = "update t_bank set money = money - ? where account = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, money);
		statement.setObject(2, account);
		statement.executeUpdate();
		statement.close();
		System.out.println("减钱成功！");
	}
}
