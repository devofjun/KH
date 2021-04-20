package ex01;

public class NullPointerExceptionExample {
	public static void main(String[] args) {
		String str = null;
		/*if( str != null) {
			String s = str.substring(0, 10);
			System.out.println(s);			
		}*/
		try {
			String s = str.substring(0,10);
			System.out.println(s);
		} catch(NullPointerException e) {
			System.out.println("널값에 접근할 수 없습니다.");
		}
		System.out.println("프로그램 종료");
	}

}
