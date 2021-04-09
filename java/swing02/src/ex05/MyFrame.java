package ex05;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JLabel myLabel = new JLabel("Java");
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("액션리스너");
		c.setLayout(null);
		myLabel.setBounds(10, 10, 50, 30);
		c.add(myLabel);
		
		setSize(500, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
