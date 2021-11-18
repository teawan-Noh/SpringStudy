package com.min.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBase {

	//1단계
	public DataBase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 드라이버로딩");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2단계
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "1234";
		
		conn = DriverManager.getConnection(url, user, password);
		
		return  conn;
	}
	
	
	//6단계
	public void closed(ResultSet rs, Statement pstmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			System.out.println("6단계 닫기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
