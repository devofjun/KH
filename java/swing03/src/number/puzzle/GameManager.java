package number.puzzle;

public class GameManager {
	private static GameManager instance = null;
	private GameManager() {	gameStart(); }
	public static GameManager getInstance() {
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
	}
	
	private int random;
	private int life;
	// 게임 진행
	public void gameStart() {
		//새로운 랜덤값
		random = (int)(Math.random()*100+1);
		life=5;
	}
	
	public void subLife() {
		life--;
	}
	
	public boolean lifeCheck() {
		if(life<=0) {
			return false;
		}
		return true;
	}
	
	public int check(int inNum) {
		int result = -1;
		if(inNum < random) {
			result = 1; //Up
		} else if(inNum > random) {
			result = 2; //Down
		} else {
			result = 0;
		}
		return result;
	}
	public int getLife() {
		return life;
	}
}
