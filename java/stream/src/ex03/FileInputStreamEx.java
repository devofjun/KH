package ex03;


import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		// FileReader�Ẹ��
		// FileReader�� ���� �ѱ��� ������.
		// �ѱ��� 2����Ʈ�ε� FileReader�� 1����Ʈ�� ó���ϱ� ����.
		String filePath = "G:/stream/coffee.html";
		FileReader fr = null; // finally���� �ݾ��ֱ� ���� ���������� ����
		
		try {
			fr = new FileReader(filePath); // ���� ���� ����
			while(true) { // �ѱ��ھ� �о����� ������ �ݺ����� �ʿ���
				int data = fr.read(); // �ѱ��ڸ� �о ����
				if(data == -1) { // ������ ��(EOF)�� -1�� ���̳�
					fr.close(); // ���� ������ �ڿ�����
					return;
				}
				System.out.print((char)data); // �о�� �ѱ��� ���
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
