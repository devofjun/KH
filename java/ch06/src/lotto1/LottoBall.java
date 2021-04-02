package lotto1;

public class LottoBall {
	//필드
	int number;
	String color;
	//생성자
	LottoBall(int number, String color) {
		this.number = number;
		this.color = color;
	}
	// Method
	void showInfo() {
		System.out.println(number + "[" + color + "]");
	}
}
