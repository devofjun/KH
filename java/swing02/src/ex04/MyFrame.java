package ex04;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JLabel[] label = new JLabel[10];
	MyMouseListener mouseLsn = new MyMouseListener(); 
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("순서대로 클릭");
		
		setcon();
		
		setSize(500, 500);
		setVisible(true);
	}
	
	public void setcon() {
		c.setLayout(null);
		for(int i=0; i<label.length; i++) {
			label[i] = new JLabel(String.valueOf(i+1));
			int x = (int)(Math.random() * 400);
			int y = (int)(Math.random() * 400);
			label[i].setBounds(x, y, 25, 25);
			label[i].addMouseListener(mouseLsn);
			c.add(label[i]);
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
