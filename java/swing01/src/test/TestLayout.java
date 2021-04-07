package test;

import java.awt.Button;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestLayout extends JFrame{
	Container c1 = getContentPane();
	Button btn_N;
	Button btn_S;
	Button btn_W;
	Button btn_E;
	Button btn_C;
	
	public TestLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setComponent();
		
		setSize(500, 300);
		setVisible(true);
	}
	
	private void setComponent() {
		btn_N = new Button("북");
		btn_S = new Button("남");
		btn_E = new Button("동");
		btn_W = new Button("서");
		btn_C = new Button("중");
		
		
	}
	
	public static void main(String[] args) {
		new TestLayout();
	}
}
