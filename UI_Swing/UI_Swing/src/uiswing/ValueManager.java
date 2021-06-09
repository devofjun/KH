package uiswing;

import java.awt.Component;

import javax.swing.JOptionPane;

public class ValueManager {
	UIDao dao = UIDao.getInstance();

	public boolean valuesCheck(String sno, String sname, String syear, String gender, String major, String score) {

		// �й��� üũ
		if (sno.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.");
			return false;
		} else if (sno.replace(" ","").length() != sno.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (sno.length() != 8) {
			JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �����ּ���.");
			return false;
		} else if (!(dao.checkSNO(sno))) {
			JOptionPane.showMessageDialog(null, "���Ұ����� �й��Դϴ�.");
			return false;
		}

		// �̸��� üũ
		if (sname.trim().equals("")) { // �̸��� ��ĭ
			JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���.");
			return false;
		} else if (sname.replace(" ","").length() != sname.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (!(sname.length() <= 3)) { // �̸��� ���ڸ����� ����
			JOptionPane.showMessageDialog(null, "�̸��� �����ڱ��� �Է°����մϴ�.");
			return false;
		}

		// �гⰪ üũ
		int intSyear = 0;
		try {
			intSyear = Integer.parseInt(syear);
			if (!(intSyear >= 1 && intSyear <= 4)) {
				JOptionPane.showMessageDialog(null, "�г��� 1~4���� �Է����ּ���.");
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�г⿡�� ���ڸ� �Է��ؾ� �մϴ�.");
			return false;
		}

		// ������ üũ
		if (gender.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է����ּ���.");
			return false;
		} else if (gender.replace(" ","").length() != gender.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (!(gender.equals("��") || gender.equals("��"))) {
			JOptionPane.showMessageDialog(null, "������ �������ּ���.");
			return false;
		}

		// ������ üũ
		if (major.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
			return false;
		} else if (major.replace(" ","").length() != major.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (!(major.length() <= 3)) {
			JOptionPane.showMessageDialog(null, "������ �����ڱ��� �Է°����մϴ�.");
			return false;
		}

		// ������ üũ
		try {
			int intScore = Integer.parseInt(score);
			if (!(intScore >= 0 && intScore <= 100)) {
				JOptionPane.showMessageDialog(null, "�����Է��� 0~100���� �����մϴ�.");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է°����մϴ�.");
			return false;
		}

		return true;
	}

	public boolean modifyValuesCheck(String sname, String syear, String gender, String major, String score) {

		// �̸��� üũ
		if (sname.trim().equals("")) { // �̸��� ��ĭ
			JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���.");
			return false;
		} else if (sname.replace(" ","").length() != sname.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (!(sname.length() <= 3)) { // �̸��� ���ڸ����� ����
			JOptionPane.showMessageDialog(null, "�̸��� �����ڱ��� �Է°����մϴ�.");
			return false;
		}

		// �гⰪ üũ
		int intSyear = 0;
		try {
			intSyear = Integer.parseInt(syear);
			if (!(intSyear >= 1 && intSyear <= 4)) {
				JOptionPane.showMessageDialog(null, "�г��� 1~4���� �Է����ּ���.");
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�г⿡�� ���ڸ� �Է��ؾ� �մϴ�.");
			return false;
		}

		// ������ üũ
		if (gender.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է����ּ���.");
			return false;
		} else if (gender.replace(" ","").length() != gender.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (!(gender.equals("��") || gender.equals("��"))) {
			JOptionPane.showMessageDialog(null, "������ �������ּ���.");
			return false;
		}

		// ������ üũ
		if (major.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
			return false;
		} else if (major.replace(" ","").length() != major.length()) {
			JOptionPane.showMessageDialog(null, "������� �Է����ּ���.");
			return false;
		} else if (!(major.length() <= 3)) {
			JOptionPane.showMessageDialog(null, "������ �����ڱ��� �Է°����մϴ�.");
			return false;
		}

		// ������ üũ
		try {
			int intScore = Integer.parseInt(score);
			if (!(intScore >= 0 && intScore <= 100)) {
				JOptionPane.showMessageDialog(null, "�����Է��� 0~100���� �����մϴ�.");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է°����մϴ�.");
			return false;
		}

		return true;
	}
}
