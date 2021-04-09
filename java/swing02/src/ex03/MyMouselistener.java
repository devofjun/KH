package ex03;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MyMouselistener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("클릭됨");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("눌림");
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
		btn.setBackground(Color.CYAN);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("땜");
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
		btn.setBackground(Color.ORANGE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("들어옴");// 해당 컴포넌트 안으로 들어옴
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
		btn.setBackground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("빠져나감");
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
		btn.setBackground(Color.YELLOW);
	}
	
}
