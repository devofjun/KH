package com.kh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyStudentDao {
	private static MyStudentDao instance;
	private MyStudentDao() {}
	public static MyStudentDao getInstance() {
		if(instance==null) {
			instance = new MyStudentDao();
		}
		return instance;
	}
	// db 연결 변수
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "jsp02";
	private final String PASSWORD = "1234";
	// 연결메소드
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn: " + conn);
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// insert 메소스
	public boolean insertStudent(MyStudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into tbl_student(st_num, st_name, st_major, st_year, st_score, st_etc)"
					+ "   values(?, ?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentVo.getSt_num());
			pstmt.setString(2, studentVo.getSt_name());
			pstmt.setString(3, studentVo.getSt_major());
			pstmt.setInt(4, studentVo.getSt_year());
			pstmt.setInt(5, studentVo.getSt_score());
			pstmt.setString(6, studentVo.getSt_etc());
			int count = pstmt.executeUpdate();
			if(count == 1) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	// 연결 닫기 메소드
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}
	}
	
}
