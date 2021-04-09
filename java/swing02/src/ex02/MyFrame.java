package ex02;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JButton btn = new JButton("버튼");
	MyActionlistener listener = new MyActionlistener();
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("배경색변경");
		setcom();
		setSize(500, 500);
		setVisible(true);
	}
	
	public void setcom() {
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		//btn.setBounds(200, 50, 100, 50);
		btn.setSize(200, 100);
		btn.addActionListener(listener);
		c.add(btn);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
