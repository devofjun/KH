package singleton2;

public class RefereeMain {
	public static void main(String[] args) {
		Referee r1 = Referee.getInstance();
		Referee r2 = Referee.getInstance();
		Referee r3 = Referee.getInstance();
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
}
