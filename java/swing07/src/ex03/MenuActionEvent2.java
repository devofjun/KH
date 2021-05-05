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
		setTitle("�޴��̺�Ʈ");
		setSize(500, 400);
		
		setMenu();
		//���̺� ����
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl.setOpaque(true);
//		lbl.setBackground(Color.YELLOW);
		c.add(lbl);
		
		setVisible(true);
	}
	
	private void setMenu() {
		// �޴��� ����
		JMenuBar menuBar = new JMenuBar();
		// �޴� ����
		JMenu textMenu = new JMenu("Text");
		// �޴� ������
		String[] strMenu = {"Color","Font","Top","Bottom"};
		JMenuItem[] mi = new JMenuItem[strMenu.length];
		for(int i=0; i<strMenu.length; i++) {
			mi[i] = new JMenuItem(strMenu[i]);
			mi[i].addActionListener(this);
			textMenu.add(mi[i]);
		}
		
		// �޴��ٿ� �߰�
		menuBar.add(textMenu);
		// �޴��ٸ� �����ӿ� ������
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
			lbl.setFont(new Font("���� ���", Font.ITALIC, 30));
			break;
		case "Top":
			lbl.setVerticalAlignment(SwingConstants.TOP); // ���� ��ġ�� �ٲܶ�
			/* �����̳� ��ġ�� �ٽ� �Ҷ� �̷��� �� ���� �ִ�.
			lbl.setVisible(false);
			c.add(lbl, BorderLayout.NORTH);
			lbl.setVisible(true);
			*/
			validate();
			break;
		case "Bottom":
			lbl.setVerticalAlignment(SwingConstants.BOTTOM); // ���� ��ġ�� �ٲܶ�
			/* �����̳� ��ġ�� �ٽ� �� �� �̷��� �ϴ°� �������ϴ�.
			c.add(lbl, BorderLayout.SOUTH);
			c.validate();
			//c.repaint(); �̰��ϸ� �ȵ�
			*/
			break;
		}
	}
}
