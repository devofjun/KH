package ex02;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TimerFrame extends JFrame{
	Container c = getContentPane();
	JLabel label = new JLabel("0");
	
	public TimerFrame() {
		setTitle("타이머 레이블");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(label);
		setSize(300, 300);
		setVisible(true);
		TimerThread th = new TimerThread(label);
		th.start();
	}
	
	public static void main(String[] args) {
		new TimerFrame();
	}
}
