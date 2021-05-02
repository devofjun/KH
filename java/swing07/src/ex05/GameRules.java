package ex05;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameRules {
	// singleton
	private static GameRules instance;
	private GameRules() {	}
	public static GameRules getInstance() {
		if(instance == null) {
			instance = new GameRules();
		}
		return instance;
	}
	
	// 필드
	JPanel centerPnl;
	JLabel user;
	TaggerLabel[] Tagger = new TaggerLabel[10];
	Thread[] thTagger = new Thread[10];
	int countTagger = 0;
	// 게임 상태
	boolean gameState = true;
	
	// 접근 및 제어가 필요한 컴포넌트를 받아오는 메소드
	public void setGame(JPanel pnl, JLabel user) {
		this.centerPnl = pnl;
		this.user = user;
	}
	
	// 술래 레이블 추가하기
	public boolean addTagger() {
		if(countTagger < 10) {
			// 태거의 수 증가
			int i = countTagger++;
			// user를 따라가는 태거 생성
			Tagger[i] = new TaggerLabel(user, this);
			// 태거를 centerPnl에 출력
			Tagger[i].printTagger(centerPnl);
			// 태거의 쓰레드를 생성
			thTagger[i] = new Thread(Tagger[i]);
			// 태거의 쓰레드를 실행
			thTagger[i].start();
			//System.out.println(countTagger);
			return true;
		} else {
			//System.out.println("더이상 생성 할 수 없음");
			return false;
		}
	}
}
