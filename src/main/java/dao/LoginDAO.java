package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginBean;
import util.JDBCUtil;

public class LoginDAO {

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        try (Connection connection = JDBCUtil.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from login where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            System.out.println("Login: "+status);
            
            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            printSQLException(e);
        }

        return status;
    }
    
    public boolean addUser(LoginBean loginBean) throws ClassNotFoundException {

        try (Connection connection = JDBCUtil.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO login VALUES (?,?)")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            int rs = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
            if(rs > 0) {
            	return true;
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return false;
    	
    }

    
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}