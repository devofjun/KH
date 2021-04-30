package ex05;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelMan extends JLabel implements Runnable{
	JLabel lUser;
	boolean life = true;
	public LabelMan(ImageIcon img, JLabel lUser) {
		super(img);
		this.lUser = lUser;
	}
	
	@Override
	public void run() {
		while(life) {
			Point p = getLocation();
			int x = (int)p.getX();
			int y = (int)p.getY();
			int userX = (int)lUser.getX();
			int userY = (int)lUser.getY();
			//System.out.println(x+":"+y+" || "+userX+":"+userY);
			if(x > userX) {
				x -= 1;
			} else if(x < userX) {
				x += 1;
			}
			if(y > userY) {
				y -= 1;
			} else if(y < userY) {
				y += 1;
			}
			setLocation(x, y);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
