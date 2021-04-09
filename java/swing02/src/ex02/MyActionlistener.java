package ex02;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionlistener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
		Color c = btn.getBackground();
		if(c==Color.RED) {
			btn.setBackground(Color.YELLOW);
		} else {
			btn.setBackground(Color.RED);
		}
	}

}
