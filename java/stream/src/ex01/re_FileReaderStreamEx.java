package ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class re_FileReaderStreamEx {
	public static void main(String[] args) {
		String path = "G:/stream/test2.txt";
		try {
			FileReader reader = new FileReader(path); // 메모리에 path파일을 연다.
			while(true) {
				int readData = reader.read(); // 메모리의 데이터를 한글자 읽어온다.
				if(readData == -1) { // 파일의 끝이라면 반복문 종료
					break;
				}
				System.out.print((char)readData); // 읽어온 데이터 출력
			}
			reader.close(); // 열린 자원을 해제한다.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
