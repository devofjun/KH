package ex06;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JLabel myLabel = new JLabel("Java");
	MyKeyAdapter lsn = new MyKeyAdapter(); 
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("액션리스너");
		c.setLayout(null);
		myLabel.setBounds(10, 10, 50, 30);
		c.add(myLabel);
		c.addKeyListener(lsn);
		setSize(500, 500);
		setVisible(true);
		//requestFocus는 visible 이후에 해야함.
		c.requestFocus(); //컨테이너가 키이벤트를 받을수 있도록 포커스를 요청
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
