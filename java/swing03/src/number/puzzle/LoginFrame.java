package number.puzzle;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener{
	Container c = getContentPane();
	
	JPanel pnl = new JPanel();
	JLabel lID = new JLabel("아이디");
	JLabel lPW = new JLabel("패스워드");
	JTextField tfID = new JTextField(7);
	JTextField tfPW = new JTextField(7);
	JButton btSignin = new JButton("로그인");
	JButton btSignup = new JButton("사용자등록");	 
	
	JoinFrame joinFrame = new JoinFrame();
	
	
	UserDao userDao = UserDao.getInstance();
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		setSize(300, 130);
		
		setUI();
		
		setVisible(true);
	}
	
	public void setUI() {
		
		lID.setHorizontalAlignment(SwingConstants.CENTER);
		lPW.setHorizontalAlignment(SwingConstants.CENTER);
		pnl.setLayout(new GridLayout(0, 2));
		pnl.add(lID);
		pnl.add(tfID);
		pnl.add(lPW);
		pnl.add(tfPW);
		pnl.add(btSignin);
		pnl.add(btSignup);
		
		btSignin.addActionListener(this);
		btSignup.addActionListener(this);
		
		c.add(pnl);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//로그인
		if(e.getSource().equals(btSignin)) {
			String sID = tfID.getText();
			String sPW = tfPW.getText();
			UserVo userVo = userDao.signin(sID, sPW);
			if(userVo == null) {
				System.out.println("로그인 실패");
			} else {
				System.out.println("로그인 성공");
				System.out.println("접속중인ID:"+userVo.getUid());
				new GameFrame(userVo);
				this.dispose();
			}
		}
		//회원가입
		else if(e.getSource().equals(btSignup)) {
			joinFrame.vsbTrue();
		}
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}

}
