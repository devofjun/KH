package ex06;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


// 라디오버튼에 이미지 넣기
@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame{
	
	Container c = getContentPane();
	
	public RadioButtonEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("라디오 버튼 예제");
		setSize(300, 300);
		
		// 라디오 버튼을 하나로 묶을 그룹 객체
		ButtonGroup group = new ButtonGroup();
		
		c.setLayout(new FlowLayout());
		JRadioButton rdoApple = new JRadioButton("사과"); // 라디오버튼
		c.add(rdoApple);
		JRadioButton rdoPear = new JRadioButton("배",true); // 체크된 라디오버튼
		c.add(rdoPear);
		
		JRadioButton rdoRps = new JRadioButton(new ImageIcon("images/rock.png"));
		rdoRps.setSelectedIcon(new ImageIcon("Images/papper.png")); // 체크 상태일 때의 이미지
		c.add(rdoRps);
		
		// 사과, 배 라디오 버튼을 그룹으로 묶음 -> name="" 속성의 값을 같게
		group.add(rdoApple);
		group.add(rdoPear);
		group.add(rdoRps);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RadioButtonEx();
	}
}
