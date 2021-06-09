package uiswing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class RegistFrame extends JFrame implements ActionListener {
	Container c = getContentPane();

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
	JRadioButton rdoMale = new JRadioButton("남자");
	JRadioButton rdoFemale = new JRadioButton("여자");
	ButtonGroup grpGender = new ButtonGroup();

	JPanel pnButtons = new JPanel();
	JCheckBox cbxContinue = new JCheckBox("계속하기");
	JCheckBox cbxReset = new JCheckBox("비우기");
	JButton btnCheck = new JButton("학번 확인");
	JButton btnRegist = new JButton("등록");

	ValueManager vmng = new ValueManager();
	UIDao dao;

	public RegistFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("학생 등록");
		setLocationRelativeTo(null);
		dao = UIDao.getInstance();
		setUI();

		setSize(300, 400);
		setVisible(true);
	}

	private void setUI() {
		c.setLayout(null);

		// 학생 정보 입력칸
		pnInput.setBorder(new TitledBorder(null, "학생 정보 입력", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInput.setBounds(10, 10, 260, 200);
		pnInput.setLayout(new GridLayout(0, 2, 0, 0));
		grpGender.add(rdoMale);
		grpGender.add(rdoFemale);
		pnGender.add(rdoMale);
		pnGender.add(rdoFemale);
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

		// 학번 확인 + 등록 버튼
		pnButtons.setBorder(new TitledBorder(null, "학생 정보 입력", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnButtons.setBounds(40, 220, 200, 110);
		btnRegist.setEnabled(false);
		cbxContinue.setEnabled(false);
		cbxReset.setEnabled(false);
		pnButtons.add(cbxContinue);
		pnButtons.add(cbxReset);
		pnButtons.add(btnCheck);
		pnButtons.add(btnRegist);
		c.add(pnButtons);
		btnCheck.addActionListener(this);
		btnRegist.addActionListener(this);
		cbxContinue.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnCheck) { // 학번 유효성 체크
			String sno = tfSno.getText();
			// 학번 체크
			if (sno.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "학번을 입력해주세요.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			} else if (sno.replace(" ","").length() != sno.length()) {
				JOptionPane.showMessageDialog(null, "학번에 빈칸은 넣을 수 없습니다.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			} else if (sno.length() != 8) {
				JOptionPane.showMessageDialog(null, "학번은 8자리여야 합니다.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			} else if (dao.checkSNO(sno)) {
				JOptionPane.showMessageDialog(RegistFrame.this, "사용 가능한 학번입니다.");
				btnRegist.setEnabled(true);
				cbxContinue.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(RegistFrame.this, "중복되거나 사용 할 수 없는 학번입니다.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			}
		} else if (obj == btnRegist) { // 등록
			String sno = tfSno.getText();
			String sname = tfSname.getText();
			String syear = tfSyear.getText();
			String gender = "";
			if (rdoMale.isSelected()) {
				gender = "남";
			} else if (rdoFemale.isSelected()) {
				gender = "여";
			}
			String major = tfMajor.getText();
			String score = tfScore.getText();

			// 다시한번 값을 체크하고 등록한다
			if (vmng.valuesCheck(sno, sname, syear, gender, major, score)) {
				int intSyear = Integer.parseInt(syear);
				int intScore = Integer.parseInt(score);
				UIVo vo = new UIVo(sno, sname, intSyear, gender, major, intScore);
				boolean result = dao.insertStudent(vo);
				if (result) {
					JOptionPane.showMessageDialog(RegistFrame.this, "등록 성공");
					if(cbxContinue.isSelected()) {
						if(cbxReset.isSelected()) {
							tfSno.setText("");
							tfSname.setText("");
							tfSyear.setText("");
							rdoMale.setSelected(false);
							rdoFemale.setSelected(false);
							tfMajor.setText("");
							tfScore.setText("");
							btnRegist.setEnabled(false);
						} else {
							btnRegist.setEnabled(false);
						}
					} else {
						RegistFrame.this.dispose();						
					}
				} else {
					JOptionPane.showMessageDialog(RegistFrame.this, "등록 실패");
				}
			}
		} else if(obj == cbxContinue) {
			if(cbxContinue.isSelected()) {
				cbxReset.setEnabled(true);
			} else {
				cbxReset.setEnabled(false);
			}
		}
	}
}
