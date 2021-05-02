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
	
	//UserLabel user = new UserLabel(new ImageIcon("images/man2.png"));
	
	JLabel user = new JLabel(new ImageIcon("images/man2.png"));
	//TaggerLabel[] lblTagger = new TaggerLabel[10]; 
	//Thread thTagger;
	JPanel pnl = new JPanel();
	JLabel lblTimer = new JLabel();
	JPanel pnlNorth = new JPanel();
	
	GameRules GR = GameRules.getInstance();
	TimerPanel timerPanel;
	
	
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이미지 옮기기");
		setSize(1000, 1000);
		
		// 초기 설정
		GR.setGame(pnl, timerPanel, user);
		timerPanel = new TimerPanel(GR);
		timerPanel.setBackground(Color.YELLOW);
		// 움직이는 영역
		pnl.setLayout(null);

		// 유저 이미지
		user.setBounds(50, 50, 80, 75);
		pnl.add(user);
		pnl.setFocusable(true);
		pnl.addKeyListener(this);
		
		/* 타이머에서 생성되게 함.
		// 술래 이미지
		lblTagger[0] = new TaggerLabel(user);
		lblTagger[0].printTagger(pnl);
		//pnl.add(lMans[0]);
		thTagger = new Thread(lblTagger[0]);
		thTagger.start();
		*/
		// 타이머글자 영역
		pnlNorth.setLayout(new GridLayout(1, 2, 10, 0));
		lblTimer.setText("Timer");
		lblTimer.setFont(new Font("Consolas", Font.BOLD, 50));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		pnlNorth.add(lblTimer);
		pnlNorth.add(timerPanel);
		
		
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(pnl, BorderLayout.CENTER);
		setVisible(true);

		Thread th = new Thread(timerPanel);
		th.start();
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}

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
