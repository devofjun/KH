package sec02.exam03;

public class CatchByExceptionKindExample {
	public static void main(String[] args) throws Exception{
		try {
			String data1 = args[0];
			String data2 = args[1];
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println("result: " + result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개변수의 갯수가 부족합니다.(2개)");
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변경 할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요");
		}
		System.out.println("프로그램종료");
	}
}
