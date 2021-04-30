package ex05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class TimerPanel extends JPanel implements Runnable{
	
	LabelMan[] lMan;
	int manCount = 1;
	int width = 2000;
	public TimerPanel(/*LabelMan[] lMan*/) {
		/*this.lMan = lMan;*/
		//this.repaint();
	}
	
	
	JLabel time = new JLabel("Timer");
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth();
		int height = this.getHeight();
		g.setColor(Color.GREEN);
		g.fillRect(width/100, height/10, this.width/5, 50);
	}
	
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				width -= 2;
				repaint();
				if (width < 0) {
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
