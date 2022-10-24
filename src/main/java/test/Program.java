package test;

import java.sql.Connection;

import util.JDBCUtil;

public class Program {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = JDBCUtil.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(connection);
		JDBCUtil.closeConnection(connection);
	}
}
