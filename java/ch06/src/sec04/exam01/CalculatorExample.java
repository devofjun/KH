package sec04.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.powerOn();
		System.out.println(calc.plus(5,6));
		
		byte x = 10;
		byte y = 4;
		System.out.println(calc.divide(x, y));
	}
}
