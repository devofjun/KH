package ex03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		// FileReader�Ẹ��
		// FileReader�� ���� �ѱ��� ������.
		// �ѱ��� 2����Ʈ�ε� FileReader�� 1����Ʈ�� ó���ϱ� ����.
		String filePath = "G:/stream/coffee.html";
		FileReader fr = null;
		
		try {
			fr = new FileReader(filePath);
			while(true) {
				int data = fr.read();
				if(data == -1) {
					return;
				}
				System.out.print((char)data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
