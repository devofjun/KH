package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GraphicsDrawLineEx extends JFrame{
	Container c = getContentPane();
	MyPanel pnl = new MyPanel();
	MyMouseAdapter adapter = new MyMouseAdapter();
	
	int startX, startY, stopX, stopY;
	
	public GraphicsDrawLineEx() {
		setTitle("선그리기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		pnl.addMouseListener(adapter);
		c.add(pnl);
	}
	
	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) { // 마우스 누르고 있을때
			startX = e.getX();
			startY = e.getY();
			System.out.printf("mousePressed: (%d, %d)\n",startX,startY);
		}

		@Override
		public void mouseReleased(MouseEvent e) { // 마우스 땠을때
			stopX = e.getX();
			stopY = e.getY();
			System.out.printf("mouseReleased: (%d, %d)\n",stopX,stopY);
			pnl.repaint(); // 패널을 다시 그리기 -> paintComponent()를 다시 호출한다.
		}
		
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(startX, startY, stopX, stopY);
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}
}
