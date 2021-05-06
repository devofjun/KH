package ex08;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class MenuAndFileDialog extends JFrame implements ActionListener{
	// �ʵ�
	Container c = getContentPane();
	JLabel lbl = new JLabel();
	// ������
	public MenuAndFileDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� ���̾�α�");
		setSize(300, 300);
		createMenu();
		// createMenu()
		c.add(lbl);
		
		setVisible(true);
	}

	
	
	private void createMenu() {
		// �޴���
		JMenuBar menuBar = new JMenuBar();
		// �޴�
		JMenu menu = new JMenu("file");
		// �޴� ������ + �׼��̺�Ʈ
		JMenuItem mi = new JMenuItem("open");
		mi.addActionListener(this);
		// �޴� �������� �޴��� �ޱ�
		menu.add(mi);
		// �޴��� �޴��ٿ� �ޱ�
		menuBar.add(menu);
		// �޴��ٸ� �����ӿ� ����
		setJMenuBar(menuBar);
	}
	// actionsListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// ������ ��θ� ���� ���� -> ������ ������ ���°� �ƴϴ�!!
		JFileChooser chooser = new JFileChooser();
		// Ȯ����(.xxx) ���͸�
		FileNameExtensionFilter filter = new FileNameExtensionFilter("�̹�������", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		// ���� ���̾�α�
		int result = chooser.showOpenDialog(null);
		// ������ �������� ���� ���
		if(result != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.");
			return;
		}
		// ������ �����Ѱ��
		String path = chooser.getSelectedFile().getPath();
		lbl.setIcon(new ImageIcon(path));
		pack();
	}
	// ����
	public static void main(String[] args) {
		new MenuAndFileDialog();
	}
	

}
