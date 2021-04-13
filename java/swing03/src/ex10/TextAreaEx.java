package ex10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


// 텍스트에어리어 예제
@SuppressWarnings("serial")
public class TextAreaEx extends JFrame{
	Container c = getContentPane();
	JTextField tf = new JTextField();
	JTextArea ta = new JTextArea();
	
	public TextAreaEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("텍스트 에어리어 예제");
		setUI();
		setSize(300, 200);
		setVisible(true);
	}
	
	private void setUI() {
		// 익명 인터페이스인가 익명 클래스
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				ta.append(text+"\n");
				tf.setText("");
			}
		});
		c.add(tf,BorderLayout.NORTH);
		c.add(new JScrollPane(ta)); // 스크롤바가 달린 텍스트 에어리어
	}
	
	public static void main(String[] args) {
		new TextAreaEx();
	}
}
