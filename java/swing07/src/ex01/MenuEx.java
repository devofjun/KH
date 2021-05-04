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
		setTitle("�޴���");
		setSize(300,300);
		
		setMenu();
		
		setVisible(true);
	}
	
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		// �޴��ٿ� ���� �޴��� (Screen, Edit, Source, Project, Run)
		JMenu mnuScreen = new JMenu("Screen");
		JMenu mnuEdit = new JMenu("Edit");
		JMenu mnuSource = new JMenu("Source");
		JMenu mnuProject = new JMenu("Project");
		JMenu mnuRun = new JMenu("Run");
		
		// Screen �޴��� �޴�������(Load, Hide, ReShow, Exit) �ޱ�
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miHide = new JMenuItem("Hide");
		JMenuItem miReShow = new JMenuItem("ReShow");
		JMenuItem miExit = new JMenuItem("Exit");
		
		
		mnuScreen.add(miLoad);
		mnuScreen.add(miHide);
		mnuScreen.addSeparator(); // �и���
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
