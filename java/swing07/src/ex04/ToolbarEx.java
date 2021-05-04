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
		setTitle("���� ����");
		setSize(800,800);
		// ���� ����
		JToolBar toolbar = new JToolBar("My Tool");
		// ���� ��ġ ����
		toolbar.setFloatable(false); // float:�ε�(���ٴ�)
		// ���ٿ� ������Ʈ�� �ޱ�
		JButton btnNew = new JButton("New");
		btnNew.setToolTipText("������"); // ���콺 Ŀ���� �ø��� ��� ��Ÿ���ٰ� ������� �ؽ�Ʈ
		toolbar.add(btnNew);
		toolbar.add(new JButton(new ImageIcon("images/man1.png")));
		toolbar.addSeparator();
		toolbar.add(new JButton("open"));
		toolbar.add(new JLabel("���̺�"));
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
