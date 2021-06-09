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
	JCheckBox cbxContinue = new JCheckBox("����ϱ�");
	JCheckBox cbxReset = new JCheckBox("����");
	JButton btnCheck = new JButton("�й� Ȯ��");
	JButton btnRegist = new JButton("���");

	ValueManager vmng = new ValueManager();
	UIDao dao;

	public RegistFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("�л� ���");
		setLocationRelativeTo(null);
		dao = UIDao.getInstance();
		setUI();

		setSize(300, 400);
		setVisible(true);
	}

	private void setUI() {
		c.setLayout(null);

		// �л� ���� �Է�ĭ
		pnInput.setBorder(new TitledBorder(null, "�л� ���� �Է�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		// �й� Ȯ�� + ��� ��ư
		pnButtons.setBorder(new TitledBorder(null, "�л� ���� �Է�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		if (obj == btnCheck) { // �й� ��ȿ�� üũ
			String sno = tfSno.getText();
			// �й� üũ
			if (sno.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			} else if (sno.replace(" ","").length() != sno.length()) {
				JOptionPane.showMessageDialog(null, "�й��� ��ĭ�� ���� �� �����ϴ�.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			} else if (sno.length() != 8) {
				JOptionPane.showMessageDialog(null, "�й��� 8�ڸ����� �մϴ�.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			} else if (dao.checkSNO(sno)) {
				JOptionPane.showMessageDialog(RegistFrame.this, "��� ������ �й��Դϴ�.");
				btnRegist.setEnabled(true);
				cbxContinue.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(RegistFrame.this, "�ߺ��ǰų� ��� �� �� ���� �й��Դϴ�.");
				btnRegist.setEnabled(false);
				cbxContinue.setEnabled(false);
			}
		} else if (obj == btnRegist) { // ���
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

			// �ٽ��ѹ� ���� üũ�ϰ� ����Ѵ�
			if (vmng.valuesCheck(sno, sname, syear, gender, major, score)) {
				int intSyear = Integer.parseInt(syear);
				int intScore = Integer.parseInt(score);
				UIVo vo = new UIVo(sno, sname, intSyear, gender, major, intScore);
				boolean result = dao.insertStudent(vo);
				if (result) {
					JOptionPane.showMessageDialog(RegistFrame.this, "��� ����");
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
					JOptionPane.showMessageDialog(RegistFrame.this, "��� ����");
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
