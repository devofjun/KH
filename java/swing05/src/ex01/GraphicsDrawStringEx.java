package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawStringEx extends JFrame{
	Container c = getContentPane();
	MyPanel pnl = new MyPanel();
	JButton btn1 = new JButton("버튼1");
	JButton btn2 = new JButton("버튼2");
	
	public GraphicsDrawStringEx() {
		setTitle("문자열 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		pnl.add(btn1);
		pnl.add(btn2);
		c.add(pnl);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밌다", 30, 30);
			g.setFont(new Font("맑은 고딕",Font.BOLD,50));
			g.setColor(Color.RED);
			g.drawString("얼마나?", 100, 100);
		}

	}
	
	public static void main(String[] args) {
		new GraphicsDrawStringEx();
	}
}
