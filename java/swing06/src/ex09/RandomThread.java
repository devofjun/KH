package ex09;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

public class RandomThread implements Runnable{
	Container c;
	public RandomThread(Container c){
		this.c = c;
	}
	
	// 종료 Flag
	boolean flag = false;
	public void finish() {
		flag = true;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(flag == true) {
					// 생성됐던 모든 컴포넌트를 지운다.
					c.removeAll();
					// Finish 레이블을 생성하여 추가한다.
					JLabel lbl = new JLabel("Finish");
					lbl.setSize(50, 30);
					lbl.setForeground(Color.RED);
					int x = (int)(Math.random() * (c.getWidth() - lbl.getWidth()));
					int y = (int)(Math.random() * (c.getWidth() - lbl.getWidth()));
					lbl.setLocation(x, y);
					c.add(lbl);
					// 변한 컴포넌트를 다시 그려준다.
					c.repaint();
					return;
				}
				JLabel lbl = new JLabel("Java");
				lbl.setSize(30, 30);
				int x = (int)(Math.random() * (c.getWidth() - lbl.getWidth()));
				int y = (int)(Math.random() * (c.getWidth() - lbl.getWidth()));
				lbl.setLocation(x, y);
				c.add(lbl);
				c.repaint();
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
