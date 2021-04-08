package ex08;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JFrame{
	Container c = getContentPane();
	JPanel pnlLeft = new JPanel();
	JPanel pnlRight = new JPanel();
	
	public MyPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("패널연습");
		
		c.setLayout(null);
		
		// 패널의 기본 배치관리자는 FlowLayout이다.
		for(int i=0; i<=3; i++) {
			JButton b = new JButton("버튼"+i);
			pnlLeft.add(b);
		}
		
		//pnlLeft.setBackground(Color.YELLOW);
		pnlLeft.setBounds(10, 10, 100, 200);
		c.add(pnlLeft);
		
		for(int i=0; i<=3; i++) {
			JButton b = new JButton("버튼"+i);
			pnlRight.add(b);
		}
		
		//pnlRight.setBackground(Color.CYAN);
		pnlRight.setBounds(220, 10, 200, 200);
		c.add(pnlRight);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyPanel();
	}
}
