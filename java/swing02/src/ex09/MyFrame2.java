package ex09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame2 extends JFrame implements ActionListener{
	Container c = getContentPane();
	JButton button = new JButton("버튼");
	JButton button2 = new JButton("버튼2");
	
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("익명 클래스");
		setSize(500,500);
		
		button.addActionListener(this);
		button2.addActionListener(this);
		
		c.setLayout(new FlowLayout());
		c.add(button);
		c.add(button2);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button) {
			System.out.println("button1");
		} else if(obj == button2) {
			System.out.println("button2");
		}
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}
