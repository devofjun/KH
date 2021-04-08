package ex08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel2 extends JFrame{
	Container c = getContentPane();
	JButton openBtn = new JButton("열기"); 
	JButton closeBtn = new JButton("닫기");
	JButton exitBtn = new JButton("나가기");
	JPanel topPnl = new JPanel();
	JPanel centerPnl = new JPanel();
	JLabel label;
	
	public MyPanel2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("직접해보기");
		
		topMenu();
		centerMenu();
		
		setSize(500,300);
		setVisible(true);
	}
	
	void topMenu() {
		topPnl.setBackground(Color.CYAN);
		topPnl.add(openBtn);
		topPnl.add(closeBtn);
		topPnl.add(exitBtn);
		
		c.add(topPnl,BorderLayout.NORTH);
	}
	
	void centerMenu(){
		centerPnl.setBackground(Color.YELLOW);
		centerPnl.setLayout(null);
		
		String[] labelTexts = {"Java","HTML","CSS"};
		for(int i=0; i<labelTexts.length;i++) {
			int xRand = (int)(Math.random()*500);
			int yRand = (int)(Math.random()*200);
			label = new JLabel(labelTexts[i]);
			label.setBounds(xRand, yRand, 50, 20);
			centerPnl.add(label);
		}
		c.add(centerPnl,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new MyPanel2();
	}
}
