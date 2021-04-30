package ex04;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TimerLabel2 extends JLabel implements Runnable{
	
	int timediff = 0;
	TimerLabel2(int timediff){
		this.timediff = timediff;
	}
	
	@Override
	public void run() {
		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setHorizontalAlignment(SwingConstants.CENTER);
		while(true) {
			Calendar cal = Calendar.getInstance();
			String text;
			int hour = cal.get(Calendar.HOUR)+timediff;
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
			setText(text);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
