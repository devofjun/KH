package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ComboActionEx extends JFrame{
	
	public ComboActionEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("콤보박스 액션리스너");
		
		String[] names = {
				"스파이더맨", "원더우먼", "배트맨", " 슈퍼맨"
		};
		
		ImageIcon[] images = {
				new ImageIcon("images/image0.jpg"),
				new ImageIcon("images/image1.jpg"),
				new ImageIcon("images/image2.jpg"),
				new ImageIcon("images/image3.jpg")
		};
		
		JComboBox<String> combo = new JComboBox<String>(names);
		JLabel label = new JLabel(images[0]);
		
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = combo.getSelectedIndex();
				//System.out.println("index:"+index);
				label.setIcon(images[index]);
			}
		});
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(combo);
		c.add(label);
		
		setSize(500, 350);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ComboActionEx();
	}
}
