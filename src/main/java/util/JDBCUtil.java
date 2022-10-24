package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private static final String username = "root";
	private static final String password = "";
	
	public static Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
