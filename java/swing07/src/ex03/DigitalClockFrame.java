package ex03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DigitalClockFrame extends JFrame{
	Container c = getContentPane();
	JLabel korT = new JLabel("시간");
	JLabel seoul = new JLabel("서울");
	JLabel newT = new JLabel("시간");
	JLabel newyork = new JLabel("뉴욕");
	
	
	
	public DigitalClockFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("시계");
		setSize(400, 400);
		setVisible(true);
		
		korT.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		korT.setHorizontalAlignment(SwingConstants.CENTER);
		seoul.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		seoul.setHorizontalAlignment(SwingConstants.CENTER);
		newT.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		newT.setHorizontalAlignment(SwingConstants.CENTER);
		newyork.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		newyork.setHorizontalAlignment(SwingConstants.CENTER);
		c.setLayout(new GridLayout(2, 0));
		c.add(seoul);
		c.add(newyork);
		c.add(korT);
		c.add(newT);
		
		TimerThread timer = new TimerThread(korT, 0);
		TimerThread timer2 = new TimerThread(newT, -13);
		
		timer.start();
		timer2.start();
	}
	
	public static void main(String[] args) {
		new DigitalClockFrame();
	}
}
