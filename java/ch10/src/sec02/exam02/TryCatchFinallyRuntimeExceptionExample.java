package sec02.exam02;

public class TryCatchFinallyRuntimeExceptionExample {
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			System.out.println(data1);
			data2 = args[1];
			System.out.println(data2);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 갯수가 부족합니다.");
		}
		
		// Integer.parseInt() 부분에 대한 예외 처리
		try {			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println("result:"+result);
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변경할 수 없습니다.");
		} finally { // 무조건 실행되는 구문
			System.out.println("다시 실행하세요");
		}
		System.out.println("프로그램 종료");
	}
}
