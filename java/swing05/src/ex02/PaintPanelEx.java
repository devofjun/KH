package ex02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintPanelEx extends JFrame {
	MyPanel pnl = new MyPanel();
	public PaintPanelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("사각형 3개가 그려진 패널");
		setContentPane(pnl);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// g -> 붓
			super.paintComponent(g);
			System.out.println("paintComponent() 호출됨");
			setBackground(Color.YELLOW);
			// 기본색상은 검정색
			g.setColor(Color.RED);
			g.drawRect(10, 10, 50, 50); // (10, 10), 50x50
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}
	}
	
	public static void main(String[] args) {
		new PaintPanelEx();
	}
}
