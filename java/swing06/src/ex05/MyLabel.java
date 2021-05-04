package ex05;

import java.awt.Point;

import javax.swing.JLabel;

public class MyLabel extends JLabel implements Runnable{

	int x,y;
	
	public MyLabel(String str) {
		super(str);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Point p = getLocation();
				x = (int)p.getX();
				y = (int)p.getY();
				setLocation(x+10,y);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
