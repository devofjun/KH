package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpDao { // 데이터베이스 접근 객체 - DAO(Data Access Object)
	private static EmpDao instance;
	private EmpDao() { /*singleton*/ }
	public static EmpDao getInstance() {
		if(instance == null) {
			instance = new EmpDao();
		}
		return instance;
	}
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 다른 컴퓨터의 데이터베이스에 접근하려면 @뒤에 ip를 붙이면된다.
	private final String ID = "user01";
	private final String PW = "1234";
	
	private Connection getConnection() { // DB드라이버 매칭
		try {
			Class.forName(DRIVER_NAME); // SQL Command Line 띄우는거라고 생각하면됨
			Connection conn = DriverManager.getConnection(URL, ID, PW); // SQL> conn user01/1234
			System.out.println("conn:"+conn); // 연결이 잘 됐는지 확인
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public EmpVo getEmpList() { // 연결된 DB에서 데이터 가져오기
		try {
			Connection conn = getConnection(); // 데이터베이스와 연결하기
			// SQL 문장 타이핑
			String sql = "select empno, ename, job, sal"
					+ "   from emp" // 공백이 있어야 from과 select문과 구분이 된다.
					+ "   order by empno asc";  // 마찬가지로 공백이 있어야 한다.
			PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 문장 전달(타이핑)
			ResultSet rs = pstmt.executeQuery(); // Enter -> 실행결과물을 받음.
			boolean b = rs.next(); // 더 읽어올 데이터가 있다면 true
			if(b == true) { // vo에 데이터를 하나씩 옮기기
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				
				EmpVo empVo = new EmpVo();
				empVo.setEmpno(empno);
				empVo.setEname(ename);
				empVo.setJob(job);
				empVo.setSal(sal);
				System.out.println(empVo.toString());
				return empVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
