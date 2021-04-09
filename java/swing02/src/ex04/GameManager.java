package ex04;

public class GameManager {
	private static GameManager instance;
	private GameManager() { /* singleto */ }
	public static GameManager getInstance() {
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
	}
}
