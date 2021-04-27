package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SliderChangeEx extends JFrame implements ChangeListener{
	Container c = getContentPane();
	JSlider[] sliders = new JSlider[3];
	Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
	JLabel lblTarget = new JLabel("여기의 배경색을 변경");
	
	
	public SliderChangeEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("슬라이더로 색상 변경하기");
		
		setUI();
		
		setSize(300, 250);
		setVisible(true);
	}
	
	private void setUI() {
		c.setLayout(new FlowLayout());
		for(int i=0; i<sliders.length; i++) {
			sliders[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sliders[i].setForeground(colors[i]);
			sliders[i].setPaintLabels(true);
			sliders[i].setPaintTicks(true);
			sliders[i].setMajorTickSpacing(50);
			sliders[i].setMinorTickSpacing(10);
			sliders[i].addChangeListener(this);
			c.add(sliders[i]);
		}
		// 레이블은 초기 상태가 투명한 상태 -> 불투명하게 설정
		lblTarget.setOpaque(true);
		lblTarget.setBackground(new Color(128,128,128));
		c.add(lblTarget);
	}
	
	public static void main(String[] args) {
		new SliderChangeEx();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int red = sliders[0].getValue();
		int green = sliders[1].getValue();
		int blue = sliders[2].getValue();
		Color newColor = new Color(red, green, blue);
		lblTarget.setBackground(newColor);
	}
}
