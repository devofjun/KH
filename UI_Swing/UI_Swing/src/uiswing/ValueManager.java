package uiswing;

import java.awt.Component;

import javax.swing.JOptionPane;

public class ValueManager {
	UIDao dao = UIDao.getInstance();

	public boolean valuesCheck(String sno, String sname, String syear, String gender, String major, String score) {

		// 학번값 체크
		if (sno.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "학번을 입력해주세요.");
			return false;
		} else if (sno.replace(" ","").length() != sno.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (sno.length() != 8) {
			JOptionPane.showMessageDialog(null, "학번은 8자리로 맞춰주세요.");
			return false;
		} else if (!(dao.checkSNO(sno))) {
			JOptionPane.showMessageDialog(null, "사용불가능한 학번입니다.");
			return false;
		}

		// 이름값 체크
		if (sname.trim().equals("")) { // 이름이 빈칸
			JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
			return false;
		} else if (sname.replace(" ","").length() != sname.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (!(sname.length() <= 3)) { // 이름은 세자리까지 허용됨
			JOptionPane.showMessageDialog(null, "이름은 세글자까지 입력가능합니다.");
			return false;
		}

		// 학년값 체크
		int intSyear = 0;
		try {
			intSyear = Integer.parseInt(syear);
			if (!(intSyear >= 1 && intSyear <= 4)) {
				JOptionPane.showMessageDialog(null, "학년은 1~4까지 입력해주세요.");
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "학년에는 숫자만 입력해야 합니다.");
			return false;
		}

		// 성별값 체크
		if (gender.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "성별을 입력해주세요.");
			return false;
		} else if (gender.replace(" ","").length() != gender.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (!(gender.equals("남") || gender.equals("여"))) {
			JOptionPane.showMessageDialog(null, "성별을 선택해주세요.");
			return false;
		}

		// 전공값 체크
		if (major.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "전공을 입력해주세요");
			return false;
		} else if (major.replace(" ","").length() != major.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (!(major.length() <= 3)) {
			JOptionPane.showMessageDialog(null, "전공은 세글자까지 입력가능합니다.");
			return false;
		}

		// 점수값 체크
		try {
			int intScore = Integer.parseInt(score);
			if (!(intScore >= 0 && intScore <= 100)) {
				JOptionPane.showMessageDialog(null, "점수입력은 0~100까지 가능합니다.");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "점수는 숫자만 입력가능합니다.");
			return false;
		}

		return true;
	}

	public boolean modifyValuesCheck(String sname, String syear, String gender, String major, String score) {

		// 이름값 체크
		if (sname.trim().equals("")) { // 이름이 빈칸
			JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
			return false;
		} else if (sname.replace(" ","").length() != sname.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (!(sname.length() <= 3)) { // 이름은 세자리까지 허용됨
			JOptionPane.showMessageDialog(null, "이름은 세글자까지 입력가능합니다.");
			return false;
		}

		// 학년값 체크
		int intSyear = 0;
		try {
			intSyear = Integer.parseInt(syear);
			if (!(intSyear >= 1 && intSyear <= 4)) {
				JOptionPane.showMessageDialog(null, "학년은 1~4까지 입력해주세요.");
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "학년에는 숫자만 입력해야 합니다.");
			return false;
		}

		// 성별값 체크
		if (gender.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "성별을 입력해주세요.");
			return false;
		} else if (gender.replace(" ","").length() != gender.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (!(gender.equals("남") || gender.equals("여"))) {
			JOptionPane.showMessageDialog(null, "성별을 선택해주세요.");
			return false;
		}

		// 전공값 체크
		if (major.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "전공을 입력해주세요");
			return false;
		} else if (major.replace(" ","").length() != major.length()) {
			JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
			return false;
		} else if (!(major.length() <= 3)) {
			JOptionPane.showMessageDialog(null, "전공은 세글자까지 입력가능합니다.");
			return false;
		}

		// 점수값 체크
		try {
			int intScore = Integer.parseInt(score);
			if (!(intScore >= 0 && intScore <= 100)) {
				JOptionPane.showMessageDialog(null, "점수입력은 0~100까지 가능합니다.");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "점수는 숫자만 입력가능합니다.");
			return false;
		}

		return true;
	}
}
