package ex04;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class MyMouseListener implements MouseListener{
	int numCount = 0;
	int chance = 3;
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		JLabel l = (JLabel)obj;
		String s = l.getText();
		if(Integer.parseInt(s) == numCount+1 && chance>0) {
			numCount++;
			l.setVisible(false);
		} else if(Integer.parseInt(s) != numCount+1 && chance<=0) {
			System.out.println("실패");
		} else {
			chance--;
			System.out.println("Error");
		}
		if(numCount>=10) {
			System.out.println("성공");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
