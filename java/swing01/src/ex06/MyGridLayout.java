package ex06;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyGridLayout extends JFrame{
	
	Container c = getContentPane();
	
	public MyGridLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new GridLayout(4, 3, 10, 10)); // 4줄에 3칸, 간격은 오른쪽간격10 아래간격10
		// 버튼 12개를 달기
		for(int i=0;i<12;++i) {
			c.add(new JButton(String.valueOf(i)));
		}
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyGridLayout();
	}
}
