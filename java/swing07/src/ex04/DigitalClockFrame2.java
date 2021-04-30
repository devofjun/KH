package ex04;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DigitalClockFrame2 extends JFrame{
	Container c = getContentPane();
	JLabel lblSEOUL = new JLabel("서울");
	JLabel lblNEWYORK = new JLabel("뉴욕");
	
	TimerLabel2 lblSeoulTime = new TimerLabel2(0);
	TimerLabel2 lblNewYorkTime = new TimerLabel2(-13);
	
	Thread th1 = new Thread(lblSeoulTime);
	Thread th2 = new Thread(lblNewYorkTime);
	
	public DigitalClockFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("시계");
		setSize(400, 200);
		setVisible(true);
		c.setLayout(new GridLayout(2, 0));
		
		lblSEOUL.setHorizontalAlignment(SwingConstants.CENTER);
		lblNEWYORK.setHorizontalAlignment(SwingConstants.CENTER);
		lblSEOUL.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNEWYORK.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		c.add(lblSEOUL);
		c.add(lblNEWYORK);
		c.add(lblSeoulTime);
		c.add(lblNewYorkTime);
		
		th1.start();
		th2.start();
	}
	
	public static void main(String[] args) {
		new DigitalClockFrame2();
	}
}
