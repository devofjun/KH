package ex07;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyNullLayout extends JFrame{
	
	Container c = getContentPane();
	
	public MyNullLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("nullLayout");
		
		c.setLayout(null);
		// 배치관리자가 없기 때문에 컴포넌트(버튼)의 크기와 위치를 직접 설정
		JButton button = new JButton("버튼");
		button.setSize(200, 100); // 가로가 200 세로가 100
		button.setLocation(100, 50); // x=100 y=50
		c.add(button);
		
		// 크기와 위치를 한번에 설정
		JButton button2 = new JButton("버튼2");
		button2.setBounds(100, 200, 100, 200);
		c.add(button2);
		
		// 여러개의 버튼을 겹치게 배치
		for(int i=0; i<=5; ++i) {
			JButton b = new JButton("버튼"+i);
			b.setBounds(200+(i*5), 200+(i*5), 100, 100);
			c.add(b);
		}
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyNullLayout();
	}
}
