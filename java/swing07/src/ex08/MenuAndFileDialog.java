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
	// 필드
	Container c = getContentPane();
	JLabel lbl = new JLabel();
	// 생성자
	public MenuAndFileDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("열기 다이얼로그");
		setSize(300, 300);
		createMenu();
		// createMenu()
		c.add(lbl);
		
		setVisible(true);
	}

	
	
	private void createMenu() {
		// 메뉴바
		JMenuBar menuBar = new JMenuBar();
		// 메뉴
		JMenu menu = new JMenu("file");
		// 메뉴 아이템 + 액션이벤트
		JMenuItem mi = new JMenuItem("open");
		mi.addActionListener(this);
		// 메뉴 아이템을 메뉴에 달기
		menu.add(mi);
		// 메뉴를 메뉴바에 달기
		menuBar.add(menu);
		// 메뉴바를 프레임에 장착
		setJMenuBar(menuBar);
	}
	// actionsListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// 파일의 경로를 얻어내는 것임 -> 파일을 실제로 여는게 아니다!!
		JFileChooser chooser = new JFileChooser();
		// 확장자(.xxx) 필터링
		FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지파일", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		// 열기 다이얼로그
		int result = chooser.showOpenDialog(null);
		// 파일을 선택하지 않은 경우
		if(result != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.");
			return;
		}
		// 파일을 선택한경우
		String path = chooser.getSelectedFile().getPath();
		lbl.setIcon(new ImageIcon(path));
		pack();
	}
	// 메인
	public static void main(String[] args) {
		new MenuAndFileDialog();
	}
	

}
