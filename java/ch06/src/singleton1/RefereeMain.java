package singleton1;

public class RefereeMain {
	public static void main(String[] args) {
		/*
		Referee r1 = new Referee();
		Referee r2 = new Referee();
		System.out.println(r1);
		System.out.println(r2);
		*/
		Referee r1 = Referee.getInstance();
		Referee r2 = Referee.getInstance();
		System.out.println(r1);
		System.out.println(r2);
	}
}
