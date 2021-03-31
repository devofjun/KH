package ch06;

public class BallMain {
	public static void main(String[] args) {
		
		BallMachine machine = new BallMachine();
		
		Ball aBall = new Ball();
		aBall.number = 1;
		aBall.color = "Orange";
		boolean result = machine.pushBall(0, aBall);
		machine.showBallInfo(0);
	}
}
