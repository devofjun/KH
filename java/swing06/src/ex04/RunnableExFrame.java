package ex04;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RunnableExFrame extends JFrame{
	
	Container c = getContentPane();
	TimerLabel lbl = new TimerLabel();
	
	Thread th = new Thread(lbl);
	
	public RunnableExFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("run메소드가 있는 레이블");
		setSize(200, 200);
		setVisible(true);
		c.add(lbl, BorderLayout.CENTER);
		th.start();
	}
	
	public static void main(String[] args) {
		new RunnableExFrame();
	}
}
