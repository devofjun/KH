package ex01;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class EmpFrame extends JFrame{
	EmpDao empDao = EmpDao.getInstance();
	Container c = getContentPane();
	JTextArea textArea = new JTextArea();
	public EmpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("사원정보");
		c.add(textArea);
		setSize(300, 300);
		setVisible(true);
		empDao.getEmpList();
		EmpVo empVo = empDao.getEmpList();
		int empno = empVo.getEmpno();
		String ename = empVo.getEname();
		String job = empVo.getJob();
		int sal = empVo.getSal();
		textArea.append(empno + " | ");
		textArea.append(ename + " | ");
		textArea.append(job + " | ");
		textArea.append(sal + " | ");
		//empDao.getConnection();
	}
	public static void main(String[] args) {
		new EmpFrame();
	}
}
