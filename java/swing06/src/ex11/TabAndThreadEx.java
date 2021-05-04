package ex11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TabAndThreadEx extends JFrame{
	Container c = getContentPane();
	// 레이블 생성
	MyLabel label = new MyLabel(300);
	// 레이블 게이지를 줄이는 쓰레드 생성
	ConsumerThread consumer = new ConsumerThread(label);
	Thread th = new Thread(consumer);
	
	public TabAndThreadEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("동기화, 쓰레드로 줄이고 키입력으로 늘리기");
		setSize(400, 200);
		c.setLayout(null);
		
		label.setBounds(40, 40, 300, 40);
		c.add(label);
//		c.setFocusable(true);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				label.fill(); // 키눌림이 발생하면 레이블을 채움
			}
		});
		th.start(); // 줄이는 쓰레드 실행
		setVisible(true);
		c.requestFocus(); // requestFocus는 setvisible 아래 와야한다.
	}
	public static void main(String[] args) {
		new TabAndThreadEx();
	}
}
