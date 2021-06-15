package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kh.vo.BoardVo;

public class BoardDao {
	static private BoardDao instance;

	private BoardDao() {
	};

	static public BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
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

	// 연결 해제 메소드
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 목록 가져오기
	public List<BoardVo> getBoardList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<>();
		try {
			String sql = "select * from tbl_board"
					+ "		order by re_group desc, re_seq asc, b_no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int b_no = rs.getInt("b_no");
				String b_filepath = rs.getString("b_filepath");
				String b_title = rs.getString("b_title");
				String m_id = rs.getString("m_id");
				Timestamp b_date = rs.getTimestamp("b_date");
				int b_readcount = rs.getInt("b_readcount");
				int re_level = rs.getInt("re_level");

				BoardVo vo = new BoardVo(b_no, b_title, null, b_date, m_id, b_readcount, 0, 0, re_level, b_filepath);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// 글작성하기
	public boolean insertArticle(BoardVo vo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into tbl_board(b_no, b_title, b_content, m_id, re_group, b_filepath)"
					+ "   values(seq_bno.nextval, ?, ?, ?, seq_bno.nextval,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getB_title());
			pstmt.setString(2, vo.getB_content());
			pstmt.setString(3, vo.getM_id());
			pstmt.setString(4, vo.getB_filepath());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}

	// 글 번호로 글 가져오기
	public BoardVo selectByBno(int b_no) {
		BoardVo vo = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from tbl_board" + "		where b_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id = rs.getString("m_id");
				int b_readcount = rs.getInt("b_readcount");
				String b_filepath = rs.getString("b_filepath");
				vo = new BoardVo(b_no, b_title, b_content, b_date, m_id, b_readcount, 0, 0, 0, b_filepath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return vo;
	}
	
	// 글 삭제
	public boolean deleteArticle(int b_no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from tbl_board where b_no="+b_no;
			pstmt = conn.prepareStatement(sql);
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	// 글 내용 수정
	public boolean updateArticle(BoardVo vo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update tbl_board set"
					+ "		b_title = ?,"
					+ "		b_content = ?,"
					+ "		m_id = ?"
					+ "		where b_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getB_title());
			pstmt.setString(2, vo.getB_content());
			pstmt.setString(3, vo.getM_id());
			pstmt.setInt(4, vo.getB_no());
			int count = pstmt.executeUpdate();
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
