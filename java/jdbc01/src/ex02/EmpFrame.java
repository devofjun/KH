package ex02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EmpFrame extends JFrame implements ActionListener{
	Container c = getContentPane();
	String[] attribute = {"사번","이름","직급","관리자사번","입사일","급여","커미션","부서번호"};
	JLabel[] lbl = new JLabel[8];
	JTextField[] tf = new JTextField[8];
	JPanel pInput = new JPanel(new GridLayout(0,4)); 
	
	JButton btSelect = new JButton("전체조회");
	JButton btEmp = new JButton("사원조회");
	JButton btInsert = new JButton("입력");
	JButton btUpdate = new JButton("수정");
	JButton btDelete = new JButton("삭제");
	JPanel pBTN = new JPanel(); // FlowLayout
	
	JPanel pNorth = new JPanel(new BorderLayout());
	
	JTextArea ta = new JTextArea();
	JScrollPane taScrollPane = new JScrollPane(ta);
	
	EmpDao empDao = EmpDao.getInstance();
	
	private void setUI() {
		for(int i=0; i<attribute.length; i++) {
			lbl[i] = new JLabel(attribute[i]);
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER); // 라벨 중앙정렬
			tf[i] = new JTextField();
			pInput.add(lbl[i]);
			pInput.add(tf[i]);
		}
		
		ta.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		
		pNorth.add(pInput, BorderLayout.CENTER);
		pNorth.add(pBTN, BorderLayout.SOUTH);
		c.add(pNorth, BorderLayout.NORTH);
		c.add(taScrollPane, BorderLayout.CENTER);
	}
	
	public EmpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EMP");
		setSize(500, 600);
		
		setUI();
		setListerer();
		
		setVisible(true);
		
		//empDao.testConnection();
	}
	
	private void setListerer() {
		btSelect.addActionListener(this);
		btEmp.addActionListener(this);
		btInsert.addActionListener(this);
		btUpdate.addActionListener(this);
		btDelete.addActionListener(this);
		pBTN.add(btSelect);
		pBTN.add(btEmp);
		pBTN.add(btInsert);
		pBTN.add(btUpdate);
		pBTN.add(btDelete);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] sInput = new String[tf.length];
		for(int i=0; i<tf.length; i++) {
			 sInput[i] = tf[i].getText();
			 //System.out.println(sInput[i]);
		}
		if(e.getSource().equals(btSelect)) { // "전체조회"버튼
			List<EmpVo> list = empDao.selectAll();
			for(EmpVo empVo : list) {
				//System.out.println(l);
				int empno = empVo.getNo();
				String ename = empVo.getName();
				String job = empVo.getJob();
				int mgr = empVo.getMgr();
				Date hiredate = empVo.getHiredate();
				int sal = empVo.getSal();
				int comm = empVo.getComm();
				int deptno = empVo.getDeptno();
				
				String strEmp = empno + " | " +
						ename + " | " +
						job + " | " +
						mgr + " | " +
						hiredate + " | " +
						sal + " | " +
						comm + " | " +
						deptno;
				ta.append(strEmp+ "\n");
			}
			
		} else if(e.getSource().equals(btEmp)) { // "사원조회"버튼
			try {
				int empno = Integer.parseInt(tf[0].getText());
				EmpVo empVo = empDao.selectByEmpno(empno);
				tf[0].setText(String.valueOf(empVo.getNo()));
				tf[1].setText(String.valueOf(empVo.getName()));
				tf[2].setText(empVo.getJob());
				tf[3].setText(String.valueOf(empVo.getMgr()));
				tf[4].setText(empVo.getHiredate().toString());
				tf[5].setText(String.valueOf(empVo.getSal()));
				tf[6].setText(String.valueOf(empVo.getComm()));
				tf[7].setText(String.valueOf(empVo.getDeptno()));
			} catch(NumberFormatException ex) {
				ta.append("-----사번은 숫자로 입력해 주세요-----\n");
			}
		} else if(e.getSource().equals(btInsert)) { // "입력"버튼
			
			
			try {
				int empno = Integer.parseInt(tf[0].getText());
				String ename = tf[1].getText();
				String job = tf[2].getText();
				int mgr = Integer.parseInt(tf[3].getText());
				Date hiredate = null;//Date.valueOf(tf[4].getText());
				int sal = Integer.parseInt(tf[5].getText());
				int comm = Integer.parseInt(tf[6].getText());
				int deptno = Integer.parseInt(tf[7].getText());
				EmpVo empVo = new EmpVo(empno, ename, job, mgr, hiredate, sal, comm, deptno); 
			
				//System.out.println(empVo);
				boolean result = empDao.insertData(empVo);
				if(result == true) {
					ta.append("----- 데이터 입력 성공 -----\n");
				} else {
					ta.append("----- 데이터 입력 실패 -----\n");
				}
			} catch (NumberFormatException ex) {
				System.out.println("숫자로 변환할 수 없는 값이 있습니다.");
			}
		} else if(e.getSource().equals(btUpdate)) { // "수정"버튼
			try {
				int empno = Integer.parseInt(tf[0].getText());
				String ename = tf[1].getText();
				String job = tf[2].getText();
				int mgr = Integer.parseInt(tf[3].getText());
				Date hiredate = null;//Date.valueOf(tf[4].getText());
				int sal = Integer.parseInt(tf[5].getText());
				int comm = Integer.parseInt(tf[6].getText());
				int deptno = Integer.parseInt(tf[7].getText());
				EmpVo empVo = new EmpVo(empno, ename, job, mgr, hiredate, sal, comm, deptno); 
			
				//System.out.println(empVo);
				boolean result = empDao.updateDate(empVo);
				if(result == true) {
					ta.append("----- 데이터 수정 성공 -----\n");
				} else {
					ta.append("----- 데이터 수정 실패 -----\n");
				}
			} catch (NumberFormatException ex) {
				System.out.println("숫자로 변환할 수 없는 값이 있습니다.");
			}
			
		} else if(e.getSource().equals(btDelete)) { // "삭제"버튼
			String strEmpno = tf[0].getText();
			try {
				boolean result = empDao.deleteData(Integer.parseInt(strEmpno));
				if(result == true) {
					ta.append("-------데이터가 삭제되었습니다.-------\n");
				} else {
					ta.append("-------데이터가 삭제에 실패했습니다.-------\n");
				}
			} catch(NumberFormatException ex) {
				ta.append("-------사번은 숫자 값으로 입력해 주세요.-------\n");
			}
		}
	}
	
	
	public static void main(String[] args) {
		new EmpFrame();
	}

}
