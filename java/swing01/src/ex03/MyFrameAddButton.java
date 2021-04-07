package ex03;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrameAddButton extends JFrame{
	Container container;
	JButton button = new JButton("button");
	public MyFrameAddButton() {
		container = this.getContentPane(); // 프레임에 들어 있는 컨텐트 팬 얻기
		container.add(button); // add() : 컨테이너에 컴포넌트 추가(붙이기)
		this.setTitle("버튼이 달린 창 ");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrameAddButton();
	}
}
