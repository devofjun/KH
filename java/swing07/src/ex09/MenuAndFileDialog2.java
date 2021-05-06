package ex09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class MenuAndFileDialog2 extends JFrame implements ActionListener{
	Container c = getContentPane();
	JTextField tf = new JTextField(30);
	JButton btn = new JButton("����");
	JTextArea ta = new JTextArea();
	JPanel pnlNorth =  new JPanel();
	JPanel pnlCenter = new JPanel();
	JScrollPane scroll = new JScrollPane(ta);
	
	FileInputStream fis = null;
	InputStreamReader isr = null;
	//BufferedOutputStream bos = null;
	
	public MenuAndFileDialog2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� �о����");
		setSize(500, 400);
		btn.addActionListener(this);
		pnlNorth.add(tf);
		pnlNorth.add(btn);
		pnlCenter.setLayout(new BorderLayout());
		pnlCenter.add(scroll);
		c.add(pnlNorth,BorderLayout.NORTH);
		c.add(pnlCenter,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuAndFileDialog2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("�ؽ�Ʈ����", "txt");
		chooser.setFileFilter(filter);
		int result = chooser.showOpenDialog(null);
		if(result != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.");
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tf.setText(filePath);
		try {
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis,"utf-8"); // �о�� �����Ϳ�  ��������(CharSet)�� ����
			//bos = new BufferedOutputStream(ta,1024);
			int i=0;
			while(true) {
				int data = isr.read(); // InputStreamReader�� ���� '�ѱ���'�� �о�´�.
				if(data == -1) { // ������ ���̶�� ����
					fis.close();
					isr.close();
					//bos.close();
					return;
				}
				//System.out.print((char)data);
				ta.append(String.valueOf((char)data));
				//bos.write(data);
				//ta.append(String.valueOf((char)data)); // ���
				//System.out.println(i++);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();
				//bos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
