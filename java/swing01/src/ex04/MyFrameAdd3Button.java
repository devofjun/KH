package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrameAdd3Button extends JFrame{
	Container c = getContentPane();
	JButton btn1 = new JButton("버튼1");
	JButton btn2 = new JButton("버튼2");
	JButton btn3 = new JButton("버튼3");
	
	public MyFrameAdd3Button() {
		// 창닫기 버튼 동작을 프로그램 종료 설정하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 배치관리자 - BorderLayout(default임)
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 100)); // 배치관리자 변경
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		setTitle("버튼 3개 달린 창");
		setSize(500, 300);
		c.setBackground(Color.CYAN);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrameAdd3Button();
	}
}
