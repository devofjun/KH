package ex01;


import java.io.FileReader;

public class FileReaderStreamEx {
	public static void main(String[] args) {
		String filePath = "G:/stream/test.txt";
		try {
			FileReader reader = new FileReader(filePath); // 빨대를 생성한다.
			while(true) {
				int data = reader.read(); // 빨대로부터 데이터를 읽어온다.
				if(data == -1) { // 파일의 끝(-1)
					break;
				}
				System.out.print((char)data); // 읽어온 데이터 출력
			}
			reader.close(); // 빨대를 정리한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
