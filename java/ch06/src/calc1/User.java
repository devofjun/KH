package calc1;

public class User {
	private Calculator calc;

	// 계산기 없이 그냥 사용자 생성
	public User() {
		
	}
	// 계산기를 가지는 사용자 생성
	public User(Calculator calc) {
		this.calc = calc;
	}
	
	// Setter
	public void setCalculator(Calculator calc) {
		this.calc = calc;
	}
	
	// 덧셈하기
	void runAdd(int a, int b) {
		System.out.println(a+" + "+b+" = "+calc.add(a, b));
	}
	// 뺄셈하기
	void runSubtract(int a, int b) {
		System.out.println(a+" - "+b+" = "+calc.substract(a, b));
	}
	// 곱셈하기
	void runMultiply(int a, int b) {
		System.out.println(a+" * "+b+" = "+calc.multiply(a, b));
	}
	// 나눗셈하기
	void runDivide(int a, int b) {
		System.out.println(a+" / "+b+" = "+calc.divide(a, b));
	}
}
