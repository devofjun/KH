package sec01.exam01;

public class NullPointerExceptionExample {
	public static void main(String[] args) {
		String data = null;
		try {
			System.out.println(data.toString());			
		} catch(NullPointerException e) {
			
		}
		System.out.println("프로그램종료");
		}
}
