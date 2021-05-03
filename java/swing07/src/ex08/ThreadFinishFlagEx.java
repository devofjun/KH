package ex08;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ThreadFinishFlagEx extends JFrame{
	Container c = getContentPane();
	RandomThread rTh = new RandomThread(c);
	Thread th = new Thread(rTh);
	
	public ThreadFinishFlagEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("랜덤위치생성과 스레드 정상종료"); // 플래그를 이용한 스레드 정상 종료
		setSize(500, 500);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				// 종료 플래그를 true로 하는 메소드
				rTh.finish();
			}
		});
		th.start();
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}
}
