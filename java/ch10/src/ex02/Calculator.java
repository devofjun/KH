package ex02;

public class Calculator {
	public int add(int num1, int num2) {
		return num1+num2;
	}
	public int sub(int num1, int num2) {
		return num1-num2;
	}
	public int mul(int num1, int num2) {
		return num1*num2;
	}
	public int div(int num1, int num2) {
		int result = 0;
		try {
			result = num1 / num2;
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요");
		}
		return result;
	}
	
	// 이런 에러 발생 할 수 있다고 명시.
	// throws - 해당 메서드를 실행하다가 예외가 발생할 수 있다.
	// - 예외를 처리하지 않고, 던지겠다.
	// - 예외를 강제로 던짐
	public int div2(int num1, int num2) throws ArithmeticException{
		return num1/num2;
	}
}
