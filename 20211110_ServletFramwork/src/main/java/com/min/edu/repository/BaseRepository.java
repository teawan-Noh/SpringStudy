//package com.min.edu.repository;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class BaseRepository {
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	public Connection getConnection() {
//			
//			Connection connection = null;
//			
//			try {
//				connection = dataSource.getConnection();
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			return connection;
//		}
//		
//		public void close(ResultSet resultSet, Statement statement, Connection connection) {
//			
//			if(resultSet != null) {
//				
//				try {
//					if(!resultSet.isClosed()) {
//						
//						resultSet.close();
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					
//					resultSet = null;
//				}
//			}
//			
//			if(statement != null) {
//				
//				try {
//					if(!statement.isClosed()) {
//						
//						statement.close();
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					
//					statement = null;
//				}
//			}
//			
//			if(connection != null) {
//				
//				try {
//					if(!connection.isClosed()) {
//						
//						connection.close();
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					
//					connection = null;
//				}
//			}
//			
//		}
//}
