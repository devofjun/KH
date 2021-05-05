package ex02;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class MenuActionEventEx extends JFrame implements ActionListener{

	Container c = getContentPane();
	JLabel label = new JLabel();
	
	public MenuActionEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴바");
		setSize(300,300);
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(label);
		setMenu();
		
		setVisible(true);
	}
	
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		// 메뉴바에 붙일 메뉴들 (Screen, Edit, Source, Project, Run)
		JMenu mnuScreen = new JMenu("Screen");
		JMenu mnuEdit = new JMenu("Edit");
		JMenu mnuSource = new JMenu("Source");
		JMenu mnuProject = new JMenu("Project");
		JMenu mnuRun = new JMenu("Run");
		
		// Screen 메뉴에 메뉴아이템(Load, Hide, ReShow, Exit) 달기
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miHide = new JMenuItem("Hide");
		JMenuItem miReShow = new JMenuItem("ReShow");
		JMenuItem miExit = new JMenuItem("Exit");	
		miLoad.addActionListener(this);
		miHide.addActionListener(this);
		miReShow.addActionListener(this);
		miExit.addActionListener(this);
		
		// "Screen"항목메뉴안에 메뉴 넣기
		mnuScreen.add(miLoad);
		mnuScreen.add(miHide);
		mnuScreen.addSeparator(); // 분리선
		mnuScreen.add(miReShow);
		mnuScreen.add(miExit);
		
		// 각 항목의 메뉴를 메뉴바에 넣기
		menuBar.add(mnuScreen);
		menuBar.add(mnuEdit);
		menuBar.add(mnuSource);
		menuBar.add(mnuProject);
		menuBar.add(mnuRun);
		// 메뉴 넣기
		setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MenuActionEventEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 발생한 컴포넌트의 Command String을 받아온다.
		String command = e.getActionCommand();
		
		// Screen 메뉴에 메뉴아이템(Load, Hide, ReShow, Exit) 달기
		switch(command){
		case "Load":
			System.out.println(1);
			Icon icon = label.getIcon();
			if(icon == null) {
				label.setIcon(new ImageIcon("images/image0.jpg"));
			}
			label.setVisible(true);
			break;
		case "Hide":
			System.out.println(2);
			label.setVisible(false);
			break;
		case "ReShow":
			label.setVisible(true);
			System.out.println(3);
			break;
		case "Exit":
			System.exit(0);
			break;
		}
		
	}
}
