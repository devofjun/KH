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

	// 목록 가져오기
	public List<BoardVo> getBoardList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<>();
		try {
			String sql = "select * from tbl_board" + "		order by b_date desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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

	// 새로운 글 등록
	public boolean insertArticle(BoardVo boardVo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_board(b_no, b_title, b_content, m_id)" + "   values(seq_bno.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getB_title());
			pstmt.setString(2, boardVo.getB_content());
			pstmt.setString(3, boardVo.getM_id());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

		return false;
	}

	// 글번호로 글 1개 가져오기
	public BoardVo selectByBno(int b_no) {
		BoardVo boardVo = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_board" + "   where b_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id = rs.getString("m_id");
				int b_readcount = rs.getInt("b_readcount");
				int re_group = rs.getInt("re_group");
				int re_seq = rs.getInt("re_seq");
				int re_level = rs.getInt("re_level");
				String b_filepath = rs.getString("b_filepath");
				boardVo = new BoardVo(b_no, b_title, b_content, b_date, m_id, b_readcount, re_group, re_seq, re_level,
						b_filepath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return boardVo;
	}
	
	// 글 내용 수정
	public boolean updateArticle(BoardVo boardVo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update tbl_board set"
					+ "   b_title = ?,"
					+ "   b_content = ?,"
					+ "   m_id = ?"
					+ "   where b_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getB_title());
			pstmt.setString(2, boardVo.getB_content());
			pstmt.setString(3, boardVo.getM_id());
			pstmt.setInt(4, boardVo.getB_no());
			int count = pstmt.executeUpdate();
			if(count > 0) {
				closeAll(null, pstmt, conn);
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	// 글 삭제
	public boolean deleteArticle(int b_no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_board"
				+ "   where b_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				closeAll(null, pstmt, conn);
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