//package com.min.edu.repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.customer.model.Customer;
//
//@Repository
//public class JdbcCustomerRepository extends BaseRepository implements CustomerRepository{
//
//	
	
//	@Override
//	public List<Customer> selectAll() {
//		
//		List<Customer> customerList = new ArrayList<Customer>();
//		
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_ALL_SQL);
//			resultSet = pStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				Customer customer = new Customer();
//				
//				customer.setCustomerid(resultSet.getInt("customerid"));
//				customer.setId(resultSet.getString("id"));
//				customer.setName(resultSet.getString("name"));
//				customer.setPassword(resultSet.getString("password"));
//				customer.setPostcode(resultSet.getString("postcode"));
//				customer.setAddress(resultSet.getString("address"));
//				customer.setAddress2(resultSet.getString("address2"));
//				customer.setPhone(resultSet.getString("phone"));
//				customer.setEmail(resultSet.getString("email"));
//				
//				customerList.add(customer);
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally {
//			close(resultSet, pStatement, connection);
//		}
//		
//		return customerList;
//	}
//
//	@Override
//	public Customer selectByCustomerId(int customerid) {
//		Customer customer = null;
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_BY_CUSTOMERID_SQL);
//			pStatement.setInt(1, customerid);
//			resultSet = pStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				
//				customer = new Customer();
//				
//				customer.setCustomerid(resultSet.getInt("customerid"));
//				customer.setId(resultSet.getString("id"));
//				customer.setName(resultSet.getString("name"));
//				customer.setPassword(resultSet.getString("password"));
//				customer.setPostcode(resultSet.getString("postcode"));
//				customer.setAddress(resultSet.getString("address"));
//				customer.setAddress2(resultSet.getString("address2"));
//				customer.setPhone(resultSet.getString("phone"));
//				customer.setEmail(resultSet.getString("email"));
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally {
//			close(resultSet, pStatement, connection);
//		}
//		
//		return customer;
//	}
//
//	@Override
//	public List<Customer> selectByName(String name) {
//		List<Customer> customerList = new ArrayList<Customer>();
//		
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_BY_NAME_SQL);
//			pStatement.setString(1, "%" + name + "%");
//			resultSet = pStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				Customer customer = new Customer();
//				
//				customer.setCustomerid(resultSet.getInt("customerid"));
//				customer.setId(resultSet.getString("id"));
//				customer.setName(resultSet.getString("name"));
//				customer.setPassword(resultSet.getString("password"));
//				customer.setPostcode(resultSet.getString("postcode"));
//				customer.setAddress(resultSet.getString("address"));
//				customer.setAddress2(resultSet.getString("address2"));
//				customer.setPhone(resultSet.getString("phone"));
//				customer.setEmail(resultSet.getString("email"));
//				
//				customerList.add(customer);
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally {
//			close(resultSet, pStatement, connection);
//		}
//		
//		return customerList;
//	}
//
//	@Override
//	public int insert(Customer customer) {
//		int result = 0;
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//	      
//		try {
//			connection = getConnection();
//	        pStatement = connection.prepareStatement(Sql.CUSTOMER_INSERT_SQL);
//	         
//	        pStatement.setString(1, customer.getId());
//	        pStatement.setString(2, customer.getName());
//	        pStatement.setString(3, customer.getPassword());
//	        pStatement.setString(4, customer.getPostcode());
//	        pStatement.setString(5, customer.getAddress());
//	        pStatement.setString(6, customer.getAddress2());
//	        pStatement.setString(7, customer.getPhone());
//	        pStatement.setString(8, customer.getEmail());
//	         
//	        result = pStatement.executeUpdate(); 
//	         
//	     } catch (SQLException e) {
//	        e.printStackTrace();
//	     } finally {
//	       close(null, pStatement, connection); 
//	      }
//	     
//		return result;
//	}
//
//	@Override
//	public int update(Customer customer) {
//		int result = 0;
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//	      
//		try {
//			connection = getConnection();
//	        pStatement = connection.prepareStatement(Sql.CUSTOMER_UPDATE_SQL);
//	         
//	        pStatement.setString(1, customer.getName());
//	        pStatement.setString(2, customer.getPassword());
//	        pStatement.setString(3, customer.getPostcode());
//	        pStatement.setString(4, customer.getAddress());
//	        pStatement.setString(5, customer.getAddress2());
//	        pStatement.setString(6, customer.getPhone());
//	        pStatement.setString(7, customer.getEmail());
//	        pStatement.setInt(8, customer.getCustomerid());
//	         
//	        result = pStatement.executeUpdate(); 
//	         
//	     } catch (SQLException e) {
//	        e.printStackTrace();
//	     } finally {
//	       close(null, pStatement, connection); 
//	      }
//	     
//		return result;
//	}
//
//	@Override
//	public int delete(int customerid) {
//		int result = 0;
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//	      
//		try {
//			connection = getConnection();
//	        pStatement = connection.prepareStatement(Sql.CUSTOMER_DELETE_SQL);
//	         
//	        pStatement.setInt(1, customerid);
//	         
//	        result = pStatement.executeUpdate(); 
//	         
//	     } catch (SQLException e) {
//	        e.printStackTrace();
//	     } finally {
//	       close(null, pStatement, connection); 
//	      }
//	     
//		return result;
//	}

//}
