package ex06;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DialogEx extends JFrame{
	Container c = getContentPane();
	JButton btn = new JButton("���̾�α� ���̱�");
	// ��ӹ��� ������ Dialog�� ���ڰ����� Frame�� "����"�� �޴´�.
	MyDialog dlg = new MyDialog(this, "title", true); // ��޻��·� ����
	
	public DialogEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���̾�α� ����");
		setSize(300, 300);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(true);
				// ��� ���̾�α��� ��� - ���̾�α� â�� ������ ������
				// ���� ���� �ȵ� = �ڵ� ������ ����
				//System.out.println("���̾�α� ����");
				btn.setText(dlg.getText());
			}
		});
		c.add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DialogEx();
	}
}
