package com.kh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UIDao {
	private static UIDao instance;

	private UIDao() {
	}

	public static UIDao getInstance() {
		if (instance == null) {
			instance = new UIDao();
		}
		return instance;
	}

	// 연결 변수
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "EXAM01";
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

	/*
	public void testData() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UIVo> list = new ArrayList<UIVo>();
		list.add(new UIVo("20151065", "정병준", 2, "남", "컴공", 100));
		list.add(new UIVo("20151001", "김민준", 2, "남", "건축학", 24));
		list.add(new UIVo("20151002", "김서연", 2, "여", "항공학", 35));
		list.add(new UIVo("20151004", "박서준", 2, "남", "신소재", 78));
		list.add(new UIVo("20151006", "박서윤", 2, "여", "신소재", 64));
		list.add(new UIVo("20151012", "박지우", 1, "여", "전기", 24));
		list.add(new UIVo("20151042", "박주원", 1, "남", "전기", 42));
		list.add(new UIVo("20131032", "최예준", 4, "남", "에너지", 42));
		list.add(new UIVo("20131054", "성현우", 4, "남", "컴퓨터", 68));
		list.add(new UIVo("20181069", "정하윤", 4, "여", "컴퓨터", 89));
		list.add(new UIVo("20171023", "최윤서", 3, "여", "교육학", 45));
		list.add(new UIVo("20201045", "강채원", 1, "여", "인문학", 74));
		list.add(new UIVo("20191087", "김은서", 2, "여", "경영학", 54));
		list.add(new UIVo("20161022", "정서현", 4, "여", "디자인", 79));
		list.add(new UIVo("20161015", "김우진", 4, "여", "미술", 74));
		list.add(new UIVo("20171052", "김민재", 3, "남", "심리학", 72));
		list.add(new UIVo("12345678", "아무개", 1, "남", "아무", 22));
		list.add(new UIVo("12345679", "홍길동", 4, "남", "추노", 88));
		String sql = "insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)" + "   values(?, ?, ?, ?, ?, ?)";
		conn = getConnection();
		int count = 0;
		try {
			for (UIVo vo : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getSNO());
				pstmt.setString(2, vo.getSNAME());
				pstmt.setInt(3, vo.getSYEAR());
				pstmt.setString(4, vo.getGENDER());
				pstmt.setString(5, vo.getMAJOR());
				pstmt.setInt(6, vo.getSCORE());
				count += pstmt.executeUpdate();
			}
		} catch (Exception e) {

		}

		if (count > 0) {
			closeAll(null, pstmt, conn);
			return;
		}
	}
	*/

	// 모두 select
	public ArrayList<UIVo> getSelectAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UIVo> list = new ArrayList<UIVo>();
		String sql = "select * from TBL_STUDENT order by SNO";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String SNO = rs.getString("SNO");
				String SNAME = rs.getString("SNAME");
				int SYEAR = rs.getInt("SYEAR");
				String GENDER = rs.getString("GENDER");
				String MAJOR = rs.getString("MAJOR");
				int SCORE = rs.getInt("SCORE");
				list.add(new UIVo(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE));
			}
			closeAll(rs, pstmt, conn);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}

	// 이름으로 select
	public ArrayList<UIVo> getSelectName(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UIVo> list = new ArrayList<UIVo>();
		String sql = "select * from TBL_STUDENT where SNAME like '%" + name + "%' order by SNO";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String SNO = rs.getString("SNO");
				String SNAME = rs.getString("SNAME");
				int SYEAR = rs.getInt("SYEAR");
				String GENDER = rs.getString("GENDER");
				String MAJOR = rs.getString("MAJOR");
				int SCORE = rs.getInt("SCORE");
				list.add(new UIVo(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE));
			}
			closeAll(rs, pstmt, conn);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}

	// 전공으로 select
	public ArrayList<UIVo> getSelectMajor(String major) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UIVo> list = new ArrayList<UIVo>();
		String sql = "select * from TBL_STUDENT where MAJOR like '%" + major + "%' order by SNO";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String SNO = rs.getString("SNO");
				String SNAME = rs.getString("SNAME");
				int SYEAR = rs.getInt("SYEAR");
				String GENDER = rs.getString("GENDER");
				String MAJOR = rs.getString("MAJOR");
				int SCORE = rs.getInt("SCORE");
				list.add(new UIVo(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE));
			}
			closeAll(rs, pstmt, conn);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}

	// 학생 정보 가져오기
	public UIVo getContent(String sno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UIVo vo = null;
		String sql = "select * from TBL_STUDENT where SNO='" + sno + "'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String SNO = rs.getString("SNO");
				String SNAME = rs.getString("SNAME");
				int SYEAR = rs.getInt("SYEAR");
				String GENDER = rs.getString("GENDER");
				String MAJOR = rs.getString("MAJOR");
				int SCORE = rs.getInt("SCORE");
				vo = new UIVo(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return vo;
	}

	// 학번 유효성 체크
	public boolean checkSNO(String sno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from TBL_STUDENT where SNO='" + sno + "'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("cnt") <= 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return false;
	}

	// 학생 정보 등록
	public boolean insertContent(UIVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)"
					+ "   values(?, ?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSNO());
			pstmt.setString(2, vo.getSNAME());
			pstmt.setInt(3, vo.getSYEAR());
			pstmt.setString(4, vo.getGENDER());
			pstmt.setString(5, vo.getMAJOR());
			pstmt.setInt(6, vo.getSCORE());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				closeAll(null, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}

	// 학생 정보 수정
	public boolean updateContent(UIVo vo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update tbl_student set" + "    SNAME = ?," + "    SYEAR = ?," + "    GENDER = ?,"
				+ "    MAJOR = ?," + "    SCORE = ?" + "    where SNO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSNAME());
			pstmt.setInt(2, vo.getSYEAR());
			pstmt.setString(3, vo.getGENDER());
			pstmt.setString(4, vo.getMAJOR());
			pstmt.setInt(5, vo.getSCORE());
			pstmt.setString(6, vo.getSNO());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				closeAll(null, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}

	// 학생 정보 삭제
	public boolean deleteContent(String sno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from TBL_STUDENT" + "   where SNO = '" + sno + "'";
		try {
			pstmt = conn.prepareStatement(sql);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				closeAll(null, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
}
