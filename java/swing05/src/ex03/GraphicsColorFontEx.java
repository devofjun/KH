package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsColorFontEx extends JFrame{
	Container c = getContentPane();
	Mypanel pnl = new Mypanel();
	
	
	
	public GraphicsColorFontEx(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("컬러와 색상 사용 예제");
		setSize(500, 500);
		setVisible(true);
		
		c.add(pnl);
	}
	
	class Mypanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 붓(g)의 색상을 파란색으로 설정
			g.setColor(Color.BLUE);
			// (30, 30)에 "I Love Java~~" 그리기
			g.drawString("I Love JAVA", 30, 30);
			// g에 새로운 색상 만들기
			Color color = new Color(0xff0000);
			// g에 새로운 폰트 설정
			g.setFont(new Font("Arial",Font.ITALIC, 30));
			// (30,60)에 "How much?" 그리기
			g.drawString("How much", 30, 60);
			// 색상을 보라색으로 설정
			g.setColor(new Color(0x00ff00ff));
			for(int i=1; i<=5; i++) {
				g.setFont(new Font("consolas", Font.BOLD, i*10));
				g.drawString("This much", 30, 10+i*60);
			}
		}
	}
	
	public static void main(String[] args) {
		new GraphicsColorFontEx();
	}
}
