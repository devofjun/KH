package ex02;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{ // 자동으로 import하는 단축키 ctrl+shift+o
	
	public MyFrame() {
		super(); // 생략가능
		this.setTitle("두번째 창"); // super나 this 생략가능.
		this.setSize(500, 300); // 왜? 상속받았기 때문에 자식클래스이 부모클래스의 멤버를 가지고 있기 때문. 
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
