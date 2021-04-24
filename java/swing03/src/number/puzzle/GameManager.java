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
	
	ScoreDao scoreDao;
	
	boolean timer; // 게임이 시작되면 true, 다시시작하면 false 
	long startTime; // 처음 확인버튼 눌렀을때의 시간
	long endTime; // 맞췄을때의 시간
	long score; // 두 시간을 뺀 값
	
	
	// 게임 진행
	public void gameStart() {
		scoreDao = ScoreDao.getInstance();
		//새로운 랜덤값
		random = (int)(Math.random()*100+1);
		System.out.println(random);
		timer = false;
		score = 0;
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
	
	private static final int SMALL = 1;
	private static final int BIG = 2;
	private static final int SAME = 0;
	
	public int check(int inNum) {
		if(timer == false) {
			startTime = System.nanoTime();
			timer = true;
		}
		int result = -1;
		if(inNum < random) { // 입력값이 작을때
			result = SMALL;
		} else if(inNum > random) { // 입력값이 클때
			result = BIG;
		} else {
			endTime = System.nanoTime();
			if(score == 0) {
				score = endTime - startTime;
			}
			timer = false;
			startTime = 0;
			endTime = 0;
			System.out.println(score);
			result = SAME;
		}
		return result;
	}
	
	public void saveScore(UserVo userVo) {
		scoreDao.setScore(userVo, score);
	}
	
	public long getScore() {
		return score;
	}
	public int getLife() {
		return life;
	}
	public String getWinnerID() {
		String id = "";
		ScoreVo scoreVo = scoreDao.getWinner();
		if(scoreVo != null) {
			id = scoreVo.getUid();
		}
		return id;
	}
	public Long getWinnerScore() {
		Long score = null;
		ScoreVo scoreVo = scoreDao.getWinner();
		if(scoreVo != null) {
			score = scoreVo.getScore();
		}
		return score;
	}
}
