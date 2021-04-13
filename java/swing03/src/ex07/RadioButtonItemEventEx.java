package ex07;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


// 라디오 버튼을 누를때 매칭되는 이미지 띄우기
@SuppressWarnings("serial")
public class RadioButtonItemEventEx extends JFrame{
	Container c = getContentPane();
	// 라디오 버튼들 배치할 패널
	JPanel pnlRadio = new JPanel(); // 패널의 기본배치관리자 : FlowLayout
	String[] texts = {"가위", "바위", "보" };
	JRadioButton[] radios = new JRadioButton[texts.length];
	ButtonGroup group = new ButtonGroup();
	ImageIcon[] images = {
			new ImageIcon("images/scissors.png"),
			new ImageIcon("images/rock.png"),
			new ImageIcon("images/papper.png")
	};
	JLabel lblImage = new JLabel(new ImageIcon("images/rock.png"));
	
	public RadioButtonItemEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(500, 500);
		
		for(int i=0; i<3; i++) {
			radios[i] = new JRadioButton(texts[i]);
			radios[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// 체크, 해제 2개의 이벤트가 발생한다.
					// 해제 이벤트 무시
					int state = e.getStateChange();
					if(state == ItemEvent.DESELECTED) {
						return;
					}
					Object obj = e.getItem();
					// 체크된 라디오 버튼에 따라서 이미지 변경
					if(obj == radios[0]) {
						lblImage.setIcon(images[0]);
					} else if(obj == radios[1]) {
						lblImage.setIcon(images[1]);
					} else if(obj == radios[2]) {
						lblImage.setIcon(images[2]);
					}
					//System.out.println(obj);
				}
			});
			group.add(radios[i]);
			pnlRadio.add(radios[i]);
		}
		radios[0].setSelected(true); // 이벤트 발생시킴
		
		pnlRadio.setBackground(Color.GRAY);
		c.add(pnlRadio, BorderLayout.NORTH);
		c.add(lblImage, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RadioButtonItemEventEx();
	}
}
