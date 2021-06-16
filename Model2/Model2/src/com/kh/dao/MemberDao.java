package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.vo.MemberVo;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		return instance;
	}

	// 연결 변수
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "model2";
	private final String PASSWORD = "1234";

	// 연결메소드
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// System.out.println("conn: " + conn);
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
	
	// 회원가입
	public boolean insertMember(MemberVo memberVo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into tbl_member(user_id, user_pw, user_name)"
					+ "		values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getUser_id());
			pstmt.setString(2, memberVo.getUser_pw());
			pstmt.setString(3, memberVo.getUser_name());
			pstmt.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	// 로그인
	public MemberVo login(String user_id, String user_pw) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tbl_member"
					+ "		where user_id = ?"
					+ "		and user_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String user_name = rs.getString("user_name");
				MemberVo memberVo = new MemberVo(user_id, user_pw, user_name);
				return memberVo;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
	
	// 아이디 중복확인
	public boolean checkDupId(String user_id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) cnt from tbl_member"
					+ "		where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return false;
	}
}
