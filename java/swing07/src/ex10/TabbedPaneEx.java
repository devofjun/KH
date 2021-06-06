package ex10;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TabbedPaneEx extends JFrame{
	Container c = getContentPane();
	JTabbedPane tabPane = new JTabbedPane(JTabbedPane.LEFT);
	
	public TabbedPaneEx() {
		setTitle("ÅÇÆÒ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
		// (ÅÇÀÌ¸§, ÅÇ¿¡¼­ »ç¿ëÇÒ ÄÄÆ÷³ÍÆ®)
		tabPane.add("½ºÆÄÀÌ´õ¸Ç",new JLabel(new ImageIcon("images/image0.jpg")));
		tabPane.add("¿ø´õ¿ì¸Õ",new JLabel(new ImageIcon("images/image1.jpg")));
		tabPane.add("MyPanel", new MyPanel());
		tabPane.add("TextArea", new JTextArea());
		c.add(tabPane);
		setVisible(true);
		System.out.println("test");
	}
	public static void main(String[] args) {
		new TabbedPaneEx();
	}
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 100, 100);
			g.setColor(Color.BLUE);
			g.fillOval(10, 120, 100, 100);
		}
	}
}
