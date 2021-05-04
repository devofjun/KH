package ex08;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable{
	JLabel lbl;
	public TimerRunnable(JLabel lbl) {
		this.lbl = lbl;
	}
	
	@Override
	public void run() {
		System.out.println("test");
		while(true) {
			int i = Integer.parseInt(lbl.getText());
			lbl.setText(String.valueOf(++i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// 예외발생
				System.out.println("스레드 강제종료");
				return;
				//e.printStackTrace();
			}			
		}
	}
	
}
