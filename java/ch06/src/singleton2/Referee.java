package singleton2;

public class Referee {
	private static Referee instance;
	private Referee() {}
	public static Referee getInstance() {
		if(instance==null) {
			instance = new Referee();
		}
		return instance;
	}
}
