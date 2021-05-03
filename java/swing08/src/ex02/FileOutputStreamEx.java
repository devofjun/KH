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
				int data = reader.read(); // 파일 읽기
				if(data == -1) {
					break;
				}
				writer.write(data); // 파일 쓰기
			}
			System.out.println("파일 복사 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 파일 닫는건 무조건 닫아야 하니까 finally에서 실행함
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
