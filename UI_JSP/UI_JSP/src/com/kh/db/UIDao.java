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
			while(rs.next()) {
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
		} catch(Exception e) {
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
		String sql = "select * from TBL_STUDENT where SNAME='"+name+"' order by SNO";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
		} catch(Exception e) {
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
		String sql = "select * from TBL_STUDENT where MAJOR='"+major+"' order by SNO";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
//	public void getSelect(String name, String major) {
//		
//	}
	// 상세정보 가져오기
	public UIVo getContent(String sno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UIVo vo = null;
		String sql = "select * from TBL_STUDENT where SNO='"+sno+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String SNO = rs.getString("SNO");
				String SNAME = rs.getString("SNAME");
				int SYEAR = rs.getInt("SYEAR");
				String GENDER = rs.getString("GENDER");
				String MAJOR = rs.getString("MAJOR");
				int SCORE = rs.getInt("SCORE");
				vo = new UIVo(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);
			}
		} catch(Exception e) {
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
		String sql = "select count(*) cnt from TBL_STUDENT where SNO='"+sno+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("cnt") <= 0) {
					return true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return false;
	}
	
	// 학생 등록
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
			pstmt.setInt   (3, vo.getSYEAR());
			pstmt.setString(4, vo.getGENDER());
			pstmt.setString(5, vo.getMAJOR());
			pstmt.setInt   (6, vo.getSCORE());
			int count = pstmt.executeUpdate(); // insert, update, delete // select -> executeQuery()
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
