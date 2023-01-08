import org.junit.Test;
import utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Main extends BaseDao {

	@Test
	public void testInsert() throws SQLException {
		String sql = "insert into t_user (account, password, nickname) values(?, ?, ?);";
		int i = executeUpdate(sql, "测试333", "3333", "ergouzi");
		System.out.println("i = " + i);
	}

	@Test
	public void testDelete() {
		try {
			String sql = "delete from t_user where id = ?;";
			int i = executeUpdate(sql, 3);
			System.out.println("i = " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			String sql = "update t_user set password = ? where nickname = ?";
			int i = executeUpdate(sql, "123456", "ergouzi");
			System.out.println("i = " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQuery() {
		String sql = "select * from t_user;";
		try {
			List<Info> infos = executeQuery(Info.class, sql);
			for (Info info : infos) {
				System.out.println(info.getId() + "--" + info.getAccount() + "--" + info.getPassword() + "--" + info.getNickname());
			}
		} catch (SQLException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException |
				 InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}


//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//public class Main {
//
//	@Test
//	public void testBatchInsert() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test?rewriteBatchedStatements=true", "root", "123456");
//		String sql = "insert into t_user(account, password, nickname) values (?, ?, ?)";
//		PreparedStatement statement = connection.prepareStatement(sql);
//		for (int i = 0; i < 10000; i++) {
//			statement.setObject(1, "ddd" + i);
//			statement.setObject(2, "ddd" + i);
//			statement.setObject(3, "驴蛋蛋" + i);
//			statement.addBatch();
//		}
//		statement.executeBatch();
//		statement.close();
//		connection.close();
//	}
//
//}


//import org.junit.Test;
//
//import java.sql.*;
//
//public class Main {
//
//	@Test
//	public void returnPrimaryKey(){
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test","root","123456");
//			String sql = "insert into t_user(account, password, nickname) values(?, ?, ?)";
//			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
//			statement.setObject(1, "test1");
//			statement.setObject(2, "123456");
//			statement.setObject(3,"驴蛋蛋");
//			int i = statement.executeUpdate();
//			if(i > 0){
//				System.out.println("数据插入成功！");
//
//				ResultSet resultSet = statement.getGeneratedKeys();
//				resultSet.next();
//				int id = resultSet.getInt(1);
//				System.out.println("id = " + id);
//
//			} else {
//				System.out.println("插入数据失败！");
//			}
//			statement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}


//import org.junit.Test;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Main {
//
//
//	@Test
//	public void testInsert() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test", "root", "123456");
//			String sql = "insert into t_user (account, password, nickname) values(?, ?, ?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setObject(1, "test");
//			preparedStatement.setObject(2, "test");
//			preparedStatement.setObject(3, "二狗子");
//
//			int rows = preparedStatement.executeUpdate();
//			if (rows > 0) {
//				System.out.println("数据插入成功!");
//			} else {
//				System.out.println("数据插入失败!");
//			}
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testUpdate() {
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test", "root", "123456");
//			String sql = "update t_user set nickname = ? where id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setObject(1, "三狗子");
//			preparedStatement.setObject(2, 3);
//
//			int i = preparedStatement.executeUpdate();
//			if (i > 0) {
//				System.out.println("修改成功");
//			} else {
//				System.out.println("修改失败");
//			}
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testDelete() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test", "root", "123");
//			String sql = "delete from t_user where id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setObject(1, 3);
//
//			int i = preparedStatement.executeUpdate();
//			if (i > 0) {
//				System.out.println("success");
//			} else {
//				System.out.println("fail");
//			}
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testSelect() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test", "root", "123456");
//			String sql = "select id, account, password, nickname from t_user;";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//
//			List<Map> list = new ArrayList<>();
//			//获取列信息
//			ResultSetMetaData metaData = resultSet.getMetaData();
//			int columnCount = metaData.getColumnCount();
//
//			while (resultSet.next()) {
//				Map<String, Object> map = new HashMap<>();
////				map.put("id", resultSet.getObject("id"));
////				map.put("account", resultSet.getObject("account"));
////				map.put("password", resultSet.getObject("password"));
////				map.put("nickname", resultSet.getObject("nickname"));
//
//				//注意从1开始
//				for (int i = 1; i <= columnCount; i++) {
//					Object value = resultSet.getObject(i);
//					//获取列名
//					String columnLabel = metaData.getColumnLabel(i);
//					map.put(columnLabel, value);
//				}
//				list.add(map);
//			}
//			System.out.println("List: " + list);
//			resultSet.close();
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//}


//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//
//		//1.获取用户输入信息
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入账号:");
//		String account = sc.nextLine();
//		System.out.println("请输入密码:");
//		String password = sc.nextLine();
//
//		//2.注册驱动
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test", "root", "123456");
//			Statement statement = connection.createStatement();
//			String sql = "select * from t_user where account = ? and password = ?;";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setObject(1, account);
//			preparedStatement.setObject(2, password);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String account1 = resultSet.getString("account");
//				String password1 = resultSet.getString("password");
//				String nickname = resultSet.getString(4);
//				System.out.println("nickname = " + nickname);
//				System.out.println("输入正确!");
//			} else {
//				System.out.println("输入错误!");
//			}
//			resultSet.close();
//			statement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}


//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//
//		//1.获取用户输入信息
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入账号:");
//		String account = sc.nextLine();
//		System.out.println("请输入密码:");
//		String password = sc.nextLine();
//
//		//2.注册驱动
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/test", "root", "123456");
//			Statement statement = connection.createStatement();
//			String sql = "select * from t_user where account = '" + account + "' and password = '" + password + "';";
//			//int i = statement.executeUpdate(sql);
//			ResultSet resultSet = statement.executeQuery(sql);
//			if (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String account1 = resultSet.getString("account");
//				String password1 = resultSet.getString("password");
//				String nickname = resultSet.getString(4);
//				System.out.println("nickname = " + nickname);
//				System.out.println("输入正确!");
//			} else {
//				System.out.println("输入错误!");
//			}
//			resultSet.close();
//			statement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}


//import java.sql.*;
//
//public class Main {
//	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.211.128:3306/study", "root", "123456");
//			Statement statement = connection.createStatement();
//			String sql = "select * from dept;";
//			ResultSet resultSet = statement.executeQuery(sql);
//			while (resultSet.next()) {
//				int id = resultSet.getInt("id");
//				String name = resultSet.getString("name");
//				System.out.println(id + "--" + name);
//			}
//			resultSet.close();
//			statement.close();
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}


//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		byte[] data;
//		try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
//			output.write("Hello ".getBytes("UTF-8"));
//			output.write("world!".getBytes("UTF-8"));
//			data = "Hello ".getBytes("UTF-8");
//		}
//		System.out.println(new String(data, "UTF-8"));
//	}
//}


//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//
//		//PrintWriter printWriter = new PrintWriter(System.out);
//		PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\Users\\王子\\Desktop\\新建 文本文档.txt"));
//		printWriter.print("hello");
//		//注意要关闭
//		printWriter.close();
//	}
//}


//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//
//		PrintStream out = System.out;
//		//默认打印到显示器
//		out.println("hello");
//		out.write("hello".getBytes());
//		out.close();
//
//		//修改打印路径，打印到文件中，且为覆盖模式
//		//System.setOut(new PrintStream("C:\\Users\\王子\\Desktop\\新建 文本文档.txt"));
//		//修改打印路径，为续写模式
//		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\王子\\Desktop\\新建 文本文档.txt",true)));
//
//		System.out.println("hello,世界");
//	}
//}


//import java.io.*;
//
//public class Main{
//	public static void main(String[] args) throws IOException {
//
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
//		osw.write("hello,你好世界");
//		osw.close();
//
//	}
//}


//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		BufferedReader br = new BufferedReader(new InputStreamReader(
//													new FileInputStream(filePath), "gbk"));
//		//读取
//		String s = br.readLine();
//		System.out.println(s);
//		//关流，也是关闭外层流
//		br.close();
//
//	}
//}


//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
//		byte[] buff = new byte[1024];
//		int n;
//		while ((n = bis.read(buff)) != -1) {
//			System.out.println(new String(buff, 0, n));
//		}
//		bis.close();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		//System类的public final static InputStream in = null;
//		//System.in 编译类型		InputStream
//		//System.in 运行类型		BufferedInputStream
//		//表示的时标准输入 键盘
//		System.out.println(System.in.getClass());
//
//		//System.out public final static PrintStream out = null;
//		//编译类型 PrintStream
//		//运行类型 PrintStream
//		//表示标准输出 显示器
//		System.out.println(System.out.getClass());
//	}
//}


//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
//
//		System.out.println(ois.readInt());
//		System.out.println(ois.readBoolean());
//		System.out.println(ois.readChar());
//		System.out.println(ois.readDouble());
//		System.out.println(ois.readUTF());
//		Object dog = ois.readObject();
//		System.out.println("运行类型=" + dog.getClass());
//		System.out.println("Dog信息=" + dog);
//		//注意这里无法调用dog的getName方法，需要向下转型才可以。
//		//写法1
//		Dog dog1 = (Dog) dog;
//		System.out.println(dog1.getName());
//		//写法2
//		System.out.println(((Dog) dog).getName());
//		ois.close();
//	}
//}


//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
//		//序列化数据到文件
//		oos.writeInt(100);//int -> Integer(实现了Serializable)
//		oos.writeBoolean(true);
//		oos.writeChar('a');
//		oos.writeDouble(9.5);
//		oos.writeUTF("Hello, world!");
//		oos.writeObject(new Dog("旺财", 10));
//
//		oos.close();
//		System.out.println("数据保存完毕");
//	}
//}

//class Dog implements Serializable {//注意需要Serializable接口
//	private static String name;
//	private transient int age;
//
//	@Serial
//	private static final long serialVersionUID = 1L;
//
//	public Dog() {
//	}
//
//	public Dog(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "Dog{" +
//				"name='" + name + '\'' +
//				", age=" + age +
//				'}';
//	}
//}


//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) {
//
////		String srcFile = "C:\\Users\\王子\\Desktop\\新文件1.exe";
////		String destFile = "C:\\Users\\王子\\Desktop\\新文件2.exe";
//		String srcFile = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		String destFile = "C:\\Users\\王子\\Desktop\\新建 文本文档-副本.txt";
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//
//		try {
//			bis = new BufferedInputStream(new FileInputStream(srcFile));
//			bos = new BufferedOutputStream(new FileOutputStream(destFile));
//
//			byte[] buff = new byte[1024];
//			int readLen = 0;
//
//			while ((readLen = bis.read(buff)) != -1) {
//				bos.write(buff, 0, readLen);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (bis != null) {
//				try {
//					bis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (bos != null) {
//				try {
//					bos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//}


//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		//写文件
//		try (OutputStream output = new FileOutputStream("C:\\Users\\王子\\Desktop\\新建 文本文档.txt", true)) {
//			output.write("Hello你好".getBytes()); // Hello
//		}
//		//复制文件
//		try (InputStream input = new FileInputStream("C:\\Users\\王子\\Desktop\\新建 文本文档.txt");
//			 OutputStream output = new FileOutputStream("C:\\Users\\王子\\Desktop\\新建 文本文档-副本.txt")) {
//			byte[] buf = new byte[1024];
//			while ((input.read(buf) != -1)) {
//				output.write(buf);
//			}
//		}
//	}
//}


//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) {
//		String srcFilePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		String destFilePath = "C:\\Users\\王子\\Desktop\\新建 文本文档-副本.txt";
//		BufferedReader bufferedReader = null;
//		BufferedWriter bufferedWriter = null;
//		String line;
//		try {
//			bufferedReader = new BufferedReader(new FileReader(srcFilePath));
//			bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
//			while ((line = bufferedReader.readLine()) != null){
//				bufferedWriter.write(line);
//    			bufferedWriter.newLine();
//			}
//			System.out.println("拷贝完毕");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (bufferedReader != null) {
//				try {
//					bufferedReader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (bufferedWriter != null) {
//				try {
//					bufferedWriter.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//}


//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		//追加，没有true表示以覆盖方式写入，注意true要加在FileWriter的后面而不是BufferedWriter的后面。
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
//		bufferedWriter.write("hello,world");
//		bufferedWriter.newLine();//插入换行
//		bufferedWriter.write("hello,world");
//		bufferedWriter.write("hello,world");
//		bufferedWriter.close();
//	}
//}


//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		String line;
//		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println(line);
//		}
//		bufferedReader.close();
//	}
//}


//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) {
//		String filePath = "C:\\Users\\王子\\Desktop\\新建 文本文档.txt";
//		Writer writer = null;
//		try {
//			writer = new FileWriter(filePath);
//			char[] chars = {'e', 'l'};
//			writer.write('H');
//			writer.write(chars);
//			writer.write("lo!".toCharArray(), 0, 2);
//			writer.write(",wor");
//			writer.write("ld!", 0, 3);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}


//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		byte[] data = { 72, 101, 108, 108, 111, 33 };
//		try (InputStream input = new ByteArrayInputStream(data)) {
//			String s = readAsString(input);
//			System.out.println(s);
//		}
//	}
//
//	public static String readAsString(InputStream input) throws IOException {
//		int n;
//		StringBuilder sb = new StringBuilder();
//		while ((n = input.read()) != -1) {
//			sb.append((char) n);
//		}
//		return sb.toString();
//	}
//}


//import java.io.File;
//import java.io.IOException;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		File f2 = new File("C:\\Users\\王子\\Desktop\\新建 文本文档.txt");
//		f2.delete();
//		f2.createNewFile();
//	}
//}


//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//
//	private static Scanner input;
//
//	public static void main(String[] args) {
//		input = new Scanner(System.in);//创建键盘输入扫描
//		Map<String,Long> map = new HashMap<>();//创建一个map用来存储输入的用户名和其对应的电话
//
//		while(true){
//			menu();
//			System.out.print("请输入选择:");
//			int choice = input.nextInt();
//			switch (choice) {
//				case 1:input(map);break;//添加用户信息
//				case 2:show(map);break;//查看所有用户信息
//				case 3:select(map);break;//查询某个用户信息
//				case 4:
//					delete(map);break;//删除某个用户
//				case 5:System.out.println("已退出！！！");return;
//				default:
//					System.out.println("输入选项不存在！！！请重新输入！！！");
//					break;
//			}
//
//		}
//	}
//
//	private static void delete(Map<String, Long> map) {
//		// TODO Auto-generated method stub
//		System.out.print("请输入用户名:");
//		String key = input.next();//需要查看信息的用户名
//
//		if(map.containsKey(key)){
//			System.out.print("是否删除名为" + key + "的用户信息(y/n):");
//			while(true){
//				String isDelete = input.next();
//				if(isDelete.equalsIgnoreCase("y")){
//					map.remove(key);
//					System.out.println("删除成功!!!");
//					break;
//				}else if(isDelete.contentEquals("n")){
//					System.out.println("删除失败!!!");
//					break;
//				}else{
//					System.out.println("输入错误,请重新输入!!!");
//				}
//			}
//		}else{
//			System.out.println("不存在此用户名!!!");
//		}
//
//	}
//
//	private static void select(Map<String, Long> map) {
//		// TODO Auto-generated method stub
//		System.out.print("请输入用户名:");
//		String key = input.next();//需要查看信息的用户名
//
//		if(map.containsKey(key)){
//			System.out.println(key + "的用户信息如下:");
//			System.out.println("用户名:\t" + key);
//			System.out.println("电话:\t" + map.get(key));
//		}else{
//			System.out.println("不存在此用户名!!!");
//		}
//	}
//
//	private static void show(Map<String, Long> map) {
//		// TODO Auto-generated method stub
//		System.out.println("用户名\t电话");
//		for (Map.Entry<String,Long> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "\t" + entry.getValue());
//		}
//	}
//
//	private static void input(Map<String, Long> map) {
//		while(true){
//			//输入用户名
//			System.out.print("请输入用户名:");
//			String userName = input.next();
//			//输入电话
//			System.out.print("请输入" + userName + "的电话:");
//			Long number = input.nextLong();
//
//			//插入用户名信息
//			map.put(userName, number);
//
//			System.out.print("按任意键继续,是否继续(y/n):");
//			String isInput = input.next();
//			if(isInput.equalsIgnoreCase("n")) break;
//		}
//
//	}
//
//	private static void menu() {
//		// TODO Auto-generated method stub
//		System.out.println("*************************************");
//		System.out.println("1.录入用户信息\n2.查看所有用户信息\n3.查询用户信息\n4.删除用户\n5.退出");
//		System.out.println("*************************************");
//	}
//
//}


//public class Main {
//	public static void main(String[] args) {
//		Weekday day = Weekday.SUN;
//		if (day.dayValue == 6 || day.dayValue == 0) {
//			System.out.println("Today is " + day + ". Work at home!");
//		} else {
//			System.out.println("Today is " + day + ". Work at office!");
//		}
//	}
//}
//
//enum Weekday {
//	MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");
//
//	public final int dayValue;
//	private final String chinese;
//
//	private Weekday(int dayValue, String chinese) {
//		this.dayValue = dayValue;
//		this.chinese = chinese;
//	}
//
//	@Override
//	public String toString() {
//		return this.chinese;
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		String[] names = {"Bob", "Alice", "Grace"};
//		var sb = new StringBuilder();
//		sb.append("Hello ");
//		for (String name : names) {
//			sb.append(name).append(", ");
//		}
//		// 注意去掉最后的", ":
//		sb.delete(sb.length() - 2, sb.length());
//		sb.append("!");
//		System.out.println(sb.toString());
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Adder adder = new Adder();
//		adder.add(3)
//				.add(5)
//				.inc()
//				.add(10);
//		System.out.println(adder.value());
//	}
//}
//
//class Adder {
//	private int sum = 0;
//
//	public Adder add(int n) {
//		sum += n;
//		return this;
//	}
//
//	public Adder inc() {
//		sum++;
//		return this;
//	}
//
//	public int value() {
//		return sum;
//	}
//
//}

//public class Main {
//	public static void main(String args[]) {
//
//		/**
//		 *Math.sqrt()//计算平方根
//		 *Math.cbrt()//计算立方根
//		 *Math.pow(a, b)//计算a的b次方
//		 *Math.max( , );//计算最大值
//		 *Math.min( , );//计算最小值
//		 */
//		System.out.println(Math.sqrt(16));  //4.0
//		System.out.println(Math.cbrt(8));  //2.0
//		System.out.println(Math.pow(3, 2));   //9.0
//		System.out.println(Math.max(2.3, 4.5));//4.5
//		System.out.println(Math.min(2.3, 4.5));//2.3
//
//		/**
//		 * abs求绝对值
//		 */
//		System.out.println(Math.abs(-10.4));  //10.4
//		System.out.println(Math.abs(10.1));   //10.1
//
//		/**
//		 * ceil天花板的意思，就是返回大的值
//		 */
//		System.out.println(Math.ceil(-10.1));  //-10.0
//		System.out.println(Math.ceil(10.7));  //11.0
//		System.out.println(Math.ceil(-0.7));  //-0.0
//		System.out.println(Math.ceil(0.0));   //0.0
//		System.out.println(Math.ceil(-0.0));  //-0.0
//		System.out.println(Math.ceil(-1.7));  //-1.0
//
//		/**
//		 * floor地板的意思，就是返回小的值
//		 */
//		System.out.println(Math.floor(-10.1)); //-11.0
//		System.out.println(Math.floor(10.7));  //10.0
//		System.out.println(Math.floor(-0.7));  //-1.0
//		System.out.println(Math.floor(0.0));  //0.0
//		System.out.println(Math.floor(-0.0));  //-0.0
//
//		/**
//		 * random 取得一个大于或者等于0.0小于不等于1.0的随机数
//		 */
//		System.out.println(Math.random()); //小于1大于0的double类型的数
//		System.out.println(Math.random() * 2);//大于0小于1的double类型的数
//		System.out.println(Math.random() * 2 + 1);//大于1小于2的double类型的数
//
//		/**
//		 * rint 四舍五入，返回double值
//		 * 注意.5的时候会取偶数
//		 */
//		System.out.println(Math.rint(10.1));  //10.0
//		System.out.println(Math.rint(10.7));  //11.0
//		System.out.println(Math.rint(11.5));  //12.0
//		System.out.println(Math.rint(10.5));  //10.0
//		System.out.println(Math.rint(10.51));  //11.0
//		System.out.println(Math.rint(-10.5));  //-10.0
//		System.out.println(Math.rint(-11.5));  //-12.0
//		System.out.println(Math.rint(-10.51)); //-11.0
//		System.out.println(Math.rint(-10.6));  //-11.0
//		System.out.println(Math.rint(-10.2));  //-10.0
//
//		/**
//		 * round 四舍五入，float时返回int值，double时返回long值
//		 */
//		System.out.println(Math.round(10.1));  //10
//		System.out.println(Math.round(10.7));  //11
//		System.out.println(Math.round(10.5));  //11
//		System.out.println(Math.round(10.51)); //11
//		System.out.println(Math.round(-10.5)); //-10
//		System.out.println(Math.round(-10.51)); //-11
//		System.out.println(Math.round(-10.6)); //-11
//		System.out.println(Math.round(-10.2)); //-10
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		String s1 = "hello";
//		String s2 = "Hello";
//
//		//charAt(int index)方法->返回指定索引处的 char值。即找出特定位置的字符，注意索引从0开始
//		System.out.println(s1.charAt(0));//h
//		System.out.println(s1.charAt(4));//o
//		//System.out.println(s1.charAt(5));//越界，编译错误
//
//		//compareTo(String anotherString)方法->按字典顺序比较两个字符串。返回 anotherString - 待比较的 String 。
//		System.out.println(s1.compareTo(s2));//s2 - s1 = 32 > 0,故s2 > s1
//		//compareToIgnoreCase(String str)方法->按字典顺序比较两个字符串，忽略大小写差异
//		System.out.println(s1.compareToIgnoreCase(s2));//0
//
//		//concat(String str)方法->将指定的字符串连接到此字符串的末尾。但是无法对s1本身操作，还不如用+连接呢
//		System.out.println(s1.concat("!!"));//hello!!
//
//		//contains(CharSequence s)方法->当且仅当此字符串包含指定的char值序列时，才返回true。
//		//注意到contains()方法的参数是CharSequence而不是String，因为CharSequence是String实现的一个接口。
//		//CharSequence是char值的可读序列。该接口提供对许多不同类型的char序列的统一，只读访问。
//		System.out.println(s1.contains("he"));//ture
//		System.out.println(s1.contains("helo"));//false
//
//		//equals(Object anObject)方法->将此字符串与指定的对象进行比较。
//		System.out.println(s1.equals(s2));//false
//		//equalsIgnoreCase(String anotherString)方法->将此 String与另一个 String比较，忽略了大小写。
//		System.out.println(s1.equalsIgnoreCase(s2));//true
//
//		//format(String format, Object... args)方法->使用指定的格式字符串和参数返回格式化字符串。
//		System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));//Hi Bob, your score is 59.50!
//		//formatted(Object... args)方法->Formats using this string as the format string, and the supplied arguments.使用此字符串作为格式字符串的格式，以及提供的参数。
//		String s = "Hi %s, your score is %d!";
//		System.out.println(s.formatted("Alice", 80));//Hi Alice, your score is 80!
//		//有几个占位符，后面就传入几个参数。参数类型要和占位符一致。我们经常用这个方法来格式化信息。常用的占位符有：
//		//%s：显示字符串；
//		//%d：显示整数；
//		//%x：显示十六进制整数；
//		//%f：显示浮点数。
//		//占位符还可以带格式，例如%.2f表示显示两位小数。如果你不确定用啥占位符，那就始终用%s，因为%s可以显示任何数据类型。
//
//		//indexOf(int ch)方法->返回指定字符第一次出现的字符串中的索引。
//		System.out.println(s1.indexOf('h'));//0
//		System.out.println(s1.indexOf('l'));//2
//		System.out.println(s1.indexOf('a'));//-1
//		//indexOf(int ch, int fromIndex)方法->返回指定字符第一次出现的此字符串中的索引，从指定索引处开始搜索。
//		System.out.println(s1.indexOf('l', 3));//3
//		System.out.println(s1.indexOf('h', 3));//-1
//		//indexOf(String str)方法->返回指定子字符串第一次出现的字符串中的索引。
//		System.out.println(s1.indexOf("el"));//1
//		System.out.println(s1.indexOf("eo"));//-1
//		//indexOf(String str, int fromIndex)方法->从指定的索引处开始，返回指定子字符串第一次出现的字符串中的索引。
//		System.out.println(s1.indexOf("ll", 2));//2
//		System.out.println(s1.indexOf("ll", 3));//-1
//
//		//isBlank()方法->如果字符串为空或仅包含 white space代码点，则返回 true ，否则 false 。
//		System.out.println(s1.isBlank());//false
//		//isEmpty()方法->返回 true，当且仅当，length()是 0 。
//		System.out.println(s1.isEmpty());//false
//
//		//join(CharSequence delimiter, CharSequence... elements)方法->返回由 CharSequence elements的副本组成的新String，该副本与指定的 delimiter的副本连接在一起。
//		System.out.println(String.join("!!", s1, s2, s1, s2));//hello!!Hello!!hello!!Hello
//		String[] arr = {"h", "e", "l", "l", "o"};
//		System.out.println(String.join("!", arr));//h!e!l!l!o
//
//		//lastIndexOf(int ch)方法->返回指定字符最后一次出现的字符串中的索引。
//		//lastIndexOf(int ch, int fromIndex)方法->返回指定字符最后一次出现的字符串中的索引，从指定的索引开始向后搜索。
//		//lastIndexOf(String str)方法->返回指定子字符串最后一次出现的字符串中的索引。
//		//lastIndexOf(String str, int fromIndex)方法->返回指定子字符串最后一次出现的字符串中的索引，从指定索引开始向后搜索。
//
//		//length()方法->返回此字符串的长度。
//		System.out.println(s1.length());//5
//
//		//repeat(int count)方法->返回一个字符串，其值为此字符串的串联重复 count次。
//		System.out.println(s1.repeat(3));//hellohellohello
//
//		//replace(char oldChar, char newChar)方法->返回从替换所有出现的导致一个字符串 oldChar在此字符串 newChar 。
//		System.out.println(s1.replace('l', 'L'));//heLLo
//		//replace(CharSequence target, CharSequence replacement)方法->将此字符串中与文字目标序列匹配的每个子字符串替换为指定的文字替换序列。
//		System.out.println(s1.replace("hel", "HEL"));//HELlo
//		//replaceAll(String regex, String replacement)方法->将给定替换的给定 regular expression匹配的此字符串的每个子字符串替换。
//		String s4 = "A,,B;C ,D";
//		System.out.println(s4.replaceAll("[,;\\s]+", ",")); // A,B,C,D
//
//		//split(String regex)方法->将此字符串拆分为给定 regular expression的匹配 项 。
//		String s5 = "A,B,C,D";
//		String[] ss1 = s5.split(",");
//		System.out.println(ss1[1]);//B
//
//		//startsWith(String prefix, int toffset)方法->测试从指定索引开始的此字符串的子字符串是否以指定的前缀开头。
//		System.out.println(s1.startsWith("he"));//true
//
//		//strip()方法->返回一个字符串，其值为此字符串，并删除了所有前导和尾随空白字符，空白字符包括任何空格（包括\u3000），\t，\r，\n。
//		System.out.println("  \u3000\tHello\r\n ".strip());//Hello
//		//stripLeading()方法->返回一个字符串，其值为此字符串，并删除了所有前导 white space 。
//		System.out.println("  \tHello\r\n ".stripLeading());//Hello<CR><CR>
//		//stripTrailing()方法->返回一个字符串，其值为此字符串，并删除所有尾随 white space 。
//		System.out.println("  \tHello\r\n ".stripTrailing());//  	Hello
//
//		//substring(int beginIndex)方法->返回一个字符串，该字符串是此字符串的子字符串。
//		System.out.println(s1.substring(1));//ello
//		//substring(int beginIndex, int endIndex)方法->返回一个字符串，该字符串是此字符串的子字符串。
//		System.out.println(s1.substring(1, 3));//el,左闭右开[a,b)
//
//		//toCharArray()方法->将此字符串转换为新的字符数组。
//		char[] ss2 = s1.toCharArray();
//		System.out.println(ss2[2]);//l
//
//		//toLowerCase()方法->使用默认语言环境的规则将此 String所有字符转换为小写。
//		System.out.println(s2.toLowerCase());//hello
//		//toUpperCase()方法->使用默认语言环境的规则将此 String所有字符转换为大写。
//		System.out.println(s1.toUpperCase());//HELLO
//
//		//trim()方法->返回一个字符串，其值为此字符串，删除了所有前导和尾随空格，其中space被定义为其代码点小于或等于 'U+0020' （空格字符）的任何字符。
//		System.out.println("\u3000Hello\u3000".trim()); // "　Hello　",3000>2000,无法删除
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		char[] a = new char[62];
//		int i = 0;
//		for (char j = 'A'; j <= 'Z'; i++, j++) {
//			a[i] = j;
//		}
//		for(int j = 0;j<i;j++)
//		System.out.println(a[j]);
//	}
//}


//import java.util.Random;
//
//public class Main {
//	public static void main(String[] args) {
//		Random random = new Random();
//		System.out.println("nextInt()：" + random.nextInt()); // 随机生成一个整数，这个整数的范围就是int类型的范围-2^31~2^31-1
//		System.out.println("nextLong()：" + random.nextLong()); // 随机生成long类型范围的整数
//		System.out.println("nextFloat()：" + random.nextFloat()); // 随机生成[0, 1.0)区间的小数
//		System.out.println("nextDouble()：" + random.nextDouble()); // 随机生成[0, 1.0)区间的小数
//		System.out.println("nextBoolean()：" + random.nextBoolean());//随机生成一个boolean值，生成true和false的值几率相等，也就是都是50%的几率
//		System.out.println("nextGaussian():" + random.nextGaussian());//随机生成呈高斯（“正态”）分布的 double 值，其平均值是 0.0，标准差是 1.0
//		byte[] byteArr = new byte[5];
//		random.nextBytes(byteArr); // 随机生成byte，并存放在定义的数组中，生成的个数等于定义的数组的个数
//		System.out.print("nextBytes()：");
//		for (int i = 0; i < byteArr.length; i++) {
//			System.out.print(byteArr[i] + "\t");
//		}
//		System.out.println();
//		/**
//		 * random.nextInt(n)
//		 * 随机生成一个正整数，整数范围[0,n),包含0而不包含n
//		 * 如果想生成其他范围的数据，可以在此基础上进行加减
//		 * 例如：
//		 * 1. 想生成范围在[0,n]的整数
//		 *         random.nextInt(n+1)
//		 * 2. 想生成范围在[m,n]的整数, n > m
//		 *         random.nextInt(n-m+1) + m
//		 *         random.nextInt() % (n-m) + m
//		 * 3. 想生成范围在(m,n)的整数
//		 *         random.nextInt(n-m+1) + m -1
//		 *         random.nextInt() % (n-m) + m - 1
//		 * ......主要是依靠简单的加减法
//		 */
//		System.out.println("nextInt(10)：" + random.nextInt(10)); // 随机生成一个整数，整数范围[0,10)
//		for (int i = 0; i < 5; i++) {
//			System.out.println("我生成了一个[3,15)区间的数，它是：" + (random.nextInt(12) + 3));
//		}
//		/**
//		 * random.nextDouble()
//		 * 例如:
//		 * 1.生成[0,1.0)区间的小数
//		 *         double d1 = random.nextDouble();//直接使用nextDouble方法获得。
//		 * 2.生成[0,5.0)区间的小数
//		 *           double d2 = random.nextDouble() * 5;//因为扩大5倍即是要求的区间。同理，生成[0,d)区间的随机小数，d为任意正的小数，则只需要将nextDouble方法的返回值乘以d即可。
//		 * 3.生成[1,2.5)区间的小数
//		 *         double d3 = r.nextDouble() * 1.5 + 1;//生成[1,2.5)区间的随机小数，则只需要首先生成[0,1.5)区间的随机数字，然后将生成的随机数区间加1即可。
//		 * ......同理，生成任意非从0开始的小数区间[d1,d2)范围的随机数字(其中d1不等于0)，则只需要首先生成[0,d2-d1)区间的随机数字，然后将生成的随机数字区间加上d1即可。
//		 *
//		 */
//	}
//}


//import java.util.Random;
//public class Main {
//	public void random() {
//		int i = 0;
//		int j = 0;
//		Random random = new Random(1);
//		Random random1 = new Random(1);
//		i = random.nextInt();
//		j = random1.nextInt();
//		System.out.println("i:" + i + "\nj:" + j);
//	}
//	public static void main(String[] args) {
//		Main tt = new Main();
//		tt.random();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		// String substring(int start,int end)
//		// 截取字符串，传入的两个参数分别为要截取边界的下标
//		// 在java api 中,通常使用两个数字表示范围时,都是含头不含尾,即包含起始下标对应的内容,但不包含结束下标的处对应的内容
//		// String toUpperCase() 将当前字符串中的英文部分转换为全大写
//		/********* Begin *********/
//		int x1=str.indexOf(".")+1;
//		int x2=str.indexOf(".",x1);
//		//x2的意思为从指定索引处开始，返回第一次出现的指定字符串中的索引
//		//通俗意思是先从指定处x1开始查找，直到查到该指定字符串，然后返回该字符串的索引
//		String a=str.substring(x1,x2);
//		System.out.println(a);
//		String b=a.toUpperCase();
//		System.out.println(b);
//		/********* End *********/
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		method(
//				new Animal() {
//					@Override
//					public void eat() {
//						System.out.println("狗吃骨头");
//					}
//				}
//		);
//	}
//
//	public static void method(Animal a) {
//		a.eat();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Person p = new Student();
////		System.out.println(p.name);
//		Student q = (Student) p;
//		q.sout();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		show(new Cat()); // 以 Cat 对象调用 show 方法
//		show(new Dog()); // 以 Dog 对象调用 show 方法
//		Animal a = new Cat(); // 向上转型
//		a.eat(); // 调用的是 Cat 的 eat
//		Cat c = (Cat) a; // 向下转型
//		c.work(); // 调用的是 Cat 的 work
//	}
//
//	public static void show(Animal a) {
//		a.eat();
//// 类型判断
//		if (a instanceof Cat) { // 猫做的事情
//			Cat c = (Cat) a;
//			c.work();
//		} else if (a instanceof Dog) { // 狗做的事情
//			Dog c = (Dog) a;
//			c.work();
//		}
//	}
//}
//
//abstract class Animal {
//	abstract void eat();
//}
//
//class Cat extends Animal {
//	public void eat() {
//		System.out.println("吃鱼");
//	}
//
//	public void work() {
//		System.out.println("抓老鼠");
//	}
//}
//
//class Dog extends Animal {
//	public void eat() {
//		System.out.println("吃骨头");
//	}
//
//	public void work() {
//		System.out.println("看家");
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		GirlFriend gf1 = new GirlFriend();
//		gf1.setAge(16);
//		System.out.println(gf1.getAge());
//		Scanner sc = new Scanner(System.in);
//		String name = sc.next();
//		String sex = sc.next();
//		Person p = new Person();
//		Person q = new Person(name,sex);


//		WuMingFen f1 = new WuMingFen("牛肉",3,true);
//		WuMingFen f2 = new WuMingFen("牛肉",3);
//		WuMingFen f3 = new WuMingFen();
//		f1.check();
//		f2.check();
//		f3.check();


//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		eat();
//	}
//	public  static  void sleep(){
//		System.out.println("睡觉");
//	}
//	public  static  void study(){
//		System.out.println("学习");
//	}
//	public  static  void  eat(){
//		study();
//		System.out.println("吃饭");
//		sleep();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		print666();
//		print666();
//	}
//
//	public static void print666() {
//		System.out.println("666");
//	}
//
//	public static void compare(int a, int b) {
//		System.out.println(a == b);
//	}
//
//	public static void compare(double a, double b) {
//		System.out.println(a == b);
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5};
//		System.out.println(arr);
//	}
//}


//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = 5;
//		int i, j, temp, min = 0;
//		int[] array;
//		array = new int[n];
//		for (i = 0; i < n; i++) {
//			array[i] = sc.nextInt();
//		}
//		System.out.println("The sequence before sorted:");
//		for (i = 0; i < n - 1; i++) {
//			min = i;
//			for (j = i + 1; j < n; j++) {
//				if (array[min] > array[i]) {
//					min = j;
//				}
//				if (min != i) {
//					temp = array[min];
//					array[min] = array[i];
//					array[i] = temp;
//				}
//			}
//			System.out.println("The sequence after sorted:");
//			for (i = 0; i < n; i++) {
//				System.out.print(array[i]);
//			}
//		}
//	}
//}


////TripPlan
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n, m, k;
//		n = sc.nextInt();
//		m = sc.nextInt();
//		k = sc.nextInt();
//		int[] ti;
//		ti = new int[n];
//		int[] ci;
//		ci = new int[n];
//		int[] qi;
//		qi = new int[n];
//		int[] answer;
//		answer = new int[n];
//		for (int i = 0; i < n; i++) {
//			ti[i] = sc.nextInt();
//			ci[i] = sc.nextInt();
//		}
//		for (int i = 0; i < m; i++) {
//			qi[i] = sc.nextInt();
//		}
//		for (int j = 0; j < m; j++) {
//			answer[j] = 0;
//			for (int i = 0; i < n; i++) {
//				if (qi[j] + k <= ti[i] && ti[i] < qi[j] + k + ci[i]) {
//					answer[j]++;
//				}
//			}
//		}
//		for (int i = 0; i < m; i++) {
//			System.out.println(answer[i]);
//		}
//	}
//}

////SalaryPerWeek
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
////		System.out.println(n);
//		double[] k;
//		k = new double[n];
//		double[] t;
//		t = new double[n];
//		for (int i = 0; i < n; i++) {
//			k[i] = sc.nextDouble();
////			System.out.println(k[i]);
//			t[i] = sc.nextDouble();
////			System.out.println(t[i]);
//		}
//		for (int i = 0; i < n; i++) {
//			if (k[i] < 50) {
//				if (t[i] > 60)
//					System.out.println("该员工每小时基本工资低于50元且该员工工作时间超过60小时");
//				else
//					System.out.println("该员工每小时基本工资低于50元");
//			} else if (t[i] > 60)
//				System.out.println("该员工周工作时间超过60小时");
//			else if (t[i] < 40)
//				System.out.println(k[i] * t[i]);
//			else if (40 <= t[i] && t[i] <= 50)
//				System.out.println(k[i]*40+(t[i]-40)*k[i]*1.5);
//			else
//				System.out.println(k[i]*40+10*k[i]*1.5+(t[i]-50)*k[i]*2);
//		}
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		int f1 = 1, f2 = 1, n = 3, f3;
//		System.out.println(f1 + "\n" + f2);
//		for (; n <= 20; n++) {
//			f3 = f1 + f2;
//			f1 = f2;
//			f2 = f3;
//			System.out.println(f3);
//		}
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//
//		System.out.println(true & true);
//		System.out.println(false & false);
//		System.out.println(true & false);
//		System.out.println(false & true);
//
//		System.out.println(true | true);
//		System.out.println(false | false);
//		System.out.println(true | false);
//		System.out.println(false | true);
//	}
//}


// public class Main{
//     public static void main(String[] args){
// 		byte b = 10;
// 		System.out.println(b);
// 		short s =20;
// 		System.out.println(s);
// 		int i = 30;
// 		System.out.println(i);
// 		long n = 9999999999L;
// 		System.out.println(n);
// 		float f = 10.1F;
// 		System.out.println(f);
// 		double d = 20.2;
// 		System.out.println(d);
// 		char c = '中';
// 		System.out.println(c);
// 		boolean o = true;
// 		System.out.println(o);
//     }
// }


// public class Main {
//     //叫做main方法，表示程序的主入口
//     public static void main(String[] args) {
//
//         //输出语句（打印语句）
//         System.out.println("Hello world!");
//
//         //整数
//         System.out.println(666);
//         System.out.println(-777);
//
//         //小数a
//         System.out.println(1.93);
//         System.out.println(-3.71);
//
//         //字符串
//         System.out.println("王渊");
//         System.out.println("爱Java");
//
//         //字符
//         System.out.println('男');
//         System.out.println('二');
//
//         //布尔
//         System.out.println(true);
//         System.out.println(false);
//
//         //空
//         System.out.println("null");
//     }
// }


