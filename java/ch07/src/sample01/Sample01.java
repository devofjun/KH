package sample01;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Sample01 extends JFrame{
	
	public Sample01() {
		this.add(new JButton("hello"));
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Sample01();
	}
}
