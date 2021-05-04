package ex04;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TimerLabel extends JLabel implements Runnable{
	
	@Override
	public void run() {
		int num = 0;
		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setHorizontalAlignment(SwingConstants.CENTER);
		while(true) {
			setText(String.valueOf(++num));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
