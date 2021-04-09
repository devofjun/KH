package ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e);
		int k = e.getKeyCode();
		switch(k) {
		case KeyEvent.VK_LEFT:
			System.out.println("좌");
			break;
		case KeyEvent.VK_UP:
			System.out.println("상");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("우");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("하");
			break;
		}
	}
	
}
