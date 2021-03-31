package ch06;

public class BallMachine {
	Ball[] balls = new Ball[45];
	
	boolean pushBall(int index, Ball ball) {
		if(index <45) {
			balls[index] = ball;
			return true;
		} else {
			return false;
		}
	}
	void showBallInfo(int index) {
		balls[index].sayInfo();
	}
}
