package ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class EmpDao {
	private static EmpDao instance;
	private EmpDao() { }
	public static EmpDao getInstance() {
		if(instance == null) {
			instance = new EmpDao();
		}
		return instance;
	}
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "user01";
	private final String PW = "1234";
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch (SQLException e) {}
		if(pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if(conn != null) try {conn.close();} catch (SQLException e) {}
	}
	
	private Connection getConnection() { // 커넥션을 연결하고 다시 반납하기 위해 private으로 하고 다른 메서드에서 접근하고 연결을 끊는다.
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
	
	// 전체조회
	public List<EmpVo> selectAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * "
				+ "   from emp "
				+ "   order by empno";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<EmpVo> list = new Vector<EmpVo>();
			
			while(rs.next()) { // 다음 읽을것이 있다면 true
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				EmpVo empVo = new EmpVo(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				
				//System.out.println(empVo);
				list.add(empVo);
			} // while End
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt,conn);
		}
		return null;
	}
	// 사원조회
	public EmpVo selectByEmpno(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from emp"
					+ "   where empno = " + empno;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next() == true) {
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				EmpVo empVo = new EmpVo(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				return empVo;
			}
		} catch(Exception e) {
			
		} finally {
			closeAll(rs,pstmt,conn);
		}
		
		
		return null;
	}
	
	// 입력
	public boolean insertData(EmpVo empVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into emp("
					+ "			empno, ename, job, mgr,"
					+ "			hiredate, sal, comm, deptno)"
					+ "		values(?,?,?,?, sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empVo.getNo());
			pstmt.setString(2, empVo.getName());
			pstmt.setString(3, empVo.getJob());
			pstmt.setInt(4, empVo.getMgr());
			pstmt.setInt(5, empVo.getSal());
			pstmt.setInt(6, empVo.getComm());
			pstmt.setInt(7, empVo.getDeptno());
			//pstmt.setInt(8, 1);
			int count = pstmt.executeUpdate();
			if(count > 0) { 
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace(); // 에러 로그 출력
		} finally {
			closeAll(null, pstmt,conn);
		}
		return false;
	}
	// 수정
	public boolean updateDate(EmpVo empVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "update emp"
					+ "   set"
					+ "		ename = ?,"
					+ "		job = ?,"
					+ "		mgr = ?,"
					+ "		hiredate = sysdate,"
					+ "		sal = ?,"
					+ "		comm = ?,"
					+ "		deptno = ?"
					+ "   where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empVo.getName());
			pstmt.setString(2, empVo.getJob());
			pstmt.setInt(3, empVo.getMgr());
			//pstmt.setString(4, empVo.getHiredate().toString());
			pstmt.setInt(4, empVo.getSal());
			pstmt.setInt(5, empVo.getComm());
			pstmt.setInt(6, empVo.getDeptno());
			pstmt.setInt(7, empVo.getNo());
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
	// 삭제
	public boolean deleteData(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete from emp"
					+ "   where empno = " + empno;
			pstmt = conn.prepareStatement(sql);
			int count = pstmt.executeUpdate(); // insert, update, delete => executeUpdate()
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
