package uiswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UIDao {
	static private UIDao instance;
	private UIDao() {}
	static public UIDao getInstance() {
		if(instance == null) {instance = new UIDao();}
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
			System.out.println(name);
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<UIVo> list = new ArrayList<UIVo>();
			String sql = "select * from TBL_STUDENT where SNAME like '%"+name+"%' order by SNO";
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
			String sql = "select * from TBL_STUDENT where MAJOR like '%"+major+"%' order by SNO";
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
		// 학생 정보 등록
		public boolean insertStudent(UIVo vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				String sql = "insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)"
						+ "   values(?, ?, ?, ?, ?, ?)";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getSno());
				pstmt.setString(2, vo.getSname());
				pstmt.setInt   (3, vo.getSyear());
				pstmt.setString(4, vo.getGender());
				pstmt.setString(5, vo.getMajor());
				pstmt.setInt   (6, vo.getScore());
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
		// 학생 정보 가져오기
		public UIVo getStudentinfo(String sno) {
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
		// 학생 정보 수정
		public boolean updateStudent(UIVo vo) {
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			String sql = "update tbl_student set" +
					"    SNAME = ?,"+ 
					"    SYEAR = ?," + 
					"    GENDER = ?," + 
					"    MAJOR = ?," + 
					"    SCORE = ?" + 
					"    where SNO = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getSname());
				pstmt.setInt   (2, vo.getSyear());
				pstmt.setString(3, vo.getGender());
				pstmt.setString(4, vo.getMajor());
				pstmt.setInt   (5, vo.getScore());
				pstmt.setString(6, vo.getSno());
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
		// 학생 정보 삭제
		public boolean deleteStudent(String sno) {
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			String sql = "delete from TBL_STUDENT"
					+ "   where SNO = '"+sno+"'";
			try {
				pstmt = conn.prepareStatement(sql);
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
