package com.kh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {
	private static StudentDao instance;
	private StudentDao() {}
	public static StudentDao getInstance() {
		if(instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "jsp01";
	private final String PASSWORD = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn:" + conn);
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null)    try {rs.close();}    catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null)  try {conn.close();}  catch(Exception e) {}
	}
	
	public boolean insertStudent(StudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into tbl_student(st_num, st_name, st_major, st_year, st_score, st_etc)"
					+ "   values(?, ?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt   (1, studentVo.getSt_num());
			pstmt.setString(2, studentVo.getSt_name());
			pstmt.setString(3, studentVo.getSt_major());
			pstmt.setInt   (4, studentVo.getSt_year());
			pstmt.setInt   (5, studentVo.getSt_score());
			pstmt.setString(6, studentVo.getSt_etc());
			int count = pstmt.executeUpdate(); // insert, update, delete // select -> executeQuery()
			if(count > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
}
