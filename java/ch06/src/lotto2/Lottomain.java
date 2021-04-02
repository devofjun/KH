package lotto2;

public class Lottomain {
	public static void main(String[] args) {
		LottoMachine machine = new LottoMachine();
		LottoBallCreator create = new LottoBallCreator();
		
		machine.setballs(create.createBall(60));
		machine.suffle();
		machine.showballs();
		System.out.println("===========");
		machine.pickBall6();
	}
}
