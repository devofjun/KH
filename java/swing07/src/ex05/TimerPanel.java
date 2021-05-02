package ex05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TimerPanel extends JPanel implements Runnable{
	
	GameRules GR;
	
	int width = 2000;

	public TimerPanel(GameRules GR/*LabelMan[] lMan*/) {
		this.GR = GR;
		// 처음 타이머가 시작 될 때 태거 하나 추가함.
		GR.addTagger();
		System.out.println("Game Start");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth();
		int height = this.getHeight();
		g.setColor(Color.GREEN);
		g.fillRect(width/100, height/10, this.width/5, 50);
	}
	
	
	@Override
	public void run() {
		while (GR.gameState) {
			try {
				Thread.sleep(10);
				width -= 20;
				repaint();
				if (width < 0) {
					if(GR.addTagger()) {
						width = 2000;
					} else {
						GR.gameState = false;
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
