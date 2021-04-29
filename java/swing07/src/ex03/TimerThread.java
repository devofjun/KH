package ex03;

import java.util.Calendar;

import javax.swing.JLabel;

public class TimerThread extends Thread{

	private JLabel lblTarget;
	
	int hour = 0;
	int min = 0;
	int sec = 0;
	int timeDiff = 0;
	public TimerThread(JLabel label, int timeDiff) {
		lblTarget = label;
		this.timeDiff = timeDiff;
	}
	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			String text;
			
			text = String.valueOf(hour = cal.get(Calendar.HOUR_OF_DAY)+timeDiff) + ":";
			text += String.valueOf(min = cal.get(Calendar.MINUTE)) + ":";   
			text += String.valueOf(sec = cal.get(Calendar.SECOND));
			lblTarget.setText(text);
			//System.out.println(text);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
