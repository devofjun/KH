package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SliderEx extends JFrame implements ActionListener{
	JButton btnDec = new JButton("감소");
	JButton btnInc = new JButton("증가");
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
	JTextField txtval = new JTextField(10);
	
	public SliderEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("슬라이더 예제");
		
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		btnDec.addActionListener(this);
		btnInc.addActionListener(this);
		slider.addChangeListener(new ChangeListener() { // 슬라이더가 변할때마다 리스너동작
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				txtval.setText(String.valueOf(value));
			}
		});
		
		Container c = getContentPane();
		c.setBackground(new Color(255,255,0));
		c.setLayout(new FlowLayout());
		c.add(slider);
		c.add(btnDec);
		c.add(btnInc);
		c.add(txtval);
		
		setSize(270, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SliderEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int val = slider.getValue();
		if(obj == btnDec) {
			slider.setValue(--val);
		} else if(obj == btnInc) {
			slider.setValue(++val);
		}
		txtval.setText(String.valueOf(val));
	}
}
