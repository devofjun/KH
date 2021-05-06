package ex07;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OptionPaneEx extends JFrame{
	// 필드
	Container c = getContentPane();
	JTextField tf = new JTextField();
	// 생성자
	public OptionPaneEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3종류의 다이얼로그");
		setSize(300, 300);
		
		OptionPanel pnl = new OptionPanel();
		
		c.add(pnl, BorderLayout.CENTER);
		c.add(tf, BorderLayout.SOUTH);
		setVisible(true);
	}
	// OptionPanel 내부 클래스
	@SuppressWarnings("unused")
	private class OptionPanel extends JPanel {
		public OptionPanel(){
			// 버튼 3개
			JButton input = new JButton("Input");
			JButton Confirm = new JButton("Confirm");
			JButton Message = new JButton("Message");
			// 버튼 3개에 대한 이벤트
			input.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 첫번째 인자로 null값을 주면 화면의 가운데로줌, 프레임의 가운데 띄우고 싶다면 OptionPaneEx.this 하면됨
					String text = JOptionPane.showInputDialog(OptionPaneEx.this, "오늘은 뭐먹을까?");
					tf.setText(text);
				}
			});
			
			Confirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 예, 아니오, 취소, 닫기 버튼이 있는 다이얼로그
					int result = JOptionPane.showConfirmDialog(OptionPaneEx.this, "정하기도 귀찮나요?");
					// 결과에 따른 처리
					// 예 0
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("예");
					}
					// 아니오 1
					if(result == JOptionPane.NO_OPTION) {
						tf.setText("아니오");
					}
					// 취소 2
					if(result == JOptionPane.CANCEL_OPTION) {
						tf.setText("취소");
					}
					// 닫기 -1
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("닫기");
					}
				}
			});
			
			Message.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 메세지만 띄우는 다이얼로그
					JOptionPane.showMessageDialog(OptionPaneEx.this, "벌써 배가고프네요");
				}
			});
			this.add(input);
			this.add(Confirm);
			this.add(Message);
		}
	}
		
		
			
			
			
	
	public static void main(String[] args) {
		new OptionPaneEx();
	}
}
