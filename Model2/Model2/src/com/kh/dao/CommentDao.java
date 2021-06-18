package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kh.vo.MemberVo;

public class CommentDao {
	private static CommentDao instance = new CommentDao();

	private CommentDao() {
	}

	public static CommentDao getInstance() {
		return instance;
	}

	// 연결 변수
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "model2";
	private final String PASSWORD = "1234";

	// 연결메소드
	public Connection getConnection() {
		try {
			/*
			// javax.naming
			Context context = new InitialContext();
			// javax.sql
			Context envContext = (Context) context.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
//			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			Connection conn = ds.getConnection();
			*/
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 연결 닫기 메소드
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}
	}
	
	
}
