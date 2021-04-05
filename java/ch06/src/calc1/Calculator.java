package calc1;

public class Calculator {
	// field {
	private int num1, num2;
	private static Calculator instance;
	// field }
	
	// Constructor {
	Calculator(){	
	}
	// Constructor }
	// singleton
	public static Calculator getInstance() {
		if(instance==null) {
			instance = new Calculator();
		}
		return instance;
	}
	
	// Getter/Setter {
	public int getNum1() {
		return num1;
	}
	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	public int getNum2() {
		return num2;
	}
	
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	// Getter/Setter }
	
	
	// Method {
	
	//더하기
	public int add() {
		return num1+num2;
	}
	//빼기
	public int substract() {
		return num1-num2;
	}
	//곱하기
	public int multiply() {
		return num1*num2;
	}
	//나누기
	public int divide() {
		return num1/num2;
	}
	
	// Method }


	//toString
	@Override
	public String toString() {
		return "Calculator [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
}
