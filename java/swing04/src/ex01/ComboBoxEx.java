package ex01;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ComboBoxEx extends JFrame{
	
	public ComboBoxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		
		String[] fruits = {
				"사과", "배", "포도", "키위", "망고"
		};
		
		String[] names = {
				"이종형", "정병준", "장윤희", "윤수", "전승민"
		};
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox<String> combo1 = new JComboBox<String>(fruits);
		c.add(combo1);
		
		JComboBox<String> combo2 = new JComboBox<String>();
		for(String aName : names) {
			combo2.addItem(aName);
		}
		c.add(combo2);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComboBoxEx();
	}
}
