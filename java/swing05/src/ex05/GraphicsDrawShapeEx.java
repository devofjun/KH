package ex05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GraphicsDrawShapeEx extends JFrame{
	Container c = getContentPane();
	MyPanel myPnl = new MyPanel();
	JPanel pnl = new JPanel();
	
	JRadioButton[] rbtn = {new JRadioButton("선"),
							new JRadioButton("원"),
							new JRadioButton("사각형")};
	ButtonGroup rbtnGroup = new ButtonGroup();
	
	int startX, startY, stopX, stopY;
	MyMouseAdapter adapter = new MyMouseAdapter();
	
	// 백터를 리스트에 넣은 이유는 나중에 백터가 어레이리스트를 사용하게 될 수도 있고 링크드리스트를 사용할 수도 있다.
	// 리스트 타입에 넣으면 어느정도 일치되는 코드는 그대로 쓸 수 있다.
	List<Shape> list = new Vector<>();
	
	public GraphicsDrawShapeEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("선,원,사각형 드래그로 그리기");
		setVisible(true);
		setUI();
	}
	
	void setUI() {
		for(int i=0; i<rbtn.length; i++) {
			rbtnGroup.add(rbtn[i]);
			pnl.add(rbtn[i]);
		}
		rbtn[0].setSelected(true);
		pnl.setBackground(Color.GRAY);
		myPnl.addMouseListener(adapter);
		myPnl.addMouseMotionListener(adapter);
		c.add(pnl,BorderLayout.NORTH);
		c.add(myPnl,BorderLayout.CENTER);
	}
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			startX = e.getX();
			startY = e.getY();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			stopX = e.getX();
			stopY = e.getY();
			myPnl.repaint(); // 패널을 다시 그리기 -> paintComponent()를 다시 호출한다.
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			ShapeType type = null;
			if(rbtn[0].isSelected()) {
				type = ShapeType.LINE;
			} else if(rbtn[1].isSelected()) {
				type = ShapeType.CIRCLE;
			} else if(rbtn[2].isSelected()) {
				type = ShapeType.RECTANGLE;
			}
			Shape shape = new Shape(startX, startY, stopX, stopY, type);
			list.add(shape);
			
			//System.out.println(list);
		}
		
	}
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//System.out.println(startX +":"+ startY +" || "+ stopX +":"+ stopY);
			
			// 리스트에 담겨 있는 도형들을 하나씩 빼내서 - 도형 하나의 정보 - 그리기
			for(Shape aShape : list) {
				//System.out.println(aShape);
				int startX = aShape.getStartX();
				int startY = aShape.getStartY();
				int stopX = aShape.getStopX();
				int stopY = aShape.getStopY();
				ShapeType type = aShape.getType();
				
				if(type == ShapeType.LINE) {
					g.drawLine(startX, startY, stopX, stopY);
				} else {
					int x = startX;
					int y = startY;
					if(startX > stopX) x = stopX;
					if(startY > stopY) y = stopY;
					if(type == ShapeType.CIRCLE) {
						g.drawOval(x, y, Math.abs(startX-stopX), Math.abs(startY-stopY));
					} else if(type == ShapeType.RECTANGLE) {
						g.drawRect(x, y, Math.abs(startX-stopX), Math.abs(startY-stopY));
					}
				}
			}
			
			// 현재 사용자가 그리고 있는 도형 그리기
			if(rbtn[0].isSelected()) { // 선
				g.drawLine(startX, startY, stopX, stopY);
			} else if(rbtn[1].isSelected()) { // 원
				// 모든 방향 다 그러지게 하기 위한 판단문
				int x = startX;
				int y = startY;
				if(startX > stopX) x = stopX;
				if(startY > stopY) y = stopY;
				g.drawOval(x, y, Math.abs(startX-stopX), Math.abs(startY-stopY));
				
			} else if(rbtn[2].isSelected()) { // 사각형
				// 모든 방향 다 그려지게 하기 위한 판단문			
				int x = startX;
				int y = startY;
				if(startX > stopX) x = stopX;
				if(startY > stopY) y = stopY;
				g.drawRect(x, y, Math.abs(startX-stopX), Math.abs(startY-stopY));
				
			}
			
			//g.drawOval(200, 200, Math.abs(-200), Math.abs(-200));
			
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawShapeEx();
	}
}
