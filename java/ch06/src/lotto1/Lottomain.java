package lotto1;

public class Lottomain {
	public static void main(String[] args) {
		LottoMachine machine = new LottoMachine();
		LottoBallCreator create = new LottoBallCreator();
		
		machine.setBalls(create.createBalls(60));
		machine.shuffle();
		machine.showBalls();
		System.out.println("===========");
		machine.pickBall6();
	}
}
