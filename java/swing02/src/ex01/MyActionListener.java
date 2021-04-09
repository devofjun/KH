package ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e); // ActionEvent에 정의된 toString이 출력됨 - 이벤트에 대한 정보
		Object obj = e.getSource(); // 액션이벤트가 발생한 컴포넌트를 Object 타입으로 리턴 
		// System.out.println(obj); // 원래는 @가 나오지만 toString으로 오브젝트에대한 정보가 출력됨.
		JButton btn = (JButton)obj; // 해당 컴포넌트의 타입으로 다운캐스팅
		String text = btn.getText(); // 버튼의 기능 중에서 글자값을 얻어오는 메서드 호출
		if(text.equals("버튼")) {
			btn.setText("Button");
		} else {
			btn.setText("버튼");
		}
	}
}
