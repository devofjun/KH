package ex01;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class EmpFrame extends JFrame{
	EmpDao empDao = EmpDao.getInstance(); // Dao 객체 만들기만함.
	Container c = getContentPane();
	JTextArea textArea = new JTextArea();
	public EmpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("사원정보");
		c.add(textArea);
		setSize(300, 300);
		setVisible(true);
		
		// db에 연결하고 데이터를 받아온 vo객체 저장
		EmpVo empVo = empDao.getEmpList(); 
		// 객체가 가지고 있는데 데이터 하나씩 저장
		int empno = empVo.getEmpno(); 
		String ename = empVo.getEname();
		String job = empVo.getJob();
		int sal = empVo.getSal();
		// 저장한 데이터 하나씩 출력
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
