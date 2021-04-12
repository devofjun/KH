package ex10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calc extends JFrame implements ActionListener{
	Container c = getContentPane();
	JButton[] btn = new JButton[19];
	String[] text = {
			"C", "<-", "+", "-",
			"7", "8", "9", "*",
			"4", "5", "6", "/",
			"1", "2", "3", "%",
			"0", ".", "="
	};
	//JLabel lbl = new JLabel();
	JTextField tf = new JTextField();
	JPanel panel = new JPanel();
	boolean inputSign = false;
	
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculater");
		setSize(250, 300);
		
		panel.setLayout(new GridLayout(5, 4, 5, 5));
		setText();
		
		c.add(panel, BorderLayout.CENTER);
		c.add(tf, BorderLayout.NORTH);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btn = (JButton)obj; 
		String t = btn.getText();
		
		if(t == "C") {
			tf.setText("");
		} else if(t == "<-") {
			String txt = tf.getText();
			tf.setText(txt.substring(0, txt.length()-1));
		} else if(t == "=") {
			tf.setText(calculation(tf.getText()));
		} else if(t == "+" || t == "-" || t == "*" || t == "/" || t == "%" || t == ".") {
			char c = tf.getText().charAt(tf.getText().length()-1);
			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '.') {
				System.out.println(c);
			} else {
				tf.setText(tf.getText()+t);
			}
		} else {
			tf.setText(tf.getText()+t);
		}
	}
	
	public static void main(String[] args) {
		new Calc();
	}
	
	public String calculation(String formula) {
		String result = "";
		int sign = 0;
		if(formula.indexOf('+') != -1) {
			
			sign = formula.indexOf('+');
			String a = formula.substring(0, sign);
			String b = formula.substring(sign+1, formula.length());
			int rst = Integer.parseInt(a) + Integer.parseInt(b);
			result = String.valueOf(rst);
		} else if(formula.indexOf('-') != -1)	{
			sign = formula.indexOf('-');
			String a = formula.substring(0, sign);
			String b = formula.substring(sign+1, formula.length());
			int rst = Integer.parseInt(a) - Integer.parseInt(b);
			result = String.valueOf(rst);
		} else if(formula.indexOf('*') != -1)	{
			sign = formula.indexOf('*');
			String a = formula.substring(0, sign);
			String b = formula.substring(sign+1, formula.length());
			int rst = Integer.parseInt(a) * Integer.parseInt(b);
			result = String.valueOf(rst);
		} else if(formula.indexOf('/') != -1)	{
			sign = formula.indexOf('/');
			String a = formula.substring(0, sign);
			String b = formula.substring(sign+1, formula.length());
			int rst = Integer.parseInt(a) / Integer.parseInt(b);
			result = String.valueOf(rst);
		} else if(formula.indexOf('%') != -1)	{
			sign = formula.indexOf('%');
			String a = formula.substring(0, sign);
			String b = formula.substring(sign+1, formula.length());
			int rst = Integer.parseInt(a) % Integer.parseInt(b);
			result = String.valueOf(rst);
		} else {
			result = formula;
		}
		return result;
	}
	
	public void setText() {
		for(int i=0; i<btn.length; ++i) {
			btn[i] = new JButton(text[i]);
		}
		for(int i=0; i<btn.length; ++i) {
			panel.add(btn[i]);
			btn[i].addActionListener(this);
		}
	}
}
