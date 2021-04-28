package ex05;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawArcEx extends JFrame{
	
	Container c = getContentPane();
	MyPanel p = new MyPanel();
	
	public GraphicsDrawArcEx() {
		setTitle("원호, 다각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		c.add(p);
	}
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawArc(10, 10, 200, 200, 65, 140);
			int w = c.getWidth();
			int h = c.getHeight();
			int[] xPoints = {w/2, 0, w/2, w};
			int[] yPoints = {0, h/2, h, h/2};
			g.drawPolygon(xPoints, yPoints, xPoints.length); // 다각형 만들어주는 메소드
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawArcEx();
	}
}
