package ex07;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JLabel myLabel = new JLabel("Java");
	MyKeyAdapter listener = new MyKeyAdapter();
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("액션리스너");
		c.setLayout(null);
		myLabel.setBounds(10, 10, 50, 30);
		c.addKeyListener(listener);
		c.add(myLabel);
		setSize(500, 500);
		setVisible(true);
		//requestFocus는 visible 이후에 해야함.
		c.requestFocus(); //컨테이너가 키이벤트를 받을수 있도록 포커스를 요청
	}
	
	// 내부클래스를 선언
	public class MyKeyAdapter extends KeyAdapter{
		private static final int speed = 10;
		
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println(e);
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				//System.out.println("좌");
				myLabel.setLocation(myLabel.getX()-speed, myLabel.getY());
				break;
			case KeyEvent.VK_UP:
				//System.out.println("상");
				myLabel.setLocation(myLabel.getX(), myLabel.getY()-speed);
				break;
			case KeyEvent.VK_RIGHT:
				//System.out.println("우");
				myLabel.setLocation(myLabel.getX()+speed, myLabel.getY());
				break;
			case KeyEvent.VK_DOWN:
				//System.out.println("하");
				myLabel.setLocation(myLabel.getX(), myLabel.getY()+speed);
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
