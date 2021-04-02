package lotto2;

public class LottoMachine {
	LottoBall[] balls;
	
	void setballs(LottoBall[] balls) {
		this.balls = balls;
	}
	void showballs() {
		for(LottoBall ball : balls) {
			ball.info();
		}
	}
	void suffle() {
		for(int i=0; i<balls.length; i++) {
			int rand = (int)(Math.random() * 45);
			LottoBall tmp;
			tmp = balls[i];
			balls[i] = balls[rand];
			balls[rand] = tmp;
		}
	}
	void pickBall6() {
		for(int i=0; i<6; i++) {
			balls[i].info();
		}
	}
}
