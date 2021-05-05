package ex06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	public static void main(String[] args) {
		String fileName = "G:/stream/test.txt";
		
		File f = new File(fileName);
		
		// �������� ���丮����
		if(f.isFile()) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("���丮�Դϴ�.");
		}
		//���ϸ�
		System.out.println("���ϸ�: " + f.getName());
		//��θ�
		System.out.println("��θ�: " + f.getPath());
		//����������
		System.out.println("����������: " + f.getParent());
		
		//���� ��� ��� = �������� li
		f = new File("C:/windows");
		File[] files = f.listFiles();
		for(File afile : files) {
			// ���ϸ�
			String fName = afile.getName();
			
			// �������� ���丮����
			String fileOrDir = "";
			if(afile.isFile()) {
				fileOrDir = "f";
			} else {
				fileOrDir = "D";
			}
			
			// ������ ũ��
			long fSize = afile.length();
			
			// ���� ������
			long time = afile.lastModified();
			// ���� ���̰� �� ��¥ ����?
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� DD�� HH�� mm�� ss��");
			Date date = new Date(time); // Date�� java.util�� �ִ°� ����Ѵ�.
			String formattedDate = sdf.format(date);
			// �̸��� ���� ���丮 ����
			System.out.print(fName + "\t" + fileOrDir);
			if(afile.isFile()) {
				System.out.println("\t����ũ��:"+fSize+"(bytes)\t"+formattedDate);
			}
			System.out.println();
		}
		
		// ���� �����ϴ� ��
		f = new File("G:/stream/java");
		// �ش� ������ �������� ������ ���� �����
		if(!f.exists()) {
			f.mkdir();
		}
		
	}
}
