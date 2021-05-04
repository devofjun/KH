package ex05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TimerPanel extends JPanel implements Runnable{
	
	GameRules GR;
	
	int width = 2000;

	public TimerPanel(GameRules GR) {
		this.GR = GR;
		// 처음 타이머가 시작 될 때 술래 하나 생성함.
		GR.addTagger();
		System.out.println("Game Start");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth();
		int height = this.getHeight();
		g.setColor(Color.GREEN);
		g.fillRect(width/100, height/10, this.width/5, 50); // (x좌표, y좌표, 폭, 높이)
	}
	
	
	@Override
	public void run() { // 타이머 실행
		while (GR.gameState) { // 게임룰의 게임상태가 어떤지 매번 체크하며 쓰레드가 실행된다.
			try {
				Thread.sleep(10);
				// 타이머 게이지 줄이기
				width -= 20; // 숫자가 높을수록 게이지가 빨리 줄어들음
				// 그림 재출력
				repaint();
				if (width < 0) { // 게이지가 다 줄어들었다면
					if(GR.addTagger()) { // 새로운 술래를 만들어낸다.
						width = 2000; // 성공하면 게이지를 다시 채움
					} else {// 실패했다는건 이미 10개의 술래가 만들어졌다는 뜻.
						System.out.println("살아남음");
						GR.gameState = false; // 반복문(여러쓰레드들)을 끝내기 위해 false로 바꿈
						break;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Game Over");
	}

}
