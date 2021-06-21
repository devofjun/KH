package studentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentVo.StudentVo;

public class StudentDao {
	private static StudentDao instance;

	private StudentDao() {
	}

	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}

	// 연결 변수
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "USER1001";
	private final String PASSWORD = "U1234";

	// 연결메소드
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
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

	// 학생 목록
	public List<StudentVo> getStudentList() {
		List<StudentVo> list = new ArrayList<StudentVo>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from TBL_STUDENT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("SNO");
				String sname = rs.getString("SNAME");
				int syear = rs.getInt("SYEAR");
				String gender = rs.getString("GENDER");
				String major = rs.getString("MAJOR");
				int score = rs.getInt("SCORE");
				StudentVo vo = new StudentVo(sno, sname, syear, gender, major, score);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return null;
	}

	// 학생등록
	public boolean insertStudent(StudentVo vo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)"
					+ "		values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSno());
			pstmt.setString(2, vo.getSname());
			pstmt.setInt(3, vo.getSyear());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getMajor());
			pstmt.setInt(6, vo.getScore());
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

	// 학생 정보
	public StudentVo getStudent(String sno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from TBL_STUDENT where sno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sname = rs.getString("SNAME");
				int syear = rs.getInt("SYEAR");
				String gender = rs.getString("GENDER");
				String major = rs.getString("MAJOR");
				int score = rs.getInt("SCORE");
				StudentVo vo = new StudentVo(sno, sname, syear, gender, major, score);
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		return null;
	}

	// 학생 수정
	public boolean updateStudent(StudentVo vo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update TBL_STUDENT" +
					"	set SNAME = ?," +
					"		SYEAR = ?," +
					"		GENDER = ?," +
					"		MAJOR = ?," +
					"		SCORE = ?" + 
					"		where SNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setInt(2, vo.getSyear());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getMajor());
			pstmt.setInt(5, vo.getScore());
			pstmt.setString(6, vo.getSno());
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	// 학생 삭제
	public boolean deleteStudent(String sno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from TBL_STUDENT where sno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			int count = pstmt.executeUpdate();
			if(count > 0) {
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
