package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawLineEx2 extends JFrame{
	Container c = getContentPane();
	MyPanel pnl = new MyPanel();
	
	
	public GraphicsDrawLineEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마름모");
		setSize(500,500);
		setVisible(true);
		
		c.add(pnl);
	}
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//System.out.println(this.getWidth());
			//System.out.println(this.getHeight());
			int xHalf = this.getWidth()/2;
			int xFull = this.getWidth();
			int yHalf = this.getHeight()/2;
			int yFull = this.getHeight();
			g.setColor(Color.RED);
			g.drawLine(xHalf, 0, xFull, yHalf); // 12-3
			g.drawLine(xFull, yHalf, xHalf, yFull); // 3-6
			g.drawLine(xHalf, yFull, 0, yHalf); // 6-9
			g.drawLine(0, yHalf, xHalf, 0); // 9-12
			
			g.setColor(Color.BLUE);
			g.drawLine(xHalf, 20, xFull-20, yHalf); // 12-3
			g.drawLine(xFull-20, yHalf, xHalf, yFull-20); // 3-6
			g.drawLine(xHalf, yFull-20, 20, yHalf); // 6-9
			g.drawLine(20, yHalf, xHalf, 20); // 9-12
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx2();
	}
}
