package DAO;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBConn {
	public static Connection conn;

	// Connection对象（链接）
	// 连接数据库
	public static Connection getConn() {
		try {
			// 加载注册SQLSever的JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 编写链接字符串，创建并且获取链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MessageBoard","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void CloseConn() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection conn=DBConn.getConn();
		if(conn!=null) {
			System.out.println("数据库连接正常");
		}else {
			System.out.println("数据库连接失败");
		}
	}
	
	
}
