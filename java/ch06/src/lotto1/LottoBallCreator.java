package lotto1;

public class LottoBallCreator {
	LottoBall[] createBalls(int count) {
		
		LottoBall[] balls = new LottoBall[count];
		for(int i=0; i<balls.length; i++) {
			int number = i + 1;
			String color = null;
			if(1 <= number && number <= 10) {
				color = "Orange";
			} else if(11 <= number && number <= 20) {
				color = "Blue";
			} else if(21 <= number && number <= 30) {
				color = "Red";
			} else if(31 <= number && number <= 40) {
				color = "Gray";
			} else {
				color = "Green";
			}
			balls[i] = new LottoBall(number, color);
		}
		return balls;
		
	}
}
