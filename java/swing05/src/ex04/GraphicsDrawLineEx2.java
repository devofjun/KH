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
			
			int layer = 0;
			for(int i=0; i<10; i++) {
				int red = (int)(Math.random()*256); // 색은 0~255까지
				int green = (int)(Math.random()*256);
				int blue = (int)(Math.random()*256);
				g.setColor(new Color(red,green,blue));
				
				layer = (i*25);
				//layer = (this.getWidth()/10)*i;
				g.drawLine(xHalf, 0+layer, xFull-layer, yHalf); // 12-3
				g.drawLine(xFull-layer, yHalf, xHalf, yFull-layer); // 3-6
				g.drawLine(xHalf, yFull-layer, 0+layer, yHalf); // 6-9
				g.drawLine(0+layer, yHalf, xHalf, 0+layer); // 9-12
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx2();
	}
}
