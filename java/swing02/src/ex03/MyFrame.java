package ex03;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JButton btn = new JButton("버튼");
	MyMouselistener listener = new MyMouselistener();
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("배경색변경");
		setcom();
		setSize(500, 500);
		setVisible(true);
	}
	
	public void setcom() {
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btn.addMouseListener(listener);
		
		btn.setSize(200, 100);
		
		c.add(btn);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
