package ex03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuActionEvent2 extends JFrame implements ActionListener{
	
	Container c = getContentPane();
	JLabel lbl = new JLabel("Hello");
	
	public MenuActionEvent2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴이벤트");
		setSize(500, 400);
		
		setMenu();
		//레이블 설정
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl.setOpaque(true);
//		lbl.setBackground(Color.YELLOW);
		c.add(lbl);
		
		setVisible(true);
	}
	
	private void setMenu() {
		// 메뉴바 생성
		JMenuBar menuBar = new JMenuBar();
		// 메뉴 생성
		JMenu textMenu = new JMenu("Text");
		// 메뉴 아이템
		String[] strMenu = {"Color","Font","Top","Bottom"};
		JMenuItem[] mi = new JMenuItem[strMenu.length];
		for(int i=0; i<strMenu.length; i++) {
			mi[i] = new JMenuItem(strMenu[i]);
			mi[i].addActionListener(this);
			textMenu.add(mi[i]);
		}
		
		// 메뉴바에 추가
		menuBar.add(textMenu);
		// 메뉴바를 프레임에 설정함
		setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MenuActionEvent2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "Color":
			lbl.setForeground(Color.BLUE);
			break;
		case "Font":
			lbl.setFont(new Font("맑은 고딕", Font.ITALIC, 30));
			break;
		case "Top":
			lbl.setVerticalAlignment(SwingConstants.TOP); // 글자 배치만 바꿀때
			/* 컨테이너 배치를 다시 할때 이렇게 할 수도 있다.
			lbl.setVisible(false);
			c.add(lbl, BorderLayout.NORTH);
			lbl.setVisible(true);
			*/
			validate();
			break;
		case "Bottom":
			lbl.setVerticalAlignment(SwingConstants.BOTTOM); // 글자 배치만 바꿀때
			/* 컨테이너 배치를 다시 할 때 이렇게 하는게 좋을듯하다.
			c.add(lbl, BorderLayout.SOUTH);
			c.validate();
			//c.repaint(); 이거하면 안됨
			*/
			break;
		}
	}
}
