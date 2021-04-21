package sec03.exam02;

public class ThrowsExample {
	public static void main(String[] args) {
		try {
			findClass();			
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
	// main에서 사용할 것이기 때문에 static을 붙임
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
