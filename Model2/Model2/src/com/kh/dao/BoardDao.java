package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kh.vo.BoardVo;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	private BoardDao() {
	}

	public static BoardDao getInstance() {
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
			System.out.println("conn: " + conn);
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
	
	public List<BoardVo> getBoardList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<>();
		try {
			String sql = "select * from tbl_board"
					+ "		order by b_date desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int b_no = rs.getInt("b_no");
				String b_title = rs.getString("b_title");
				String m_id = rs.getString("m_id");
				Timestamp b_date = rs.getTimestamp("b_date");
				int b_readcount = rs.getInt("b_readcount");
				
				BoardVo vo = new BoardVo(b_no, b_title, null, b_date, m_id, b_readcount, 0, 0, 0, null);
				list.add(vo);
			}
			closeAll(rs, pstmt, conn);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}
}
