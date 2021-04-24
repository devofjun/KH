package number.puzzle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private static UserDao instance = null;
	private UserDao() {	}
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		//System.out.println("userdao 생성됨"+instance);
		return instance;
	}
	// ====================singleton========================
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "user01";
	private final String PW = "1234";
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch (SQLException e) {}
		if(pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if(conn != null) try {conn.close();} catch (SQLException e) {}
	}
	
	// 커넥션을 연결하고 다시 반납하기 위해 private으로 하고 다른 메서드에서 접근하고 연결을 끊는다.
	private Connection getConnection() { 
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			System.out.println("conn:" + conn);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스에 접속 할 수 없습니다.");
		}
		return null;
	}
	
	// 로그인
	public UserVo signin(String sID, String sPW) {
		UserVo user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from tbl_user"
					+ "		where u_id = ? and u_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sID);
			pstmt.setString(2, sPW);
			rs = pstmt.executeQuery();
			if(rs.next() == true) {
				//System.out.println("로그인 성공");
				String uid = rs.getString("u_id");
				String upw = rs.getString("u_pw");
				String uname = rs.getString("u_name");
				user = new UserVo(uid, upw, uname);
			} else {
				//System.out.println("로그인 실패");
				user = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt,conn);
		}
		return user;
	}

	// 회원가입
	public boolean signup(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into tbl_user ("
					+ "		u_id, u_pw, u_name)"
					+ "		values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getUid());
			pstmt.setString(2, userVo.getUpw());
			pstmt.setString(3, userVo.getUname());
			int count = pstmt.executeUpdate(); // "몇 행이 삽입되었습니다." 에서 숫자를 리턴한다.
			if(count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt,conn);
		}
		return false;
	}
}
