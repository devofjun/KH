package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ListEx extends JFrame {
	
	public ListEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("리스트 예제");
		
		String[] fruits = {
				"apple", "banana", "kiwi", "mango", "pear",
				"peach", "berry", "strawberry", "blackberry"
		};
		
		JList<String> list1 = new JList<String>(fruits);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(list1);
		
		ImageIcon[] icons = {
			new ImageIcon("images/left.png"),
			new ImageIcon("images/right.png")
		};
		Vector<ImageIcon> vec = new Vector<>();
		vec.add(icons[0]);
		vec.add(icons[1]);
		
		JList<ImageIcon> list2 = new JList<>(vec);
		c.add(list2);
		
		JList<String> list3 = new JList<>(fruits);
		c.add(new JScrollPane(list3));
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListEx();
	}
}
