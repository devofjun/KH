package ex02;

import javax.swing.JLabel;

public class TimerThread extends Thread{
	private JLabel lblTarget;
	
	public TimerThread(JLabel label) {
		lblTarget = label;
	}
	
	@Override
	public void run() {
		while(true) {
			String text = lblTarget.getText();
			int iText = Integer.parseInt(text);
			iText++;
			lblTarget.setText(String.valueOf(iText));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
