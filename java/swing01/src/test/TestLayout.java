package test;

import java.awt.BorderLayout;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestLayout extends JFrame{
	Container c1 = getContentPane();
	JButton[] btn1 = new JButton[5];
	
	public TestLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		setComponent();
		
		setSize(500, 300);
		setVisible(true);
	}
	
	private void setComponent() {
		for(int i=0;i<btn1.length;++i) {
			switch(i) {
			case 0:
				btn1[i] = new JButton("동");
				c1.add(btn1[i],BorderLayout.EAST);
				break;
			case 1:
				btn1[i] = new JButton("서");
				c1.add(btn1[i],BorderLayout.WEST);
				break;
			case 2:
				btn1[i] = new JButton("남");
				c1.add(btn1[i],BorderLayout.SOUTH);
				break;
			case 3:
				btn1[i] = new JButton("북");
				c1.add(btn1[i],BorderLayout.NORTH);
				break;
			case 4:
				btn1[i] = new JButton("중");
				c1.add(btn1[i],BorderLayout.CENTER);
				break;
			}	
		}
	}
	
	public static void main(String[] args) {
		System.out.println("동");
		new TestLayout();
	}
}
