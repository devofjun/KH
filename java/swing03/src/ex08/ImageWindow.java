package ex08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageWindow extends JFrame implements ActionListener{
	Container c = getContentPane();
	ImageIcon leftImg = new ImageIcon("images/left.png");
	JButton left = new JButton(leftImg);
	ImageIcon rightImg = new ImageIcon("images/right.png");
	JButton right = new JButton(rightImg);
	JPanel pnlSouth = new JPanel();
	
	
	ImageIcon[] lblImg = {
			new ImageIcon("images/image0.jpg"),
			new ImageIcon("images/image1.jpg"),
			new ImageIcon("images/image2.jpg"),
			new ImageIcon("images/image3.jpg")
			};
	int imgIndex = 0; 
	JLabel lbl = new JLabel(lblImg[0]);
	JPanel pnlCenter = new JPanel();
	
	public ImageWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이미지");
		setSize(600, 500);
		
		left.addActionListener(this);
		right.addActionListener(this);
		
		pnlSouth.setBackground(Color.YELLOW);
		
		pnlCenter.add(lbl);
		pnlSouth.add(left);
		pnlSouth.add(right);
		c.add(pnlCenter,BorderLayout.CENTER);
		c.add(pnlSouth,BorderLayout.SOUTH);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == right) {
			imgIndex++;
			if(imgIndex>=4) {
				imgIndex=0;
				lbl.setIcon(lblImg[imgIndex]);
			} else {
				lbl.setIcon(lblImg[imgIndex]);
			}
		} else if(obj == left) {
			imgIndex--;
			if(imgIndex<=-1) {
				imgIndex=3;
				lbl.setIcon(lblImg[imgIndex]);
			} else {
				lbl.setIcon(lblImg[imgIndex]);
			}
		}
	}
	public static void main(String[] args) {
		new ImageWindow();
	}
}
