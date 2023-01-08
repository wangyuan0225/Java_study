package transactionnew;

import org.junit.Test;
import utils.JdbcUtilsV2;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: JDBC_transaction
 * @Author: yuan wang
 * @CreateTime: 2023-01-06  10:04
 * @Description: 银行卡业务方法，调用Dao方法
 * @Version: 1.0
 */
public class BankService {

	/**
	 * @description: 二狗子给驴蛋蛋转500
	 * @author: yuan wang
	 * @date: 2023/1/6 10:17
	 **/
	@Test
	public void test() throws SQLException {
		transfer("lvdandan", "ergouzi", 500);
	}


	/**
	 * @description:
	 * @author: yuan wang
	 * @date: 2023/1/6 10:05
	 * @param: addAccount 加钱账户
	 * @param: subAccount 减钱账户
	 * @param: money 金额
	 **/
	public void transfer(String addAccount, String subAccount, int money) throws SQLException {

		BankDao bankDao = new BankDao();

		Connection connection = JdbcUtilsV2.getConnection();

		try {
			connection.setAutoCommit(false);

			bankDao.add(addAccount, money);
			System.out.println("--------------");
			bankDao.sub(subAccount, money);

			connection.commit();

			System.out.println("转账成功");
		} catch (Exception e) {
			try {
				System.out.println("转账失败");
				connection.rollback();
				e.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				JdbcUtilsV2.freeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
