package ex01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FileInputStreamEx2 extends JFrame implements ActionListener{
	Container c = getContentPane();
	JTextField tf = new JTextField(30);
	JButton btn = new JButton("열기");
	JTextArea ta = new JTextArea();
	JPanel pnlNorth =  new JPanel();
	JPanel pnlCenter = new JPanel();
	
	FileReader reader = null;
	
	public FileInputStreamEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("파일 읽어오기");
		setSize(500, 400);
		btn.addActionListener(this);
		pnlNorth.add(tf);
		pnlNorth.add(btn);
		pnlCenter.setLayout(new BorderLayout());
		pnlCenter.add(ta);
		c.add(pnlNorth,BorderLayout.NORTH);
		c.add(pnlCenter,BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FileInputStreamEx2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String fileName = tf.getText();
		try {
			reader = new FileReader(fileName);
			while(true) {
				int data = reader.read();
				if(data == -1) {
					break;
				}
				ta.append(String.valueOf((char)data));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
