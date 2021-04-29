package ex05;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawLineMouseEx extends JFrame{
	
	Container c = getContentPane();
	PaintPanel panel = new PaintPanel();
	MyMouseAdapter adapter = new MyMouseAdapter();
	Vector<Point> vecStarts = new Vector<>();
	Vector<Point> vecEnds = new Vector<>();
	
	
	public GraphicsDrawLineMouseEx() {
		setTitle("마우스 드래그해서 선그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.addMouseListener(adapter);
		c.add(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			vecStarts.add(p);
			System.out.println(vecStarts);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			Point p = e.getPoint();
			vecEnds.add(p);
			System.out.println(vecEnds);
			panel.repaint();
		}
	}
	
	@SuppressWarnings("unused")
	private class PaintPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=0; i<vecStarts.size(); i++) {
				Point p1 = vecStarts.get(i);
				Point p2 = vecEnds.get(i);
				int startX = (int)p1.getX();
				int startY = (int)p1.getY();
				int endX = (int)p2.getX();
				int endY = (int)p2.getY();
				
				g.drawLine(startX, startY, endX, endY);
			}
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}
}
