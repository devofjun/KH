package ex06;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlickeringLabel extends JLabel implements Runnable{
	int delay;
	public FlickeringLabel(String text, int delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		th.start();
	}
	
	int flag = 0;
	@Override
	public void run() {
		while(true) {
			try {
				if(flag == 0) {
					setBackground(Color.GREEN);
					flag = 1;
				} else if(flag == 1) {
					setBackground(Color.YELLOW);
					flag = 0;
				}
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
