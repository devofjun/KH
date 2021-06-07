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
public class RegistFrame extends JFrame implements ActionListener{
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
	JRadioButton rdoMan = new JRadioButton("����");
	JRadioButton rdoWoman = new JRadioButton("����");
	ButtonGroup grpGender = new ButtonGroup();
	
	JPanel pnButtons = new JPanel();
	JButton btnCheck = new JButton("�й� Ȯ��");
	JButton btnRegist = new JButton("���"); 

	UIDao dao;
	
	public RegistFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("�л� ���");
		
		dao = UIDao.getInstance();
		setUI();

		setSize(300, 400);
		setVisible(true);
	}

	private void setUI() {
		c.setLayout(null);

		pnInput.setBorder(new TitledBorder(null, "�л� ���� �Է�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInput.setBounds(10, 10, 260, 200);
		pnInput.setLayout(new GridLayout(0, 2, 0, 0));
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
		
		pnButtons.setBorder(new TitledBorder(null, "�л� ���� �Է�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnButtons.setBounds(40, 220, 200, 70);
		btnRegist.setEnabled(false);
		pnButtons.add(btnCheck);
		pnButtons.add(btnRegist);
		c.add(pnButtons);
		btnCheck.addActionListener(this);
		btnRegist.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ov = e.getSource();
		if(ov == btnCheck) { // �й� ��ȿ�� üũ
			String sno = tfSno.getText();
			boolean check = dao.checkSNO(sno);
			if(check) {
				JOptionPane.showMessageDialog(RegistFrame.this, "��� ������ �й��Դϴ�.");
				btnRegist.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(RegistFrame.this, "��� �� �� ���� �й��Դϴ�.");
			}
		} else if(ov == btnRegist) { // ���
			String sno = tfSno.getText();
			String sname = tfSname.getText();
			int syear = Integer.parseInt(tfSyear.getText());
			String gender = "";
			if(rdoMan.isSelected()) {
				gender = "��";
			} else if(rdoWoman.isSelected()) {
				gender = "��";
			}
			String major = tfMajor.getText();
			int score = Integer.parseInt(tfScore.getText());;
			
			UIVo vo = new UIVo(sno, sname, syear, gender, major, score);
			boolean result = dao.insertStudent(vo);
			if(result) {
				JOptionPane.showMessageDialog(RegistFrame.this, "��� ����");
			} else {
				JOptionPane.showMessageDialog(RegistFrame.this, "��� ����");
			}
		}
	}
}
