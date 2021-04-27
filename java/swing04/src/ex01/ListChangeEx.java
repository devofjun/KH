package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListChangeEx extends JFrame{
	
	private Container c = getContentPane();
	private JTextField txtName = new JTextField(10);
	private Vector<String> vec = new Vector<>();
	private JList<String> list = new JList<>();
	
	
	public ListChangeEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		
		list.setVisibleRowCount(5); // 보이는 행(이이템)의 갯수
		list.setFixedCellWidth(100); // 폭 고정 : 100픽셀
		
		vec.add("홍길동");
		vec.add("유관순");
		
		list.setListData(vec);
		
		c.setLayout(new FlowLayout());
		c.add(txtName);
		c.add(new JScrollPane(list));
		
		txtName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이 안에서 this는 actionlistener를 가르킨다.
				String text = txtName.getText();
				vec.add(text);
				list.setListData(vec);
				txtName.setText("");
			}
		});
		
		
		setSize(200, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListChangeEx();
	}
}
