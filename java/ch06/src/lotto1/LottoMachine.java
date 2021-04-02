package lotto1;

public class LottoMachine {
	LottoBall[] balls = new LottoBall[45];
	
	void setBalls(LottoBall[] balls) {
		this.balls = balls;
	}
	
	void showBalls() {
		for (LottoBall ball : balls) {
			ball.showInfo();
		}
	}
	
	void shuffle() {
		for (int i=0; i<balls.length; i++) {
			int random = (int)(Math.random()*45);
			LottoBall tmp;
			tmp = balls[i];
			balls[i] = balls[random];
			balls[random] = tmp;
		}
	}
	
	void pickBall6() {
		for(int i=0; i<6; i++) {
			balls[i].showInfo();
		}
	}
}
