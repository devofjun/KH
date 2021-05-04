package ex01;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuEx extends JFrame{
	Container c = getContentPane();
	
	
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴바");
		setSize(300,300);
		
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
		
		
		mnuScreen.add(miLoad);
		mnuScreen.add(miHide);
		mnuScreen.addSeparator(); // 분리선
		mnuScreen.add(miReShow);
		mnuScreen.add(miExit);
		
		menuBar.add(mnuScreen);
		menuBar.add(mnuEdit);
		menuBar.add(mnuSource);
		menuBar.add(mnuProject);
		menuBar.add(mnuRun);
		
		setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}
}
