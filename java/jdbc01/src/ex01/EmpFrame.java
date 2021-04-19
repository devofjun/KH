package ex01;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class EmpFrame extends JFrame{
	EmpDao empDao = EmpDao.getInstance();
	Container c = getContentPane();
	
	public EmpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("사원정보");
		setSize(300, 300);
		setVisible(true);
		
		empDao.getConnection();
	}
	public static void main(String[] args) {
		new EmpFrame();
	}
}
