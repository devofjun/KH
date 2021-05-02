package ex05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MyFrame2 extends JFrame implements KeyListener{
	Container c = getContentPane();

	JLabel user = new JLabel(new ImageIcon("images/man2.png"));

	JPanel pnlCenter = new JPanel();
	JLabel lblTimer = new JLabel();
	JPanel pnlNorth = new JPanel();
	
	GameRules GR = GameRules.getInstance();
	TimerPanel timerPanel;
	
	
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이미지 옮기기");
		setSize(1000, 1000);
		
		// 게임룰 시작
		GR.setGame(pnlCenter, user);
		// 게이지 패널 생성
		timerPanel = new TimerPanel(GR);
		// 움직이는 영역
		pnlCenter.setLayout(null);

		// 유저 이미지
		user.setBounds(50, 50, 80, 75);
		pnlCenter.add(user);
		pnlCenter.setFocusable(true);
		pnlCenter.addKeyListener(this);
		
		// 타이머글자 영역
		pnlNorth.setLayout(new GridLayout(1, 2, 10, 0));
		lblTimer.setText("Timer");
		lblTimer.setFont(new Font("Consolas", Font.BOLD, 50));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		pnlNorth.add(lblTimer);
		pnlNorth.add(timerPanel);
		
		
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(pnlCenter, BorderLayout.CENTER);
		// setVisible은 왠만하면 제일 아래 있는것이 좋다. 프레임이 제대로 안나올 수도 있기때문
		setVisible(true);

		Thread th = new Thread(timerPanel);
		th.start();
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}

	// 키이벤트 리스너
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		int x = user.getX();
		int y = user.getY();
		switch(keycode) {
		case KeyEvent.VK_UP:
			y -= 10;
			user.setLocation(x, y);
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			user.setLocation(x, y);
			break;
		case KeyEvent.VK_RIGHT:
			x += 10;
			user.setLocation(x, y);
			break;
		case KeyEvent.VK_LEFT:
			x -= 10;
			user.setLocation(x, y);
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
}
