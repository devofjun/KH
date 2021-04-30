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
	//private static final int SEOUL = 0;
	//private static final int NEWYORK = 1;
	private static final int SEOULTIME = 2;
	private static final int NEWYORKTIME = 3;
	JLabel[] lbl = {
			new JLabel("서울"),
			new JLabel("뉴욕"),
			new JLabel("서울시간"),
			new JLabel("뉴욕시간")
	};
	
	public DigitalClockFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("시계");
		setSize(400, 200);
		setVisible(true);
		c.setLayout(new GridLayout(2, 0));
		for(int i=0; i<lbl.length; i++) {
			lbl[i].setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			c.add(lbl[i]);
		}
		
		TimerThread timer = new TimerThread(lbl[SEOULTIME], 0);
		TimerThread timer2 = new TimerThread(lbl[NEWYORKTIME], -13);
		
		timer.start();
		timer2.start();
	}
	
	public static void main(String[] args) {
		new DigitalClockFrame();
	}
}
