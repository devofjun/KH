package ex07;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OptionPaneEx extends JFrame{
	// �ʵ�
	Container c = getContentPane();
	JTextField tf = new JTextField();
	// ������
	public OptionPaneEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3������ ���̾�α�");
		setSize(300, 300);
		
		OptionPanel pnl = new OptionPanel();
		
		c.add(pnl, BorderLayout.CENTER);
		c.add(tf, BorderLayout.SOUTH);
		setVisible(true);
	}
	// OptionPanel ���� Ŭ����
	@SuppressWarnings("unused")
	private class OptionPanel extends JPanel {
		public OptionPanel(){
			// ��ư 3��
			JButton input = new JButton("Input");
			JButton Confirm = new JButton("Confirm");
			JButton Message = new JButton("Message");
			// ��ư 3���� ���� �̺�Ʈ
			input.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ù��° ���ڷ� null���� �ָ� ȭ���� �������, �������� ��� ���� �ʹٸ� OptionPaneEx.this �ϸ��
					String text = JOptionPane.showInputDialog(OptionPaneEx.this, "������ ��������?");
					tf.setText(text);
				}
			});
			
			Confirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ��, �ƴϿ�, ���, �ݱ� ��ư�� �ִ� ���̾�α�
					int result = JOptionPane.showConfirmDialog(OptionPaneEx.this, "���ϱ⵵ ��������?");
					// ����� ���� ó��
					// �� 0
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("��");
					}
					// �ƴϿ� 1
					if(result == JOptionPane.NO_OPTION) {
						tf.setText("�ƴϿ�");
					}
					// ��� 2
					if(result == JOptionPane.CANCEL_OPTION) {
						tf.setText("���");
					}
					// �ݱ� -1
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("�ݱ�");
					}
				}
			});
			
			Message.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// �޼����� ���� ���̾�α�
					JOptionPane.showMessageDialog(OptionPaneEx.this, "���� �谡�����׿�");
				}
			});
			this.add(input);
			this.add(Confirm);
			this.add(Message);
		}
	}
		
		
			
			
			
	
	public static void main(String[] args) {
		new OptionPaneEx();
	}
}
