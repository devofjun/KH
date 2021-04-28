package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GraphicsDrawLineEx4 extends JFrame{
	Container c = getContentPane();
	MyPanel pnl = new MyPanel();
	MyMouseAdapter adapter = new MyMouseAdapter();
	
	int startX, startY, stopX, stopY;
	
	public GraphicsDrawLineEx4() {
		setTitle("드래그 선그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		pnl.addMouseListener(adapter);
		pnl.addMouseMotionListener(adapter);
		c.add(pnl);
	}
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			startX = e.getX();
			startY = e.getY();
			System.out.printf("mouseReleased: (%d, %d)\n",startX,startY);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			stopX = e.getX();
			stopY = e.getY();
			System.out.printf("mouseDragged: (%d, %d)\n",stopX,stopY);
			pnl.repaint(); // 패널을 다시 그리기 -> paintComponent()를 다시 호출한다.
		}

	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) { // 콜백 메소드
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(startX, startY, stopX, stopY);
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx4();
	}
}
