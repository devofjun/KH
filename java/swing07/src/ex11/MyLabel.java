package ex11;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyLabel extends JLabel {
	int nowWidth = 200;
	int maxWidth;
	private final int HEIGHT = 30;
	
	
	public MyLabel(int maxWidth){
		this.maxWidth = maxWidth-10;
		setOpaque(true);
		setBackground(Color.ORANGE);
	}
	
	synchronized public void fill() {
		if(nowWidth >= maxWidth) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return;
		}
		nowWidth++;
		repaint();
		notify(); // 입력이 있었다면 쓰래드를 깨운다.
	}
	
	synchronized public void consume() {
		if(nowWidth <= 0) {
			try {
				wait(); // 0이라면 쓰레드를 재운다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nowWidth--;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		//System.out.println("nowWidth:" + nowWidth);
		g.fillRect(5, 5, nowWidth, HEIGHT);
	}
}
