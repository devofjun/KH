package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawLineEx3 extends JFrame{
	Container c = getContentPane();
	MyPanel pnl = new MyPanel();
	
	
	public GraphicsDrawLineEx3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("각종 모양 그리기");
		setSize(500,500);
		setVisible(true);
		
		c.add(pnl);
	}
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 원(타원) 그리기
			g.drawOval(100, 100, 100, 100);
			
			// 사각형 그리기
			g.drawRect(100, 100, 100, 100);
			
			// 둥근 사각형 그리기
			g.drawRoundRect(100, 100, 100, 100, 20, 20);
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx3();
	}
}
