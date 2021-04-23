package number.puzzle;

import java.awt.Container;
import java.awt.GridBagLayout;
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
public class JoinFrame extends JFrame implements ActionListener{
	Container c = getContentPane();
	
	JPanel pnl = new JPanel();
	JLabel[] lbl = new JLabel[4];
	JTextField[] tf = new JTextField[4];
	JButton btSubmit = new JButton("완료");
	JButton btCancle = new JButton("닫기");
	
	UserDao userDao = UserDao.getInstance();
	
	public JoinFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원가입");
		setSize(200,200);
		
		setUI();
		
		setVisible(false);
	}
	
	public void vsbTrue() {
		setVisible(true);
	}
	
	public void setUI() {
		String[] str = {"아이디","패스워드","패스워드확인","이름"};
		pnl.setLayout(new GridLayout(0,2));
		for(int i=0; i<4; i++) {
			lbl[i] = new JLabel(str[i]);
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			tf[i] = new JTextField(7);
			pnl.add(lbl[i]);
			pnl.add(tf[i]);
		}
		btSubmit.addActionListener(this);
		btCancle.addActionListener(this);
		pnl.add(btSubmit);
		pnl.add(btCancle);
		c.add(pnl);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		UserVo userVo = new UserVo();
		// 완료 버튼
		if(e.getSource().equals(btSubmit)) {
			String uid = tf[0].getText();
			String upw;
			if(tf[1].getText().equals(tf[2].getText())) {
				upw = tf[1].getText();
			} else {
				System.out.println("패스워드가 다릅니다.");
				return;
			}
			String uname = tf[3].getText();
			userVo.setUid(uid);
			userVo.setUpw(upw);
			userVo.setUname(uname);
			boolean up = userDao.signup(userVo);
			if(up) {
				System.out.println("등록되었습니다.");
				this.dispose();
			} else {
				System.out.println("회원가입이 되지 않았습니다.");
			}
		}
		// 닫기버튼
		else if(e.getSource().equals(btCancle)) {
			this.dispose();
		}
	}
/*	
	public static void main(String[] args) {
		new JoinFrame();
	}
*/
}
