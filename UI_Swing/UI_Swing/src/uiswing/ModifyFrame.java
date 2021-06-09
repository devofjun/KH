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
public class ModifyFrame extends JFrame implements ActionListener {
	Container c = getContentPane();

	JPanel pnSearch = new JPanel();
	JTextField tfSearch = new JTextField(8);
	JButton btnSearch = new JButton("�ҷ�����");

	JPanel pnInput = new JPanel();
	JPanel pnGender = new JPanel();
	JLabel lblSno = new JLabel("�й�", JLabel.CENTER);
	JLabel lblSname = new JLabel("�̸�", JLabel.CENTER);
	JLabel lblSyear = new JLabel("�г�", JLabel.CENTER);
	JLabel lblGender = new JLabel("����", JLabel.CENTER);
	JLabel lblMajor = new JLabel("����", JLabel.CENTER);
	JLabel lblScore = new JLabel("����", JLabel.CENTER);
	JTextField tfSno = new JTextField();
	JTextField tfSname = new JTextField();
	JTextField tfSyear = new JTextField();
	JTextField tfMajor = new JTextField();
	JTextField tfScore = new JTextField();
	JRadioButton rdoMale = new JRadioButton("����");
	JRadioButton rdoFemale = new JRadioButton("����");
	ButtonGroup grpGender = new ButtonGroup();

	JPanel pnButtons = new JPanel();
	JCheckBox cbxContinue = new JCheckBox("���");
	JButton btnModify = new JButton("����");
	JButton btnDelete = new JButton("����");

	ValueManager vmgr = new ValueManager();
	UIDao dao;

	public ModifyFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("�л� ���� ����");
		setLocationRelativeTo(null);
		dao = UIDao.getInstance();
		setUI();

		setSize(300, 400);
		setVisible(true);
	}

	private void setUI() {
		c.setLayout(null);

		pnSearch.setBorder(new TitledBorder(null, "�й� �Է�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnSearch.setBounds(10, 10, 260, 70);
		pnSearch.add(tfSearch);
		pnSearch.add(btnSearch);
		c.add(pnSearch);
		btnSearch.addActionListener(this);

		pnInput.setBorder(new TitledBorder(null, "�л� ���� �Է�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInput.setBounds(10, 90, 260, 200);
		pnInput.setLayout(new GridLayout(0, 2, 0, 0));
		tfSno.setEditable(false);
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

		pnButtons.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnButtons.setBounds(30, 310, 230, 40);
		btnModify.setEnabled(false);
		btnDelete.setEnabled(false);
		cbxContinue.setEnabled(false);
		pnButtons.add(cbxContinue);
		pnButtons.add(btnModify);
		pnButtons.add(btnDelete);
		c.add(pnButtons);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == btnSearch) { // �������� ��ư
			String search = tfSearch.getText();
			if (!(dao.checkSNO(search))) {
				UIVo vo = dao.getStudentinfo(search);
				tfSno.setText(vo.getSno());
				tfSname.setText(vo.getSname());
				tfSyear.setText(vo.getSyear() + "");
				if (vo.getGender().equals("��")) {
					rdoMale.setSelected(true);
				} else {
					rdoFemale.setSelected(true);
				}
				tfMajor.setText(vo.getMajor());
				tfScore.setText(vo.getScore() + "");
				
				cbxContinue.setEnabled(true);
				btnModify.setEnabled(true);
				btnDelete.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� �й��Դϴ�.");
			}
		} else if (ob == btnModify) { // ���� ��ư
			String sno = tfSno.getText();
			String sname = tfSname.getText();
			String syear = tfSyear.getText();
			String gender = "";
			if (rdoMale.isSelected()) {
				gender = "��";
			} else if (rdoFemale.isSelected()) {
				gender = "��";
			}
			String major = tfMajor.getText();
			String score = tfScore.getText();

			// �� üũ�� ��������
			if (vmgr.modifyValuesCheck(sname, syear, gender, major, score)) {
				int intSyear = Integer.parseInt(syear);
				int intScore = Integer.parseInt(score);
				UIVo vo = new UIVo(sno, sname, intSyear, gender, major, intScore);
				boolean result = dao.updateStudent(vo);
				if (result) {
					JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
					if(cbxContinue.isSelected()) {
						tfSearch.setText("");
						tfSno.setText("");
						tfSname.setText("");
						tfSyear.setText("");
						tfMajor.setText("");
						tfScore.setText("");
						btnModify.setEnabled(false);
						btnDelete.setEnabled(false);
						cbxContinue.setEnabled(false);
					} else {
						ModifyFrame.this.dispose();						
					}
				} else {
					JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
				}
			}

		} else if (ob == btnDelete) { // ���� ��ư
			String sno = tfSno.getText();
			boolean result = dao.deleteStudent(sno);
			if (result) {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
				if(cbxContinue.isSelected()) {
					tfSearch.setText("");
					tfSno.setText("");
					tfSname.setText("");
					tfSyear.setText("");
					tfMajor.setText("");
					tfScore.setText("");
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
					cbxContinue.setEnabled(false);
				} else {
					ModifyFrame.this.dispose();						
				}
			} else {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
			}
		}
	}
}
