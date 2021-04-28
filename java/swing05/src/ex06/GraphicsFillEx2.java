package ex06;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsFillEx2 extends JFrame{
	Container c = getContentPane();
	MyPanel pnl = new MyPanel();
	
	public GraphicsFillEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3가지 원호를 가운데 그리기");
		setSize(500,500);
		setVisible(true);
		
		c.add(pnl);
	}
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int centerX = this.getWidth() / 2 - 100;
			int centerY = this.getHeight() / 2 - 100;
			g.setColor(Color.RED);
			g.fillArc(centerX, centerY, 200, 200, 90, 120);
			g.setColor(Color.BLUE);
			g.fillArc(centerX, centerY, 200, 200, 210, 120);
			g.setColor(Color.YELLOW);
			g.fillArc(centerX, centerY, 200, 200, 330, 120);
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsFillEx2();
	}
}
