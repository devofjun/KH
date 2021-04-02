package lotto2;

public class LottoBall {
	int number;
	String color;
	LottoBall(int num, String color){
		this.number = num;
		this.color = color;
	}
	void info() {
		System.out.println("["+number+"] "+color);
	}
}
