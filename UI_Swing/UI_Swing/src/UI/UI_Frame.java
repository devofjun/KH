package UI;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UI_Frame extends JFrame{
	Container c = getContentPane();
	
	public UI_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(600,800);
		
		setUI();
		
		setVisible(true);
	}
	
	private void setUI() {
		
	}
}
