package ex06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PieChart extends JFrame implements ActionListener{
	Container c = getContentPane();
	
	JLabel[] lbl = {
		new JLabel("사과"),
		new JLabel("딸기"),
		new JLabel("망고"),
		new JLabel("배"),
	};
	JTextField[] tf = {
			new JTextField(3),
			new JTextField(3),
			new JTextField(3),
			new JTextField(3)
	};
	JPanel panel = new JPanel();
	MyPanel myPanel = new MyPanel();

	String[] strFruit = {"사과", "딸기", "망고", "배"};
	int[] Fruit = {0,0,0,0};
	
	public PieChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("과일 판매 현황");
		setSize(500,500);
		setVisible(true);
		setUI();
	}
	
	private void setUI() {
		for(int i=0; i<tf.length; i++) {
			panel.add(lbl[i]);
			panel.add(tf[i]);
			tf[i].addActionListener(this);
		}
		c.add(panel, BorderLayout.NORTH);
		c.add(myPanel, BorderLayout.CENTER);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int centerX = this.getWidth() / 2 - 100;
			int centerY = this.getHeight() / 2 - 100;
			int arcWidth = 200;
			int arcHeight = 200;
			int startAngle = 0;
			int sum = 0;
			for(int i=0; i<Fruit.length; i++) {
				sum+=Fruit[i];
			}
			Color[] color = {Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE};
			int[] arcAngle = new int[Fruit.length];
			int[] percent = new int[Fruit.length];
			Font f = new Font("맑은 고딕", Font.BOLD, 20);
			g.setFont(f);
			for(int i=0; i<Fruit.length; i++) {
				if(sum>0) {
					percent[i] = Fruit[i]*100/sum;
					arcAngle[i] = Fruit[i]*360/sum;
					System.out.println("arc:"+arcAngle[i]+"|start:"+startAngle);
				}
				g.setColor(color[i]);
				g.fillArc(centerX, centerY, arcWidth, arcHeight, startAngle, arcAngle[i]);
				startAngle += arcAngle[i];
				if(i==Fruit.length-1 && startAngle < 360 && sum != 0) {
					int fill = 360 - startAngle;
					g.fillArc(centerX, centerY, arcWidth, arcHeight, startAngle, fill);
				}
				//System.out.println("arcAngle:"+arcAngle);
				g.setColor(color[i]);
				g.drawString(strFruit[i]+percent[i]+"%", (this.getWidth()/5)*(1+i)-20, 30);
			}
//			
//			g.setColor(color[1]);
//			g.drawString("딸기"+percent[1]+"%", 150, 30);
//			g.setColor(color[2]);
//			g.drawString("망고"+percent[2]+"%", 250, 30);
//			g.setColor(color[3]);
//			g.drawString("배"+percent[3]+"%", 350, 30);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0; i<tf.length; i++) {
			try {
				Fruit[i] = Integer.parseInt(tf[i].getText());
			} catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
			System.out.print(Fruit[i]+" ");
		}
		System.out.println();
		
		myPanel.repaint();
	}
	
	public static void main(String[] args) {
		new PieChart();
	}
}
