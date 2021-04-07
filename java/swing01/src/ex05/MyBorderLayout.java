package ex05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyBorderLayout extends JFrame{
	Container c = getContentPane();
	JButton btnNorth = new JButton("북쪽");
	JButton btnSouth = new JButton("남쪽");
	JButton btnEast = new JButton("동쪽");
	JButton btnWest = new JButton("서쪽");
	JButton btnCenter = new JButton("중앙");
	
	public MyBorderLayout() {
		// 기본 배치관리자 = borderlayout
		
		// 창닫기 옵션 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창제목 설정
		setTitle("보더 레이아웃");
		// 창크기 설정
		setSize(500,500);
		// 컴포넌트 설정
		setComponents();
		// 창보이기
		setVisible(true);
	}
	
	private void setComponents() {
		c.add(btnNorth,BorderLayout.NORTH);
		c.add(btnSouth,BorderLayout.SOUTH);
		c.add(btnEast,BorderLayout.EAST);
		c.add(btnWest,BorderLayout.WEST);
		c.add(btnCenter,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new MyBorderLayout();
	}
}
