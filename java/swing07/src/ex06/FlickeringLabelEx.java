package ex06;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FlickeringLabelEx extends JFrame {
	Container c = getContentPane();
	FlickeringLabel fLabel;
	JPanel pnl = new JPanel();
	
	public FlickeringLabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("깜빡이는 레이블");
		setSize(200, 200);
		
		fLabel = new FlickeringLabel("깜빡깜빡",1000);
		pnl.add(fLabel);
		
		FlickeringLabel fLabel2 = new FlickeringLabel("반짝반짝",100);
		pnl.add(fLabel2);
		
		c.add(pnl,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlickeringLabelEx();
	}
}
