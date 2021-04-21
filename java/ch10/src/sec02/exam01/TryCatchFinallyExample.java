package sec02.exam01;

public class TryCatchFinallyExample {
	public static void main(String[] args) { // main에서 throws를하게되면 JVM까지 에러를 보내게 되기 때문에 의미가없다.
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		System.out.println("프로그램종료");
	}
}
