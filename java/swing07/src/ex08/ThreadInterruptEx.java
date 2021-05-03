package ex08;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ThreadInterruptEx extends JFrame implements ActionListener{
	Container c = getContentPane();
	JLabel lbl = new JLabel("0");
	JButton btn = new JButton("Kill Thread");
	TimerRunnable timer;
	Thread th;
	
	public ThreadInterruptEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("스레드 강제종료");
		setSize(250,200);
		
		lbl.setFont(new Font("consolas", Font.BOLD, 50));
		btn.addActionListener(this);
		
		timer = new TimerRunnable(lbl);
		th = new Thread(timer);
		th.start();
		
		c.setLayout(new FlowLayout());
		c.add(lbl);
		c.add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ThreadInterruptEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Thread를 강제종료
		th.interrupt();
	}
}
