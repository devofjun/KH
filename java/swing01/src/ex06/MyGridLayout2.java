package ex06;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyGridLayout2 extends JFrame{
	
	public MyGridLayout2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생정보");
		setUI();
		setSize(300,300);
		setVisible(true);
	}
	
	public void setUI() {
		String[] labelTexts = {"이름", "학번", "학과", "점수"};
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 2)); // 4x2
		for(int i=0; i<labelTexts.length; i++) {
			c.add(new JLabel(labelTexts[i]));
			c.add(new JTextField());
		}
	}
	
	public static void main(String[] args) {
		new MyGridLayout2();
	}
}
