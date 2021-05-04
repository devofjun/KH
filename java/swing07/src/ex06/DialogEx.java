package ex06;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DialogEx extends JFrame{
	Container c = getContentPane();
	JButton btn = new JButton("다이얼로그 보이기");
	// 상속받은 원래의 Dialog의 인자값으로 Frame과 "제목"을 받는다.
	MyDialog dlg = new MyDialog(this, "title", true); // 모달상태로 생성
	
	public DialogEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("다이얼로그 예제");
		setSize(300, 300);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(true);
				// 모달 다이얼로그인 경우 - 다이얼로그 창이 닫히기 전까지
				// 여기 실행 안됨 = 코드 실행이 멈춤
				//System.out.println("다이얼로그 닫힘");
				btn.setText(dlg.getText());
			}
		});
		c.add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DialogEx();
	}
}
