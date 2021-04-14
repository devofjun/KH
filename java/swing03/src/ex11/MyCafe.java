package ex11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyCafe extends JFrame implements ActionListener{
	Container c = getContentPane();
	// 라디오 버튼 3개
	JRadioButton[] radios = new JRadioButton[3];
	ButtonGroup group = new ButtonGroup();
	// 상단텍스트필드
	JTextField tfInput = new JTextField();
	JTextField tfChange = new JTextField();
	// 중간텍스트필드
	JTextField[] tfWon = new JTextField[6];
	// 상단레이블
	JLabel lblInput = new JLabel("투입");
	JLabel lblChange = new JLabel("거스름돈");
	// 중간레이블
	JLabel[] lblWon = new JLabel[6];
	String[] won = {"5천원", "1천원", "500원", "100원", "50원", "10원"};
	// 중간 체크박스
	JCheckBox[] chkWon = new JCheckBox[6];
	// 화폐단위, 가격
	static final int[] WON = {5000, 1000, 500, 100, 50, 10};
	static final int[] PRICES = {1550,2320,3630};
	// 하단레이블
	JLabel lblPrice = new JLabel("에스프레소:"+PRICES[0]+"원 | 아메리카노:"+PRICES[1]+"원 | 카페라떼:"+PRICES[2]+"원");
	// 버튼
	JButton btn = new JButton("주문");
	
	public MyCafe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("커피계산");
		
		setUI();
		
		setSize(500, 500);
		setVisible(true);
	}
	
	private void setUI() {
		// 상단 메뉴 라디오 버튼
		radios[0] = new JRadioButton("에스프레소");
		radios[1] = new JRadioButton("아메리카노");
		radios[2] = new JRadioButton("카페라떼");
		group.add(radios[0]);
		group.add(radios[1]);
		group.add(radios[2]);
		JPanel topMenuPnl = new JPanel();
		topMenuPnl.add(radios[0]);
		topMenuPnl.add(radios[1]);
		topMenuPnl.add(radios[2]);
		radios[0].setSelected(true);
		
		// 투입, 주문, 거스름돈
		JPanel inputPnl = new JPanel();
		inputPnl.setLayout(new GridLayout(1, 5));
		btn.addActionListener(this);
		inputPnl.add(lblInput);
		inputPnl.add(tfInput);
		inputPnl.add(btn);
		inputPnl.add(lblChange);
		inputPnl.add(tfChange);
		
		// 중간 거스름돈 
		JPanel wonPnl = new JPanel();
		wonPnl.setLayout(new GridLayout(0, 3, 10, 40));
		for(int i=0; i<lblWon.length; ++i) {
			lblWon[i] = new JLabel(won[i]);
			wonPnl.add(lblWon[i]);
			tfWon[i] = new JTextField();
			wonPnl.add(tfWon[i]);
			chkWon[i] = new JCheckBox();
			chkWon[i].setSelected(true);
			wonPnl.add(chkWon[i]);
		}
		
		// 하단 가격표
		JPanel pricePnl = new JPanel();
		pricePnl.add(lblPrice);
		
		JPanel centerPnl = new JPanel();
		centerPnl.setLayout(new BorderLayout());
		centerPnl.add(inputPnl,BorderLayout.NORTH);
		centerPnl.add(wonPnl,BorderLayout.CENTER);
		
		c.add(topMenuPnl,BorderLayout.NORTH);
		c.add(centerPnl,BorderLayout.CENTER);
		c.add(pricePnl,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 거스름돈 출력
		int price = 0;
		if(radios[0].isSelected()) {
			price = PRICES[0];
		} else if(radios[1].isSelected()) {
			price = PRICES[1];
		} else if(radios[2].isSelected()) {
			price = PRICES[2];
		} else {
			System.out.println("ERROR");
		}
		int inputWon = Integer.parseInt(tfInput.getText());
		int change = inputWon - price;
		tfChange.setText(String.valueOf(change));
		
		// 거스름돈 단위별로 필요한 갯수 출력
		int num = 0;
		
		for(int i=0; i<tfWon.length;i++) {
			if(!chkWon[i].isSelected()) {
				continue;
			}
			num = change / WON[i];
			if(num != 0) {
				change %= WON[i];
				//change = change - (WON[i] * num);
			}
			tfWon[i].setText(String.valueOf(num));
		}
	}

	public static void main(String[] args) {
		new MyCafe();
	}

}
