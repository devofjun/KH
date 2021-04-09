package ex04;

public class GameManager {
	static int numCount = 1;
	private static GameManager instance;
	private GameManager() { /* singleto */ }
	public static GameManager getInstance() {
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
	}
	private int num = 1;
	private int count = 3;
	
	public boolean judge(int num) {
		if (this.num == num) {
			this.num++;
			if (this.num > 10) {
				showMessage("성공했습니다.");
			}
			return true;
		} else {
			count--;
			showMessage("틀렸습니다.");
			if (count < 1) {
				showMessage("기회를 소진했어요");
				showMessage("게임 종료");
			}
			return false;
		}
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
}
