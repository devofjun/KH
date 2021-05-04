package ex03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		// FileReader써보기
		// FileReader만 쓰면 한글이 깨진다.
		// 한글은 2바이트인데 FileReader는 1바이트씩 처리하기 때문.
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
