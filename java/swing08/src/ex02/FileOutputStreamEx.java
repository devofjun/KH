package ex02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		String fileName = "G:/stream/test.txt";
		String copyName = "G:/stream/test2.txt";
		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new FileReader(fileName);
			writer = new FileWriter(copyName);
			while(true) {
				int data = reader.read(); // ���� �б�
				if(data == -1) {
					break;
				}
				writer.write(data); // ���� ����
			}
			System.out.println("���� ���� �Ϸ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // ���� �ݴ°� ������ �ݾƾ� �ϴϱ� finally���� ������
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
