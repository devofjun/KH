package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JComponentEx extends JFrame implements ActionListener{
	Container c= getContentPane();
	JButton btn1 = new JButton("Magenta/Yellow Button");
	JButton btn2 = new JButton("Disabled Button");
	JButton btn3 = new JButton("getX(), getY()");
	
	public JComponentEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("컴포넌트 공통 메서드");
		setSize(200,200);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		c.setLayout(new FlowLayout());
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton theButton = (JButton)obj;
		if(theButton == btn1) {
			btn1.setBackground(Color.YELLOW);
			btn1.setForeground(Color.MAGENTA);
			btn1.setFont(new Font("맑은 고딕", Font.ITALIC, 15));
		} else if(theButton == btn2) {
			btn2.setEnabled(false);
		} else if(theButton == btn3) {
			JFrame f = (JFrame)btn3.getTopLevelAncestor();
			int x= btn3.getX();
			int y = btn3.getY();
			f.setTitle("("+x+", "+y+")");
			if(btn2.isVisible() == true) {
				btn2.setVisible(false);
			} else {
				btn2.setVisible(true);
			}
		}
	}
	
	public static void main(String[] args) {
		new JComponentEx();
	}

}