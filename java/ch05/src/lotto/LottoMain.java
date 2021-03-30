package lotto;

public class LottoMain {
	public static void main(String[] args) {
		//공을 생성
		LottoBall[] balls = makeBalls();
		//공 섞기
		shuffleBalls(balls);
		//공 6개 꺼내기
		for(int i=0; i<6; ++i) {
			LottoBall aBall = getOneBall(balls,i);
			System.out.printf("(%d, %s)",aBall.number, aBall.color);
		}
	} // main
	
	public static LottoBall[] makeBalls() {
		LottoBall[] balls = new LottoBall[45];
		for(int i=0;i<balls.length;++i) {
			LottoBall aBall = new LottoBall();
			aBall.number = i+1;
			if(1 <= aBall.number && aBall.number <=10) {
				aBall.color = "Orange";
			} else if(11 <= aBall.number && aBall.number <=20) {
				aBall.color = "Blue";
			} else if(21 <= aBall.number && aBall.number <=30) {
				aBall.color = "Red";
			} else if (31 <= aBall.number && aBall.number <=40) {
				aBall.color = "Gray";
			} else {
				aBall.color = "Green";
			}
			balls[i] = aBall;
		}
		return balls;
	} // makeBalls()
	
	public static void shuffleBalls(LottoBall[] balls) {
		int rand = 0;
		LottoBall temp;
		for(int i=0; i<balls.length; ++i) {
			rand = (int)(Math.random()*balls.length);
			temp = balls[i];
			balls[i] = balls[rand];
			balls[rand] = temp;
		}
	} // shuffleBalls()
	
	public static LottoBall getOneBall(LottoBall[] balls, int index) {
		return balls[index];
	}
}
