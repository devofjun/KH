package ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class re_FileReaderStreamEx {
	public static void main(String[] args) {
		String path = "G:/stream/test2.txt";
		try {
			FileReader reader = new FileReader(path); // �޸𸮿� path������ ����.
			while(true) {
				int readData = reader.read(); // �޸��� �����͸� �ѱ��� �о�´�.
				if(readData == -1) { // ������ ���̶�� �ݺ��� ����
					break;
				}
				System.out.print((char)readData); // �о�� ������ ���
			}
			reader.close(); // ���� �ڿ��� �����Ѵ�.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
