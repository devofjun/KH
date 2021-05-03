package ex05;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 유저를 따라 다니는 술래역할의 레이블 정의/구현
@SuppressWarnings("serial")
public class TaggerLabel extends JLabel implements Runnable{
	JLabel lUser;
	GameRules GR;
	
	public TaggerLabel(JLabel lUser, GameRules GR) {
		super(new ImageIcon("images/man1.png"));
		this.lUser = lUser;
		this.GR = GR;
	}
	
	Random rand = new Random();
	public void printTagger(JPanel pnl) {
		// 창크기에 맞는 랜덤수
		int randX = rand.nextInt(Math.abs(pnl.getWidth()-80));
		int randY = rand.nextInt(Math.abs(pnl.getHeight()-75));
		//System.out.println(randX+":"+ randY);
		this.setBounds(randX, randY, 80, 75);
		pnl.add(this);
		//System.out.println(this);
	}
	
	@Override
	public void run() {
		//System.out.println("생성");
		while(GR.gameState) {
			Point p = getLocation();
			int x = (int)p.getX();
			int y = (int)p.getY();
			int userX = (int)lUser.getX();
			int userY = (int)lUser.getY();
			//System.out.println(x+":"+y+" || "+userX+":"+userY);
			
			// x값이 유저를 따라가게 한다. 
			if(x > userX) {
				x -= 1;
			} else if(x < userX) {
				x += 1;
			}
			// y값이 유저를 따라가게 한다.
			if(y > userY) {
				y -= 1;
			} else if(y < userY) {
				y += 1;
			}
			setLocation(x, y);
			// 따라잡았다면
			if(x == userX && y == userY) {
				System.out.println("잡힘!");
				GR.gameState = false; // 반복문의 조건을 false로 만들면서 쓰레드들이 종료된다.
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("종료"+this);
	}

}
