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
	JLabel lblTitle = new JLabel("학생 관리");

	JPanel pnSearch = new JPanel();
	ButtonGroup rdoGroup = new ButtonGroup();
	JRadioButton rdoNameSearch = new JRadioButton("이름");
	JRadioButton rdoMajorSearch = new JRadioButton("전공");
	JTextField tfSearch = new JTextField(10);
	JButton btnSearch = new JButton("검색");
	
	JPanel pnButtons = new JPanel();
	JButton btnRegist = new JButton("등록하기");
	JButton btnModify = new JButton("수정하기");
	
	JPanel pnList = new JPanel();
	JTextArea taList = new JTextArea(22, 35);
	JScrollPane scrollList = new JScrollPane(taList);
	
	UIDao dao;
	ArrayList<UIVo> voList;
	public ListFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생 목록");
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

		pnSearch.setBorder(new TitledBorder(null, "검색", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnSearch.setToolTipText("검색어 없이 검색하면 전체 검색입니다.");
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
		if(e.getSource() == btnSearch) { // 검색버튼 클릭
			String search = tfSearch.getText();
			if(search.trim().equals("")) { // 전체 검색
				voList = dao.getSelectAll();
				taListPaint();
			} else {
				if(rdoNameSearch.isSelected()) { // 이름으로 검색
					voList = dao.getSelectName(search);
					taListPaint();
				} else if(rdoMajorSearch.isSelected()) { // 전공으로 검색
					voList = dao.getSelectMajor(search);
					taListPaint();
				}
			}
		} else if(e.getSource() == btnRegist) { // 등록버튼
			new RegistFrame();
		} else if(e.getSource() == btnModify) { // 수정버튼
			new ModifyFrame();
		}
		
	}
	
	// 조회 결과 출력하기
	private void taListPaint() {
		taList.setText("학번 | 이름 | 학년 | 성별 | 학과 | 점수\n------------------------------------------------------\n");
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
