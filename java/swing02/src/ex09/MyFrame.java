package ex09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	Container c = getContentPane();
	JButton button = new JButton("버튼");
	JButton button2 = new JButton("버튼2");
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("익명 클래스");
		setSize(500,500);
		
		// 독립된 클래스
		//MyActionListener listener = new MyActionListener();
		//button.addActionListener(listener);
		
		// 내부클래스
		//MyActionListener2 listener2 = new MyActionListener2();
		//button.addActionListener(listener2);
		
		// 익명 내부클래스 사용 - 객체명(인스턴스 이름)이 필요없는 겨우 - 그 이름으로 점(.) 찍고 접근 할 필요가 없음.
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action3");			
			}
		});
		
		// 익명클래스는 코드 재사용이 안된다는 단점이 있다.
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action3");
			}
		});
		
		c.setLayout(new FlowLayout());
		c.add(button);
		c.add(button2);
		setVisible(true);
	}
	
	public class MyActionListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("action2");
		}
		
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
