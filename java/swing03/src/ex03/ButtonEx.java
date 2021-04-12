package ex03;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonEx extends JFrame{

	
	public ButtonEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("버튼예제");
		setSize(500, 500);
		
		JButton button = new JButton(new ImageIcon("images/scissors.png"));
		button.setRolloverIcon(new ImageIcon("images/rock.png"));
		button.setPressedIcon(new ImageIcon("images/papper.png"));
		getContentPane().add(button);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ButtonEx();
	}
}
