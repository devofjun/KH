package ex06;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsFillEx extends JFrame{
	Container c = getContentPane();
	
	public GraphicsFillEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("색이 채워진 도형 그리기");
		c.add(new MyPanel());
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 100, 100);
			
			g.setColor(Color.BLUE);
			g.fillOval(10, 120, 100, 100);
			
			g.setColor(Color.GREEN);
			g.fillArc(10, 230, 100, 100, 0, 270);
			
			g.setColor(Color.MAGENTA);
			int w = getWidth();
			int h = getHeight();
			int [] xPoints = {w/2, 0, w/2, w};
			int [] yPoints = {0, h/2, h, h/2};
			
			g.fillPolygon(xPoints, yPoints, xPoints.length);
		}
	}
	
	public static void main(String[] args) {
		new GraphicsFillEx();
	}
}
