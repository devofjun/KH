package ex03;


import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		// FileReader써보기
		// FileReader만 쓰면 한글이 깨진다.
		// 한글은 2바이트인데 FileReader는 1바이트씩 처리하기 때문.
		String filePath = "G:/stream/coffee.html";
		FileReader fr = null; // finally에서 닫아주기 위해 전역변수로 선언
		
		try {
			fr = new FileReader(filePath); // 읽을 파일 생성
			while(true) { // 한글자씩 읽어지기 때문에 반복문이 필요함
				int data = fr.read(); // 한글자를 읽어서 저장
				if(data == -1) { // 파일의 끝(EOF)은 -1로 끝이남
					fr.close(); // 끝이 났을때 자원해제
					return;
				}
				System.out.print((char)data); // 읽어온 한글자 출력
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
