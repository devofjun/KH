package calc1;

public class CalculatorMain {
	public static void main(String[] args) {
		User user1 = new User(Calculator.getInstance());
		int a=4;
		int b=2;
		user1.runAdd(a, b);
		user1.runSubtract(a, b);
		user1.runMultiply(a, b);
		user1.runDivide(a, b);
	}
}
