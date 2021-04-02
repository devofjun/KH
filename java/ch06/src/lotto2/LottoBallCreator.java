package lotto2;

public class LottoBallCreator {
	LottoBall[] createBall(int count) {
		LottoBall[] balls = new LottoBall[count];
		String color;
		for(int i=0; i<balls.length; i++) {
			if(0<=i && i<=10) {
				color = "Orange";
			} else if(11<=i && i<=20) {
				color = "Blue";
			} else if(11<=i && i<=20) {
				color = "Red";
			} else if(11<=i && i<=20) {
				color = "Gray";
			} else {
				color = "Green";
			}
			balls[i] = new LottoBall(i+1, color);
		}
		
		return balls;
	}
}
