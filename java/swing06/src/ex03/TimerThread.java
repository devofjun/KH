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
			int hour = cal.get(Calendar.HOUR)+timeDiff;
			int min = cal.get(Calendar.MINUTE);
			int sec = cal.get(Calendar.SECOND);
			String strHour;
			String strMin;
			String strSec;
			
			if(hour < 0) { // 시차를 계산했을때 음수일 경우 24이내의 값으로 변환
				hour = 24 + hour;
			}
			
			if(hour < 10) { // 시간이 한자리수일때 십의자리 0
				strHour = "0" + hour;
			} else {
				strHour = String.valueOf(hour);
			}
			
			if(min < 10) { // 분이 한자리수일때 십의자리 0
				strMin = "0" + min;
			} else {
				strMin = String.valueOf(min);
			}
			
			if(sec < 10) { // 초가 한자리수일때 십의자리 0
				strSec = "0" + sec;
			} else {
				strSec = String.valueOf(sec);
			}
			text = strHour + ":";
			text += strMin + ":";   
			text += strSec;
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
