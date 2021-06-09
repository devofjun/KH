package uiswing;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ListFrame extends JFrame implements ActionListener{
	Container c = getContentPane();

	JPanel pnTitle = new JPanel();
	JLabel lblTitle = new JLabel("�л� ����");

	JPanel pnSearch = new JPanel();
	ButtonGroup rdoGroup = new ButtonGroup();
	JRadioButton rdoNameSearch = new JRadioButton("�̸�");
	JRadioButton rdoMajorSearch = new JRadioButton("����");
	JTextField tfSearch = new JTextField(10);
	JButton btnSearch = new JButton("�˻�");
	
	JPanel pnButtons = new JPanel();
	JButton btnRegist = new JButton("����ϱ�");
	JButton btnModify = new JButton("�����ϱ�");
	
	JPanel pnList = new JPanel();
	JTextArea taList = new JTextArea(22, 35);
	JScrollPane scrollList = new JScrollPane(taList);
	
	UIDao dao;
	ArrayList<UIVo> voList;
	public ListFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�л� ���");
		setSize(500, 720);
		setLocationRelativeTo(null);
		dao = UIDao.getInstance();
		voList = dao.getSelectAll();
		
		setUI();

		setVisible(true);
	}

	public void setUI() {
		c.setLayout(null);

		//pnTitle.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblTitle.setFont(new Font("Serif", Font.BOLD, 40));
		pnTitle.add(lblTitle);
		pnTitle.setBounds(140, 25, 200, 60);
		c.add(pnTitle);

		pnSearch.setBorder(new TitledBorder(null, "�˻�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnSearch.setToolTipText("�˻��� ���� �˻��ϸ� ��ü �˻��Դϴ�.");
		rdoNameSearch.setSelected(true);
		rdoGroup.add(rdoNameSearch);
		rdoGroup.add(rdoMajorSearch);
		pnSearch.add(rdoNameSearch);
		pnSearch.add(rdoMajorSearch);
		pnSearch.add(tfSearch);
		pnSearch.add(btnSearch);
		pnSearch.setBounds(40, 100, 400, 70);
		c.add(pnSearch);
		btnSearch.addActionListener(this);
		
		pnButtons.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnButtons.add(btnRegist);
		pnButtons.add(btnModify);
		pnButtons.setBounds(140, 190, 200, 40);
		c.add(pnButtons);
		btnRegist.addActionListener(this);
		btnModify.addActionListener(this);
		
		pnList.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		taList.setEditable(false);
		pnList.add(scrollList);
		pnList.setBounds(40, 250, 400, 415);
		c.add(pnList);
		
		voList = dao.getSelectAll();
		taListPaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e);
		if(e.getSource() == btnSearch) { // �˻���ư Ŭ��
			String search = tfSearch.getText();
			if(search.trim().equals("")) { // ��ü �˻�
				voList = dao.getSelectAll();
				taListPaint();
			} else {
				if(rdoNameSearch.isSelected()) { // �̸����� �˻�
					voList = dao.getSelectName(search);
					taListPaint();
				} else if(rdoMajorSearch.isSelected()) { // �������� �˻�
					voList = dao.getSelectMajor(search);
					taListPaint();
				}
			}
		} else if(e.getSource() == btnRegist) { // ��Ϲ�ư
			new RegistFrame();
		} else if(e.getSource() == btnModify) { // ������ư
			new ModifyFrame();
		}
		
	}
	
	// ��ȸ ��� ����ϱ�
	private void taListPaint() {
		taList.setText("�й� | �̸� | �г� | ���� | �а� | ����\n------------------------------------------------------\n");
		for(UIVo vo : voList) {
			String sno = vo.getSno();
			String sname = vo.getSname();
			int syear = vo.getSyear();
			String gender = vo.getGender();
			String major = vo.getMajor();
			int score = vo.getScore();
			taList.append(sno + " | " + sname + " | " + syear + " | " + gender + " | " + major + " | " + score + "\n");
		}
	}
}
