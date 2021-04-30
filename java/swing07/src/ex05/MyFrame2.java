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
	
	JLabel lUser = new JLabel(new ImageIcon("images/man2.png"));
	LabelMan[] lMans = new LabelMan[10]; 
	Thread manTh;
	JPanel pnl = new JPanel();
	JLabel lblTimer = new JLabel("Timer");
	JPanel pnlNorth = new JPanel();
	
	TimerPanel timerPanel = new TimerPanel();
	
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이미지 옮기기");
		setSize(1000, 1000);
		
		pnl.setLayout(null);
		// 따라오는 이미지
		lMans[0] = new LabelMan(new ImageIcon("images/man1.png"),lUser);
		lMans[0].setBounds(800, 800, 80, 75);
		pnl.add(lMans[0]);
		manTh = new Thread(lMans[0]);
		manTh.start();
		// 유저 이미지
		lUser.setBounds(50, 50, 80, 75);
		pnl.add(lUser);
		pnl.setFocusable(true);
		pnl.addKeyListener(this);
		
		pnlNorth.setLayout(new GridLayout(1, 2, 10, 0));
		lblTimer.setFont(new Font("Consolas", Font.BOLD, 50));
		pnlNorth.add(lblTimer);
		pnlNorth.add(timerPanel);
		
		lMans[1] = new LabelMan(new ImageIcon("images/man1.png"),lUser);
		lMans[1].setBounds(500, 800, 80, 75);
		pnl.add(lMans[1]);
		manTh = new Thread(lMans[1]);
		manTh.start();
		
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
//		timerPanel.setSize(c.getWidth(), 100);
		timerPanel.setBackground(Color.YELLOW);
//		timerPanel.add(lblTimer);
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(pnl, BorderLayout.CENTER);
		setVisible(true);
//		timerPanel.repaint();
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
		int x = lUser.getX();
		int y = lUser.getY();
		switch(keycode) {
		case KeyEvent.VK_UP:
			y -= 10;
			lUser.setLocation(x, y);
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			lUser.setLocation(x, y);
			break;
		case KeyEvent.VK_RIGHT:
			x += 10;
			lUser.setLocation(x, y);
			break;
		case KeyEvent.VK_LEFT:
			x -= 10;
			lUser.setLocation(x, y);
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
}
