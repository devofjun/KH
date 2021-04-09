package ex01;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestAction extends JFrame{
	Container ctn = getContentPane();
	JButton btn = new JButton("");
	ActionLsn listener = new ActionLsn();
	
	public TestAction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		btn.addActionListener(listener);
		ctn.add(btn);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestAction();
	}
}


class ActionLsn implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Do it");
	}
	
}