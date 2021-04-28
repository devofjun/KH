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
		setTitle("마름모 그리기");
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
			int halfX = this.getWidth()/2;
			int fullX = this.getWidth();
			int halfY = this.getHeight()/2;
			int fullY = this.getHeight();
			
			for(int i=0; i<10; i++) {
				int red = (int)(Math.random()*256); // 색은 0~255까지
				int green = (int)(Math.random()*256);
				int blue = (int)(Math.random()*256);
				g.setColor(new Color(red,green,blue));
				
				//layer = (i*25);
				int wLayer = ((this.getWidth()/2)/10)*i;
				int hLayre = ((this.getHeight()/2)/10)*i;
				g.drawLine(halfX, 			0+hLayre, 		fullX-wLayer, 	halfY); // 12-3
				g.drawLine(fullX-wLayer, 	halfY, 			halfX, 			fullY-hLayre); // 3-6
				g.drawLine(halfX, 			fullY-hLayre, 	0+wLayer, 		halfY); // 6-9
				g.drawLine(0+wLayer, 		halfY, 			halfX, 			0+hLayre); // 9-12
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx2();
	}
}
