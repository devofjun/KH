package study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalcFraction extends JFrame implements ActionListener{
	// 컨테이너
	Container c = getContentPane();
	// 빈레이블 + 선레이블
	//JLabel lblSpace = new JLabel();
	//JLabel lblLine = new JLabel("----------");
	// 좌항
	JTextField LNumerator = new JTextField(); // 분자 
	JTextField LDenominator = new JTextField(); // 분모
	JTextField LNumber = new JTextField(); // 자연수
	JPanel pLTerm = new JPanel(new GridLayout(0, 2));
	// 우항
	JTextField RNumerator = new JTextField(); // 분자 
	JTextField RDenominator = new JTextField(); // 분모
	JTextField RNumber = new JTextField(); // 자연수
	JPanel pRTerm = new JPanel(new GridLayout(0, 2));
	// 부호
	JButton btnSign = new JButton("+");
	JPanel pSign = new JPanel();
	// 식이 들어갈 패널
	JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
	// -----------------------------------------------------------
	// 등호
	JButton btnEquals = new JButton("=");
	JPanel pEquals = new JPanel();
	// 결과분수
	JTextField Numerator = new JTextField(); // 분자 
	JTextField Denominator = new JTextField(); // 분모
	JTextField Number = new JTextField(); // 자연수
	JPanel pResult = new JPanel(new GridLayout(0, 2));
	// 결과가 들어갈 패널
	JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	public CalcFraction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("분수계산기");
		setSize(600,200);
		
		setUI();
		
		setVisible(true);
	}
	
	private void setUI() {
		// 좌항분수 세팅
		pLTerm.add(new JLabel());
		pLTerm.add(LNumerator);
		pLTerm.add(LNumber);
		pLTerm.add(new JLabel("-----------------------------"));
		pLTerm.add(new JLabel());
		pLTerm.add(LDenominator);
		// 부호 버튼
		btnSign.addActionListener(this);
		pSign.add(btnSign);
		// 우항분수 세팅
		pRTerm.add(new JLabel());
		pRTerm.add(RNumerator);
		pRTerm.add(RNumber);
		pRTerm.add(new JLabel("-----------------------------"));
		pRTerm.add(new JLabel());
		pRTerm.add(RDenominator);
		// 계산식 셋팅
		pNorth.add(pLTerm);
		pNorth.add(pSign);
		pNorth.add(pRTerm);
		c.add(pNorth,BorderLayout.CENTER);
		// 결과식 세팅
		btnEquals.addActionListener(this);
		pEquals.add(btnEquals);
		pResult.add(new JLabel());
		pResult.add(Numerator);
		pResult.add(Number);
		pResult.add(new JLabel("-----------------------------"));
		pResult.add(new JLabel());
		pResult.add(Denominator);
		pSouth.add(pEquals);
		pSouth.add(pResult);
		c.add(pSouth, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new CalcFraction();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSign)) {
			switch (btnSign.getText()) {
			case "+":
				btnSign.setText("-");
				break;
			case "-":
				btnSign.setText("*");
				break;
			case "*":
				btnSign.setText("/");
				break;
			case "/":
				btnSign.setText("+");
				break;
			}
		} else if(e.getSource().equals(btnEquals)) {
			calculation();
		}
	}
	
	public void calculation() {
		int LNumb = Integer.parseInt(LNumber.getText()); // 자연수 
		int LNume = Integer.parseInt(LNumerator.getText()); // 분자
		int LDeno = Integer.parseInt(LDenominator.getText()); // 분모
		int RNumb = Integer.parseInt(RNumber.getText()); // 자연수 
		int RNume = Integer.parseInt(RNumerator.getText()); // 분자
		int RDeno = Integer.parseInt(RDenominator.getText()); // 분모
		
		if(LNumb != 0) { // 좌항 자연수가 있을때
			LNume = LNume + (LNumb * LDeno); // 분모와 자연수를 곱하여 분자에 더한다.
		}
		if(RNumb != 0) { // 우항 자연수가 있을때
			RNume = RNume + (RNumb * RDeno); // 분모와 자연수를 곱하여 분자에 더한다.
		}
		if() // 분모를 같게 한다.
	}
}
