package ex05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class MyMouseAdapter extends MouseAdapter{

	private JLabel lblTarget;
	
	public void setLblTarget(JLabel label) {
		lblTarget = label;
	}
	/*
	@Override //MouseListener에 정의됨
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		//Object obj = e.getSource(); // label이 아니기 때문에 필요가 없음
		lblTarget.setLocation(x, y);
	}
	*/
	@Override //MouseMotionListener에 정의됨
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		lblTarget.setLocation(x, y);
	}
	
	
	
}
