package ex01;

import java.sql.Connection;
import java.sql.DriverManager;

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
	
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME); // SQL Command Line 띄우는거라고 생각하면됨
			Connection conn = DriverManager.getConnection(URL, ID, PW); // SQL> conn user01/1234
			System.out.println("conn:"+conn); // 연결이 잘 됐는지 확인
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
