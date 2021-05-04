package ex05;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	
	MyLabel label = new MyLabel("o");
	
	Thread th = new Thread(label);
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(500, 500);
		setVisible(true);
		
		c.add(label);
		th.start();
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
