package sec05.exam02;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator.getArea(3);
		Calculator.getCircum(4);
		
		/*final*/ int  a= 10; // final은 마지막 값이라는 의미임 -> 변경 불가
		a = 20;
	}
}
