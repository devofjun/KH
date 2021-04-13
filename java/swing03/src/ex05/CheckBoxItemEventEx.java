package ex05;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


// 체크박스에 아이템리스너 적용하기
@SuppressWarnings("serial")
public class CheckBoxItemEventEx extends JFrame{
	MyListener listener = new MyListener();
	Container c = getContentPane();
	String[] texts = {"사과", "배", "체리"};
	JCheckBox[] checks = new JCheckBox[texts.length];
	JLabel lblPrice = new JLabel("사과 100, 배 500원, 체리 20000원");
	JLabel lblSum = new JLabel("현재 0원입니다.");
	
	public CheckBoxItemEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("체크박스 아이템 이벤트 예제");
		setSize(250,300);
		
		c.setLayout(new FlowLayout());
		c.add(lblPrice);
		
		for(int i=0;i<texts.length;i++) {
			checks[i] = new JCheckBox(texts[i]);
			checks[i].addItemListener(listener);
			c.add(checks[i]);
		}
		c.add(lblSum);
		
		setVisible(true);
	}
	// 내부 클래스 : 외부클래스의 멤버를 사용할 수 있다.
	class MyListener implements ItemListener {	
		int sum = 0; // 합계금액
		@Override
		public void itemStateChanged(ItemEvent e) {
			Object obj = e.getItem();
			
			
			System.out.println("체크상태 바뀜");
			//해제 -> 체크, 체크 -> 해체
			int state = e.getStateChange();
			// 체크 상태로 변경된 경우
			if(state == ItemEvent.SELECTED) {
				if(obj == checks[0]) {
					sum += 100;
				} else if(obj==checks[1]) {
					sum += 500;
				} else if(obj==checks[2]) {
					sum += 20000;
				}
			} else { // 해체 상태로 변경된 경우
				if(obj == checks[0]) {
					sum -= 100;
				} else if(obj==checks[1]) {
					sum -= 500;
				} else if(obj==checks[2]) {
					sum -= 20000;
				}
			}
			lblSum.setText("현재가격 "+sum+"원 입니다.");
		}
		
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}
}
