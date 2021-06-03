package com.kh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestStudentDao {
	static TestStudentDao instance;
	private TestStudentDao() {}
	public static TestStudentDao getInstance() {
		if(instance == null) {
			instance = new TestStudentDao();
		}
		return instance;
	}
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "test01";
	private final String PASSWORD = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn: "+conn);
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(conn!=null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
	public ArrayList<TestStudentVo> getStudentList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TestStudentVo> voList = new ArrayList<TestStudentVo>();
		String sql = "select st_num, st_name, st_major, st_year"
				+ "   from tbl_student"
				+ "   order by st_num";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("rs:"+rs);
			while(rs.next()) {
				int stNum = rs.getInt("st_num");
				String stName = rs.getString("st_name");
				String stMajor = rs.getString("st_major");
				int stYear = rs.getInt("st_year");
				//System.out.println(stNum+", "+stName+", "+stMajor+", "+stYear);
				TestStudentVo vo = new TestStudentVo(stNum, stName, stMajor, stYear, 0, null); 
				//System.out.println("vo: "+vo);
				voList.add(vo);
			}
			//closeAll(rs, pstmt, conn);
			System.out.println("voList:"+voList);
			return voList;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
}
