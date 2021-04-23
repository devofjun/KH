package number.puzzle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDao {
	private static ScoreDao instance = null;
	private ScoreDao() {}
	public static ScoreDao getInstance() {
		if(instance == null) {
			instance = new ScoreDao();
		}
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
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			System.out.println("conn:" + conn);
			return conn;
		} catch (SQLException e) {
			System.out.println("데이터베이스에 접속 할 수 없습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
		}
		return null;
	}
	
	
	public boolean setScore(UserVo userVo, long score) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "insert into tbl_score ("
					+ "	u_id, score)"
					+ "	values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getUid());
			pstmt.setLong(2, score);
			int count = pstmt.executeUpdate();
			if(count > 0) { 
				System.out.println("점수 등록 성공");
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null,pstmt,null);
			closeAll(rs,pstmt,conn);
		}
		return false;
	}
	
	
	public ScoreVo getWinner() {
		ScoreVo scoreVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from tbl_score"
					+ "		order by score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next() == true) {
				String uid = rs.getString("u_id");
				Long score = rs.getLong("score");
				scoreVo = new ScoreVo(uid, score);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return scoreVo;
	}
}
