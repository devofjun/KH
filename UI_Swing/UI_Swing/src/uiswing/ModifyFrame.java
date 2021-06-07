package uiswing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ModifyFrame extends JFrame implements ActionListener{
	Container c = getContentPane();
	
	JPanel pnSearch = new JPanel();
	JTextField tfSearch = new JTextField(8);
	JButton btnSearch = new JButton("가져오기");
	
	JPanel pnInput = new JPanel();
	JPanel pnGender = new JPanel();
	JLabel lblSno = new JLabel("학번", JLabel.CENTER);
	JLabel lblSname = new JLabel("이름", JLabel.CENTER);
	JLabel lblSyear = new JLabel("학년", JLabel.CENTER);
	JLabel lblGender = new JLabel("성별", JLabel.CENTER);
	JLabel lblMajor = new JLabel("전공", JLabel.CENTER);
	JLabel lblScore = new JLabel("점수", JLabel.CENTER);
	JTextField tfSno = new JTextField();
	JTextField tfSname = new JTextField();
	JTextField tfSyear = new JTextField();
	JTextField tfMajor = new JTextField();
	JTextField tfScore = new JTextField();
	JRadioButton rdoMan = new JRadioButton("남자");
	JRadioButton rdoWoman = new JRadioButton("여자");
	ButtonGroup grpGender = new ButtonGroup();
	
	JPanel pnButtons = new JPanel();
	JButton btnModify = new JButton("수정");
	JButton btnDelete = new JButton("삭제"); 
	
	UIDao dao;
	
	public ModifyFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("학생 등록");
		dao = UIDao.getInstance();
		setUI();

		setSize(300, 400);
		setVisible(true);
	}

	private void setUI() {
		c.setLayout(null);
		
		pnSearch.setBorder(new TitledBorder(null, "학번 입력", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnSearch.setBounds(10, 10, 260, 70);
		pnSearch.add(tfSearch);
		pnSearch.add(btnSearch);
		c.add(pnSearch);
		btnSearch.addActionListener(this);

		pnInput.setBorder(new TitledBorder(null, "학생 정보 입력", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInput.setBounds(10, 90, 260, 200);
		pnInput.setLayout(new GridLayout(0, 2, 0, 0));
		tfSno.setEditable(false);
		grpGender.add(rdoMan);
		grpGender.add(rdoWoman);
		pnGender.add(rdoMan);
		pnGender.add(rdoWoman);
		pnInput.add(lblSno);
		pnInput.add(tfSno);
		pnInput.add(lblSname);
		pnInput.add(tfSname);
		pnInput.add(lblSyear);
		pnInput.add(tfSyear);
		pnInput.add(lblGender);
		pnInput.add(pnGender);
		pnInput.add(lblMajor);
		pnInput.add(tfMajor);
		pnInput.add(lblScore);
		pnInput.add(tfScore);		
		c.add(pnInput);
		
		pnButtons.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnButtons.setBounds(40, 310, 200, 40);
		//btnModify.setEnabled(false);
		pnButtons.add(btnModify);
		pnButtons.add(btnDelete);
		c.add(pnButtons);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == btnSearch) { // 학번 검색 버튼
			String search = tfSearch.getText();
			UIVo vo = dao.getStudentinfo(search);
			tfSno.setText(vo.getSno());
			tfSname.setText(vo.getSname());
			tfSyear.setText(vo.getSyear()+"");
			if(vo.getGender().equals("남")) {
				rdoMan.setSelected(true);
			} else {
				rdoWoman.setSelected(true);
			}
			tfMajor.setText(vo.getMajor());
			tfScore.setText(vo.getScore()+"");
		} else if(ob == btnModify) { // 수정 버튼
			String sno = tfSno.getText();
			String sname = tfSname.getText();
			int syear = Integer.parseInt(tfSyear.getText());
			String gender = "";
			if(rdoMan.isSelected()) {
				gender = "남";
			} else if(rdoWoman.isSelected()) {
				gender = "여";
			}
			String major = tfMajor.getText();
			int score = Integer.parseInt(tfScore.getText());;
			
			UIVo vo = new UIVo(sno, sname, syear, gender, major, score);
			boolean result = dao.updateStudentInfo(vo);
			if(result) {
				JOptionPane.showMessageDialog(ModifyFrame.this, "수정 성공");
			} else {
				JOptionPane.showMessageDialog(ModifyFrame.this, "수정 실패");
			}
			
		} else if(ob == btnDelete) { // 삭제 버튼
			String sno = tfSno.getText();
			boolean result = dao.deleteStudent(sno);
			if(result) {
				JOptionPane.showMessageDialog(ModifyFrame.this, "삭제 성공");
			} else {
				JOptionPane.showMessageDialog(ModifyFrame.this, "삭제 실패");
			}
		}
	}
}
