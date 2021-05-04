package ex04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class ToolbarEx extends JFrame{
	Container c = getContentPane();
	
	
	public ToolbarEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("툴바 예제");
		setSize(800,800);
		// 툴바 생성
		JToolBar toolbar = new JToolBar("My Tool");
		// 툴바 위치 고정
		toolbar.setFloatable(false); // float:부동(떠다님)
		// 툴바에 컴포넌트를 달기
		JButton btnNew = new JButton("New");
		btnNew.setToolTipText("새파일"); // 마우스 커서를 올리면 잠시 나타났다가 사라지는 텍스트
		toolbar.add(btnNew);
		toolbar.add(new JButton(new ImageIcon("images/man1.png")));
		toolbar.addSeparator();
		toolbar.add(new JButton("open"));
		toolbar.add(new JLabel("레이블"));
		Vector<String> vec = new Vector<String>();
		vec.add("java");
		vec.add("Python");
		vec.add("C#");
		vec.add("javaScript");
		JComboBox<String> combo = new JComboBox<String>(vec);
		toolbar.add(combo);
		
		//toolbar.setLayout(new FlowLayout());
		
		c.add(toolbar,BorderLayout.NORTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ToolbarEx();
	}
}
