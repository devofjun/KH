package number.puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener{
	Container c = getContentPane();
	// 상단
	JPanel pNorth = new JPanel();
	JLabel lblInput = new JLabel("입력");
	JTextField tfInput = new JTextField(3);
	JButton btChk = new JButton("확인");
	JTextField tfWinner = new JTextField(7);
	JLabel lblRecord = new JLabel("기록");
	JTextField tfRecord = new JTextField(10);
	JButton btNewGame = new JButton("새게임");
	
	// 중단
	JTextArea ta = new JTextArea();
	JScrollPane taScroll = new JScrollPane(ta);
	
	// 하단
	JPanel pSouth = new JPanel();
	JLabel lblLife = new JLabel("남은횟수"); 
	JTextField tfLife = new JTextField("♥♥♥♥♥"); 
	
	GameManager GM = GameManager.getInstance();
	
	UserVo userVo;
	
	public GameFrame(UserVo userVo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("1~100 숫자 맞추기");
		setSize(600,250);
		
		setUI();
		
		setVisible(true);
		this.userVo = userVo;
	}
	
	private void setUI() {
		//pNorth.setLayout();
		tfRecord.setEnabled(false);
		tfWinner.setEnabled(false);
		tfWinner.setText(GM.getWinnerID());
		tfRecord.setText(String.valueOf(GM.getWinnerScore()));
		pNorth.setBackground(Color.YELLOW);
		pNorth.add(lblInput);
		pNorth.add(tfInput);
		pNorth.add(btChk);
		pNorth.add(tfWinner);
		pNorth.add(lblRecord);
		pNorth.add(tfRecord);
		pNorth.add(btNewGame);
		btChk.addActionListener(this);
		btNewGame.addActionListener(this);
		tfInput.addActionListener(this);
		
		ta.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		ta.setText("1~100사이의 숫자를 맞추세요.\n");
		ta.append("======================\n");
		
		pSouth.setBackground(Color.CYAN);
		pSouth.add(lblLife);
		pSouth.add(tfLife);
		
		c.add(pNorth,BorderLayout.NORTH);
		c.add(taScroll,BorderLayout.CENTER);
		c.add(pSouth,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 확인 버튼
		if(obj == tfInput || obj == btChk) { 
			int inNum = 0;
			int result = -1;
			
			try {
				 inNum = Integer.parseInt(tfInput.getText());				
				 result = GM.check(inNum);
				 if(result==1 && GM.lifeCheck()) { // 작을때
					 GM.subLife();
					 String l = "";
					 for(int i=0; i<GM.getLife(); i++) {
						 l+="♥";
					 }
					 tfLife.setText(l);
					 ta.append("Up\n");
				 } else if(result==2 && GM.lifeCheck()) { // 클때
					 GM.subLife();
					 String l = "";
					 for(int i=0; i<GM.getLife(); i++) {
						 l+="♥";
					 }
					 tfLife.setText(l);
					 ta.append("Down\n");
				 } else if(result==0 && GM.lifeCheck()) { // 같을때
					 ta.append("맞췄습니다! 당신의 기록은 "+GM.getScore()+"입니다.");
					 GM.saveScore(userVo);
					 tfWinner.setText(GM.getWinnerID());
					 tfRecord.setText(String.valueOf(GM.getWinnerScore()));
				 }
				 if(!GM.lifeCheck()){
					 ta.append("기회를 모두 소진했습니다.\n");
					 btChk.setEnabled(false);
					 tfInput.setEnabled(false);
				 }
			} catch(NumberFormatException ex) {
				ta.append("숫자를 입력하세요.\n");
			}
			tfInput.setText("");
		}
		// 새게임 버튼
		else if(e.getSource().equals(btNewGame)) {
			tfInput.setText("");
			ta.setText("1~100사이의 숫자를 맞추세요.\n");
			ta.append("======================\n");
			GM.gameStart();
			String l = "";
			for(int i=0; i<GM.getLife(); i++) {
				l+="♥";
			}
			btChk.setEnabled(true);
			tfInput.setEnabled(true);
			tfLife.setText(l);
		}
	}
	/*
	public static void main(String[] args) {
		new GameFrame();
	}
	*/
}
