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
import com.kh.vo.PagingDto;

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
	public List<BoardVo> getBoardList(PagingDto pagingDto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<>();
		try {
			// 그룹번호로 정렬 + 그룹번호가 같다면 시퀀스(re_seq) 값으로 정렬
			// rownum은 테이블의 갯수라고 생각하면 된다.
			// 테이블 전체 데이터를 정렬해서 가져온다. -> 그 테이블에 rownum 값을 매긴다. -> 매겨진 rownum의 원하는 rownum으로 조건을 줘서 일부분만 가져온다.
			String sql = "select * from" + 
					"			(select rownum rnum, a.* from" + 
					"				(select * from tbl_board" + 
					"					order by re_group desc, re_seq asc) a)" + 
					"	where rnum between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagingDto.getStartRow());
			pstmt.setInt(2, pagingDto.getEndRow());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int b_no = rs.getInt("b_no");
				String b_title = rs.getString("b_title");
				String m_id = rs.getString("m_id");
				Timestamp b_date = rs.getTimestamp("b_date");
				int b_readcount = rs.getInt("b_readcount");
				String b_filepath = rs.getString("b_filepath");
				int re_level = rs.getInt("re_level");

				BoardVo vo = new BoardVo(b_no, b_title, null, b_date, m_id, b_readcount, 0, 0, re_level, b_filepath);
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
		String sql = "insert into tbl_board(b_no, b_title, b_content, m_id, re_group, b_filepath)"
		+ "				values(seq_bno.nextval, ?, ?, ?, seq_bno.nextval,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getB_title());
			pstmt.setString(2, boardVo.getB_content());
			pstmt.setString(3, boardVo.getM_id());
			pstmt.setString(4, boardVo.getB_filepath());
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
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_board" + "   where b_no = ?";
		
		String sql2 = "update tbl_board set"
				+ "		b_readcount = b_readcount+1"
				+ "		where b_no =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, b_no);
			pstmt2.executeUpdate();
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
			closeAll(null, pstmt2, null);
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
	
	// 답글 달기
	public boolean insertReply(BoardVo boardVo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = "update tbl_board set"
				+ "		re_seq = re_seq + 1"
				+ "		where re_group = ?"
				+ "		and re_seq > ?";
		String sql2 = "insert into tbl_board(b_no, b_title, b_content, m_id, re_group, re_seq, re_level)"
				+ "		values(seq_bno.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false); // JDBC는 기본 자동커밋이라서 false로 설정해준다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getRe_group());
			pstmt.setInt(2, boardVo.getRe_seq());
			int count = pstmt.executeUpdate();
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, boardVo.getB_title());
			pstmt2.setString(2, boardVo.getB_content());
			pstmt2.setString(3, boardVo.getM_id());
			pstmt2.setInt(4, boardVo.getRe_group());
			pstmt2.setInt(5, boardVo.getRe_seq() + 1);
			pstmt2.setInt(6, boardVo.getRe_level() + 1);
			int count2 = pstmt2.executeUpdate();		
			if(count > 0 && count2 > 0) {
				conn.commit();
				return true;
			}
			
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(null, pstmt, null);
			closeAll(null, pstmt2, conn);
		}
		return false;
	}
}
