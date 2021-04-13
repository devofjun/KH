package ex04;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CheckBoxEx extends JFrame {
	Container c = getContentPane();
	
	public CheckBoxEx(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("체크박스 예제");
		setSize(300,300);
		
		c.setLayout(new FlowLayout());
		JCheckBox check1 = new JCheckBox("apple"); // 기본적인 체크박스
		c.add(check1);
		
		JCheckBox check2 = new JCheckBox("배",true); // 초기 상태가 체크된 상태
		c.add(check2);
		
		ImageIcon image1 = new ImageIcon("images/Americano.png");
		ImageIcon image2 = new ImageIcon("images/apple.png");
		JCheckBox check3 = new JCheckBox(image1); 
		check3.setSelectedIcon(image2); // 체크된 상태에 나타날 이미지
		check3.setBorderPainted(true); // 입체감있게 표현, 체크된 상태와 해제된 상태의 표현이 다름.
		c.add(check3);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxEx();
	}
}
