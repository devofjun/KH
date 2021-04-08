package ex01;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	Container c = getContentPane();
	JButton btn = new JButton("버튼");
	MyActionListener listener = new MyActionListener();
	
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("액션리스너");
		setSize(500, 500);
		// 버튼에 액션감시자를 붙임
		btn.addActionListener(listener);
		c.add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
