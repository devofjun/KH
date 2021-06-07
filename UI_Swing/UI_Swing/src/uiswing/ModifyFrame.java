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
	JButton btnSearch = new JButton("��������");
	
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
	JButton btnModify = new JButton("����");
	JButton btnDelete = new JButton("����"); 
	
	UIDao dao;
	
	public ModifyFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("�л� ���");
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
		if(ob == btnSearch) { // �й� �˻� ��ư
			String search = tfSearch.getText();
			UIVo vo = dao.getStudentinfo(search);
			tfSno.setText(vo.getSno());
			tfSname.setText(vo.getSname());
			tfSyear.setText(vo.getSyear()+"");
			if(vo.getGender().equals("��")) {
				rdoMan.setSelected(true);
			} else {
				rdoWoman.setSelected(true);
			}
			tfMajor.setText(vo.getMajor());
			tfScore.setText(vo.getScore()+"");
		} else if(ob == btnModify) { // ���� ��ư
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
			boolean result = dao.updateStudentInfo(vo);
			if(result) {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
			} else {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
			}
			
		} else if(ob == btnDelete) { // ���� ��ư
			String sno = tfSno.getText();
			boolean result = dao.deleteStudent(sno);
			if(result) {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
			} else {
				JOptionPane.showMessageDialog(ModifyFrame.this, "���� ����");
			}
		}
	}
}
