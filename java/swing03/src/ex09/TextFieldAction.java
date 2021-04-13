package ex09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


// 텍스트필드에서 액션리스너 사용법
@SuppressWarnings("serial")
public class TextFieldAction extends JFrame implements ActionListener{
	Container c = getContentPane();
	JTextField txtNorth =new JTextField();
	JTextField txtSouth =new JTextField();
	JLabel lblCenter = new JLabel(new ImageIcon("images/left.png"));
	
	ImageIcon imgLeft = new ImageIcon("images/left.png");
	ImageIcon imgRight = new ImageIcon("images/right.png");
	
	public TextFieldAction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setUI();
		setListener();
		setSize(500, 500);
		setVisible(true);
	}

	private void setListener() {
		txtNorth.addActionListener(this);
		txtSouth.addActionListener(this);
	}

	private void setUI() {
		// 폰트크기를 늘리면 칸 크기도 늘어난다.
		txtNorth.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		txtSouth.setFont(new Font("굴림체", Font.BOLD, 40));
		c.add(txtNorth, BorderLayout.NORTH);
		c.add(txtSouth, BorderLayout.SOUTH);
		c.add(lblCenter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == txtNorth) {
			String text = txtNorth.getText();
			txtSouth.setText(text);
			txtNorth.setText("");
			lblCenter.setIcon(imgLeft);
		} else if(obj == txtSouth) {
			String text = txtSouth.getText();
			txtNorth.setText(text);
			txtSouth.setText("");
			lblCenter.setIcon(imgRight);
		}
	}
	public static void main(String[] args) {
		new TextFieldAction();
	}
}

