package ex04;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class MyMouseListener implements MouseListener{
	
	GameManager manager = GameManager.getInstance();
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		JLabel label = (JLabel)obj;
		String text = label.getText();
		int iText = Integer.parseInt(text);
		boolean result = manager.judge(iText);		
		if (result == true) {
//			label.setText("");
			label.setVisible(false);	
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
