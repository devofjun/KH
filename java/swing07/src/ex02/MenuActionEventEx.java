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
		setTitle("�޴���");
		setSize(300,300);
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(label);
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
		miLoad.addActionListener(this);
		miHide.addActionListener(this);
		miReShow.addActionListener(this);
		miExit.addActionListener(this);
		
		// "Screen"�׸�޴��ȿ� �޴� �ֱ�
		mnuScreen.add(miLoad);
		mnuScreen.add(miHide);
		mnuScreen.addSeparator(); // �и���
		mnuScreen.add(miReShow);
		mnuScreen.add(miExit);
		
		// �� �׸��� �޴��� �޴��ٿ� �ֱ�
		menuBar.add(mnuScreen);
		menuBar.add(mnuEdit);
		menuBar.add(mnuSource);
		menuBar.add(mnuProject);
		menuBar.add(mnuRun);
		// �޴� �ֱ�
		setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MenuActionEventEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ�� �߻��� ������Ʈ�� Command String�� �޾ƿ´�.
		String command = e.getActionCommand();
		
		// Screen �޴��� �޴�������(Load, Hide, ReShow, Exit) �ޱ�
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
