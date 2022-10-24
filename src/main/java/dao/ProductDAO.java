package dao;

import model.Product;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
	
	public boolean addProduct(Product p) throws ClassNotFoundException {

        try (Connection connection = JDBCUtil.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO product (`name`,`price`) VALUES (?,?)")) {
            preparedStatement.setString(1, p.getpName());
            preparedStatement.setString(2, p.getpPrice());

            System.out.println(preparedStatement);
            int rs = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
            if(rs > 0) {
            	return true;
            }
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return false;
	}
	
	public ArrayList<Product> getAllProduct() throws ClassNotFoundException {
		ArrayList<Product> lstProduct = new ArrayList<Product>();
		
        try (Connection connection = JDBCUtil.getConnection();) {
        	
        	Statement stmt = connection.createStatement();
        	String sql = "Select id, name, price from product";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	int id = rs.getInt("id");
            	String product_name = rs.getString("name");
            	String product_price = rs.getString("price");
            	
            	Product product = new Product(id, product_name, product_price);
            	
            	lstProduct.add(product);
            }
            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        
		return lstProduct;
	}
	
	public boolean deleteProduct(String pId) throws ClassNotFoundException {
		//Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = JDBCUtil.getConnection();

            // Step 2:Create a statement using connection object
            Statement stmt = connection.createStatement();
        	) {
        	
        	String deleteQuery = "delete from product where id = "+pId;
            stmt.executeUpdate(deleteQuery);
            //System.out.print(true);
            JDBCUtil.closeConnection(connection);
            return true;
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        //System.out.print(false);	
		return false;
	}
	
	public Product getProductById(String pid) throws ClassNotFoundException {
		Product product = new Product();
		
        try (Connection connection = JDBCUtil.getConnection();) {
        	
        	Statement stmt = connection.createStatement();
        	String sql = "Select id, name, price from product where id ="+pid;
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
            	int id = rs.getInt("id");
            	String product_name = rs.getString("name");
            	String product_price = rs.getString("price");
            	
            	product.setpId(id);
            	product.setpName(product_name);
            	product.setpPrice(product_price); 
            	return product;
            } 
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
		return null;
	}
	
	public boolean update(Product p) throws ClassNotFoundException {

        try (Connection connection = JDBCUtil.getConnection();
        	) {
        	String query = "update product set name = ?, price = ? where id = ?";
        	PreparedStatement preparedStatement = connection
    	            .prepareStatement(query);
        	preparedStatement.setString(1, p.getpName());
        	preparedStatement.setString(2, p.getpPrice());
        	preparedStatement.setInt(3, p.getpId());
        	
            int row = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
            if(row > 0) {
                return true;
            }
            
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
		return false;
	}
		
}
