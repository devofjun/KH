package ex01;


import java.io.FileReader;

public class FileReaderStreamEx {
	public static void main(String[] args) {
		String filePath = "G:/stream/test.txt";
		try {
			FileReader reader = new FileReader(filePath); // ���븦 �����Ѵ�.
			while(true) {
				int data = reader.read(); // ����κ��� �����͸� �о�´�.
				if(data == -1) { // ������ ��(-1)
					break;
				}
				System.out.print((char)data); // �о�� ������ ���
			}
			reader.close(); // ���븦 �����Ѵ�.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
