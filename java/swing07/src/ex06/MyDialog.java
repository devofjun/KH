package ex06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyDialog extends JDialog{
	JTextField tf = new JTextField(10);
	JButton button = new JButton("OK");
	
	public MyDialog(JFrame frame, String title, boolean modal) {
		super(frame, title, modal);
		setLayout(new FlowLayout());
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		add(tf);
		add(button);
		setSize(200,200);
	}
	
	public String getText() {
		return tf.getText();
	}
}
