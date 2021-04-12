package ex02;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame{
	Container c = getContentPane();
	// 텍스트 레이블
	JLabel label1 = new JLabel("사랑합니다.");
	// 이미지 레이블
	ImageIcon image = new ImageIcon("images/Americano.png");
	JLabel label2 = new JLabel(image);
	// 텍스트 + 이미지 레이블
	JLabel label3 = new JLabel("사과",new ImageIcon("images/apple.png"), SwingConstants.CENTER); 
	
	public LabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(200,600);
		
		c.setLayout(new FlowLayout());
		c.add(label1);
		c.add(label2);
		c.add(label3);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}
}
