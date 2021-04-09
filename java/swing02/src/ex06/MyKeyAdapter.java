package ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class MyKeyAdapter extends KeyAdapter{
	private JLabel lbl = new JLabel();
	public void setlbl(JLabel lbl) {
		this.lbl = lbl;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e);
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			//System.out.println("좌");
			lbl.setLocation(lbl.getX()-10, lbl.getY());
			break;
		case KeyEvent.VK_UP:
			//System.out.println("상");
			lbl.setLocation(lbl.getX(), lbl.getY()-10);
			break;
		case KeyEvent.VK_RIGHT:
			//System.out.println("우");
			lbl.setLocation(lbl.getX()+10, lbl.getY());
			break;
		case KeyEvent.VK_DOWN:
			//System.out.println("하");
			lbl.setLocation(lbl.getX(), lbl.getY()+10);
			break;
		}
	}
	
}
